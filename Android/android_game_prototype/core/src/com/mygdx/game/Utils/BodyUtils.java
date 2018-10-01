package com.mygdx.game.Utils;

import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2d.UserData;
import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 22/11/2017.
 */

public class BodyUtils {

    public static boolean bodyIsPlayer(Body body){
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.PLAYER;
    }

    public static boolean bodyIsGround(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.GROUND;
    }

    public static boolean bodyIsCeiling(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.CEILING;
    }

    public static boolean bodyIsObstacle(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.OBSTACLE;
    }

    public static boolean bodyIsSafeZone(Body body) {
        UserData userData = (UserData) body.getUserData();

        return userData != null && userData.getUserDataType() == UserDataType.SAFE_ZONE;
    }

}
