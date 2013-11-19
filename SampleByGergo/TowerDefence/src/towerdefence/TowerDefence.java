/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import towerdefence.view.GamePanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;

/**
 *
 * @author Gergo
 */
public class TowerDefence extends JFrame {
    
    public static final String TITLE = "Tower Defense 1.0 by @Gergo";
    public static final Dimension SIZE = new Dimension(800, 650);

    public TowerDefence(){
        init();
    }
    
    public void init(){
        setTitle(TITLE);
        setSize(SIZE);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1, 0, 0));
        GamePanel gp = new GamePanel(this);
        add(gp);
        setVisible(true);
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TowerDefence td = new TowerDefence();
    }
}
