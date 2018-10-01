package com.mygdx.game.Box2d;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 21/11/2017.
 */

public class GroundUserData extends UserData{
    public GroundUserData(){
        super();
        userDataType = UserDataType.GROUND;
    }
}
