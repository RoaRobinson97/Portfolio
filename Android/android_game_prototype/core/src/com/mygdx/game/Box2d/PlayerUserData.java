package com.mygdx.game.Box2D;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Enums.UserDataType;
import com.mygdx.game.Utils.Constants;

/**
 * Created by Robin on 07/08/2017.
 */

public class PlayerUserData extends UserData {

    private Vector2 flyingLinearImpulse;

    public PlayerUserData(){
           super();
           flyingLinearImpulse = Constants.PLAYER_FLYING_LINEAR_IMPULSE_Y;
           userDataType = UserDataType.PLAYER;
    }
    public Vector2 getFlyingLinearImpulse() {
        return flyingLinearImpulse;
    }
    public void setFlyingLinearImpulse(Vector2 flyingLinearImpulse) {
        this.flyingLinearImpulse = flyingLinearImpulse;
    }



}
