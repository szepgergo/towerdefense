/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.image.BufferedImage;

/**
 *
 * @author Poc
 */
public class Minion extends GameObject
{
    private int health; //élet
    private int level; //szint
    private int damage; //sebzés
    private float speed; //sebesség
    private int reward; //mennyi pénzt ad
    
    public Minion(Vector2 position, float rotation, Vector2 destination, BufferedImage image, int health, int level, float speed, int reward)
    {
        super(position, rotation, destination, image);
        this.health = health;
        this.level = level;
        this.speed = speed;
        this.reward = reward;
    }
    
    public Minion(Vector2 position, float rotation, BufferedImage image)
    {
        super(position,rotation, image);
    }
    
    public void Update()
    {
        
    }
    
    public void Move()
    {
        
    }
}
