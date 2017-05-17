package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.Screen;

/**
 * Created by Żurek on 2017-05-07.
 */
public class EndScreen implements Screen

{
    EndScreen(int winner)
    {
    
    }
    
    @Override
    public void show()
    {
    
    }
    
    @Override
    public void render(float delta)
    {
        
        
        GdxGame.changeScreenTo(new MenuScreen());
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
    
    }
}
