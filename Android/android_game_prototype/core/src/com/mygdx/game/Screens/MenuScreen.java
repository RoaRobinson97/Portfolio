package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.ToteMain;

/**
 * Created by Robin on 05/08/2017.
 */

 public class MenuScreen implements Screen{
    ToteMain game;

    Screen parent;
    Screen optionsScreen;
    Screen instructionsScreen;
    Screen gameScreen;

    float r = 0.01f;
    float g = 0.01f;
    float b = 0.01f;

    int a = 0;





   public MenuScreen(ToteMain game, Screen parent ) {

        this.game = game;
        this.parent= parent;
        optionsScreen = new OptionsScreen(game,this);
        instructionsScreen= new InstructionsScreen(game,this);



    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
       if(r<=0.99f){
        r=r+0.015f;
        g=g+0.015f;
        b=b+0.015f;}
        Gdx.gl.glClearColor(r, g, b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        if (Gdx.input.isKeyPressed(Input.Keys.V)){
      game.setScreen(parent);
    }
        if (Gdx.input.justTouched()){
             r = 0.01f;
             g = 0.01f;
             b = 0.01f;
            a=a+1;
            System.out.println("Menu:"+a);
            game.setScreen(new GameScreen(game, this));
           // game.setScreen(optionsScreen);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.V)){
            game.setScreen(instructionsScreen);
        }

        if(1>=2){

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
