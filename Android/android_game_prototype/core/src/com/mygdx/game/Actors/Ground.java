package com.mygdx.game.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.physics.box2d.Body;
import com.mygdx.game.Box2D.GroundUserData;
import com.mygdx.game.GameStage;
import com.mygdx.game.Utils.Constants;


public class Ground extends GameActor {


   public Ground(Body body){
       super(body);

   }



   
    public void dispose() {
    }
   @Override
   public GroundUserData getUserData() {
      return (GroundUserData) userData ;
   }


}
