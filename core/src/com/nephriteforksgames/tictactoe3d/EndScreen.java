package com.nephriteforksgames.tictactoe3d;

<<<<<<< HEAD
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
=======
import com.badlogic.gdx.Screen;
>>>>>>> origin/master

/**
 * Created by Żurek on 2017-05-07.
 */
public class EndScreen implements Screen
<<<<<<< HEAD
{
    private Stage stage;
    Skin mySkin;
    TextButton againbutton;
    int winner;
    Label wintext;
    EndScreen(int winner)
    {
        this.winner=winner;
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        int row_height = Gdx.graphics.getWidth() / 7;
        int col_width = Gdx.graphics.getWidth() / 7;
        mySkin = Assets.assets.get("skin/glassy-ui.json" , Skin.class);
        againbutton = new TextButton("PLAY\nAGAIN",mySkin,"default");
        againbutton.setSize(col_width*4, (float) ( row_height*1.3) );
        againbutton.setPosition(Gdx.graphics.getWidth()/2-col_width*2,Gdx.graphics.getHeight()-row_height*4);
        wintext=new Label( "PLAYER "+winner+" IS THE WINNER :)",mySkin,"big" );
        wintext.setPosition( Gdx.graphics.getWidth()/2-col_width*3,Gdx.graphics.getHeight()-row_height*2 );
        againbutton.addListener( new InputListener(){
            @Override
            public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
                dispose();
                GdxGame.changeScreenTo(new MenuScreen());
            }
            @Override
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                return true;
            }

        });
        stage.addActor(againbutton);
        stage.addActor( wintext );

=======

{
    EndScreen(int winner)
    {
    
>>>>>>> origin/master
    }
    
    @Override
    public void show()
    {
    
    }
    
    @Override
    public void render(float delta)
    {
<<<<<<< HEAD
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear( GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
        
//        GdxGame.changeScreenTo(new MenuScreen());
=======
        
        
        GdxGame.changeScreenTo(new MenuScreen());
>>>>>>> origin/master
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
<<<<<<< HEAD
        stage.dispose();
=======
    
>>>>>>> origin/master
    }
}
