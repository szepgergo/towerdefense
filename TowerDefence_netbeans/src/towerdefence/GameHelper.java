/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.geom.AffineTransform;

/**
 *
 * @author Ádám
 */
public abstract class GameHelper
{
    private GameHelper()
    {
        
    }
    
    public static AffineTransform AffineTransformation(GameObject go)
    {
        AffineTransform at = new AffineTransform();
        double r = Math.toRadians(go.rotation);
        double sinR = Math.sin(r);
        double cosR = Math.cos(r);
        
        //at.translate((int)go.position.getX(), (int)go.position.getY());
        
        return at;
    }
}
