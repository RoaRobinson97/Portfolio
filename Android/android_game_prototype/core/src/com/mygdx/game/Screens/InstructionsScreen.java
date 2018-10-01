package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.mygdx.game.MainClass;

/**
 * Created by Robin on 21/11/2017.
 */

public class InstructionsScreen implements Screen {

    private final MainClass game;
    Screen parent;

    public InstructionsScreen (MainClass game, Screen parent){
        this.game = game;
        this.parent = parent;
    }

    protected void handleInputs(){
        if (Gdx.input.justTouched()){
            game.setScreen(parent);}
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

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
