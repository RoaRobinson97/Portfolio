package com.mygdx.game.Box2D;

import com.mygdx.game.Enums.UserDataType;

public abstract class UserData {

    protected UserDataType userDataType;

    public UserData(){}

    public UserDataType getUserDataType(){
        return userDataType;
    }
}