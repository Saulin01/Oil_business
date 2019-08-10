package dev.tuhin.oilgame.states;

import dev.tuhin.oilgame.Game;
import dev.tuhin.oilgame.entities.Entities;
import dev.tuhin.oilgame.entities.Rig;
import dev.tuhin.oilgame.entities.Silo;
import dev.tuhin.oilgame.gfx.Assets;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DarkThunder on 8/22/2016.
 */
public class MenuState extends State
{
    private int width, height, placed=0;
    private int x, y=150,x1=0,y1=20, x2=0, y2=85;

    public MenuState(int width, int height, Game game) {
        super(game);
        this.width = width;
        this.height = height;
    }

    @Override
    public void tick() {
        x+=1;
        if (x>=width) {
            x=-150;
        }
        if(x%2==0) {
            x1+=1;
            if(x1>=width+20)
                x1=-95;

            if(x1%2==0)
            {
                x2+=1;
                if(x1>=width)
                {
                    x2=-55;
                }
            }
        }
    }

    @Override
    public void render(Graphics g) {
        init(g);
    }

    private void init(Graphics g) {
        //sky
        Color c=new Color(115,200,255);
        g.setColor(c);
        g.fillRect(0,0,width,height);

        cloud(g);

        //Company
        g.drawImage(Assets.blueInc, 0, height-300-128, 128, 128, null);
        g.drawImage(Assets.redInc, width-128, height-300-128, 128, 128, null);

        //Ground draw
        for (int y=height-300;y<=height;y+=16) {
            for (int x=0;x<width;x+=16) {
                g.drawImage(Assets.earth, x, y, null);
            }
        }

        //Icons
        iconManager(g);
    }

    public void iconManager(Graphics g)
    {
        int mouseX = game.getMouseManager().getMouseX(),
                mouseY = game.getMouseManager().getMouseY();
        int clicked = game.getMouseManager().getClickCount();

        g.drawImage(Assets.title, 310, 35, null);
        g.drawImage(Assets.startIcon[0], 412, 300, null);
        g.drawImage(Assets.aboutIcon[0], 437, 430, null);
        g.drawImage(Assets.exitIcon[0], 437, 510, null);

        //start
        if(mouseX>=412 && mouseX<=412+200 && mouseY>=300 && mouseY<=400) {
            g.drawImage(Assets.startIcon[1], 412, 300, null);
            if(clicked==1)
            {
                State.setState(game.getGameState());
                game.getMouseManager().setClickCount(0);
            }
        }

        //about
        else if(mouseX>=437 && mouseX<=412+150 && mouseY>=430 && mouseY<=500) {
            g.drawImage(Assets.aboutIcon[1], 437, 430, null);
            if (clicked==1)
            {
                State.setState(game.getAboutState());
                //game.getMouseManager().setClickCount(0);
            }
        }

        //exit
        else if(mouseX>=437 && mouseX<=437+150 && mouseY>=510 && mouseY<=590) {
            g.drawImage(Assets.exitIcon[1], 437, 510, null);
            if(clicked==1)
            {
                System.exit(0);
            }
        }
    }

    private void cloud(Graphics g) {
        g.setColor(Color.WHITE);

        g.fillOval(x2, y2, 40, 35);
        g.fillOval(x2+15, y2+5, 40, 35);
        g.fillOval(x2-5, y2+5, 40, 35);

        g.fillOval(x,y,160,90);
        g.fillOval(x+30,y-25,120,120);

        g.fillOval(x1,y1,80,50);
        g.fillOval(x1-30,y1-5,55,40);
        g.fillOval(x1+35,y1-5,55,40);
    }
}