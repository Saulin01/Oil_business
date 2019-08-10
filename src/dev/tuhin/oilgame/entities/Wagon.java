package dev.tuhin.oilgame.entities;

import dev.tuhin.oilgame.gfx.Assets;

import java.awt.*;

/**
 * Created by DarkThunder on 9/19/2016.
 */
public class Wagon extends Entities{
    int a=1;
    private boolean direction=true;
    public Wagon(int x, int y) {
        super(x, y);
        price=750;
    }

    @Override
    public void tick() {
        x+=a;
        if(x>=1024-64-55)
        {
            a=-1;
            direction=false;
        }
        else if(x<=64)
        {
            a=1;
            direction=true;
        }

    }

    @Override
    public void render(Graphics g) {
        if(direction)
            g.drawImage(Assets.wagon[1], x, y, null);
        else if(!direction)
            g.drawImage(Assets.wagon[0], x, y, null);

    }
}
