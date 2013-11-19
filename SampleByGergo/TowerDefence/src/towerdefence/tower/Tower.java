/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import towerdefence.mob.Mob;
import towerdefence.view.Field;

/**
 *
 * @author Gergo
 */
public abstract class Tower {
    
    private int damage;
    private int range;
    private int price;
    protected int speed;
    
    private int x, y;
    
    protected boolean inGame;
    private Position position;
    private Image image;
    private boolean isSelected;
    
    protected Tower(){
        
    }
    
    protected Tower(int damage, int range, int speed, int price, Image image, Position pos){
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.price = price;
        inGame = false;
        this.image = image;
        isSelected = false;
        this.position = pos;
        
        this.x = Field.BLOCK_SIZE * position.getColumn();
        this.y = Field.BLOCK_SIZE * position.getRow();
    }
    
    public abstract void applyUpgrade(Upgrade u);
    
    public abstract void drawProjectile(Graphics g, Mob m);
    
    public void draw(Graphics g){
        if(inGame){
            g.drawImage(image, x, y, Field.BLOCK_SIZE, Field.BLOCK_SIZE, null);
            g.setColor(new Color(230,230,230));
            if(isSelected){
                g.drawOval(Field.BLOCK_SIZE * position.getColumn() + Field.BLOCK_SIZE/2 - range, 
                        Field.BLOCK_SIZE * position.getRow() + Field.BLOCK_SIZE/2 - range, 2*range, 2*range);
            }
        }
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public boolean isInGame() {
        return inGame;
    }

    public void setInGame(boolean inGame) {
        this.inGame = inGame;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }
    
    public boolean isInRange(Mob m){
        return m.getMid().distance(getMid()) <= range;
    }
    
    public Point getMid(){
        return new Point(x + Field.BLOCK_SIZE / 2, y + Field.BLOCK_SIZE / 2);
    }
    
}
