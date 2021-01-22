/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.configuration;
import Utils.Database.connection;

/**
 *
 * @author sebastian.londono
 */
public class configurationController {

    private String table = "configuration";
    connection bdConnect = new connection();

    public boolean createConfiguration(configuration modelConfiguration) {
        String values = "'" + modelConfiguration.getNit() + "', '" + modelConfiguration.getName() + "', "
                + "'" + modelConfiguration.getLocation() + "', '" + modelConfiguration.getNumbers() + "', "
                + "'" + modelConfiguration.getEmail() + "', '" + modelConfiguration.getWebPage() + "', "
                + "'" + modelConfiguration.getDescription() + "', '" + modelConfiguration.getEmailGmail() + "', "
                + "'" + modelConfiguration.getPassword() + "', '" + modelConfiguration.getFooter() + "'";
        bdConnect.showAlert = false;
        bdConnect.deleteData(table, "");
        System.out.println(values);
        return bdConnect.createData(table, values);
    }

    public boolean deleteProduct() {
        bdConnect.showAlert = false;
        return bdConnect.deleteData(table, "");
    }

    public Object[][] returnDataConfiguration() {
        String[] dataBaseName = {
            "nit", "name", "location", "numbers", "email", "webPage", "description", "emailGmail", "password", "footer"
        };
        return bdConnect.returnAllData("SELECT nit, name, location, numbers, email, webPage, description, "
                + "emailGmail, password, footer", table, "", dataBaseName);
    }

}
