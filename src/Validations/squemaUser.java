/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Validations;

import Alerts.showAlerts;
import Model.user;

/**
 *
 * @author sebastian.londono
 */
public class squemaUser extends javax.swing.JPanel {

    /**
     * Creates new form squemaProduct
     */
    showAlerts alerts = new showAlerts();

    public squemaUser() {
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

    public boolean validation_user(user dataUser) {

        //Name
        if (dataUser.getName().equals("")) {
            alerts.alert("El nombre es obligatorio");
            return false;
        }
        if (dataUser.getName().length() > 50) {
            alerts.alert("El nombre es máximo de 50 caracteres");
            return false;
        }
        if (dataUser.getName().length() < 5) {
            alerts.alert("El nombre es minimo de 10 caracteres");
            return false;
        }

        //Username
        if (dataUser.getUserName().equals("")) {
            alerts.alert("El usuario es obligatorio");
            return false;
        }
        if (dataUser.getUserName().length() > 20) {
            alerts.alert("El usuario es máximo de 20 caracteres");
            return false;
        }
        if (dataUser.getUserName().length() < 5) {
            alerts.alert("El usuario es minimo de 5 caracteres");
            return false;
        }

        //Password
        if (dataUser.getPassword().equals("")) {
            alerts.alert("La contraseña es obligatoria");
            return false;
        }
        if (dataUser.getRepassword().equals("")) {
            alerts.alert("La confirmación es obligatoria");
            return false;
        }
        if (!dataUser.getPassword().equals(dataUser.getRepassword())) {
            alerts.alert("La contraseña y la confirmación no coinciden");
            return false;
        }
        if (dataUser.getPassword().length() > 20) {
            alerts.alert("La contraseña es máximo de 20 caracteres");
            return false;
        }
        if (dataUser.getPassword().length() < 5) {
            alerts.alert("La contraseña es minimo de 5 caracteres");
            return false;
        }

        return true;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
