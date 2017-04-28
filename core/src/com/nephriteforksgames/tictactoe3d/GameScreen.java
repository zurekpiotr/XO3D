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
        cam.position.set(10f, 10f, 10f);
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
    
    @Override
    public void render(float delta)
    {
        
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
