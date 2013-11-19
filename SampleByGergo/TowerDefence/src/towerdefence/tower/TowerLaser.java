/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.tower;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import towerdefence.ImageLoader;
import towerdefence.mob.Mob;

/**
 *
 * @author Gergo
 */
public class TowerLaser extends Tower {

    
    public TowerLaser(Position pos){
        super(2, 122, 500, 20, ImageLoader.tower[1], pos);
    }
    
    @Override
    public void applyUpgrade(Upgrade u) {
        
    }


    private int step = speed;
    
    private int animStep = 0;
    private int animDuration = 50;
    
    @Override
    public void drawProjectile(Graphics g, Mob m) {

        if(step == speed){
            if(animStep <= animDuration){
                g.setColor(Color.red);
                //g.drawLine(getMid().x-1, getMid().y -16, m.getMid().x-1, m.getMid().y-1);
                g.drawLine(getMid().x, getMid().y -15, m.getMid().x, m.getMid().y);
                //g.drawLine(getMid().x+1, getMid().y -14, m.getMid().x+1, m.getMid().y+1);
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
