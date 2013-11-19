/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.mob;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import towerdefence.tower.Position;
import towerdefence.view.Field;

/**
 *
 * @author Gergo
 */
public abstract class Mob {
    
    private static final int NORTH = 1;
    private static final int EAST = 2;
    private static final int SOUTH = 3;
    private static final int WEST = 4;
    
    private int health;
    private int maxHealth;
    private int speed;
    private Image image;
    private boolean inGame;
    
    private int direction = EAST;
    private int from = EAST;
    private int x, y, posX, posY;
    
    private int prize;
    
    public Mob(Position spawnPosition, Image image, int health, int speed, int prize){
        this.x = spawnPosition.getColumn() * Field.BLOCK_SIZE;
        this.y = spawnPosition.getRow() * Field.BLOCK_SIZE + 1;

        posX = 0;
        posY = y / Field.BLOCK_SIZE;
        this.image = image;
        this.health = health;
        maxHealth = health;
        this.speed = speed;
        this.prize = prize;
    }
    
    public void spawn(){
        inGame = true;
    }
    
    public void kill(){
        inGame = false;
    }
    
    
    private int steps = 0;
    private int mobwalk = 0;
    public void move(){
        if(inGame){
            if(steps >= speed){

                if(direction == EAST){
                    x++;
                    from = EAST;
                } else if(direction == NORTH){
                    y--;
                    from = NORTH;
                } else if(direction == SOUTH){
                    y++;
                    from = SOUTH;
                } else if(direction == WEST){
                    x--;
                    from = WEST;
                }

                mobwalk++;

                if(mobwalk == Field.BLOCK_SIZE){
                    if(direction == EAST){
                        posX++;
                    } else if(direction == NORTH){
                        posY--;
                    } else if(direction == SOUTH){
                        posY++;
                    } else if(direction == WEST){
                        posX--;
                    }

                    if(Field.block[posY + 1][posX] != null && Field.block[posY + 1][posX].getId() == 1 && from != NORTH){
                        direction = SOUTH;
                    }
                    if(Field.block[posY - 1][posX] != null && Field.block[posY - 1][posX].getId() == 1 && from != SOUTH){
                        direction = NORTH;
                    }
                    if(Field.block[posY][posX + 1] != null && Field.block[posY][posX + 1].getId() == 1 && from != WEST){
                        direction = EAST;
                    }
                    if(Field.block[posY][posX - 1] != null && Field.block[posY][posX - 1].getId() == 1 && from != EAST){
                        direction = WEST;
                    }

                    mobwalk = 0;
                }

                steps = 0;
            } else {
                steps++;
            }
        }
    }
    
    
    
    public void draw(Graphics g){
        if(inGame){
            g.setColor(Color.RED);
            g.fillRect(x+10, y-1, Field.BLOCK_SIZE-20, 3);
            g.setColor(Color.GREEN);
            g.fillRect(x+10, y-1, (Field.BLOCK_SIZE-20) * (health * 100 / maxHealth) / 100 , 3);
            g.drawImage(image, x, y, Field.BLOCK_SIZE, Field.BLOCK_SIZE, null);
        }
    }
    
    public boolean isInGame(){
        return inGame;
    }
    
    public int getSpawnSpeed(){
        return 60 * speed;
    }
    
    public void setSpeed(int speed){
        this.speed = speed;
    }
    
    public int getSpeed(){
        return speed;
    }
    
    public void setHealth(int health){
        this.health = health;
        if(this.health < 0) this.health = 0;
    }
    
    public int getHealth(){
        return health;
    }
    
    public Point getMid(){
        return new Point(x + Field.BLOCK_SIZE / 2, y + Field.BLOCK_SIZE / 2);
    }

    public int getPrize() {
        return prize;
    }
    
    
    
}
