package dev.tuhin.oilgame.states;

import dev.tuhin.oilgame.Game;
import dev.tuhin.oilgame.input.MouseManager;

import java.awt.*;

/**
 * Created by DarkThunder on 8/22/2016.
 */
public abstract class State
{
    //states manager

    public static State currentState=null;
    public static void setState(State state)
    {
        currentState=state;
    }

    public static State getState()
    {
        return currentState;
    }

    //class

    protected Game game;

    public State(Game game) {
        this.game = game;
    }

    public abstract void tick();
    public abstract void render(Graphics g);
}
