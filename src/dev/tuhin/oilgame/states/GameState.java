package dev.tuhin.oilgame.states;

import dev.tuhin.oilgame.Game;
import dev.tuhin.oilgame.entities.*;
import dev.tuhin.oilgame.gfx.Assets;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by DarkThunder on 8/22/2016.
 */
public class GameState extends State
{
    public static boolean [][] ground = new boolean[64][19];

    public ArrayList<Entities> entities = new ArrayList<Entities>();
    public ArrayList<Wagon> wagons = new ArrayList<Wagon>();
    public static ArrayList<Oil> oils = new ArrayList<Oil>();
    public static ArrayList<Dowser> dowsers = new ArrayList<Dowser>();

    private int width, height, placed=0;
    private int x, y=150,x1=0,y1=20, x2=0, y2=85;
    public boolean left=false, right=false;
    public static int money=2000;

    public GameState(int width, int height, Game game) {
        super(game);
        this.width = width;
        this.height = height;

        for (boolean[] row : ground) {
            Arrays.fill(row, true);
        }
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
        for (Oil o: oils)
        {
            o.tick();
        }
        for (Entities o: entities)
        {
            o.tick();
        }
        for (Wagon o: wagons)
        {
            o.tick();
        }
        for (Dowser o: dowsers)
        {
            o.tick();
        }
    }

    @Override
    public void render(Graphics g) {
        init(g);
        for (Entities o: entities)
        {
            o.render(g);
        }
        for (Wagon o: wagons)
        {
            o.render(g);
        }
        for (Dowser o: dowsers)
        {
            o.render(g);
        }
    }

    private void init(Graphics g) {
        int clicked = game.getMouseManager().getClickCount();
        int mouseX = game.getMouseManager().getMouseX(), mouseY= game.getMouseManager().getMouseY();

        //sky
        Color c=new Color(115,200,255);
        g.setColor(c);
        g.fillRect(0,0,width,height-300);

        cloud(g);

        //Company
        g.drawImage(Assets.blueInc, 0, height-300-128, 128, 128, null);
        g.drawImage(Assets.redInc, width-128, height-300-128, 128, 128, null);

        //sell point
        if(right) {
            g.drawImage(Assets.tick[1], width - 100, height - 508, null);
        }
        else if(!right) {
            g.drawImage(Assets.tick[0], width - 100, height - 508, null);
        }
        if (left) {
            g.drawImage(Assets.tick[1], 20, height - 508, null);
        }
        else if (!left) {
            g.drawImage(Assets.tick[0], 20, height - 508, null);
        }
        //manager
        if(mouseX>=width-100 && mouseX<=width-20 && mouseY>=height-508 && mouseY>= height-508-80 && clicked==1)
        {
            right=!right;
            clicked = 0;
            game.getMouseManager().setClickCount(0);
        }
        if(mouseX>=20 && mouseX<=100 && mouseY>=height-508 && mouseY>= height-508-80 && clicked==1)
        {
            left=!left;
            clicked = 0;
            game.getMouseManager().setClickCount(0);
        }

        //Icons
        iconManager(g);

        //oil draw
        oils.add(new Oil(550, height-200, 200, 100));
        oils.add(new Oil(200, height -275, 150, 115));
        for (Oil o: oils)
        {
            o.render(g);
        }

        //Ground draw
        int a=0 , b = 0;
        for (int y=height-300;y<=height;y+=16) {
            for (int x=0;x<width;x+=16) {
                a= x/16;
                b= (y-420)/16;
                if (ground[a][b]==true) {
                    g.drawImage(Assets.earth, x, y, null);
                }
            }
        }
    }

