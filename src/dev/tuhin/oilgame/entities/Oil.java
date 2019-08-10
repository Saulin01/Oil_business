package dev.tuhin.oilgame.entities;

import dev.tuhin.oilgame.states.GameState;

import java.awt.*;

/**
 * Created by DarkThunder on 9/19/2016.
 */
public class Oil
{
    public int x, y, y1, height1, width, height, pipes=0, capacity;
    public boolean found;

    public Oil(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        capacity = (width*height)/10;
        y1 = y+3;
        height1 = height-10;
    }

    public void tick() {
        if(pipes>0)
        {
            capacity-=pipes;
            GameState.money+=(pipes);
        }
    }

    public void render(Graphics g) {
        g.setColor(Color.gray);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.fillRect (x+5, y+5, width-10, height1);
    }

    public boolean isInside(int x, int y)
    {
        if (x>=this.x && x<=this.x+width && y>=this.y && y<=this.y+height)
        {
            return true;
        }
        else
            return false;
    }

    public int getPipes() {
        return pipes;
    }

    public void setPipes(int pipes) {
        this.pipes = pipes;
    }
}
