package com.mygdx.game.Box2D;


import com.mygdx.game.Enums.UserDataType;

public class GroundUserData extends UserData{
    public GroundUserData(){
        super();
        userDataType = UserDataType.GROUND;
    }
}
