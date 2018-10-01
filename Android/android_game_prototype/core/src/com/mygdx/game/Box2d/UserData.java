package com.mygdx.game.Box2d;

import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.Enums.UserDataType;

/**
 * Created by Robin on 21/11/2017.
 */

public abstract class UserData {

    protected UserDataType userDataType;

    public UserData(){}

    public UserDataType getUserDataType(){
        return userDataType;
    }


}