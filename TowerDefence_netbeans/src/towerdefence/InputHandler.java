/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 */
public class InputHandler implements KeyListener
{
    boolean[] keys = new boolean[256];
    
    public InputHandler(Component c)
    {
        c.addKeyListener(this);
    }
    
    public boolean isKeyDown(int keyCode)
    {
        if (keyCode > 0 && keyCode < 256)
        {
            return keys[keyCode];
        }
               
        return false;
    }

    public boolean keyTyped(int keyCode)
    {
        if (keyCode > 0 && keyCode < 256)
        {
            return keys[keyCode];
        }
               
        return false;
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
        {
            keys[e.getKeyCode()] = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        if (e.getKeyCode() > 0 && e.getKeyCode() < 256)
        {
            keys[e.getKeyCode()] = false;
        }
    }
    
    public void keyTyped(KeyEvent e)
    {
        
    }
}
