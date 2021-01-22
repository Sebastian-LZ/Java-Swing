/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validations;

import Alerts.showAlerts;
import Model.configuration;

/**
 *
 * @author sebastian.londono
 */
public class squemaConfiguration extends javax.swing.JPanel {

    /**
     * Creates new form squemaProduct
     */
    showAlerts alerts = new showAlerts();

    public squemaConfiguration() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public boolean validation_configuration(configuration dataConfiguration) {
        //Nit
        if (dataConfiguration.getNit().equals("")) {
            alerts.alert("El nit es obligatorio");
            return false;
        }
        if (dataConfiguration.getNit().length() > 15) {
            alerts.alert("El nit es máximo de 15 caracteres");
            return false;
        }
        if (dataConfiguration.getNit().length() < 5) {
            alerts.alert("El nit es minimo de 5 caracteres");
            return false;
        }

        //Name
        if (dataConfiguration.getName().equals("")) {
            alerts.alert("El nit es obligatorio");
            return false;
        }
        if (dataConfiguration.getName().length() > 40) {
            alerts.alert("El nit es máximo de 40 caracteres");
            return false;
        }
        if (dataConfiguration.getName().length() < 5) {
            alerts.alert("El nit es minimo de 5 caracteres");
            return false;
        }

        //Name
        if (dataConfiguration.getName().equals("")) {
            alerts.alert("El nombre es obligatorio");
            return false;
        }
        if (dataConfiguration.getName().length() > 40) {
            alerts.alert("El nombre es máximo de 40 caracteres");
            return false;
        }
        if (dataConfiguration.getName().length() < 5) {
            alerts.alert("El nombre es minimo de 5 caracteres");
            return false;
        }

        //Location
        if (!dataConfiguration.getLocation().equals("") && dataConfiguration.getLocation().length() > 40) {
            alerts.alert("El lugar es máximo de 40 caracteres");
            return false;
        }
        if (!dataConfiguration.getLocation().equals("") && dataConfiguration.getLocation().length() < 5) {
            alerts.alert("El lugar es minimo de 5 caracteres");
            return false;
        }

        //Numbers
        if (!dataConfiguration.getNumbers().equals("") && dataConfiguration.getNumbers().length() > 40) {
            alerts.alert("Los numeros es máximo de 40 caracteres");
            return false;
        }
        if (!dataConfiguration.getNumbers().equals("") && dataConfiguration.getNumbers().length() < 5) {
            alerts.alert("Los numeros es minimo de 5 caracteres");
            return false;
        }

        //Emails
        if (!dataConfiguration.getEmail().equals("") && dataConfiguration.getEmail().length() > 40) {
            alerts.alert("Los email es máximo de 40 caracteres");
            return false;
        }
        if (!dataConfiguration.getEmail().equals("") && dataConfiguration.getEmail().length() < 5) {
            alerts.alert("Los email es minimo de 5 caracteres");
            return false;
        }

        //Web page
        if (!dataConfiguration.getWebPage().equals("") && dataConfiguration.getWebPage().length() > 40) {
            alerts.alert("La página web es máximo de 40 caracteres");
            return false;
        }
        if (!dataConfiguration.getWebPage().equals("") && dataConfiguration.getWebPage().length() < 5) {
            alerts.alert("La página web es minimo de 5 caracteres");
            return false;
        }

        //Email gmail
        if (!dataConfiguration.getEmailGmail().equals("") && !validateEmail(dataConfiguration.getEmailGmail())) {
            alerts.alert("El gmail no es válido");
            return false;
        }
        if (!dataConfiguration.getEmailGmail().equals("") && dataConfiguration.getEmailGmail().length() > 50) {
            alerts.alert("El gmail es máximo de 50 caracteres");
            return false;
        }

        //Password gmail
        if (!dataConfiguration.getPassword().equals("") && dataConfiguration.getPassword().length() > 20) {
            alerts.alert("La contraseña es máximo de 20 caracteres");
            return false;
        }
        if (!dataConfiguration.getPassword().equals("") && dataConfiguration.getPassword().length() < 5) {
            alerts.alert("La contraseña es minimo de 5 caracteres");
            return false;
        }

        //Footer
        if (!dataConfiguration.getFooter().equals("") && dataConfiguration.getFooter().length() > 160) {
            alerts.alert("El pie de página es máximo de 160 caracteres");
            return false;
        }
        if (!dataConfiguration.getFooter().equals("") && dataConfiguration.getFooter().length() < 5) {
            alerts.alert("El pie de página es minimo de 5 caracteres");
            return false;
        }

        return true;
    }

    private boolean validateEmail(String email) {
        Object[] optionsEmail = {"@gmail.com"};
        boolean validation = false;
        for (Object option : optionsEmail) {
            if (email.contains(option.toString())) {
                validation = true;
            }
        }
        return validation;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
