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
public class configuration {

    String nit = "";
    String name = "";
    String location = "";
    String numbers = "";
    String email = "";
    String webPage = "";
    String description = "";
    String emailGmail = "";
    String password = "";
    String footer = "";

    public String getFooter() {
        return footer;
    }

    public void setFooter(String footer) {
        this.footer = footer;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebPage() {
        return webPage;
    }

    public void setWebPage(String webPage) {
        this.webPage = webPage;
    }

    public String getEmailGmail() {
        return emailGmail;
    }

    public void setEmailGmail(String emailGmail) {
        this.emailGmail = emailGmail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*public configuration dataUser(Object[] vector) {
        configuration dataUser = new configuration();
        dataUser.setUserName((String) vector[0]);
        dataUser.setName((String) vector[1]);
        dataUser.setPassword((String) vector[2]);
        return dataUser;
    }*/
}
