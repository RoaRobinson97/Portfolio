package com.mygdx.game.Actors;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2d.PlayerUserData;
import com.mygdx.game.Box2d.UserData;

/**
 * Created by Robin on 21/11/2017.
 */

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


    public float getPlayerX(){
            return body.getPosition().x;
    }


}

