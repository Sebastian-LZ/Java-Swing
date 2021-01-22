/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.product;
import Utils.Database.connection;

/**
 *
 * @author sebastian.londono
 */
public class productController {

    private String table = "product";
    connection bdConnect = new connection();

    public boolean createProduct(product modelProd) {
        String values = "'" + modelProd.getCodeProduct() + "', '" + modelProd.getDescription() + "', "
                + modelProd.getPrice() + ", " + modelProd.getCant() + ", '" + modelProd.getDescription1() + "', "
                + "'" + modelProd.getDescription2() + "'";
        bdConnect.showAlert = false;
        return bdConnect.createData(table, values);
    }

    public boolean createPathImages(String path) {
        bdConnect.showAlert = false;
        bdConnect.deleteData("config", "");
        String values = "'" + path + "'";
        return bdConnect.createData("config", values.replace("\\", "/"));
    }

    public boolean deleteProduct() {
        bdConnect.showAlert = false;
        return bdConnect.deleteData(table, "");
    }

    public String currentPath() {
        String dataBaseName[] = {
            "pathImages"
        };
        return bdConnect.returnData("SELECT pathImages", "config", "", dataBaseName);
    }

}
