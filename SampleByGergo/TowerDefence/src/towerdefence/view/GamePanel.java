/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.view;

import java.awt.Graphics;
import java.awt.Point;
import javax.swing.JFrame;
import javax.swing.JPanel;
import towerdefence.ImageLoader;
import towerdefence.MouseHandler;
import towerdefence.Player;
import towerdefence.mob.MobType;
import towerdefence.mob.Wave;
import towerdefence.mob.WaveListener;
import towerdefence.tower.Position;
import towerdefence.tower.Tower;
import towerdefence.tower.TowerController;
import towerdefence.tower.TowerFactory;
import towerdefence.tower.TowerType;

/**
 *
 * @author Gergo
 */
public class GamePanel extends JPanel implements Runnable {
    
    private Thread gameLoop;
    
    private TowerController towerController;
    
    public static Field field;
    private ControlPanel controlPanel;

    private boolean holding;
    private int held;
    
    private Wave wave;
    
    private Player player;
    
    public static Point mouse = new Point(0, 0);
    
    public GamePanel(JFrame frame){
        init();
        gameLoop = new Thread(this);
        gameLoop.start();
    }
    
    
    private void init(){
        towerController = new TowerController(this);
        ImageLoader il = new ImageLoader();
        il.loadImages();
        field = new Field();
        controlPanel = new ControlPanel(0, Field.BLOCK_SIZE * Field.WORLD_HEIGHT, Field.BLOCK_SIZE * Field.WORLD_WIDTH, 150);
        player = new Player();
        int tmp = 0;
        for (int i = 0; i < Field.block.length; i++) {
            if(Field.block[i][0].getId() == 1){
                tmp = i;
                break;
            }
        }
        
        wave = new Wave(MobType.BLUE, 10, 100, new Position(tmp, 0));
        wave.addWaveListener(new WaveListener(player));
        MouseHandler mh = new MouseHandler(this);
        this.addMouseListener(mh);
        this.addMouseMotionListener(mh);
    }
    

    @Override
    protected void paintComponent(Graphics g) {
        field.draw(g);
        controlPanel.draw(g);
        player.draw(g);
        wave.draw(g);
        towerController.doDraw(g);
        if(holding){
            g.drawImage(ControlPanel.menuItem[held].getImage(), mouse.x - Field.BLOCK_SIZE / 2, mouse.y - Field.BLOCK_SIZE / 2,
                    Field.BLOCK_SIZE, Field.BLOCK_SIZE, null);
        }
        for (int i = 0; i < ControlPanel.menuItem.length; i++) {
            if(ControlPanel.menuItem[i].contains(mouse)){
                ControlPanel.highlight(i);
                break;
            } else {
                ControlPanel.highlight(-1);
            }
        }
    }

    @Override
    public void run() {
        while(true){        
            wave.next();
            repaint();
            try{
                Thread.sleep(1);
            }catch(InterruptedException e){
                
            }
            
        }
    }
    
    public void createTower(){
        Position pos = field.getPosition(mouse);
        if(field.getBlockByPosition(pos).getId() == 0){
            Tower t = TowerFactory.createTower(TowerType.values()[held], pos);
            if(player.getGold() >= t.getPrice()){
                t.setInGame(true);
                towerController.buildTower(t);
                player.setGold(player.getGold() - t.getPrice());
            }
        }
    }
    
    public Wave getWave(){
        return wave;
    }
    
    
    public boolean getHolding(){
        return holding;
    }
    
    public void setHolding(boolean h, int held){
        holding = h;
        this.held = held;
    }
    
}
