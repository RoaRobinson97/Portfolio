package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.ToteMain;

/**
 * Created by Robin on 05/08/2017.
 */

public class GameOverScreen implements Screen {
    ToteMain game;
    Screen superparent;
    int a =0;

    public GameOverScreen(ToteMain game, Screen superparent) {
        this.game= game;
        this.superparent = superparent;
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 0,0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.justTouched()){

            System.out.println("Fracasado!");
            game.setScreen(superparent);
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
