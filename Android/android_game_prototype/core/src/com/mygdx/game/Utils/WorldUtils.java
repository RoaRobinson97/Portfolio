package com.mygdx.game.Utils;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.mygdx.game.Box2d.CeilingUserData;
import com.mygdx.game.Box2d.GroundUserData;
import com.mygdx.game.Box2d.ObstacleUserData;
import com.mygdx.game.Box2d.PlayerUserData;
import com.mygdx.game.Box2d.SafeZoneUserData;

/**
 * Created by Robin on 22/11/2017.
 */

public class WorldUtils {

    public static World createWorld() {
        return new World(Constants.WORLD_GRAVITY, true);
    }

    public static Body createPlayer(World world){
        BodyDef bodyDef = new BodyDef();
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        bodyDef.position.set(new Vector2(Constants.PLAYER_X, Constants.PLAYER_Y));
        Body body = world.createBody(bodyDef);
        CircleShape circle = new CircleShape();
        circle.setRadius(Constants.PLAYER_RADIUS/2);
        body.setGravityScale(Constants.PLAYER_GRAVITY_SCALE);
              /*NEW IMPLEMENTAION*/
        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape= circle;
        fixtureDef.density = Constants.PLAYER_DENSITY;
        fixtureDef.friction = Constants.PLAYER_FRICTION;
        fixtureDef.restitution = Constants.PLAYER_RESTITUTION;
        Fixture fixture= body.createFixture(fixtureDef);
              /*UNTIL HERE*/

        //body.createFixture(circle, Constants.PLAYER_DENSITY);
        //body.resetMassData();

        body.setUserData(new PlayerUserData());
        circle.dispose();
        return body;
    }

    public static Body createGround(World world, int x){
        BodyDef groundbodyDef = new BodyDef();
        groundbodyDef.position.set(new Vector2(Constants.GROUND_X+x, Constants.GROUND_Y));
        Body groundbody = world.createBody(groundbodyDef);
        PolygonShape groundshape = new PolygonShape();
        groundshape.setAsBox(Constants.GROUND_WIDTH / 2, Constants.GROUND_HEIGHT / 2);
        groundbody.createFixture(groundshape, Constants.GROUND_DENSITY);
        groundbody.setUserData(new GroundUserData());
        groundshape.dispose();
        return groundbody;
    }

    public static Body createCeiling(World world, int x){
        BodyDef ceilingbodyDef = new BodyDef();
        ceilingbodyDef.position.set(new Vector2(Constants.CEILING_X+x, Constants.CEILING_Y));
        Body ceilingbody = world.createBody(ceilingbodyDef);
        PolygonShape ceilingshape = new PolygonShape();
        ceilingshape.setAsBox(Constants.CEILING_WIDTH / 2, Constants.CEILING_HEIGHT / 2);
        ceilingbody.createFixture(ceilingshape, Constants.CEILING_DENSITY);
        ceilingbody.setUserData(new CeilingUserData());
        ceilingshape.dispose();
        return ceilingbody;
    }

    public static Body createObstacle(World world, float CoordX, float CoordY){
        BodyDef obstaclebodyDef = new BodyDef();
        obstaclebodyDef.position.set(new Vector2(Constants.OBSTACLE_X + CoordX , CoordY));
        Body obstaclebody = world.createBody(obstaclebodyDef);
        CircleShape obstacleshape = new CircleShape();
        obstacleshape.setRadius(Constants.OBSTACLE_RADIUS);
        obstaclebody.createFixture(obstacleshape, Constants.OBSTACLE_DENSITY);
        obstaclebody.setUserData(new ObstacleUserData());
        obstacleshape.dispose();
        return obstaclebody;
    }

    public static Body createSafeZone(World world, float CoordX, float CoordY){
        BodyDef safezonebodyDef = new BodyDef();
        safezonebodyDef.position.set(new Vector2(Constants.SAFE_ZONE_X + CoordX, CoordY));
        Body safezonebody = world.createBody(safezonebodyDef);
        PolygonShape safezoneshape = new PolygonShape();
        safezoneshape.setAsBox(Constants.SAFE_ZONE_WIDTH/ 2, Constants.SAFE_ZONE_HEIGHT / 2);
        safezonebody.createFixture(safezoneshape, Constants.SAFE_ZONE_DENSITY);
        safezonebody.setUserData(new SafeZoneUserData());
        safezoneshape.dispose();
        return safezonebody;

    }
    public static Body clcreateSafeZone(World world, float CoordX, float CoordY) {
        BodyDef clsafezonebodyDef = new BodyDef();
        clsafezonebodyDef.position.set(new Vector2(Constants.SAFE_ZONE_X + CoordX -2, CoordY+0.5f));
        Body clsafezonebody = world.createBody(clsafezonebodyDef);
        CircleShape clsafezoneshape = new CircleShape();
        clsafezoneshape.setRadius(0.5f);
        clsafezonebody.createFixture(clsafezoneshape, Constants.SAFE_ZONE_DENSITY);
        clsafezonebody.setUserData(new SafeZoneUserData());
        clsafezoneshape.dispose();
        return clsafezonebody;
    }

    public static Body crcreateSafeZone(World world, float CoordX, float CoordY) {
        BodyDef clsafezonebodyDef = new BodyDef();
        clsafezonebodyDef.position.set(new Vector2(Constants.SAFE_ZONE_X + CoordX +2, CoordY+0.5f));
        Body clsafezonebody = world.createBody(clsafezonebodyDef);
        CircleShape clsafezoneshape = new CircleShape();
        clsafezoneshape.setRadius(0.5f);
        clsafezonebody.createFixture(clsafezoneshape, Constants.SAFE_ZONE_DENSITY);
        clsafezonebody.setUserData(new SafeZoneUserData());
        clsafezoneshape.dispose();
        return clsafezonebody;
    }
    public static Body lcreateSafeZone(World world, float CoordX, float CoordY){
        BodyDef safezonebodyDef = new BodyDef();
        safezonebodyDef.position.set(new Vector2(Constants.SAFE_ZONE_X -2 + CoordX, CoordY-0.5f));
        Body safezonebody = world.createBody(safezonebodyDef);
        PolygonShape safezoneshape = new PolygonShape();
        safezoneshape.setAsBox(0.5f,0.5f);
        safezonebody.createFixture(safezoneshape, Constants.SAFE_ZONE_DENSITY);
        safezonebody.setUserData(new SafeZoneUserData());
        safezoneshape.dispose();
        return safezonebody;
    }

    public static Body rcreateSafeZone(World world, float CoordX, float CoordY){
        BodyDef safezonebodyDef = new BodyDef();
        safezonebodyDef.position.set(new Vector2(Constants.SAFE_ZONE_X+4f-2 + CoordX, CoordY-0.5f));
        Body safezonebody = world.createBody(safezonebodyDef);
        PolygonShape safezoneshape = new PolygonShape();
        safezoneshape.setAsBox(0.5f,0.5f);
        safezonebody.createFixture(safezoneshape, Constants.SAFE_ZONE_DENSITY);
        safezonebody.setUserData(new SafeZoneUserData());
        safezoneshape.dispose();
        return safezonebody;
    }

}
