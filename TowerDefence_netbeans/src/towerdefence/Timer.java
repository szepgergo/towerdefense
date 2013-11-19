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
        startTime = GetTime();
        GetDeltaTime();
    }
    
    public void Update()
    {
        UpdateDeltaTime();
        UpdateFPS();
    }
    
    public long GetTime()
    {
        return System.nanoTime() / 1000000;
    }
    
    public long ElapsedTime()
    {
        return (System.nanoTime() - startTime);
    }
    
    public void UpdateFPS()
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
    
    public int GetFPS()
    {
        return fps;
    }
    
    public int GetDeltaTime()
    {
        return deltaTime;
    }
    
    public void UpdateDeltaTime()
    {
        long time = GetTime();
        deltaTime = (int) (time - lastFrame);
        lastFrame = time;
    }
}
