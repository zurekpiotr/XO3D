package com.nephriteforksgames.tictactoe3d;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;


/**
 * Created by Żurek on 2017-04-28.
 */
public class MenuScreen implements Screen
{
    private Stage stage;
    Skin mySkin;
    final TextButton startbutton;
    final TextButton upbutton;
    final TextButton downbutton;
    final TextButton sizebutton;
    int size;
    MenuScreen(){
        size=3;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        int row_height = Gdx.graphics.getWidth() / 7;
        int col_width = Gdx.graphics.getWidth() / 7;

        mySkin = new Skin(Gdx.files.internal("skin/glassy-ui.json"));

        startbutton = new TextButton("START",mySkin,"default");
        upbutton = new TextButton( ">",mySkin,"default" );
        downbutton=new TextButton( "<",mySkin,"default" );
        sizebutton=new TextButton( "3",mySkin,"default" );

        startbutton.setSize(col_width*4,row_height);
        startbutton.setPosition(Gdx.graphics.getWidth()/2-col_width*2,Gdx.graphics.getHeight()-row_height*2);
        startbutton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                GdxGame.swapscreen=true;
                GdxGame.size=size;
                dispose();
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        upbutton.setSize(col_width,row_height);
        upbutton.setPosition(Gdx.graphics.getWidth()/2+col_width/2,Gdx.graphics.getHeight()-row_height*4);
        upbutton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if(size<9)
                size++;
                sizebutton.setText(size+"");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        downbutton.setSize(col_width,row_height);
        downbutton.setPosition(Gdx.graphics.getWidth()/2-col_width*3/2,Gdx.graphics.getHeight()-row_height*4);
        downbutton.addListener(new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                if(size>3)
                size--;
                sizebutton.setText(size+"");
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }
        });
        sizebutton.setSize(col_width,row_height);
        sizebutton.setPosition(Gdx.graphics.getWidth()/2-col_width/2,Gdx.graphics.getHeight()-row_height*4);

        stage.addActor(startbutton);
        stage.addActor(upbutton);
        stage.addActor(downbutton);
        stage.addActor(sizebutton);
    }
    @Override
    public void show()
    {

    }
    
    @Override
    public void render(float delta)
    {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
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
        stage.dispose();
    }
}
