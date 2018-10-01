package com.mygdx.game.Actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2d.GroundUserData;
import com.mygdx.game.Box2d.UserData;

/**
 * Created by Robin on 21/11/2017.
 */

public class Ground extends GameActor {

    public Ground (Body body){
        super(body);
    }

    @Override
    public UserData getUserData() {
        return (GroundUserData) userData;
    }
}
