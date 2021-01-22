/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.cover;
import Utils.Database.connection;

/**
 *
 * @author sebastian.londono
 */
public class coverController {

    private String table = "cover";
    connection bdConnect = new connection();

    public boolean createCover(cover modelCover) {
        String values = "0, '" + modelCover.getDescription() + "', '" + modelCover.getImageURL() + "'";
        return bdConnect.createData(table, values);
    }

    public boolean updateCover(cover modelCover) {        
        Object[] data = {modelCover.getIdCover(), modelCover.getDescription(), modelCover.getImageURL()};
        return bdConnect.updateData(table, "description=?, imageUrl=?",
                "WHERE idCover = " + modelCover.getIdCover(), data);
    }

    public Object[][] returnDataCover(String idCover) {
        String[] dataBaseName = {
            "idCover", "description", "imageUrl"
        };
        return bdConnect.returnAllData("SELECT idCover, description, imageUrl", table,
                "WHERE idCover = " + idCover, dataBaseName);
    }
}
