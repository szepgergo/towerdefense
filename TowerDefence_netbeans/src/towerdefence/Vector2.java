/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

/**
 *
 * @author Ádám
 */
public class Vector2
{
    private float x;
    private float y;
    
    public Vector2(float x, float y)
    {
        this.x = x;
        this.y = y;
    }
    
    public Vector2(Vector2 v)
    {
        this.x = v.x;
        this.y = v.y;
    }
    
    public float getX()
    {
        return x;
    }
    
    public float getY()
    {
        return y;
    }
    
    public static Vector2 Zero()
    {
        return new Vector2(0,0);
    }
    
    public static Vector2 One()
    {
        return new Vector2(1,1);
    }
    
    public float Length()
    {
        return (float)Math.abs(Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2)));
    }
    
    public static Vector2 Add(Vector2 v1, Vector2 v2)
    {
        return new Vector2(v1.x + v2.x, v1.y + v2.y);
    }
    
    public static Vector2 Substract(Vector2 v1, Vector2 v2)
    {
        return new Vector2(v1.x - v2.x, v1.y - v2.y);
    }
    
    public static Vector2 ScalarMultiply(Vector2 v, float s)
    {
        return new Vector2(v.x * s, v.y * s);
    }
    
    public static Vector2 Normailize(Vector2 v)
    {
        return new Vector2(ScalarMultiply(v, 1 / v.Length()));
    }
    
    public static float DotProduct(Vector2 v1, Vector2 v2, float angle)
    {
        return (float)(v1.Length() * v2.Length() * Math.cos(angle));
    }
    
    public static float DotProduct(Vector2 v1, Vector2 v2)
    {
        return (float)(v1.x * v2.x + v1.y * v2.y);
    }
}
