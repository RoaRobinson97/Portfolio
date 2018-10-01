package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.mygdx.game.Actors.Background;
import com.mygdx.game.Actors.Ceiling;
import com.mygdx.game.Actors.City;
import com.mygdx.game.Actors.Ground;
import com.mygdx.game.Actors.Obstacle;
import com.mygdx.game.Actors.Player;
import com.mygdx.game.Actors.SafeZone;
import com.mygdx.game.Utils.BodyUtils;
import com.mygdx.game.Utils.Constants;
import com.mygdx.game.Utils.WorldUtils;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Robin on 07/08/2017.
 */

public class GameStage extends Stage implements ContactListener {

/////////////////*Variables*////////////////////////////////////////////////////////////////////////
    public Texture piso;
    public static final int VIEWPORT_WIDTH = 24*2;
    public static final int VIEWPORT_HEIGHT = 40*2;
    private World world;
    public Player player;
    private ArrayList<Ground> grounds = new ArrayList<Ground>();
    private ArrayList<Ceiling> ceilings = new ArrayList<Ceiling>();
    public ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    public ArrayList<SafeZone> safeZones = new ArrayList<SafeZone>();
    private float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;
    private Box2DDebugRenderer renderer;
    public OrthographicCamera camera;
    private int distanceCoordX = 0;
    private int grounddist = 0;
    private int ceilingdist = 0;

    public float playerX, playerY;
    private int counter =0;
    public boolean death = false;
    public boolean safeLanding = false;
    private Vector2 worldGravity = new Vector2(0,-20f);
    private boolean gravityON = false;

    SpriteBatch batch;
    Texture img;


/////////////////*Methods*//////////////////////////////////////////////////////////////////////////

    public GameStage() {
           setUpWorld();
           renderer = new Box2DDebugRenderer();
           setupCamera();
           int a =0;

    }

    public void setUpWorld(){
           world = WorldUtils.createWorld();
           world.setContactListener(this);
           setUpSection();
           setUpPlayer();
           setUpBackground();
           setUpCity();
    }

    private void setUpBackground() {
        addActor(new Background());
    }
    private void setUpCity() {
        addActor(new City());
    }

    private void setUpSection(){
            setUpCeiling();
            setUpGround();
            Random r = new Random();
            int i = r.nextInt(11 - 5) + 5;
            for (int a =0; a<i; a=a+1){
                setUpObstacle();
            }
            setUpSafeZone();
    }

    private void setUpPlayer() {
            player = new Player(WorldUtils.createPlayer(world));
            addActor(player);
    }

    private void setUpGround() {
            //grounds[grounds_cant] = new Ground(WorldUtils.createGround(world));
            //addActor(grounds[grounds_cant]);
            grounds.add (new Ground(WorldUtils.createGround(world,grounddist)));
            grounddist = grounddist + (int) Constants.GROUND_WIDTH;
    }

    private void setUpCeiling() {
            ceilings.add(new Ceiling(WorldUtils.createCeiling(world, grounddist)));
            ceilingdist = ceilingdist + (int) Constants.CEILING_WIDTH;
            }

    private void setUpObstacle() {
            Random r1 = new Random();
            int i1 = r1.nextInt(21 - 10) + 10;
            obstacles.add (new Obstacle(WorldUtils.createObstacle(world, distanceCoordX, i1)));
            distanceCoordX = distanceCoordX + 15;
    }

    private void setUpSafeZone() {
            Random r2 = new Random();
            int i2 = r2.nextInt(21 - 10) + 10;
            safeZones.add(new SafeZone(WorldUtils.createSafeZone(world, distanceCoordX, i2 )));
            safeZones.add(new SafeZone(WorldUtils.crcreateSafeZone(world, distanceCoordX, i2 )));
            safeZones.add(new SafeZone(WorldUtils.clcreateSafeZone(world, distanceCoordX, i2 )));
            safeZones.add(new SafeZone(WorldUtils.rcreateSafeZone(world, distanceCoordX, i2 )));
            safeZones.add(new SafeZone(WorldUtils.lcreateSafeZone(world, distanceCoordX, i2 )));
            distanceCoordX = distanceCoordX + 15;
    }

    public void DropActors(){
       Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
       if (grounds.size() >= 8){
            grounds.remove(grounds.size()-7);
        }
        if (ceilings.size() >=8){
            ceilings.remove(ceilings.size()-7);
        }
        if (obstacles.size() >= 15){
            obstacles.remove(obstacles.size()-14);
        }
       if (safeZones.size()>=15){
           safeZones.remove(safeZones.size()-14);
        }


    }

    public void setupCamera(){
           camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
           camera.position.set((VIEWPORT_WIDTH / 2), VIEWPORT_HEIGHT / 2 , 0f);
           camera.update();
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        // Fixed timestep
        accumulator += delta;



        while (accumulator >= delta) {
            world.step(TIME_STEP, 6, 2);
            accumulator -= TIME_STEP;
        }
        //TODO: Implement interpolation
       }

    @Override
    public void draw() {
           super.draw();
           renderer.render(world, camera.combined);
           playerX = player.body.getPosition().x;
           playerY = player.body.getPosition().y;


           if ((gravityON == false) && (Gdx.input.justTouched())){
               world.setGravity(worldGravity);
               player.body.setLinearVelocity(10f,0f);
           }
           if (Gdx.input.justTouched()){
                player.fly();
           }
        counter = counter +1;
           if (counter>=90){
            System.out.println("Obstacles:"+obstacles.size());
               System.out.println("SafeZones:"+safeZones.size());

               setUpSection();
            counter =0;
           }

    }

    @Override
    public void beginContact(Contact contact) {
           Body a = contact.getFixtureA().getBody();
           Body b = contact.getFixtureB().getBody();

        if ((BodyUtils.bodyIsPlayer(a) && BodyUtils.bodyIsSafeZone(b)) ||
                (BodyUtils.bodyIsSafeZone(a) && BodyUtils.bodyIsPlayer(b))) {
            System.out.println("Safe");
            safeLanding = true;
        }
        if ((BodyUtils.bodyIsPlayer(a) && BodyUtils.bodyIsGround(b)) ||
                (BodyUtils.bodyIsGround(a) && BodyUtils.bodyIsPlayer(b))) {
            System.out.println("Death");
            safeLanding = true;
        }
       if ((BodyUtils.bodyIsPlayer(a) && BodyUtils.bodyIsObstacle(b)) ||
               (BodyUtils.bodyIsObstacle(a) && BodyUtils.bodyIsPlayer(b))) {
                System.out.println("Death");
               death = true;
              }
        if ((BodyUtils.bodyIsPlayer(a) && BodyUtils.bodyIsCeiling(b)) ||
                (BodyUtils.bodyIsCeiling(a) && BodyUtils.bodyIsPlayer(b))) {
            System.out.println("Death");
            safeLanding = true;
        }
           }
    @Override
    public void endContact(Contact contact) {
    }
    @Override
    public void preSolve(Contact contact, Manifold oldManifold) {
    }
    @Override
    public void postSolve(Contact contact, ContactImpulse impulse) {
    }

    @Override
    public void dispose() {
    }
}