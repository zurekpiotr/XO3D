package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.Pool;

/**
 * Created by Żurek on 2017-05-07.
 */
public class Point implements Disposable, RenderableProvider
{
    static Model form;
    //ModelInstance meshModel;
    ModelInstance modelinstane;
    
    Vector3 position;
    
    @Override
    public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool)
    {
        //meshModel.getRenderables(renderables, pool);
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
}
