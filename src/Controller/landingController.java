/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Utils.Database.connection;

/**
 *
 * @author sebastian.londono
 */
public class landingController {

    connection bdConnect = new connection();

    public String login(String username, String password) {
        String dataBaseName[] = {
            "name"
        };

        return bdConnect.returnData("SELECT name", "user", "WHERE username = '" + username + "' and password = '" + password + "'", 
                dataBaseName);
    }
}
