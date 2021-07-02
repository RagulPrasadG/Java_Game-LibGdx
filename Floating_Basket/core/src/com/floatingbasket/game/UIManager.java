package com.floatingbasket.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class UIManager
{
    private BitmapFont scoreFont;
    private BitmapFont plusHitFont;
    private BitmapFont gameOverFont;
    private String scoreText = "Score :";
   // private String gameOverText = "GameOver!!";
    private String plusHitTexts = "+" + 10;
    private String minusHitTexts = "-";
    private float alpha = 1f;
    public Vector2 hitTextPos;
    private Texture bgTexture;
    private Texture mainMenuTexture;
    private Texture gameOverTexture;



    UIManager()
    {
        this.bgTexture = new Texture("bg.jpg");
        this.mainMenuTexture = new Texture("MainMenu.png");
        this.scoreFont = new BitmapFont();
        this.plusHitFont = new BitmapFont();
        this.gameOverFont = new BitmapFont();
        this.plusHitFont.getData().setScale(2.0f);
        this.scoreFont.setColor(Color.WHITE);
        this.scoreFont.getData().setScale(2.5f,2.5f);
        this.gameOverFont.getData().setScale(3f,3f);
        this.gameOverTexture = new Texture("GameOver.png");

    }
    public void DrawScore(SpriteBatch batch)
    {
        this.scoreFont.draw(batch,scoreText + Main.score,10,560);
    }
    public void GameOver(SpriteBatch batch)
    {
        //this.gameOverFont.draw(batch,gameOverText,350,400);
       batch.draw(this.gameOverTexture,0,0,1280,720);
    }



    public void UpdatePlusHitText(SpriteBatch batch)
    {

        this.alpha -= Gdx.graphics.getDeltaTime();
        this.plusHitFont.setColor(new Color(0,1,0,alpha));

        this.plusHitFont.draw(batch,this.plusHitTexts,this.hitTextPos.x,this.hitTextPos.y); //Drawing hit text
        if(alpha < 0 )
        {
            alpha = 1f;
            Main.showplusHittexts = false;
        }
    }
    public void UpdateMinusHitText(SpriteBatch batch)
    {

        this.alpha -= Gdx.graphics.getDeltaTime();
        this.plusHitFont.setColor(new Color(0,1,0,alpha));

        this.plusHitFont.draw(batch,this.minusHitTexts+Main.minusPoint,this.hitTextPos.x,this.hitTextPos.y); //Drawing hit text
        if(alpha < 0 )
        {
            alpha = 1f;
            Main.showMinusHittexts = false;
        }


    }
    public void DrawBg(SpriteBatch batch)
    {

        batch.draw(bgTexture,0,0,1280 ,720);
    }

    public void DrawMainMenu(SpriteBatch batch)
    {
        batch.draw(mainMenuTexture,0,0,1280 ,720);
    }




}
