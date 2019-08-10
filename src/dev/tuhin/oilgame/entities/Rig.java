package dev.tuhin.oilgame.entities;

import dev.tuhin.oilgame.gfx.Assets;
import dev.tuhin.oilgame.states.GameState;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by DarkThunder on 8/30/2016.
 */
public class Rig extends Entities {
    int n=0, a=1, b=0, x1, y1;
    boolean hit=false;

    public Rig(int x, int y) {
        super(x, y);

        width = 64;
        height = 128;
        capacity = 64;
        price = 750;
        x1 = x+(width/2-5);
        y1 = y+height;
    }

    @Override
    public void tick() {
        n+=a;
        for (Oil o: GameState.oils)
        {
            hit = o.isInside(x1+5, n+y1);
            if(hit || n>300)
            {
                a=0;
                if(hit && b!=0)
                {
                    b=1;
                    o.pipes+=1;
                }
            }
        }
        if(GameState.ground[x1/16][(n+y1-420)/16]!=false)
            GameState.ground[x1/16][(n+y1-420)/16]=false;
        if (GameState.ground[(x1+10)/16][(n+y1-420)/16]!=false)
            GameState.ground[(x1+10)/16][(n+y1-420)/16]=false;
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.rig, x, y, null);
        g.setColor(Color.WHITE);
        g.fillOval(x+(width/2-5), y+(height-10), 10, 10);

        //System.out.println(a);
        //pipe
        if(!hit) {

            g.setColor(Color.gray);
            g.fillRect(x1, y1, 10, n);
        }
        else {
            g.setColor(Color.BLACK);
            g.fillRect(x1, y1, 10, n+10);
        }
    }
}
