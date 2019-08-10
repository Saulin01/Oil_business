package dev.tuhin.oilgame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by DarkThunder on 8/22/2016.
 */
public class SpriteSheet {
    private BufferedImage sheet;

    public SpriteSheet(BufferedImage sheet)
    {
        this.sheet=sheet;
    }

    public BufferedImage crop(int x, int y, int width, int height)
    {
        return sheet.getSubimage(x, y, width, height);
    }
}
