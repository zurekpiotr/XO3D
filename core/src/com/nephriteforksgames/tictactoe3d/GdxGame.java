package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;

public class GdxGame extends Game
{
    static boolean swapscreen;
    static int size;
    @Override
    public void create()
    {
        swapscreen=false;
        setScreen( new MenuScreen() );
    }
    
    @Override
    public void render()
    {
        if(swapscreen)
        {
            setScreen( new GameScreen( size ) );
            swapscreen=false;
        }
        Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);
        Gdx.gl.glClearColor(1.0f , 0.95f , 0.95f , 0f);
        
        screen.render(Gdx.graphics.getDeltaTime());
    }
    
    @Override
    public void dispose()
    {
    
    }
}
