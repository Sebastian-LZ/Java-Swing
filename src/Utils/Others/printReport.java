/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Others;

import Alerts.showAlerts;
import Utils.Database.connection;
import java.io.File;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JInternalFrame;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;

/**
 *
 * @author sebastian.londono
 */
public class printReport {

    showAlerts alerts = new showAlerts();
    connection bdConnect = new connection();
    public JasperPrint reporte_view;
    public JasperReport reporte;
    public Map parametros;
    public boolean usingDB, imprimir;
    private String pathToSave = "";

    public void setPathToSave(String pathToSave) {
        this.pathToSave = pathToSave;
    }

    public printReport(Map parametros, JasperReport reporte, boolean imprimir, boolean usingDB) {
        this.parametros = parametros;
        this.reporte = reporte;
        this.imprimir = imprimir;
        this.usingDB = usingDB;
    }

    public void run(String pathSave) {

        try {
            if (usingDB) {
                reporte_view = JasperFillManager.fillReport(reporte, parametros, bdConnect.getConnection());
            } else {
                reporte_view = JasperFillManager.fillReport(reporte, parametros, new JREmptyDataSource());
            }

            if (pathSave != null) {
                if (pathSave.equals("")) {
                    JasperExportManager.exportReportToPdfFile(reporte_view, System.getProperty("user.home") + "/desktop/Catalogo.pdf");
                } else {
                    JasperExportManager.exportReportToPdfFile(reporte_view, pathSave);
                }
            }
            /* if (count <= 0) {
                JasperPrintManager.printReport(reporte_view, false);
            }*/
        } catch (JRException ex) {
            Logger.getLogger(printReport.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String obtainPath(String nombre) {
        JFileChooser ventana = new JFileChooser("C:\\");
        ventana.setSelectedFile(new File("C:\\" + nombre + ".pdf"));
        int boton = ventana.showDialog(null, "Seleccionar");
        if (boton == 0) {
            return ventana.getSelectedFile().toString();
        }
        return null;
    }

}
