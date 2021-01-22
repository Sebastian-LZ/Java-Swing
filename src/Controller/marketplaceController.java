/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Alerts.showAlerts;
import Utils.Database.connection;
import Utils.Others.printReport;
import View.SendEmail;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;

/**
 *
 * @author sebastian.londono
 */
public class marketplaceController {

    private String table = "marketplace";
    connection bdConnect = new connection();
    showAlerts alerts = new showAlerts();

    public DefaultTableModel getProducts(String table, String dataToSelect, String condition, String orderSql,
            String tableNames[], String dataBaseName[]) {
        return bdConnect.getDataSeeker(table, dataToSelect, condition, orderSql, tableNames, dataBaseName);
    }

    public DefaultTableModel getWallpapersAndCovers(String table, String dataToSelect, String condition, String orderSql,
            String tableNames[], String dataBaseName[]) {
        return bdConnect.getDataSeeker(table, dataToSelect, condition, orderSql, tableNames, dataBaseName);
    }

    public String currentPath() {
        String dataBaseName[] = {
            "pathImages"
        };
        return bdConnect.returnData("SELECT pathImages", "config", "", dataBaseName);
    }

    public boolean createProduct(int count, String codProduct) {
        String values = count + ", '" + codProduct + "'";
        bdConnect.showAlert = false;
        return bdConnect.createData(table, values);
    }

    public boolean deleteProduct() {
        bdConnect.showAlert = false;
        return bdConnect.deleteData(table, "");
    }

    public Boolean generateMarketplace(String urlBackground, String urlCover, int option,
            String nit, String name, String location, String numbers, String email,
            String webPage, String description, String footer) {

        String path = null;
        String pathBackground = System.getProperty("user.dir") + "\\Images-client\\";

        JasperReport reporte;
        try {
            URL in = null;
            if (option == 1) {
                in = this.getClass().getResource("/Reports/marketplace_one.jasper");
            } else if (option == 2) {
                in = this.getClass().getResource("/Reports/marketplace.jasper");
            } else if (option == 4) {
                in = this.getClass().getResource("/Reports/marketplace_four.jasper");
            }

            reporte = (JasperReport) JRLoader.loadObject(in);
            Map parametros = new HashMap();
            parametros.clear();
            parametros.put("nit", nit);
            parametros.put("name", name);
            parametros.put("location", location);
            parametros.put("numbers", numbers);
            parametros.put("email", email);
            parametros.put("webPage", webPage);
            parametros.put("description", description);
            parametros.put("footer", footer);
            parametros.put("pathImages", currentPath());
            parametros.put("pathBackground", pathBackground.replace("\\", "/"));
            parametros.put("nameBackground", urlBackground);
            parametros.put("nameCover", "Cover-" + urlCover);
            printReport marketplace = new printReport(parametros, reporte, true, true);
            path = marketplace.obtainPath("Catalogo");
            marketplace.run(path);

            if (path != null) {
                if (alerts.option("¿Enviar catálogo por correo?")) {
                    SendEmail sendEmail = new SendEmail(null, true, path);
                    sendEmail.setVisible(true);
                }

            }
        } catch (JRException E) {
            System.out.println(E);
        }

        if (path != null) {
            alerts.alertSuccess("¡Catalogo generado exitosamente!");
            try {
                Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + path);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return true;
        } else {
            return false;
        }
    }

    public Object[][] returnDataConfiguration() {
        String[] dataBaseName = {
            "nit", "name", "location", "numbers", "email", "webPage", "description", "footer"
        };
        return bdConnect.returnAllData("SELECT nit, name, location, numbers, email, webPage, "
                + "description, footer", "configuration", "", dataBaseName);
    }
}
