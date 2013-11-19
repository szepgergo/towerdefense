/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import towerdefence.ImageLoader;

/**
 *
 * @author Gergo
 */
public class Button extends Rectangle {

    private Image image;
    private boolean highlighted;
    private int price;

    public Button(int x, int y, int width, int height, Image img, int price) {
        this.image = img;
        setBounds(x, y, width, height);
        this.price = price;
    }

    public void draw(Graphics g) {
        if(highlighted){
            g.setColor(new Color(230, 230, 230));
            g.fillRect(x, y, width, height);
        }
        g.drawImage(image, x + 1, y + 1, width - 2, height - 2, null);
        g.drawImage(ImageLoader.menu[0], x + 1, y + 1, width - 2, height - 2, null);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Courier", Font.BOLD, 12));
        g.drawString(""+price, x+5, y+15);
    }
    
    public void setHighlighted(boolean hl){
        highlighted = hl;
    }
    
    public Image getImage(){
        return image;
    }
    
}