    public void iconManager(Graphics g)
    {
        int mouseX = game.getMouseManager().getMouseX(),
                mouseY = game.getMouseManager().getMouseY();
        int clicked = game.getMouseManager().getClickCount();

        //System.out.println(clicked);

        int x=377, y=10, x1=446, x2=515, x3= 584;
        g.drawImage(Assets.rigIcon[0], x, y, null);
        g.drawImage(Assets.siloIcon[0], x1, y, null);
        g.drawImage(Assets.wagonIcon[0], x2, y, null);
        g.drawImage(Assets.dowserIcon[0], x3, y, null);

        //dowser start
        if(mouseX>=x3 && mouseX<=x3+64 && mouseY>=y && mouseY<=y+32)
        {
            g.drawImage(Assets.dowserIcon[1], x3, y, null);
            if (clicked==1)
            {
                placed=4;
                game.getMouseManager().setClickCount(0);
                clicked=0;
            }
        }
        if (placed == 4)
        {
            if(mouseX >= 128 && mouseX <= width-175) {
                g.drawImage(Assets.dowser[0], mouseX, height - 332, null);
                if(clicked == 1)
                {
                    placed = 0;
                    dowsers.add(new Dowser(mouseX, height - 332));
                    game.getMouseManager().setClickCount(0);
                    //money-=500;
                }
            }
            else if(mouseX<128)
            {
                g.drawImage(Assets.dowser[0], 128, height - 332, null);
                if(clicked == 1)
                {
                    placed = 0;
                    dowsers.add(new Dowser(128, height - 332));
                    game.getMouseManager().setClickCount(0);
                    //money-=500;
                }
            }
            else if(mouseX > width-128-43)
            {
                g.drawImage(Assets.dowser[0], width-128-43, height - 300 - 32, null);
                if(clicked == 1)
                {
                    placed = 0;
                    dowsers.add(new Dowser(width -128-43, height - 332));
                    game.getMouseManager().setClickCount(0);
                    //money-=500;
                }
            }
        }
        //dowser end

        //rig start
        if(mouseX >=x && mouseX <= x+64 && mouseY >=y && mouseY <= y+32) {
            g.drawImage(Assets.rigIcon[1], x, y, null);
            if(clicked == 1)
            {
                placed=1;
                game.getMouseManager().setClickCount(0);
                clicked=0;
            }
        }
        if (placed == 1)
        {
            if(mouseX >= 128 && mouseX <= width-192) {
                g.drawImage(Assets.rig, mouseX, height - 428, null);
                if(clicked == 1)
                {
                        placed = 0;
                        entities.add(new Rig(mouseX, height - 428));
                        game.getMouseManager().setClickCount(0);
                    //money-=750;
                    if(!dowsers.isEmpty())
                    {
                        dowsers.remove(0);
                    }
                }
            }
            else if(mouseX<128)
            {
                g.drawImage(Assets.rig, 128, height - 300 - 128, null);
                if(clicked == 1)
                {
                        placed = 0;
                        entities.add(new Rig(128, height - 428));
                        game.getMouseManager().setClickCount(0);
                    //money-=750;
                    if(!dowsers.isEmpty())
                    {
                        dowsers.remove(0);
                    }
                }
            }
            else if(mouseX > width-128-64)
            {
                g.drawImage(Assets.rig, width-128-64, height - 300 - 128, null);
                if(clicked == 1)
                {
                        placed = 0;
                        entities.add(new Rig(width - 192, height - 428));
                        game.getMouseManager().setClickCount(0);
                    //money-=750;
                    if(!dowsers.isEmpty())
                    {
                        dowsers.remove(0);
                    }
                }
            }
        }
        //rig end

        //silo start
        if(mouseX >= x1 && mouseX <= x1+64 && mouseY >=y && mouseY<=y+32) {
            g.drawImage(Assets.siloIcon[1], x1, y, null);
            if (clicked == 1) {
                placed = 2;
                game.getMouseManager().setClickCount(0);
                clicked = 0;
            }
        }
        if (placed == 2)
        {
                if(mouseX >= 128 && mouseX <= width-128-128) {
                    g.drawImage(Assets.silo, mouseX, height - 300-64, null);
                    if(clicked == 1)
                    {
                        placed = 0;
                        entities.add(new Silo(mouseX, height - 364));
                        game.getMouseManager().setClickCount(0);
                        //money-=1000;
                    }
                }
                else if(mouseX<128)
                {
                    g.drawImage(Assets.silo, 128, height - 364, null);
                    if(clicked == 1)
                    {
                        placed = 0;
                        entities.add(new Silo(128, height - 364));
                        game.getMouseManager().setClickCount(0);
                        //money-=1000;
                    }
                }
                else if(mouseX > width-128-128)
                {
                    g.drawImage(Assets.silo, width-128-128, height - 364, null);
                    if(clicked == 1)
                    {
                        placed = 0;
                        entities.add(new Silo(width - 192, height - 364));
                        game.getMouseManager().setClickCount(0);
                        //money-=1000;
                    }
                }
        }
        //silo end

        //wagon start
        if(mouseX >= x2 && mouseX <= x2+64 && mouseY >=y && mouseY<=y+32) {
            g.drawImage(Assets.wagonIcon[1], x2, y, null);
            if (clicked==1)
            {
                placed = 3;
                game.getMouseManager().setClickCount(0);
                clicked = 0;
            }
        }
        if (placed == 3)
        {
            if(mouseX >= 128 && mouseX <= width-128-63) {
                g.drawImage(Assets.wagon[0], mouseX, height - 319, null);
                if(clicked == 1)
                {
                    placed = 0;
                    wagons.add(new Wagon(mouseX, height - 319));
                    game.getMouseManager().setClickCount(0);
                    //money-=750;
                }
            }
            else if(mouseX<128)
            {
                g.drawImage(Assets.wagon[0], 128, height - 319, null);
                if(clicked == 1)
                {
                    placed = 0;
                    wagons.add(new Wagon(128, height - 319));
                    game.getMouseManager().setClickCount(0);
                    //money-=750;
                }
            }
            else if(mouseX > width-128-63)
            {
                g.drawImage(Assets.wagon[1], width-128-63, height - 319, null);
                if(clicked == 1)
                {
                    placed = 0;
                    wagons.add(new Wagon(width - 128-63, height - 319));
                    game.getMouseManager().setClickCount(0);
                    //money-=750;
                }
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