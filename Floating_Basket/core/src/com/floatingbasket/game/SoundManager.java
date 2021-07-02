package com.floatingbasket.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

public class SoundManager
{
    public static Sound Collectsound;
    public static Sound GameOversound;
    public static Sound WrongCollectSound;
    public static Music bgm;
    static  void LoadSounds()
    {
          Collectsound = Gdx.audio.newSound(Gdx.files.internal("Sounds/Collect.wav"));
          GameOversound = Gdx.audio.newSound(Gdx.files.internal("Sounds/GameOver.wav"));
          WrongCollectSound = Gdx.audio.newSound(Gdx.files.internal("Sounds/WrongCollect.mp3"));
          bgm = Gdx.audio.newMusic(Gdx.files.internal("Sounds/CricketAmbience.wav"));
          bgm.setLooping(true);
    }

    static void Play(Sound sound)
    {
        if(sound != null)
        sound.play();
    }


}
