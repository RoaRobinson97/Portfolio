package com.mygdx.game.Box2D;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 07/08/2017.
 */

public class CeilingUserData extends UserData {
    public CeilingUserData(){
        super();
        userDataType = UserDataType.CEILING;
    }
}
