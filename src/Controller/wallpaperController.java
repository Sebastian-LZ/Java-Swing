/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.wallpaper;
import Utils.Database.connection;

/**
 *
 * @author sebastian.londono
 */
public class wallpaperController {

    private String table = "wallpaper";
    connection bdConnect = new connection();

    public boolean createWallpaper(wallpaper modelWallpaper) {
        String values = "0, '" + modelWallpaper.getDescription() + "', '" + modelWallpaper.getImageURL() + "', "
                + modelWallpaper.getCantPage();
        return bdConnect.createData(table, values);
    }

    public boolean updateWallpaper(wallpaper modelWallpaper) {
        Object[] data = {modelWallpaper.getIdWallpaper(), modelWallpaper.getDescription(), modelWallpaper.getImageURL(),
            modelWallpaper.getCantPage()};
        return bdConnect.updateData(table, "description=?, imageUrl=?, cantPage=?",
                "WHERE idWallpaper = " + modelWallpaper.getIdWallpaper(), data);
    }

    public Object[][] returnDataWallpaper(String idWallpaper) {
        String[] dataBaseName = {
            "idWallpaper", "description", "imageUrl", "cantPage"
        };
        return bdConnect.returnAllData("SELECT idWallpaper, description, imageUrl, cantPage", "wallpaper",
                "WHERE idWallpaper = " + idWallpaper, dataBaseName);
    }
}
