/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.user;
import Utils.Database.connection;

/**
 *
 * @author sebastian.londono
 */
public class userController {

    private String table = "user";
    connection bdConnect = new connection();

    public boolean createUser(user modelUser) {
        String values = "'" + modelUser.getUserName() + "', '" + modelUser.getName() + "', '" + modelUser.getPassword() + "'";
        return bdConnect.createData(table, values);
    }

    public boolean updateUser(user modelUser) {
        Object[] data = {modelUser.getUserName(), modelUser.getName(), modelUser.getPassword()};
        return bdConnect.updateData(table, "name=?, password=?", "WHERE username = '" + modelUser.getUserName() + "'", data);
    }

    public Object[][] returnDataUser(String username) {
        String[] dataBaseName = {
            "username", "name", "password"
        };
        return bdConnect.returnAllData("SELECT username, name, password", "user", "WHERE username = '" + username + "'",
                dataBaseName);
    }
}
