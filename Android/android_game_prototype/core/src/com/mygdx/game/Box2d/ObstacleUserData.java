package com.mygdx.game.Box2d;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 21/11/2017.
 */

public class ObstacleUserData extends UserData{
    public ObstacleUserData(){
        super();
        userDataType = UserDataType.OBSTACLE;
    }
}
