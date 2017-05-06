package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by Żurek on 2017-04-16.
 */
public class Cross extends Empty
{
    
    Cross(Vector3 position , float size)
    {
        super(position ,size);
        meshModel = new ModelInstance(new ModelBuilder().createBox(2*size, 2*size, 2*size, new Material(ColorAttribute.createDiffuse(Color.GREEN)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));
        meshModel.transform.set(position , new Quaternion(0 , 0 , 0, 0));
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
