package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.model.MeshPart;
import com.badlogic.gdx.graphics.g3d.model.Node;
import com.badlogic.gdx.graphics.g3d.model.data.ModelAnimation;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;


public class Empty implements Disposable
{
    static Model form;
    
    static ModelInstance inst;
    static ModelInstance box;
    
    ModelInstance modelinstane;
    
    Empty(Vector3 position)
    {
        modelinstane = new ModelInstance( form );
        
    	modelinstane.transform.set(position, new Quaternion(0, 0, 0, 0));
     
    }
    
    static boolean init(AssetManager asset)
    {
        form = new Model();
        inst = new ModelInstance(form);
        			
        box = new ModelInstance(new ModelBuilder().createBox(1f, 1f, 1f, new Material(ColorAttribute.createDiffuse(Color.GREEN)),  Usage.Position | Usage.Normal));
        
        return true;
    }
    
   
    
    @Override
    public void dispose()
    {
    
    }
}
