package com.floatingbasket.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.InputAdapter;


public class Player
{
    public Texture playerTexture;
    public Vector2 playerPos;
    private float speed;
    public Rectangle collider;
    public Texture currentLabel;
    private boolean isTouching;
    private boolean isMovingRight;




    Player()
    {
        this.playerTexture = new Texture("Player.png");
        this.speed = 500f;
        this.playerPos = new Vector2(0,0);
        this.currentLabel = new Texture(SetRandomFruitLabel());


    }


//    public void PcUpdate()
//    {
//        //For Windows input system
//        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT) && this.playerPos.x < Gdx.graphics.getWidth() - 75)
//        {
//          //Move Right
//            this.playerPos.x += this.speed * Gdx.graphics.getDeltaTime();
//        }
//        else if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && this.playerPos.x > 0)
//        {
//           //Moving Left
//            this.playerPos.x -= this.speed * Gdx.graphics.getDeltaTime();
//        }
//
//        this.collider = new Rectangle(this.playerPos.x,this.playerPos.y,68,50);
//
//    }

    public void ProcessTouchInput()
    {
        Gdx.input.setInputProcessor(new InputAdapter()
                                    {
                                        @Override
                                        public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                                            isTouching = false;

                                            return true;
                                        }

                                        @Override
                                        public boolean touchDown(int screenX, int screenY, int pointer, int button)
                                        {

                                            isTouching = true;
                                            if(screenX >= Gdx.graphics.getWidth()/2)
                                            {
                                              isMovingRight = true;
                                            }
                                            else
                                            {
                                                isMovingRight = false;
                                            }
                                            return true;
                                        }

                                    }

        );

    }
     public void MovePlayer()
     {

           if(isTouching)
           {
               if(isMovingRight && this.playerPos.x < Gdx.graphics.getWidth())
               {
                   //Move Right
                   this.playerPos.x += this.speed * Gdx.graphics.getDeltaTime();
               }
               else if(!isMovingRight && this.playerPos.x > 0)
               {
                   //Move Left
                   this.playerPos.x -= this.speed * Gdx.graphics.getDeltaTime();
               }
               //this.collider = new Rectangle(this.playerPos.x,this.playerPos.y,68,50);
           }
         this.collider = new Rectangle(this.playerPos.x,this.playerPos.y,68,50);
     }


    public void Draw(SpriteBatch batch)
    {

        batch.draw(playerTexture,playerPos.x,playerPos.y,80,80); //drawing player
        batch.draw(currentLabel,10,450,52,52); // drawing label

    }


    public String SetRandomFruitLabel()
    {
        int index = (int) (Math.random()  * 5) + 1;
        switch (index)
        {
            case 1:

                return  "Orange.png";

            case 2:

                return  "StrawBerry.png";
            case 3:

               return  "Guava.png";
            case 4:

                return "Apple.png";

        }

        return "Apple.png";
    }







}
