package com.mygdx.game.Actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2d.ObstacleUserData;

/**
 * Created by Robin on 21/11/2017.
 */

public class Obstacle extends GameActor {
    public Obstacle(Body body){
        super(body);
    }

    @Override
    public ObstacleUserData getUserData() {
        return (ObstacleUserData) userData ;
    }

}

