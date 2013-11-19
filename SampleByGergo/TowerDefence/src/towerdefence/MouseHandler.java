/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import towerdefence.view.ControlPanel;
import towerdefence.view.Field;
import towerdefence.view.GamePanel;

/**
 *
 * @author Gergo
 */
public class MouseHandler implements MouseListener, MouseMotionListener {
    
    private boolean holding = false;
    private GamePanel gp;
    
    public MouseHandler(GamePanel gp){
        this.gp = gp;
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        GamePanel.mouse = e.getPoint();
        
        if(holding){
            Field.hideLots();
            holding = false;
            gp.createTower();
            gp.setHolding(holding, -1);
        }
        
        for (int i = 0; i < ControlPanel.menuItem.length; i++) {
            
            if(ControlPanel.menuItem[i].contains(e.getPoint())){
                Field.showLots();
                holding = true;
                gp.setHolding(holding, i);
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        GamePanel.mouse = e.getPoint();
    }

    
}
