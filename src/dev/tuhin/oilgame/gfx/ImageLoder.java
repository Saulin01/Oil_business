package dev.tuhin.oilgame.gfx;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by DarkThunder on 8/22/2016.
 */

public class ImageLoder
{

    public static BufferedImage loadImage(String path)
    {
        try {
            return ImageIO.read(ImageLoder.class.getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

}
