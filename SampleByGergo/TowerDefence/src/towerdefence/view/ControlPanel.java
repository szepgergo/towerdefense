/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.view;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import towerdefence.ImageLoader;
import towerdefence.tower.TowerType;

/**
 *
 * @author Gergo
 */
public class ControlPanel extends Rectangle {

    private static final int buttonSize = 53;
    private static final int buttonNumber = 5;

    
    public static Button[] menuItem;

    public ControlPanel(int x, int y, int width, int height) {
        setBounds(x, y, width, height);
        menuItem = new Button[5];
        for (int i = 0; i < menuItem.length; i++) {
            menuItem[i] = new Button(width / 2 - ((buttonSize) * buttonNumber) / 2 + (i * buttonSize), y + height / 2 - buttonSize / 2, buttonSize, buttonSize, ImageLoader.tower[i], TowerType.values()[i].getPrice());
        }
    }

    public void draw(Graphics g) {
        g.setColor(new Color(50, 50, 50));
        g.fillRect(x, y, width, height);
        for (int i = 0; i < menuItem.length; i++) {
            menuItem[i].draw(g);
        }
    }
    
    public static void highlight(int i){
        if(i < 0){
            for (int j = 0; j < menuItem.length; j++) {
                menuItem[j].setHighlighted(false);
            }
        } else {
            for (int j = 0; j < menuItem.length; j++) {
                if(i == j){
                    menuItem[j].setHighlighted(true);
                    break;  
                }
            }
        }
    }
}
