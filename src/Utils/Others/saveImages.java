/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils.Others;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author sebastian.londono
 */
public class saveImages {

    public void saveImage(String origen, String destino) {
        BufferedImage imagen = uploadImagen(origen);
        moveImagen(imagen, destino);
    }

    public static void moveImagen(BufferedImage bufferedImage, String pathName) {
        try {
            String format = (pathName.endsWith(".png")) ? "png" : "jpg";
            File file = new File(pathName);
            file.getParentFile().mkdirs();
            ImageIO.write(bufferedImage, format, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static BufferedImage uploadImagen(String origen) {
        BufferedImage image = null;
        try {
            image = ImageIO.read(new File(origen));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return image;
    }
}
