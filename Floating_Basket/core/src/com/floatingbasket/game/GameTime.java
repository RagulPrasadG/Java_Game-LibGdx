package com.floatingbasket.game;

import com.badlogic.gdx.Gdx;

public  class GameTime
{

    long startTime,elapsedTime,elapsedSeconds,seconds = 1;
    GameTime()
    {
        this.startTime =System.currentTimeMillis();
    }
    public void Start()
    {
        System.out.println(seconds);
        elapsedTime = System.currentTimeMillis()- startTime;     //elapsed time - start time
        elapsedSeconds = elapsedTime/1000;        //elapsed seconds = elapsed time / 1000
        seconds += elapsedSeconds % 60;           //seconds = elapsed seconds % 60
    }
    public long GetCurrentSeconds()
    {
        //System.out.println(seconds); //debugging system timer
        return  seconds;
    }



}
