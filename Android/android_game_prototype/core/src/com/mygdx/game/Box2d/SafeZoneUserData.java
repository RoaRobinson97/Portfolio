package com.mygdx.game.Box2D;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 07/08/2017.
 */

public class SafeZoneUserData extends UserData {
    public SafeZoneUserData(){
        super();
        userDataType = UserDataType.SAFE_ZONE;
    }
}
