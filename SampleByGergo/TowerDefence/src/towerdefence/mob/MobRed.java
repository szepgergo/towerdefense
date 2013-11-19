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
public class MobRed extends Mob {
    
    public MobRed(Position spawnPosition){
        super(spawnPosition, ImageLoader.mob[1], 50, 30, 10);
    }
    
}
