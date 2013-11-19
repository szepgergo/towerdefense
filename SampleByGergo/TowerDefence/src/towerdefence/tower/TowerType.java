/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.tower;

/**
 *
 * @author Gergo
 */
public enum TowerType {
    ARROW (1, 1, 64, 1000, 10),
    LASER (2, 2, 122, 500, 20),
    SHOTGUN (3, 5, 82, 2000, 50),
    MINIGUN (4, 0, 0, 0, 0),
    ROCKET (5, 0, 0, 0, 0);
    
    private final int id;
    private final int damage;
    private final int range;
    private final int speed;
    private final int price;
    
    TowerType(int id, int damage, int range, int speed, int price){
        this.id = id;
        this.damage = damage;
        this.range = range;
        this.speed = speed;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public int getDamage() {
        return damage;
    }

    public int getRange() {
        return range;
    }

    public int getSpeed() {
        return speed;
    }

    public int getPrice() {
        return price;
    }
    
    
}
