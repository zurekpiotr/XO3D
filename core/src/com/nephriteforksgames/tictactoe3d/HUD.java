package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

class HUD {
    static Stage stage;
    private static Skin mySkin;
    private static TextButton left;
    private static TextButton right;
    static Slider slider;
    static void initialize(){
        stage = new Stage(new ScreenViewport());
        Gdx.input.setInputProcessor(stage);

        int row_height = Gdx.graphics.getWidth() / 7;
        int col_width = Gdx.graphics.getWidth() / 7;

        mySkin = Assets.assets.get("skin/glassy-ui.json" , Skin.class);
        //left=new TextButton( "",mySkin );
        //right=new TextButton( "",mySkin );
        slider=new Slider( 0f,200f,1f,true,mySkin );
        slider.setSize( (float) (slider.getWidth()*1.5),Gdx.graphics.getHeight()-row_height );
        slider.setPosition( col_width/4,row_height/2 );
        slider.setValue( 200f );
       /* left.setPosition( col_width,row_height/2 );
        left.setSize( col_width,row_height );
        right.setPosition( Gdx.graphics.getWidth()-col_width*2,row_height/2 );
        right.setSize( col_width,row_height );
        stage.addActor(left);
        stage.addActor(right);*/
        stage.addActor( slider );
    }
    static void render(){
        stage.act();
        stage.draw();
    }
    static void finish(){
        stage.dispose();
    }
    static float get_slider_ratio(){
        return slider.getPercent();
    }
}
