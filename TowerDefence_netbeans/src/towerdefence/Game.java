/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFrame;
import java.awt.event.KeyEvent;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

/**
 *
 * @author Ádám
 */
public class Game
{
    JFrame window;
    Timer timer;
    
    int width;
    int height;
    boolean isRunning;
    
    BufferedImage buffer;
    Insets insets;
    
    Graphics graphics;
    Graphics2D g;
    
    long elapsedTime;
    
    InputHandler input;
    
    ArrayList<Minion> minions;
    
    Random random;
    BufferedImage minion;
    AffineTransform at;
    AffineTransformOp ato;
    
    public Game()
    {
        timer = new Timer();
        
        width = 853;
        height = 480;
        window = new JFrame();
        
        window.setSize(width, height);
        window.setDefaultCloseOperation(EXIT_ON_CLOSE);
        window.setVisible(true);
        buffer = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        
        insets = window.getInsets();
        window.setSize(insets.left + width + insets.right, insets.top + height + insets.bottom);
        input = new InputHandler(window);
    }
    
    public void Run()
    {
        isRunning = true;
        Initialize();
        
        while(isRunning)
        {
            Update();
            Draw();
        }
    }
    
    public void Initialize()
    {
        graphics = window.getGraphics();
        elapsedTime = System.currentTimeMillis();
        random = new Random();
        minions = new ArrayList<>();
        at = new AffineTransform();
        g = buffer.createGraphics();
        
        try
        {
            minion = ImageIO.read(new File("minion.png"));
        }
        catch (IOException e) {}
    }
    
    public void Update()
    {
        timer.Update();
        window.setTitle("FPS: " + timer.GetFPS() + " Minions: " + minions.size() );
        
        if (input.IsKeyDown(KeyEvent.VK_A))
        {
            minions.add(new Minion(new Vector2(random.nextInt(width), random.nextInt(height)), random.nextInt(360), minion));
        }
        
        if (input.IsKeyDown(KeyEvent.VK_S))
        {
            for (int i = 0; i < minions.size(); i++)
            {
                minions.get(i).rotation = random.nextInt(360);
            }
        }
        
        if (input.IsKeyDown(KeyEvent.VK_D))
        {
            if (minions.size() > 0)
            {
                minions.remove(minions.size() - 1);
            }
        }
    }
    
    public void Draw()
    {   
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        g.setColor(Color.BLACK);
        
        for (int i = 0; i < minions.size(); i++)
        {
            at = new AffineTransform();
            at.translate((int)minions.get(i).position.getX(), (int)minions.get(i).position.getY());
            at.rotate(Math.toRadians(minions.get(i).rotation), minion.getWidth()/2, minion.getHeight()/2);
            
            //at = GameHelper.AffineTransformation(minions.get(i));
            
            g.drawImage(minion, at, window);
        }
        graphics.drawImage(buffer, insets.left, insets.top, window);
    }
}
