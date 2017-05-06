package com.nephriteforksgames.tictactoe3d;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.math.Vector3;

import java.security.Key;

/**
 * Created by Żurek on 2017-04-16.
 */
public class GameScreen implements Screen
{
    PerspectiveCamera cam;
    Environment environment;
    ModelBatch modelBatch;
    AssetManager assets ;
    
    Cube cube;
    
    GameScreen(int cubeSize)
    {
        assets = new AssetManager();
    
        assets.load("circle.obj" , Model.class);
        assets.load("Well.obj" , Model.class);
    
        assets.finishLoading();
        
        Empty.init(assets);
        Cross.init(assets);
        Circle.init(assets);
        
        modelBatch = new ModelBatch();
        
        cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        //cam = new
        cam.position.set(10f, 0f, 0f);
        cam.lookAt(0,0,0);
        cam.near = 1f;
        cam.far = 300f;
        cam.update();
        
        environment = new Environment();
        environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f, 0.4f, 0.4f, 1f));
        environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f, -0.8f, -0.2f));
        
        cube = new Cube(cubeSize);
        
        
        
        //assets.update();
        System.out.println( assets.isLoaded("Cross.obj" , Model.class) );
        
        
        
        
        
    
    }
    @Override
    public void show()
    {
    
    }
    boolean justrelease = false , moved = false;
    float firstX = -3.141592f , firstY = -3.141592f;
    @Override
    public void render(float delta)
    {
        if(cube.somebodyWin())
        {
        
        }
        if(Gdx.input.isKeyPressed(97))
        {
            cam.rotateAround( new Vector3(0 , 0 , 0) ,
                              new Vector3(cam.position.x , cam.position.y, cam.position.z) ,
                              1f );
        }
        
        
        if(Gdx.input.isTouched())
        {
            if(justrelease == false)
            {
                justrelease = true;
                firstX = Gdx.input.getX();
                firstY = Gdx.input.getY();
                moved = false;
            }
            else if(firstX != Gdx.input.getX() || firstY != Gdx.input.getY())
            {
                moved = true;
            }
    
            cam.rotateAround( new Vector3(0 , 0 , 0) ,
                              new Vector3(cam.up.x , cam.up.y, cam.up.z) ,
                              Math.signum(Gdx.input.getDeltaX() * (float) (-Math.sqrt( Math.abs( Gdx.input.getDeltaX() ) ) * 0.5f)));
            Vector3 vertical = new Vector3(cam.up);
            vertical.crs(cam.position);
            cam.rotateAround( new Vector3(0 , 0 , 0) ,
                              new Vector3(vertical.x , vertical.y, vertical.z) ,
                              Math.signum(Gdx.input.getDeltaY() * (float) (-Math.sqrt( Math.abs( Gdx.input.getDeltaY() ) ) * 0.5f)));
    
        }
        else if(justrelease)
        {
            justrelease = false;
            if(moved == false)
            {
                System.out.println("" + firstX + "   " + firstY);
                Vector3 temp = cam.unproject(new Vector3(firstX , firstY , 0));
                System.out.println("" + temp);
                cube.changeFirstAt(cam.position , temp , 1);
            }
        }
        
        cam.update();
        
        
        
        
        modelBatch.begin(cam);
        modelBatch.render(cube, environment);
        modelBatch.end();
    }
    
    @Override
    public void resize(int width, int height)
    {
    
    }
    
    @Override
    public void pause()
    {
    
    }
    
    @Override
    public void resume()
    {
    
    }
    
    @Override
    public void hide()
    {
    
    }
    
    @Override
    public void dispose()
    {
    	assets.dispose();
    }
}
