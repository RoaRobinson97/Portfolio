package com.mygdx.game.Actors;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2D.SafeZoneUserData;


public class SafeZone extends GameActor {
    public SafeZone(Body body){
    super(body);
}

    @Override
    public SafeZoneUserData getUserData() {
        return (SafeZoneUserData) userData ;
    }

}
