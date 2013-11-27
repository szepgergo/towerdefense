package towerdefence;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ádám
 */
public final class Timer
{
    long startTime;
    long lastFrame;
    int frames;
    int elapsedTime;
    int fps;
    int deltaTime;
    
    public Timer()
    {
        //startTime in milliseconds
        startTime = getTime();
        getDeltaTime();
    }
    
    public void update()
    {
        updateDeltaTime();
        updateFPS();
    }
    
    public long getTime()
    {
        return System.nanoTime() / 1000000;
    }
    
    public long elapsedTime()
    {
        return (System.nanoTime() - startTime);
    }
    
    public void updateFPS()
    {
        elapsedTime += deltaTime;
        if (elapsedTime > 1000)
        {
            fps = frames;
            elapsedTime = 0;
            frames = 0;
        }
        frames++;
    }
    
    public int getFPS()
    {
        return fps;
    }
    
    public int getDeltaTime()
    {
        return deltaTime;
    }
    
    public void updateDeltaTime()
    {
        long time = getTime();
        deltaTime = (int) (time - lastFrame);
        lastFrame = time;
    }
}
