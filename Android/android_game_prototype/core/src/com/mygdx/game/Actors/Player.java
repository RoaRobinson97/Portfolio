package com.mygdx.game.Actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2D.PlayerUserData;


public class Player extends GameActor {
       private boolean alive;

    public Player(Body body){
           super(body);
           alive = true;
    }

    public void fly() {
           body.applyLinearImpulse(getUserData().getFlyingLinearImpulse(), body.getWorldCenter(), true);
           body.applyForceToCenter(0f,-10f,true);
    }


    @Override
    public PlayerUserData getUserData() {
        return (PlayerUserData) userData;
    }
}
