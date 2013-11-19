/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.image.BufferedImage;

/**
 *
 * @author Ádám
 */
public class GameObject
{
    /**
     * Aktuális pozíció
     */
    protected Vector2 position;
    /**
     * Forgatás
     */
    protected float rotation;
    /**
     * Cél pozíciója
     */
    protected Vector2 destination;
    
    /**
     * Objektum textúrája
     */
    protected BufferedImage image;
    
    
    public GameObject(Vector2 position, float rotation, Vector2 destination, BufferedImage image)
    {
        //...
        this.position = position;
        this.rotation = rotation;
        this.destination = destination;
        this.image = image;
    }
    
    public GameObject(Vector2 position, float rotation, BufferedImage image)
    {
        //...
        this.position = position;
        this.rotation = rotation;
        this.image = image;
    }
}
