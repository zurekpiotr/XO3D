package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.graphics.g3d.attributes.BlendingAttribute;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;

/**
 * Created by Żurek on 2017-05-07.
 */
public class Point implements Disposable, RenderableProvider
{
    boolean visable;
    static Model form;
    //ModelInstance meshModel;
    ModelInstance modelinstane;
    
    Vector3 position;
    
    @Override
    public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool)
    {
        
        modelinstane.getRenderables(renderables, pool);
    }
    
    @Override
    public void dispose()
    {
    
    }
    Vector3 getPosition()
    {
        return position;
    }
    
    public void setVisable(boolean visable)
    {
        this.visable = visable;
        if(visable == true)
        {
            modelinstane.materials.get(0).set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, 1f));
        }
        else
        {
    
            modelinstane.materials.get(0).set(new BlendingAttribute(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA, 0.2f));
        }
    }
}
