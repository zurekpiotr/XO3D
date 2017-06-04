package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g3d.*;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
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
        
        modelinstane = new ModelInstance(form);
        
        modelinstane.materials.get(0).set(new ColorAttribute(ColorAttribute.Diffuse, 0f, 0f, 0f, 1f));
        modelinstane.materials.get(0).set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, 0.2f));
        
        modelinstane.transform.set(position, new Quaternion(0, 0, 0, 0));
        modelinstane.transform.scale(size, size, size);
        
    }
    
    static boolean init()
    {
        form = Assets.assets.get("EmptyModel2.obj", Model.class);
        form.materials.get(0).set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA));
        
        return true;
    }
    
   
    
    @Override
    public void dispose()
    {
    
    }
    
    @Override
    public void setVisable(boolean visable)
    {
        this.visable = visable;
        if(visable == true)
        {
            modelinstane.materials.get(0).set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, 0.1f));
        }
        else
        {
            modelinstane.materials.get(0).set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, 0));
        }
    }
}
