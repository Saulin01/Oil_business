package dev.tuhin.oilgame;

/**
 * Created by DarkThunder on 8/20/2016.
 */
public class Launcher
{
    //private static int res;
    public static void main(String[] args)
    {
        Game game=new Game("Oil Tycoon", 1024, 720);
        game.start();
    }
}
