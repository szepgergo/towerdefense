package towerdefence;

public class TowerDefenceMain {

    public static int[][] lvExample = new int[][] {
        {1,2,3},
        {4,5,6},
        {7,8,9},
        {10,11,12}
    };
    
    public static void main(String[] args) {
        
        Game towerDefense = new Game();
        towerDefense.run();
        System.exit(0);
        
        /*
        Level level = new Level();
        level.readLevelFromFile("level2.txt");
        System.out.println(level);
        //*/
        
        /*Level level = new Level(lvExample);
        level.setElement(1, 2, Level.LEVEL_ROAD);
        System.out.println(level.getHeight());
        System.out.println(level);*/
    }
}
