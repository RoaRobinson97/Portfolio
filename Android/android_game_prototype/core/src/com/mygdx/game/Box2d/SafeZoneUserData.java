package com.mygdx.game.Box2d;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 21/11/2017.
 */

public class SafeZoneUserData extends UserData {
    public SafeZoneUserData(){
        super();
        userDataType = UserDataType.SAFE_ZONE;
    }
}
