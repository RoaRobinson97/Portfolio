package com.mygdx.game.Utils;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;


public class Constants {
    //1794x1080
    public static final int APP_WIDTH = Gdx.graphics.getWidth();
    public static final int APP_HEIGHT = Gdx.graphics.getHeight();

                 /*GRAVITY VALUES*/

    public static final Vector2 WORLD_GRAVITY = new Vector2(0, 0);
    public static final float   PLAYER_GRAVITY_SCALE = 0.5f;
    public static final Vector2 PLAYER_FLYING_LINEAR_IMPULSE_Y = new Vector2(0, 12f);
    public static final Vector2 PLAYER_FLYING_LINEAR_IMPULSE_X = new Vector2(0, 0);

                 /*ACTOR'S VALLUES*/

    public static final float GROUND_X = 0;
    public static final float GROUND_Y = 0;
    public static final float GROUND_WIDTH = 100;
    public static final float GROUND_HEIGHT = 2f;
    public static final float GROUND_DENSITY = 0f;

    public static final float CEILING_X =0;
    public static final float CEILING_Y = 30;
    public static final float CEILING_WIDTH = 100f;
    public static final float CEILING_HEIGHT = 2f;
    public static final float CEILING_DENSITY = 0f;

    public static final float SAFE_ZONE_X =15;
    public static final float SAFE_ZONE_WIDTH = 4;
    public static final float SAFE_ZONE_HEIGHT = 2;
    public static final float SAFE_ZONE_DENSITY = 0f;

    public static final float OBSTACLE_X = 15;
    public static final float OBSTACLE_RADIUS = 5f;
    public static final float OBSTACLE_DENSITY = 0f;
    
    public static final float PLAYER_X = -25;
    public static final float PLAYER_Y = 18;
    public static final float PLAYER_RADIUS = 1f;
    public static float PLAYER_DENSITY = 0f;
    public static float PLAYER_FRICTION = 0f;
    public static float PLAYER_RESTITUTION = 0;

    public static final String BACKGROUND_IMAGE_PATH = "background.png";
    public static final String CITY_IMAGE_PATH = "city.png";
    public static final String GROUND_IMAGE_PATH = "ground.png";

}
