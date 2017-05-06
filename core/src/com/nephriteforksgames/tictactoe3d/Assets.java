package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;

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
        assets.load("Well.obj" , Model.class);
    
        assets.finishLoading();
    }
}
