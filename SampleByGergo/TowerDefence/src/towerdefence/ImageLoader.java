/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence;

import java.awt.Component;
import java.awt.Image;
import java.awt.image.CropImageFilter;
import java.awt.image.FilteredImageSource;
import javax.swing.ImageIcon;

/**
 *
 * @author Gergo
 */
public class ImageLoader extends Component {
    
    public static Image[] tower = new Image[10];
    public static Image[] ground = new Image[10];
    public static Image[] mob = new Image[10];
    public static Image[] menu = new Image[10];
    public static Image[] lot = new Image[10];
    
    public void loadImages(){
        for (int i = 0; i < tower.length; i++) {
            tower[i] = new ImageIcon("res/tileset_towers.png").getImage();
            tower[i] = createImage(new FilteredImageSource(tower[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }
        for (int i = 0; i < ground.length; i++) {
            ground[i] = new ImageIcon("res/tileset_ground.png").getImage();
            ground[i] = createImage(new FilteredImageSource(ground[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }
        for (int i = 0; i < mob.length; i++) {
            mob[i] = new ImageIcon("res/tileset_mobs.png").getImage();
            mob[i] = createImage(new FilteredImageSource(mob[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }
        for (int i = 0; i < menu.length; i++) {
            menu[i] = new ImageIcon("res/tileset_menu.png").getImage();
            menu[i] = createImage(new FilteredImageSource(menu[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }
        for (int i = 0; i < lot.length; i++) {
            lot[i] = new ImageIcon("res/tileset_lot.png").getImage();
            lot[i] = createImage(new FilteredImageSource(lot[i].getSource(), new CropImageFilter(0, 26*i, 26, 26)));
        }
    }
    
}
