package dev.tuhin.oilgame.gfx;

import java.awt.image.BufferedImage;

/**
 * Created by DarkThunder on 8/22/2016.
 */
public class Assets
{
    private static final int width=16, height=16;

    public static BufferedImage earth, redInc, blueInc, rig, silo, wagon[] = new BufferedImage[2], dowser[] = new BufferedImage[2],
            rigIcon[] = new BufferedImage[2], siloIcon[] = new BufferedImage[2], wagonIcon[] = new BufferedImage[2],
            startIcon[] = new BufferedImage[2], exitIcon[] = new BufferedImage[2], aboutIcon[] = new BufferedImage[2],
            title, about, dowserIcon[] = new BufferedImage[2], tick[] = new BufferedImage[2];

    public static void init()
    {
        earth = ImageLoder.loadImage("/textures/earth.png");
        redInc = ImageLoder.loadImage("/textures/Red.png");
        blueInc = ImageLoder.loadImage("/textures/Blue.png");
        rig = ImageLoder.loadImage("/textures/rig.png");
        silo = ImageLoder.loadImage("/textures/silo.png");
        dowser[0] = ImageLoder.loadImage("/textures/dowser.png");
        dowser[1] = ImageLoder.loadImage("/textures/dowser1.png");
        wagon[0] = ImageLoder.loadImage("/textures/wagon1.png");
        wagon[1] = ImageLoder.loadImage("/textures/wagon2.png");
        dowserIcon[0] = ImageLoder.loadImage("/textures/dowser-icon1.png");
        dowserIcon[1] = ImageLoder.loadImage("/textures/dowser-icon2.png");
        rigIcon[0] = ImageLoder.loadImage("/textures/rig-icon1.png");
        rigIcon[1] = ImageLoder.loadImage("/textures/rig-icon2.png");
        siloIcon[0] = ImageLoder.loadImage("/textures/silo-icon1.png");
        siloIcon[1] = ImageLoder.loadImage("/textures/silo-icon2.png");
        wagonIcon[0] = ImageLoder.loadImage("/textures/wagon-icon1.png");
        wagonIcon[1] = ImageLoder.loadImage("/textures/wagon-icon2.png");
        startIcon[0] = ImageLoder.loadImage("/textures/start1.png");
        startIcon[1] = ImageLoder.loadImage("/textures/start2.png");
        exitIcon[0] = ImageLoder.loadImage("/textures/exit1.png");
        exitIcon[1] = ImageLoder.loadImage("/textures/exit2.png");
        aboutIcon[0] = ImageLoder.loadImage("/textures/about1.png");
        aboutIcon[1] = ImageLoder.loadImage("/textures/about2.png");
        title = ImageLoder.loadImage("/textures/title.png");
        about = ImageLoder.loadImage("/textures/about-page.png");
        tick[0] = ImageLoder.loadImage("/textures/no.png");
        tick[1] = ImageLoder.loadImage("/textures/yes.png");
    }
}