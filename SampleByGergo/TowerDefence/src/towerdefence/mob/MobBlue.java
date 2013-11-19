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
public class MobBlue extends Mob {
    
    public MobBlue(Position spawnPosition){
        super(spawnPosition, ImageLoader.mob[0], 3, 25, 5);
        
    }
    
}
