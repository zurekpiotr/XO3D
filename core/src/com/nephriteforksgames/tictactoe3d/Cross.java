package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;

/**
 * Created by Żurek on 2017-04-16.
 */
public class Cross extends Point
{
    static Model form;
    Cross(Vector3 position , float size)
    {
        modelinstane = new ModelInstance(form);
        this.position = position;
    
        modelinstane.transform.set(position, new Quaternion(0, 0, 0, 0));
        modelinstane.transform.scale(size, size, size);
    
    }
    
    static boolean init()
    {
        boolean flag = true;
        
        Cross.form = Assets.assets.get("plus.obj", Model.class);
        
        return flag;
    }
    
    
    @Override
    public void dispose()
    {
    
    }
    
}
