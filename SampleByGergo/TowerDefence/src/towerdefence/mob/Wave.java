/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package towerdefence.mob;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import towerdefence.tower.Position;

/**
 *
 * @author Gergo
 */
public class Wave {
    
    private List<WaveListener> waveListeners;
    
    private List<Mob> mobs;
    private int prize;
    private int count;
    private MobType type;
    private int spawnSpeed = 500;
    private int counter;
    private int spawned = 0;
    
    
    private boolean rewadGiven = false;
    
    public Wave(MobType type, int count, int prize, Position spawnPosition){
        this.type = type;
        this.count = count;
        this.prize = prize;
        waveListeners = new ArrayList<>();
        mobs = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            mobs.add(MobFactory.createMob(type, spawnPosition));
        }
        spawnSpeed = MobFactory.createMob(type, spawnPosition).getSpawnSpeed();
        counter = spawnSpeed;
    }

    
    public void draw(Graphics g){
        for(Mob m : mobs){
            m.draw(g);
        }
    }
    
    
    
    public void next() {
        
            if(hasNext()){
                if(counter >= spawnSpeed){
                    mobs.get(spawned).spawn();
                    spawned++;
                    counter = 0;
                }
                counter++;
            }
            boolean over = true;
            for(int i = 0; i < mobs.size(); i++){
                if(mobs.get(i).isInGame()){
                    over = false;
                    mobs.get(i).move();
                    if(mobs.get(i).getHealth() <= 0){
                        mobs.get(i).kill();
                        for(WaveListener wl : waveListeners){
                            wl.mobKilled(mobs.get(i));
                        }
                    }
                }
            }
            if(over && !rewadGiven){
                rewadGiven = true;
                for(WaveListener wl : waveListeners){
                    wl.giveWaveReward(this);
                }
            }
        
    }
    
    public boolean hasNext(){
        return spawned+1 < count;
    }
    
    
    public List<Mob> getMobs() {
        return mobs;            
    }    
    
    public void addWaveListener(WaveListener wl){
        waveListeners.add(wl);
    }

    public int getPrize() {
        return prize;
    }
    
    
    
}
