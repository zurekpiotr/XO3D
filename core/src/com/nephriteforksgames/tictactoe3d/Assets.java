package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;

/**
 * Created by Żurek on 2017-05-06.
 */
public class Assets
{
    static AssetManager assets;
    
    public static void init()
    {
        assets = new AssetManager();
    
        assets.load("circle.obj" , Model.class);
        assets.load("plus.obj" , Model.class);
        assets.load("skin/glassy-ui.json" , Skin.class);
        assets.finishLoading();
    }
}
