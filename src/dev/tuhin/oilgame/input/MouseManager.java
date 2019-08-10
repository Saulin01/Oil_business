package dev.tuhin.oilgame.input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

/**
 * Created by DarkThunder on 8/29/2016.
 */
public class MouseManager implements MouseListener, MouseMotionListener {
    private int mouseX, mouseY, cX, cY, clickCount;
    private  boolean clicked;

    public MouseManager(){

    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            clicked = true;
            cX = e.getX();
            cY = e.getY();
        }
        clickCount+=e.getClickCount();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            clicked = false;
        }
        //clickCount+=e.getClickCount();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    public int getcX() {
        return cX;
    }

    public int getcY() {
        return cY;
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        mouseX = e.getX();
        mouseY = e.getY();
    }

    public int getClickCount() {
        return clickCount;
    }

    public void setClickCount(int clickCount) {
        this.clickCount = clickCount;
    }

    public int getMouseX() {
        return mouseX;
    }

    public int getMouseY() {
        return mouseY;
    }

    public boolean isClicked() {
        return clicked;
    }
}