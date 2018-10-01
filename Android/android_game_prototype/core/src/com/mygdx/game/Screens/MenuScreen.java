package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.MainClass;

/**
 * Created by Robin on 19/11/2017.
 */

public class MenuScreen implements Screen {

    private final MainClass game;
    Screen parent;
    Screen optionsScreen;
    Screen instructionsScreen;
    Screen gameScreen;

    public MenuScreen(MainClass game, Screen parent){

        this.game = game;
        this.parent = parent;
        optionsScreen = new OptionsScreen(game,this);
        instructionsScreen= new InstructionsScreen(game,this);

    }

    protected void handleInputs(){
        if (Gdx.input.justTouched()){
            game.setScreen(new GameScreen(game, this));
    }}
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glClearColor(0, 0, 1, 1);
        handleInputs();

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }

}
