/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Alerts.showAlerts;
import Model.sendEmail;
import Utils.Database.connection;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author sebastian.londono
 */
public class sendEmailController {

    private String table = "";
    connection bdConnect = new connection();
    showAlerts alerts = new showAlerts();

    public boolean sendEmail(sendEmail data, String pathDocument) {

        String remitente, password;
        Object[][] dataConfiguration = returnDataEmail();
        if (!dataConfiguration[0][0].equals("")) {
            remitente = dataConfiguration[0][0].toString();
            password = dataConfiguration[0][1].toString();
        } else {
            alerts.bigAlert("No ha establecido la cuenta gmail en configuraciones");
            return false;
        }

        Properties props = System.getProperties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.user", remitente);
        props.put("mail.smtp.clave", password);    //La clave de la cuenta
        props.put("mail.smtp.auth", "true");    //Usar autenticación mediante usuario y clave
        props.put("mail.smtp.starttls.enable", "true"); //Para conectar de manera segura al servidor SMTP
        props.put("mail.smtp.port", "587"); //El puerto SMTP seguro de Google

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        String emails = "";
        for (Object object : data.getSendTo()) {
            emails = emails + object + ",";
        }
        emails = emails.substring(0, emails.length() - 1);

        try {
            message.setFrom(new InternetAddress(remitente));
            message.addRecipients(Message.RecipientType.TO, InternetAddress.parse(emails));
            // Se compone la parte del texto
            BodyPart texto = new MimeBodyPart();
            texto.setText(data.getBody());
            // Se compone el adjunto con la imagen
            BodyPart adjunto = new MimeBodyPart();
            adjunto.setDataHandler(new DataHandler(new FileDataSource(pathDocument)));
            adjunto.setFileName("Catalogo.pdf");
            // Una MultiParte para agrupar texto e imagen.
            MimeMultipart multiParte = new MimeMultipart();
            multiParte.addBodyPart(texto);
            multiParte.addBodyPart(adjunto);
            //Asunto
            message.setContent(multiParte);
            message.setSubject(data.getSubject());
            Transport transport = session.getTransport("smtp");
            transport.connect("smtp.gmail.com", remitente, password);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (MessagingException me) {
//            me.printStackTrace();
            return false;
        }

        return true;
    }

    public Object[][] returnDataEmail() {
        String[] dataBaseName = {
            "emailGmail", "password"
        };
        return bdConnect.returnAllData("SELECT emailGmail, password", "configuration", "", dataBaseName);
    }
}
