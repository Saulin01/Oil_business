package dev.tuhin.oilgame.entities;

import dev.tuhin.oilgame.gfx.Assets;

import java.awt.*;

/**
 * Created by DarkThunder on 8/30/2016.
 */
public class Silo extends Entities {

    public Silo(int x, int y) {
        super(x, y);
        price = 1000;
        width = 128;
        height = 64;
        capacity = 2560;
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.silo, x, y, null);
    }
}
