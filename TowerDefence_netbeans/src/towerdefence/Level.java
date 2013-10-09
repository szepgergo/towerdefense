package towerdefence;

import java.io.*;
import java.util.*;

public class Level {

    private int[][] level;
    private List<Integer> levelRoad;
    public static final int LEVEL_WALL = 0x00000001,
            LEVEL_ROAD = 0x00000002,
            LEVEL_DECORATION_TREE = 0x00000003,
            LEVEL_UNDEFINED = 0x00000000;

    /**
     * Konstruktor: Létrehoz egy üres (null) pályát, inicializálja a
     * feltérképezéshez szükséges listát.
     */
    public Level() {
        level = null;
        levelRoad = new LinkedList<>();
    }

    /**
     * Konstruktor: Létrehoz egy pályát a megadott
     *
     * @param level alapján, inicializálja a feltérképezéshez szükséges listát
     *
     * @param	level	A saját int[][] adattagjához hozzárendelendő int[][]
     * objektum.
     */
    public Level(int[][] level) {
        this.level = level;
        levelRoad = new LinkedList<>();
    }

    /**
     * Beállítja a pálya méterét a megadott paramétereknek megfelelően.
     *
     * @param	row	hány soros legyen a pálya
     * @param	column	hájy oszlopa legyen a pályának
     */
    public void setDimensions(int row, int column) {
        level = new int[row][column];
    }

    /**
     * A pálya összes elemét "lenullázza".
     */
    public void clear() {
        for (int i = 0; i < getHeight(); ++i) {
            for (int j = 0; j < getWidth(); j++) {
                setElement(i, j, LEVEL_UNDEFINED);
            }
        }
    }

    /**
     * A pálya egy adott elemét állítja be a kívánt helyen.
     *
     * @param	row	melyik sorban
     * @param	column	melyik oszlopban
     * @param	tileID	mire cserélje a régi elemet
     */
    public void setElement(int row, int column, int tileID) {
        level[row][column] = tileID;
    }

    /**
     * A pálya egy adott elemét kérdezi le a kíván helyen.
     *
     * @param	row	kívánt sor
     * @param	column	kívánt oszlop
     */
    public int getElement(int row, int column) {
        return level[row][column];
    }

    /**
     * A pálya magasságát (sorainak számát) adja vissza.
     */
    public int getHeight() {
        return level.length;
    }

    /**
     * A pálya szélességét (oszlopainak számát) adja vissza.
     */
    public int getWidth() {
        return level[0].length;
    }

    @Override
    public String toString() {
        String lvString = "toString(): ROSSZUL DEFINIÁLT PÁLYA...";
        if(level != null) {
            lvString = "";
            for (int i = 0; i < getHeight(); ++i) {
                for (int j = 0; j < getWidth(); j++) {
                    if(getElement(i, j) != LEVEL_UNDEFINED) {
                        lvString += getElement(i, j) + " ";
                    } else {
                        lvString = "toString(): NEM DEFINIÁLT ELEM VAN A PÁLYÁBAN";
                        break;
                    }
                }
                lvString += "\n";
            }
        }
        return lvString;
    }

    public void readLevelFromFile(String levelFile) {
        List<String[]> list = new LinkedList<>();
        BufferedReader inputStream = null;
        try {
            inputStream = new BufferedReader(new FileReader(levelFile));
            String line;
            while ((line = inputStream.readLine()) != null) {
                //a pálya elemeit SPACE választja el egymástól->szátválasztás
                String[] splitLine = line.split(" ");
                list.add(splitLine);
            }
            
            if( !list.isEmpty() /*&& !(list.get(0).length == 0)*/ ) {
                //vizsgálat, hogy minden sorban ugyanannyi elem van-e
                //ha nem, akkor rossz a pálya definíciója
                boolean correctLevel = true;
                int len = list.get(0).length;
                for(int i = 0; i < list.size() && correctLevel; i++) {
                    if (list.get(i).length != len) {
                        correctLevel = false;
                    }
                }
                //ha minden ok:
                if(correctLevel == true) {
                    //soronként beolvasva a lista mérete adja meg a pálya sorainak számát
                    int rows = list.size();
                    //a lista bármelyik elemének hossza pedig az oszlopok számát adja meg
                    int cols = list.get(0).length;
                    level = new int[rows][cols];
                    for (int i = 0; i < rows; i++) {
                        for (int j = 0; j < cols; j++) {
                            setElement(i, j, Integer.parseInt(list.get(i)[j]));
                        }
                    }
                } else {
                    System.out.println("A " + levelFile + "-ben lévő pálya rosszul definiált");
                }
            } 
        } catch (IOException | NumberFormatException e) {
            System.out.println("readLevelFromFile_error:\n" + e.getMessage());
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    System.out.println("readLevelFromFile_inputstream.close()_error:\n"
                            + e.getMessage());
                }
            }
        }
    }
}
