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


public class Circle extends Empty
{
    
	Circle(Vector3 position , float size)
	{
		super(position , size);
        meshModel = new ModelInstance(new ModelBuilder().createBox(2*size, 2*size, 2*size, new Material(ColorAttribute.createDiffuse(Color.RED)), VertexAttributes.Usage.Position | VertexAttributes.Usage.Normal));
        meshModel.transform.set(position , new Quaternion(0 , 0 , 0, 0));
	}
	
    static boolean init(AssetManager asset)
    {
        boolean flag = true;
        
        form = asset.get("circle.obj", Model.class);
        
        
        inst = new ModelInstance(form);
        
        return flag;
    }
    
    @Override
    public void dispose()
    {
    
    }
}
