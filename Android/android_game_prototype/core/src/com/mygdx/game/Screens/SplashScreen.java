package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.ToteMain;

/**
 * Created by Robin on 06/08/2017.
 */

public class SplashScreen implements Screen {
    private final ToteMain game;
    Screen menuScreen;
    SpriteBatch batch;
    Texture img;
    int a = 0;





    public SplashScreen(ToteMain game){
        this.game = game;
        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        menuScreen = new MenuScreen(game,this);
    }


    @Override
    public void show() {


    }

    @Override
    public void render(float delta) {


        Gdx.gl.glClearColor(1, 0, 0, 1f);
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       batch.begin();
       batch.draw(img, (((Gdx.graphics.getWidth()-img.getWidth())/2)), ((Gdx.graphics.getHeight()-img.getHeight())/2));
        batch.end();
        if (a<=120){
       a=a+1;}
        if (a >= 120){              //Espera 4 segundas ya que el delta time es 30
            //game.setScreen(new MenuScreen(game, this)); Asi se crea desde cero siempre
            game.setScreen(menuScreen);
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
        batch.dispose();
        img.dispose();

    }
}
