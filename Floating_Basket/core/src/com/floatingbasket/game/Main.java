package com.floatingbasket.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;


public class Main extends ApplicationAdapter
{
	public static int minusPoint;
	public static Scene scene = Scene.MainMenu;
	public static SpriteBatch batch;
    Player player;
    ObjectSpawner spawner;
    GameTime timer;
    static UIManager ui;
    static int score = 0;
	static boolean showplusHittexts = false;
	static boolean showMinusHittexts = false;

	OrthographicCamera camera;
	

	@Override
	public void create () {
		camera = new OrthographicCamera();
		batch = new SpriteBatch();
		spawner = new ObjectSpawner();
		player = new Player();
		timer = new GameTime();
		ui = new UIManager();
        SoundManager.LoadSounds();

	}

	@Override
	public void render () {
		 Gdx.gl.glClearColor(0, 0, 0, 1);
		 Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.setToOrtho(false,1280, 1280* 9/18);
		batch.setProjectionMatrix(camera.combined);


		 batch.begin();



		 switch (scene)
		 {
			 case MainMenu:
			 	//Draw MainMenu
				 Reset();
				 ui.DrawMainMenu(batch);
				 CheckForGameStart();

			 	break;
			 case GamePlay:
			 	//Draw Gameplay
				 ui.DrawBg(batch);
				 SoundManager.bgm.play();

				 player.Draw(batch) ;   //drawing player
				 player.ProcessTouchInput();      //Processing the Touch Events
				 //player.PcUpdate();
				 player.MovePlayer();         //Moving Player

				 timer.Start();

				 if(timer.GetCurrentSeconds() % 100 == 0)       //increasing the value increases the delay in spawning
				 {
					 spawner.LoadFruit(); //Loading fruits in the array list
				 }


				 spawner.Update(batch);  //Updating the fruits in the array list

				 spawner.IncreaseScore(player); // Increasing Score

				 spawner.RemoveFruit();    //Removing Fruit

				 ui.DrawScore(batch);      //Displaying Game Over Text
				 if(showplusHittexts)
				 {
					 ui.UpdatePlusHitText(batch);
				 }
				 else if(showMinusHittexts)
				 {
					 ui.UpdateMinusHitText(batch);
				 }
			 	break;
			 case GameOver:

			 	ui.GameOver(batch);
				CheckForGameRestart();
			 	break;

	         }


		batch.end();
	}

	@Override
	public void dispose ()
	{
		batch.dispose();

	}
	private void CheckForGameStart()
	{

			Gdx.input.setInputProcessor(new InputAdapter()
										{


											@Override
											public boolean touchDown(int screenX, int screenY, int pointer, int button)
											{
												scene = Scene.GamePlay;
                                               return true;

											}

										}

			);

	}
	private void CheckForGameRestart()
	{

		Gdx.input.setInputProcessor(new InputAdapter()
									{


										@Override
										public boolean touchDown(int screenX, int screenY, int pointer, int button)
										{
											scene = Scene.MainMenu;
											return true;

										}

									}

		);

	}


	public void Reset()
	{
       this.player.playerPos = new Vector2(0,0);
       this.spawner.ResetSpawner();
       this.score = 0;
	}
}






