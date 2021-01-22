/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.Database.connection;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author sebastian.londono
 */
public class seekerController {

    connection bdConnect = new connection();

    public DefaultTableModel openSeeker(String table, String dataToSelect, String condition, String orderSql,
            String tableNames[], String dataBaseName[]) {
        return bdConnect.getDataSeeker(table, dataToSelect, condition, orderSql, tableNames, dataBaseName);
    }
}
