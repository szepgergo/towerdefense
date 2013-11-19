/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import towerdefence.view.Field;

/**
 *
 * @author Gergo
 */
public class Player {
    
    private int health;
    private int gold;
    
    
    public Player(){
        health = 20;
        gold = 50;
    }
    
    
    
    public void draw(Graphics g){
        g.setFont(new Font("Courier", Font.BOLD, 14));
        g.setColor(new Color(200, 200, 200));
        g.drawString("Gold: " + gold, 10, Field.BLOCK_SIZE * Field.WORLD_HEIGHT + 50);
        g.drawString("Health: " + health, 10, Field.BLOCK_SIZE * Field.WORLD_HEIGHT + 70);
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
    
    
    
    
}
