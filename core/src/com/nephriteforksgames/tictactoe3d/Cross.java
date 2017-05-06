package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Żurek on 2017-04-16.
 */
public class Cross extends Empty
{
    
    Cross(Vector3 position , float scale)
    {
        super(position ,scale);
    }
    
    static boolean init(AssetManager asset)
    {
        boolean flag = true;
        
        
        form = asset.get("Well.obj", Model.class);
        
        inst = new ModelInstance(form);
        return flag;
    }
    
    
    @Override
    public void dispose()
    {
    
    }
}
