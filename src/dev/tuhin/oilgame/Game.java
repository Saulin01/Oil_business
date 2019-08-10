package dev.tuhin.oilgame;

import dev.tuhin.oilgame.display.Display;
import dev.tuhin.oilgame.gfx.Assets;
import dev.tuhin.oilgame.input.MouseManager;
import dev.tuhin.oilgame.states.AboutState;
import dev.tuhin.oilgame.states.GameState;
import dev.tuhin.oilgame.states.MenuState;
import dev.tuhin.oilgame.states.State;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * Created by DarkThunder on 8/22/2016.
 */
public class Game implements Runnable
{
    private Display display;

    public int width,height;
    public String title;

    private boolean running=false;
    private Thread thread;
    private MouseManager mouseManager;

    private BufferStrategy bs;
    private Graphics g;

    //states
    State gameState;
    State menuState;
    State aboutState;

    public Game(String title, int width, int height)
    {
        this.width=width;
        this.height=height;
        this.title=title;

        mouseManager = new MouseManager();
    }

    private void init()
    {
        display = new Display(title, width, height);
        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);

        Assets.init();

        //State start

        gameState = new GameState(width,height, this);
        menuState = new MenuState(width, height, this);
        aboutState = new AboutState(this);
        State.setState(menuState);

        //State end
    }

    private void tick()
    {
        if (State.getState() != null)
            State.getState().tick();

    }

    private void render()
    {
        bs = display.getCanvas().getBufferStrategy();
        if  (bs==null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g=bs.getDrawGraphics();

        //Clear Screen

        g.clearRect(0, 0, width, height);

        //Draw here

        if (State.getState() != null)
            State.getState().render(g);

        //End Drawing
        bs.show();
        g.dispose();
    }

    @Override
    public void run()
    {
        init();

        int fps = 60;
        double timePerTick = 1000000000/fps;
        double delta=0;
        long now;
        long lastTime = System.nanoTime();
        long timer = 0;
        long ticks = 0;

        while(running)
        {
            now = System.nanoTime();
            delta += (now-lastTime)/timePerTick;
            timer += now-lastTime;
            lastTime = now;

            //hame loop
            if (delta>=1)
            {
                tick();
                render();
                ticks++;
                delta--;
            }
            //fps counter
            if(timer>=1000000000)
            {
                //System.out.println("FPS: "+ticks);
                /*g.setFont(new Font("TimesRoman", Font.PLAIN, 600));
                g.setColor(Color.cyan);
                g.drawString("FPS: ", 10, 10);*/

                ticks=0;
                timer=0;
            }
        }
    }

    public synchronized void start()
    {
        if (running==true)
            return;

        running=true;
        thread = new Thread(this);
        thread.start();
    }

    public synchronized void stop()
    {
        if(running==false)
            return;

        running=false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public MouseManager getMouseManager() {
        return mouseManager;
    }

    public State getGameState()
    {
        return gameState;
    }

    public State getMenuState() {
        return menuState;
    }

    public State getAboutState() {
        return aboutState;
    }
}
