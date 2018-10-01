package com.mygdx.game.Actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2D.ObstacleUserData;

/**
 * Created by Robin on 07/08/2017.
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
