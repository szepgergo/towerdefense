/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.tower;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import towerdefence.mob.Mob;
import towerdefence.view.GamePanel;

/**
 *
 * @author Gergo
 */
public class TowerController {
    
    private GamePanel gp;
    private List<Tower> towers;
    
    public TowerController(GamePanel gp){
        this.gp = gp;
        init();
    }
    
    private void init(){
        towers = new ArrayList<>();
    }
    
    
    
    public void doDraw(Graphics g){
        for(Tower t : towers){
            t.draw(g);
            for(Mob m : gp.getWave().getMobs()){
                if(m.isInGame() && t.isInRange(m)){
                    t.drawProjectile(g, m);
                    break;
                }
            }
        }
    }
    
    public void buildTower(Tower t){
        towers.add(t);
    }
    
    public void sellTower(){
        
    }
    
    public void upgradeTower(){
        
    }
    
    
}
