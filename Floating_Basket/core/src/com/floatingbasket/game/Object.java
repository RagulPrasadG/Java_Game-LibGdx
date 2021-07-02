package com.floatingbasket.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Object
{
    public Texture objTexture;
    public Vector2 objPos;
    public Rectangle collider;


    public float speed;

   Object(String texture)
    {

        this.objTexture = new Texture(texture);     // setting the texture
        this.speed = (float)Math.random() * (200- 120 + 1) + 120;      // setting the random speed of the variable
        this.objPos = new Vector2((float)Math.random() * ((Gdx.graphics.getWidth() -20)- 20 + 1) + 20,Gdx.graphics.getHeight());  //Math.random() * (max - min + 1) + min


    }

    public void Update()
    {
        this.objPos.y -= this.speed * Gdx.graphics.getDeltaTime();
        this.collider = new Rectangle(this.objPos.x,this.objPos.y,28,30);
    }

    public void Draw(SpriteBatch batch)
    {
        batch.draw(this.objTexture,this.objPos.x,this.objPos.y,35,35);
    }


}
