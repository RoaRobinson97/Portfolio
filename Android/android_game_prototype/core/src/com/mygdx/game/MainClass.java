package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.SplashScreen;

public class MainClass extends Game {

	public SplashScreen splashScreen;


	
	@Override
	public void create () {

		splashScreen = new SplashScreen(this);
		setScreen(splashScreen);

	}

	@Override
	public void render () {
		super.render();

	}
	
	@Override
	public void dispose () {
	}
}
