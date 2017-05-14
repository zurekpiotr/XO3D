package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;


public class Empty extends Point
{
    
    
    
    Empty(Vector3 position, float size)
    {
        this.position = position;
        
        modelinstane = new ModelInstance(
                new ModelBuilder().createBox(
                        2 * size, 2 * size, 2 * size,
                        new Material(
                                ColorAttribute.createDiffuse(new Color(Color.rgba8888(0.5f, 0.5f, 0.5f, 0f)))), Usage.Position | Usage.Normal
                )
        )
        ;
        modelinstane.transform.set(position, new Quaternion(0, 0, 0, 0));
        
    }
    
    static boolean init()
    {
        form = new Model();
        
        return true;
    }
    
   
    
    @Override
    public void dispose()
    {
    
    }
    
    
}
