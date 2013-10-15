/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.util.Random;

/**
 *
 * @author Poc
 */
public class Tower {
    private int level, actualXP, nextLevelXP = 200, damage, /*slowdown,*/
            reach, shootSpeed; //slowdown inkább csak származtatot speciális toronyál kellene
    private final int MAX_LEVEL = 5;
    private Random rnd;
    
    public Tower(int damage, /*int slowdown,*/ int reach, int shootSpeed) {
        this.damage = damage;
        //this.slowdown = slowdown;
        this.reach = reach;
        this.shootSpeed = shootSpeed;
        level = 1; //minden torony 1-es szinten kezd
        actualXP = 0;
        rnd = new Random();
    }
    
    public void upgrade() {
        //például:
        if(level<MAX_LEVEL) {
            nextLevelXP *= (level * 2);
            level++;
            int r = rnd.nextInt(5);
            damage += r;
            r = rnd.nextInt(5);
            reach += r;
            r = rnd.nextInt(5);
            shootSpeed += r;
        }
    }
}
