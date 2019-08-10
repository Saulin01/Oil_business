package dev.tuhin.oilgame.entities;

import java.awt.*;

/**
 * Created by DarkThunder on 8/30/2016.
 */
public abstract class Entities {
    protected int x,y;
    public int width, height, capacity, price;

    public Entities(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isInside(int x, int y) {
        if(x>=this.x && x<=this.x+width && y>=this.y && y<=this.y+height)
            return true;

        else
            return false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getCapacity() {
        return capacity;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}