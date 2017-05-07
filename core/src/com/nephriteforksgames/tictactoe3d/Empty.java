package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.*;
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


public class Empty implements Disposable, RenderableProvider
{
    static Model form;
    
    static ModelInstance inst;
    static ModelInstance box;
    
    ModelInstance meshModel ;
    
    ModelInstance modelinstane;
    private Vector3 position;
    
    
    Empty(Vector3 position , float size)
    {
        modelinstane = new ModelInstance( form );
        this.position = position;
        
    	modelinstane.transform.set(position, new Quaternion(0, 0, 0, 0));
    	modelinstane.transform.scale( size  , size , size);
    
        meshModel = new ModelInstance(new ModelBuilder().createBox(2*size, 2*size, 2*size, new Material(ColorAttribute.createDiffuse(Color.WHITE)),  Usage.Position | Usage.Normal));
        meshModel.transform.set(position , new Quaternion(0 , 0 ,0,0));
    
    
    }
    
    Vector3 getPosition()
    {
        return position;
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
    
    @Override
    public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool)
    {
        meshModel.getRenderables(renderables , pool);
        modelinstane.getRenderables(renderables , pool);
    }
}
