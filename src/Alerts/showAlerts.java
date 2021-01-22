/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Alerts;

/**
 *
 * @author sebastian.londono
 */
public class showAlerts extends javax.swing.JPanel {

    /**
     * Creates new form showAlerts
     */
    public showAlerts() {
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

    public void alertFail(String message) {
        Fail messageError = new Fail(null, true, message);
        messageError.setVisible(true);
    }

    public void alertSuccess(String message) {
        Success messageSuccess = new Success(null, true, message);
        messageSuccess.setVisible(true);
    }

    public void alert(String message) {
        Alert messageAlert = new Alert(null, true, message);
        messageAlert.setVisible(true);
    }

    public void bigAlert(String message) {
        BigAlert messageBigAlert = new BigAlert(null, true, message);
        messageBigAlert.setVisible(true);
    }

    public Boolean option(String ask) {
        Option messageOption = new Option(null, true, ask);
        messageOption.setVisible(true);
        return messageOption.answer;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}