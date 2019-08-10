package dev.tuhin.oilgame.entities;

import dev.tuhin.oilgame.gfx.Assets;
import dev.tuhin.oilgame.states.GameState;

import java.awt.*;

/**
 * Created by DarkThunder on 9/19/2016.
 */
public class Dowser extends Entities
{
    int n=1;
    boolean a=true;
    public Dowser(int x, int y) {
        super(x, y);
        price = 500;
    }

    @Override
    public void tick() {
        if (x>=1024-43-64) {
            n = -1;
            a = false;
        }
        else if(x<=64) {
            n = 1;
            a = true;
        }

        for (Oil o: GameState.oils)
        {
            if(x==o.x+(o.width/2) && o.found!=true)
            {
                n=0;
                o.found=true;
            }
        }

        x+=n;
    }

    @Override
    public void render(Graphics g) {
        if(!a)
            g.drawImage(Assets.dowser[0], x, y, null);
        else if(a)
            g.drawImage(Assets.dowser[1], x, y, null);
    }
}
