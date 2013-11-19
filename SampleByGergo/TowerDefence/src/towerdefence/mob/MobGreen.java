/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.mob;

import towerdefence.ImageLoader;
import towerdefence.tower.Position;

/**
 *
 * @author Gergo
 */
public class MobGreen extends Mob{
    
    public MobGreen(Position spawnPosition){
        super(spawnPosition, ImageLoader.mob[2], 20, 30, 7);
    }
    
}
