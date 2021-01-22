/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Database;

import Alerts.showAlerts;
import Utils.Others.information;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebastian.londono
 */
public class connection {

    information data = new information();
    private static Connection conexion = null;
    showAlerts alerts = new showAlerts();
    public Boolean showAlert = true;

    public void connectionDB() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try {
                conexion = DriverManager.getConnection(data.getBdUrl(), data.getBdUsername(), data.getBdPassword());
                System.out.println("Conexión a la base de datos exitosa");
            } catch (SQLException ex) {
                System.out.println("Error: " + ex);
                alerts.alertFail("Error al conectarse a la Base de datos");
                System.exit(0);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getConnection() {
        return conexion;
    }

    //Operaciones crud
    public boolean createData(String table, String values) {
        int resp = 0;
        try {
            String query = "INSERT INTO " + table + " VALUES (" + values + ")";
            Statement stmt = conexion.createStatement();
            resp = stmt.executeUpdate(query);
            if (resp > 0) {
                if (showAlert) {
                    alerts.alertSuccess("Registro creado con exito");
                }
            } else {
                alerts.alertFail("Error al crear el registro");
            }
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
        }

        showAlert = true;
        if (resp > 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deleteData(String table, String condition) {
        boolean resp = false;
        String instruccion = "DELETE FROM " + table + " " + condition;
        try {
            PreparedStatement pstm = conexion.prepareStatement(instruccion);
            pstm.execute();
            pstm.close();
            if (showAlert) {
                alerts.alertSuccess("Registro eliminado con exito");
            }
            resp = true;
        } catch (SQLException e) {
            alerts.alertFail("Error al eliminar el registro");
            System.out.println(e);
        }

        showAlert = true;
        return resp;
    }

    public boolean updateData(String table, String values, String condition, Object data[]) {
        boolean resp = false;

        try {
            String instruccion_sql = "UPDATE " + table + " SET " + values + " " + condition;
            PreparedStatement pstm = conexion.prepareStatement(instruccion_sql);

            if (data != null) {
                for (int i = 1; i < data.length; i++) {
                    try {
                        pstm.setBoolean(i, (boolean) data[i]);
                    } catch (Exception e) {
                        try {
                            pstm.setInt(i, (int) data[i]);
                        } catch (Exception ex) {
                            try {
                                pstm.setString(i, (String) data[i]);
                            } catch (ArrayIndexOutOfBoundsException ee) {
                                try {
                                    SQLXML xmlVal = conexion.createSQLXML();
                                    xmlVal.setString(data[i].toString());
                                } catch (Exception exx) {
                                }
                            }
                        }
                    }
                }
            }
            pstm.execute();
            pstm.close();
            if (showAlert) {
                alerts.alertSuccess("Registro actualizado con exito");
            }
            resp = true;
        } catch (SQLException ex) {
            Logger.getLogger(connection.class.getName()).log(Level.SEVERE, null, ex);
            alerts.alertFail("Error al actualizar el registro");
        }

        showAlert = true;
        return resp;
    }

    //Buscador
    public DefaultTableModel getDataSeeker(String table, String dataToSelect, String condition, String orderSql,
            String tableNames[], String dataBaseName[]) {
        Object[][] data = null;
        int registros = 0;

        try {
            PreparedStatement pstm = conexion.prepareStatement("SELECT count(*) as total FROM " + table + " " + condition);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            data = new String[registros][dataBaseName.length];
            String col[] = new String[dataBaseName.length];
            PreparedStatement pstm1 = conexion.prepareStatement(dataToSelect + " FROM " + table + " "
                    + condition + " " + orderSql);
            res = pstm1.executeQuery();
            int i = 0;
            while (res.next()) {
                for (int j = 0; j <= dataBaseName.length - 1; j++) {
                    col[j] = res.getString(dataBaseName[j]);
                    data[i][j] = col[j];
                }
                i++;
            }
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        DefaultTableModel datos = new DefaultTableModel(data, tableNames) {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        return datos;
    }

    //Consultar un string
    public String returnData(String dataToSelect, String table, String condition, String dataBaseName[]) {
        String instruccion_sql = dataToSelect + " FROM " + table + " " + condition;
        Object[] data = new Object[dataBaseName.length];
        try {
            PreparedStatement pstm = conexion.prepareStatement(instruccion_sql);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                for (int j = 0; j <= dataBaseName.length - 1; j++) {
                    //if (cadena[j]) {
                    data[j] = res.getString(dataBaseName[j]);
                    //} else {
                    //  data[j] = res.getBoolean(dataBaseName[j]);
                    //}
                }
            }
            res.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        if (data[0] != null) {
            return data[0].toString();
        } else {
            return null;
        }

    }

    public Object[][] returnAllData(String dataToSelect, String table, String condition, String dataBaseName[]) {
        int registros = 0;
        Object[][] data = null;
        try {
            PreparedStatement pstm = conexion.prepareStatement("SELECT count(*) as total FROM " + table + " " + condition);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            data = new String[registros][dataBaseName.length];
            String col[] = new String[dataBaseName.length];
            PreparedStatement pstm1 = conexion.prepareStatement(dataToSelect + " FROM " + table + " " + condition);
            res = pstm1.executeQuery();
            int i = 0;
            while (res.next()) {
                for (int j = 0; j <= dataBaseName.length - 1; j++) {
                    col[j] = res.getString(dataBaseName[j]);
                    data[i][j] = col[j];
                }
                i++;
            }

            res.close();
            pstm.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return data;
    }

}
