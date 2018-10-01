package com.mygdx.game.Box2D;

import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 07/08/2017.
 */

public class ObstacleUserData extends UserData{
    public ObstacleUserData(){
        super();
        userDataType = UserDataType.OBSTACLE;
    }
}
