/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Others;

/**
 *
 * @author sebastian.londono
 */
public class information {

    private String bdUrl = "jdbc:mysql://localhost:3306/catalogo-dev";
    private String bdUsername = "root";
    private String bdPassword = "root";

    public String getBdUrl() {
        return bdUrl;
    }

    public void setBdUrl(String bdUrl) {
        this.bdUrl = bdUrl;
    }

    public String getBdUsername() {
        return bdUsername;
    }

    public void setBdUsername(String bdUsername) {
        this.bdUsername = bdUsername;
    }

    public String getBdPassword() {
        return bdPassword;
    }

    public void setBdPassword(String bdPassword) {
        this.bdPassword = bdPassword;
    }
}
