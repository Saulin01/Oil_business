package dev.tuhin.oilgame.states;

import dev.tuhin.oilgame.Game;
import dev.tuhin.oilgame.gfx.Assets;

import java.awt.*;

/**
 * Created by DarkThunder on 9/15/2016.
 */
public class AboutState extends State {
    public AboutState(Game game) {
        super(game);
        game.getMouseManager().setClickCount(0);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        int clicked = game.getMouseManager().getClickCount();
        g.drawImage(Assets.about, 0, 0, null);
        if(clicked==2)
        {
            State.setState(game.getMenuState());
            game.getMouseManager().setClickCount(0);
        }
    }
}