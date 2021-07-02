package com.floatingbasket.game;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.*;

public class ObjectSpawner
{
    private ArrayList<Object> objects = new ArrayList<Object>();



    public void LoadFruit()
    {
        objects.add(new Object(SetRandomObject()));
    }

    public void Update(SpriteBatch batch)
    {

        for(int i = 0;i<objects.size();i++)
        {
            // update each fruit in the list
            if(objects.get(i) != null)
            {
                objects.get(i).Draw(batch);//drawing fruits
                objects.get(i).Update();    //updating fruits
            }
        }
    }


    public String SetRandomObject()
    {
        int index = (int) (Math.random()  * 8) + 1;
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
            case 5:
                return  "Snake.png";
            case 6:
                return  "Bug.png";
            case 7:
                return "Squirrel.png";
        }
        return "Apple.png";
    }

    public void RemoveFruit()
    {
        for(int i = 0;i<objects.size();i++)
        {
            if(objects.get(i).objPos.y < 0 )  //if fruits cross over the screen border remove it from the array list
            {
                objects.remove(i);
            }

        }
    }
    public void IncreaseScore(Player player)
    {
        for(int i =0;i<objects.size();i++)
        {
            //check if the fruits collide with the basket
            if(objects.get(i).collider.overlaps(player.collider) )
            {
                if(objects.get(i).objTexture.toString() == player.currentLabel.toString()) // Check if the player collected the correct fruit
                {
                    SoundManager.Play(SoundManager.Collectsound); //Playing collecting sound
                    Main.ui.hitTextPos = new Vector2(player.playerPos.x,player.playerPos.y + 80);
                    Main.showplusHittexts =  true;
                    objects.remove(i);  //removing the object from the array list
                    Main.score += 10;                      //Increasing game score
                    player.currentLabel = new Texture(player.SetRandomFruitLabel()); //setting label to a different label

                }

                //else check if the player collects the snake,squirrel or bug to reduce the score
                else if(objects.get(i).objTexture.toString() == "Snake.png")
                {

                  Main.scene = Scene.GameOver;
                  objects.removeAll(objects);
                  SoundManager.Play(SoundManager.GameOversound);
                }

                else if(objects.get(i).objTexture.toString() == "Bug.png")
                {
                    Main.minusPoint = 10;

                    if(Main.score > 0)
                    {
                        Main.score -= 10;
                    }
                    objects.remove(i);
                    Main.showMinusHittexts =  true;
                    Main.ui.hitTextPos = new Vector2(player.playerPos.x,player.playerPos.y + 80);
                    SoundManager.Play(SoundManager.WrongCollectSound);


                }
                else if(objects.get(i).objTexture.toString() == "Squirrel.png")
                {
                    Main.minusPoint = Main.score;
                    Main.score = 0;
                    objects.remove(i);
                    Main.showMinusHittexts =  true;
                    Main.ui.hitTextPos = new Vector2(player.playerPos.x,player.playerPos.y + 80);
                    SoundManager.Play(SoundManager.WrongCollectSound);
                }
                else
                {
                    Main.minusPoint = 10;
                    if(Main.score > 0)
                    {
                        Main.score -= 10;
                    }
                    objects.remove(i);

                    Main.ui.hitTextPos = new Vector2(player.playerPos.x,player.playerPos.y + 80);
                    Main.showMinusHittexts =  true;
                    player.currentLabel = new Texture(player.SetRandomFruitLabel());
                    SoundManager.Play(SoundManager.WrongCollectSound);
                }


            }
        }

    }
    public void ResetSpawner()
    {
        this.objects.removeAll(objects);
    }








}
