package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.ToteMain;


public class OptionsScreen implements Screen {
    ToteMain game;
    Screen parent;
    int a =0;


    public OptionsScreen(ToteMain game, Screen parent) {
        this.game = game;
        this.parent=parent;

    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
            Gdx.gl.glClearColor(0, 1,0, 1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        if (Gdx.input.justTouched()){
            a=a+1;
            game.setScreen(parent);
            System.out.println(a);
        }

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
