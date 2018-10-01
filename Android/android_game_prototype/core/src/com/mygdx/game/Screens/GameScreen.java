package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.mygdx.game.GameStage;
import com.mygdx.game.MainClass;

/**
 * Created by Robin on 21/11/2017.
 */

public class GameScreen implements Screen {

    private final MainClass game;
    Screen parent;
    Screen gameOverScreen;
    GameStage stage;


    public GameScreen (MainClass game, Screen parent){
        this.game = game;
        this.parent = parent;
        gameOverScreen = new GameOverScreen(game,parent);
        stage = new GameStage();

    }

    public void handleInputs(){
//        if ((Gdx.input.justTouched()) && stage.gravityON == true){
//            game.setScreen(gameOverScreen);
//        }
    }

    public void stageValues(){

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);


        stage.camera.position.set((stage.VIEWPORT_WIDTH / 2 + (stage.playerX -10)), (stage.VIEWPORT_HEIGHT / 2-5 ), 0f);
        handleInputs();
        stage.draw();
        stage.act(delta);
        stage.camera.update();

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
