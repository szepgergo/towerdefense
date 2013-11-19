/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.tower;

import java.awt.Point;
import towerdefence.view.Field;

/**
 *
 * @author Gergo
 */
public class Position {
    
    private int row;
    private int column;
    
    public Position(int row, int column){
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
    
    public boolean contains(Point p){
        return p.x >= Field.BLOCK_SIZE * column && p.x < Field.BLOCK_SIZE * (column + 1)
                && p.y >= Field.BLOCK_SIZE * row && p.y < Field.BLOCK_SIZE * (row + 1);
    }
    
    public boolean contains(int x, int y){
        return x >= Field.BLOCK_SIZE * column && x < Field.BLOCK_SIZE * (column + 1)
                && y >= Field.BLOCK_SIZE * row && y < Field.BLOCK_SIZE * (row + 1);
    }
    
}
