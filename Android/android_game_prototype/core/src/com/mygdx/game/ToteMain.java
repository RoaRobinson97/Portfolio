package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.mygdx.game.Screens.ContinueScreen;
import com.mygdx.game.Screens.GameOverScreen;
import com.mygdx.game.Screens.GameScreen;
import com.mygdx.game.Screens.InstructionsScreen;
import com.mygdx.game.Screens.MenuScreen;
import com.mygdx.game.Screens.OptionsScreen;
import com.mygdx.game.Screens.SplashScreen;

public class ToteMain extends Game {

	ContinueScreen continueScreen;
	GameOverScreen gameOverScreen;
	GameScreen gameScreen;
	InstructionsScreen instructionsScreen;
	public MenuScreen menuScreen;
	OptionsScreen optionsScreen;
	public SplashScreen splashScreen;
	public int a=0;


	@Override
	public void create () {

		//continueScreen = new ContinueScreen(this);
		//gameOverScreen = new GameOverScreen(this);
		//gameScreen = new GameScreen(this,menuScreen);
		//instructionsScreen = new InstructionsScreen(this,menuScreen);
		//menuScreen = new MenuScreen(this,splashScreen);
		//optionsScreen = new OptionsScreen(this,menuScreen);
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
