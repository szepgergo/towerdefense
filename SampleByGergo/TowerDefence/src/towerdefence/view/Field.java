/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.view;

import java.awt.Graphics;
import java.awt.Point;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import towerdefence.tower.Position;

/**
 *
 * @author Gergo
 */
public class Field {
    
    public static final int BLOCK_SIZE = 53;
    public static final int WORLD_WIDTH = 15;
    public static final int WORLD_HEIGHT = 9;
    
    public static Block[][] block;
    private static boolean showLots = false;
    
    public Field(){
        init();
    }
    
    private void init(){
        try{
            Scanner sc = new Scanner(new File("res/mission1.tdf"));
            
            block = new Block[WORLD_HEIGHT][WORLD_WIDTH];
            
            while(sc.hasNext()){
                for (int i = 0; i < block.length; i++) {
                    for (int j = 0; j < block[0].length; j++) {
                        block[i][j] = new Block(j*BLOCK_SIZE, i*BLOCK_SIZE, BLOCK_SIZE, BLOCK_SIZE, sc.nextInt(), new Position(i, j));
                    }
                }
            }

            sc.close();
            
        }catch(FileNotFoundException ex){
            System.out.println(ex);
        }
        
    }
    
    public void draw(Graphics g){
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[0].length; j++) {
                block[i][j].draw(g);
                if(showLots){
                    block[i][j].drawLot(g);
                }
            }
        }
    }

    
    
    public Position getPosition(Point p){
        Position pos = new Position(-1, -1);
        for (int i = 0; i < block.length; i++) {
            for (int j = 0; j < block[0].length; j++) {
                if(block[i][j].contains(p)){
                    pos = block[i][j].getPosition();
                    break;
                }
            }
        }
        return pos;
    }    

    public Block getBlockByPosition(Position pos){
        try{
            return block[pos.getRow()][pos.getColumn()];
        } catch(ArrayIndexOutOfBoundsException ex){
            return new NullBlock();
        }
    }
    
    public static void showLots(){
        showLots = true;
    }
    
    public static void hideLots(){
        showLots = false;
    }
    
}
