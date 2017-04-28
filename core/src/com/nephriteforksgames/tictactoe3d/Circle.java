package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;


public class Circle extends Empty
{
    
	Circle(Vector3 position)
	{
		super(position);
		
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
