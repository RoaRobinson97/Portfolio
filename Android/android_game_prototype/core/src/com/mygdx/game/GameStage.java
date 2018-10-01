package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.IntArray;
import com.mygdx.game.Actors.Ceiling;
import com.mygdx.game.Actors.Ground;
import com.mygdx.game.Actors.Obstacle;
import com.mygdx.game.Actors.Player;
import com.mygdx.game.Actors.SafeZone;
import com.mygdx.game.Utils.Constants;
import com.mygdx.game.Utils.WorldUtils;

import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

/**
 * Created by Robin on 22/11/2017.
 */

public class GameStage extends Stage implements ContactListener {

    public static final int VIEWPORT_WIDTH = 24;
    public static final int VIEWPORT_HEIGHT = 40;
    private World world;
    private float TIME_STEP = 1 / 300f;
    private float accumulator = 0f;
    private Box2DDebugRenderer renderer;
    public OrthographicCamera camera;
    private Vector2 worldGravity = new Vector2(0,-10f);
    public boolean gravityON = false;

    protected Player player;
    private ArrayList<Ground> grounds = new ArrayList<Ground>();
    private ArrayList<Ceiling> ceilings = new ArrayList<Ceiling>();
    private ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();
    private ArrayList<SafeZone> szcenter = new ArrayList<SafeZone>();
    private ArrayList<SafeZone> rrectangle = new ArrayList<SafeZone>();
    private ArrayList<SafeZone> lrectangle = new ArrayList<SafeZone>();
    private ArrayList<SafeZone> rcircle = new ArrayList<SafeZone>();
    private ArrayList<SafeZone> lcircle = new ArrayList<SafeZone>();

    private Ceiling aCeiling;
    public Ground aGround, dGround;
    private Obstacle aObstacle;
    public SafeZone aSzcenter;
    private SafeZone aRrectangel;
    private SafeZone aLrectangel;
    private SafeZone aRcircle;
    private SafeZone aLcircle;


    private int grounddist = 0;
    private int ceilingdist = 0;
    public float playerX, distanceCoordX;
    public int ceilingscant=0;
    public int groundscant=0;
    public int obstaclescant=0;
    public int szscant=0;
    public int rcscant=0;
    public int lcscant=0;
    public int rrscant=0;
    public int lrscant=0;

    public float ceilingdel=200.00f;
    public float grounddel=200.00f;
    public float obstacledel =0f;
    public int szdel= 0;
    public float rcsdel=0f;
    public float lcsdel=0f;
    public float rrsdel=0f;
    public float lrsdel=0f;


    public GameStage(){
        setUpWorld();
        renderer = new Box2DDebugRenderer();
        setupCamera();
    }

    private void setUpWorld(){
        world = WorldUtils.createWorld();
        world.setContactListener(this);
        setUpGround();
        setUpGround();
        setUpGround();
        setUpCeiling();
        setUpCeiling();
        setUpCeiling();
        setUpPlayer();
        setUpSection();
        setUpSection();
        szscant = 0;
        groundscant = 0;
        ceilingscant = 0;
        obstaclescant=0;
        rcscant=0;
        lcscant=0;
        rrscant=0;
        lrscant=0;
        aSzcenter = szcenter.get(szscant);
        aObstacle = obstacles.get(obstaclescant);

    }
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
    private void setUpPlayer() {
        player = new Player(WorldUtils.createPlayer(world));
        addActor(player);
    }

    private void setUpGround() {
        grounds.add (new Ground(WorldUtils.createGround(world,grounddist)));
        grounddist = grounddist + (int) Constants.GROUND_WIDTH;
}

    private void setUpCeiling() {
        ceilings.add(new Ceiling(WorldUtils.createCeiling(world, ceilingdist)));
        ceilingdist = ceilingdist + (int) Constants.CEILING_WIDTH;
    }

    private void setUpObstacle() {
        Random r1 = new Random();
        int i1 = r1.nextInt(21 - 10) + 10;
        obstacles.add (new Obstacle(WorldUtils.createObstacle(world, distanceCoordX, i1)));
        distanceCoordX = distanceCoordX + 15;


        if (obstacles.size()>=12) {
            if (obstaclescant == 12) {
                obstaclescant = 0;
            }
            obstaclescant = obstaclescant + 1;
            obstacles.remove(obstaclescant - 1);

        }
    }

    private void setUpSafeZone() {
        Random r2 = new Random();
        int i2 = r2.nextInt(21 - 10) + 10;
        szcenter.add(new SafeZone(WorldUtils.createSafeZone(world, distanceCoordX, i2 )));
        rcircle.add(new SafeZone(WorldUtils.crcreateSafeZone(world, distanceCoordX, i2 )));
        lcircle.add(new SafeZone(WorldUtils.clcreateSafeZone(world, distanceCoordX, i2 )));
        rrectangle.add(new SafeZone(WorldUtils.rcreateSafeZone(world, distanceCoordX, i2 )));
        lrectangle.add(new SafeZone(WorldUtils.lcreateSafeZone(world, distanceCoordX, i2 )));
        distanceCoordX = distanceCoordX + 15;

        aSzcenter = szcenter.get(szscant);

        szscant = szscant + 1;
        if (szscant >= 4) {
        szscant = 0;
        }

    }
    private void setUpSection(){
        Random r = new Random();
        int i = r.nextInt(11 - 5) + 5;
        for (int a =0; a<i; a=a+1){
            setUpObstacle();
        }
        setUpSafeZone();
    }
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

    public void setupCamera(){
        camera = new OrthographicCamera(VIEWPORT_WIDTH, VIEWPORT_HEIGHT);
        camera.position.set((VIEWPORT_WIDTH / 2), VIEWPORT_HEIGHT / 2 , 0f);
        camera.update();
    }

    protected void handleInputs(){
        if (Gdx.input.justTouched() && gravityON == false){
            gravityON = true;
            world.setGravity(worldGravity);
            player.body.setLinearVelocity(10f,0f);
        }


        if (Gdx.input.justTouched()) {
        player.fly();

        }

        }

    public void worldValues(){
        playerX = player.getPlayerX();
    }

    public void worldUpdater(){
        if (playerX >= aSzcenter.body.getPosition().x){
            setUpSection();
        }

        if (szcenter.size()>=4) {
            if (szdel==4){
                szdel = 0;
            }
            szdel = szdel+1;
            szcenter.remove(szdel-1);
            rcircle.remove(szdel-1);
            lcircle.remove(szdel-1);
            rrectangle.remove(szdel-1);
            lrectangle.remove(szdel-1);
        }



        if (playerX >= grounddel){
            if (groundscant==3){
                groundscant = 0;
            }
            setUpGround();
            groundscant = groundscant +1;
            grounddel = grounddel + 100.00f;
            grounds.remove(groundscant-1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        }

        if (playerX >= ceilingdel){
            if (ceilingscant==3){
                ceilingscant = 0;
            }
            setUpCeiling();
            ceilingscant = ceilingscant +1;
            ceilingdel = ceilingdel + 100.00f;
            ceilings.remove(ceilingscant-1);
            Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        }

    }


////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

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
        worldValues();
        handleInputs();
        worldUpdater();
//        System.out.println("Cantidad de grounds:"+grounds.size());
//        System.out.println(grounddel);
//        System.out.println(playerX);
        System.out.println("sfzone: " + szcenter.size());
    }

////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////

    @Override
    public void beginContact(Contact contact) {

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

}
