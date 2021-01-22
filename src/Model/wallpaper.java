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
public class wallpaper {

    String idWallpaper = "";
    String description = "";
    String imageURL = "";
    Integer cantPage = 0;
    
    public String getIdWallpaper() {
        return idWallpaper;
    }

    public void setIdWallpaper(String idWallpaper) {
        this.idWallpaper = idWallpaper;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public Integer getCantPage() {
        return cantPage;
    }

    public void setCantPage(Integer cantPage) {
        this.cantPage = cantPage;
    }
}
