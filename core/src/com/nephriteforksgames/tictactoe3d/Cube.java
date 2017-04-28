package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;


public class Cube implements RenderableProvider
{
    Empty tab[][][];
    int size = 0;
    Array<ModelInstance> net;
   // Array<Renderable> r;
    
    Cube(int n)
    {
        tab = new Empty[n][n][n];
        for(int i = 0 ; i < n ; i ++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                for(int k = 0 ; k < n ; k ++)
                {
                    tab[i][j][k] = new Circle(new Vector3(i*2.5f , j*2.5f , k*2.5f));
                }
            }
        }
        
        size = n;
        
    }
    
    @Override
    public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool)
    {
        for(int i = 0 ; i < size ; i ++)
        {
            for(int j = 0 ; j < size ; j++)
            {
                for(int k = 0 ; k < size ; k ++)
                {
                    tab[i][j][k].modelinstane.getRenderables(renderables , pool);
                }
            }
        }
        
    }
}
