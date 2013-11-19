/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.tower;

import java.awt.Color;
import java.awt.Graphics;
import towerdefence.ImageLoader;
import towerdefence.mob.Mob;


/**
 *
 * @author Gergo
 */
public class TowerArrow extends Tower{

    
    
    public TowerArrow(Position pos){
        super(1, 64, 1000, 10, ImageLoader.tower[0], pos);
    }
    
    
    @Override
    public void applyUpgrade(Upgrade u) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private int step = speed;
    
    private int animStep = 0;
    private int animDuration = 100;
    
    
    @Override
    public void drawProjectile(Graphics g, Mob m) {

        if(step == speed){
            if(animStep <= animDuration){
                
                g.setColor(Color.BLACK);
                g.drawLine(getMid().x, getMid().y -15, m.getMid().x, m.getMid().y);
                animStep++;
            } else {
                m.setHealth(m.getHealth() - getDamage());
                animStep = 0;
                step = 0;
            }
        } else if(animStep == 0){
            step++;
        }

    }
    
}
