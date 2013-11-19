/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.view;

import java.awt.Graphics;
import java.awt.Rectangle;
import towerdefence.ImageLoader;
import towerdefence.tower.Position;

/**
 *
 * @author Gergo
 */
public class Block extends Rectangle{
    
    protected int id;
    private boolean occupied = false;
    
    private Position pos;
    
    public Block(){
        
    }
    
    public Block(int x, int y, int width, int height, int id, Position pos){
        setBounds(x, y, width, height);
        this.id = id;
        this.pos = pos;
    }
    
    public void draw(Graphics g){
        g.drawImage(ImageLoader.ground[id], x, y, width, height, null);
    }
    
    public void drawLot(Graphics g){
        if(id == 0 && !occupied){
            g.drawImage(ImageLoader.lot[0], x, y, width, height, null);
        } else {
            g.drawImage(ImageLoader.lot[1], x, y, width, height, null);
        }
    }
    
    public Position getPosition(){
        return pos;
    }

    public int getId() {
        return id;
    }
    
    
    
}
