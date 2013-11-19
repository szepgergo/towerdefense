/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.tower;

/**
 *
 * @author Gergo
 */
public class TowerFactory {
    
    private TowerFactory(){
        
    }
    
    public static Tower createTower(TowerType tt, Position pos){
        switch(tt){
            case ARROW: {
                return new TowerArrow(pos);
            }
            case LASER: {
                return new TowerLaser(pos);
            }
            case SHOTGUN: {
                return new TowerShotgun(pos);
            }
            case MINIGUN: {
                return new TowerMinigun();
            }
            case ROCKET: {
                return new TowerRocket();
            }   
            default: {
                throw new IllegalArgumentException();
            }
        }
    }
    
}
