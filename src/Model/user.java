/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author sebastian.londono
 */
public class user {

    String userName = "";
    String name = "";
    String password = "";
    String repassword = "";

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public user dataUser(Object[] vector) {
        user dataUser = new user();
        dataUser.setUserName((String) vector[0]);
        dataUser.setName((String) vector[1]);
        dataUser.setPassword((String) vector[2]);
        return dataUser;
    }
}
