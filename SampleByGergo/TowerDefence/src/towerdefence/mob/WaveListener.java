/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.mob;

import towerdefence.Player;

/**
 *
 * @author Gergo
 */
public class WaveListener {
    
    private Player p;
    
    public WaveListener(Player p){
        this.p = p;
    }
    
    public void mobKilled(Mob m){
        p.setGold(p.getGold() + m.getPrize());
    }
    
    public void giveWaveReward(Wave w){
        p.setGold(p.getGold() + w.getPrize());
    }
    
}
