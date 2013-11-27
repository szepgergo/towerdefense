/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.Component;
import towerdefence.view.GamePanel;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Gergo
 */
public class TowerDefence extends JFrame {

    public static final String TITLE = "Tower Defense 1.0 by @Gergo";
    public static final Dimension SIZE = new Dimension(800, 650);

    public TowerDefence() {
        init();
    }

    public void init() {
        setTitle(TITLE);
        setSize(SIZE);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(1, 1, 0, 0));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JButton btnStartGame = new JButton("Start Game");

        btnStartGame.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnStartGame.setSize(200, 400);
        btnStartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TowerDefence.this.getContentPane().removeAll();
                GamePanel gp = new GamePanel(TowerDefence.this);
                add(gp);
                TowerDefence.this.validate();
                TowerDefence.this.repaint();
                /**/
            }
        });

        JButton btnClose = new JButton("Close");
        btnClose.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        TowerDefence.this,
                        "Are you sure you want to exit the application?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    System.exit(1);
                }
            }
        });

        mainPanel.add(btnStartGame);
        mainPanel.add(btnClose);
        add(mainPanel);

        TowerDefence.this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                JFrame frame = (JFrame) e.getSource();

                int result = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit the application?",
                        "Exit Application",
                        JOptionPane.YES_NO_OPTION);

                if (result == JOptionPane.YES_OPTION) {
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                }
            }
        });

        /*GamePanel gp = new GamePanel(this);
         add(gp);*/
        setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        TowerDefence td = new TowerDefence();
    }
}
