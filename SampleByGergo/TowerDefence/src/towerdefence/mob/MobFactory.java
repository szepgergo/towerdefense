/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.mob;

import towerdefence.tower.Position;

/**
 *
 * @author Gergo
 */
public class MobFactory {
    
    private MobFactory(){
        
    }
    
    
    public static Mob createMob(MobType type, Position spawnPosition){
        switch(type){
            case BLUE: {
                return new MobBlue(spawnPosition);
            }
            case RED: {
                return new MobRed(spawnPosition);
            }
            case GREEN: {
                return new MobGreen(spawnPosition);
            }
            default:{
                throw new IllegalArgumentException();
            }
        }
    }
    
}
