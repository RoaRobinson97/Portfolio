package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.GameStage;
import com.mygdx.game.ToteMain;

public class GameScreen implements Screen {
    ToteMain game;
    Screen parent;
    Screen gameOverScreen;
    Screen continueScreen;
    GameStage stage;




    public GameScreen(ToteMain game, Screen parent) {
        this.game =game;
        this.parent = parent;
        gameOverScreen = new GameOverScreen(game,parent);
        continueScreen= new ContinueScreen(game, this);
        stage = new GameStage();
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.camera.position.set((stage.VIEWPORT_WIDTH / 2 + (stage.playerX -10)), (stage.VIEWPORT_HEIGHT / 2-2 ), 0f);



        if (stage.death == true){
            stage.death=false;
            game.setScreen(gameOverScreen);
        }

        stage.DropActors();
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
