package com.mygdx.game.Actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2D.CeilingUserData;

public class Ceiling extends GameActor {
    public Ceiling(Body body){
        super(body);
    }

    @Override
    public CeilingUserData getUserData() {
        return (CeilingUserData) userData ;
    }

}
