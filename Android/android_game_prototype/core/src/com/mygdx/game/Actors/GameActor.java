package com.mygdx.game.Actors;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.mygdx.game.Box2D.UserData;

/**
 * Created by Robin on 07/08/2017.
 */

public abstract class GameActor extends Actor {
    public Body body;
    protected UserData userData;
    public Sprite img;


    public GameActor(Body body){
        this.body = body;
        this.userData = (UserData) body.getUserData();
    }
    public abstract UserData getUserData();
}
