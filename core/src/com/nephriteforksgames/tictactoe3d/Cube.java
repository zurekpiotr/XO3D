package com.nephriteforksgames.tictactoe3d;

import android.hardware.Camera;
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
    float pointSize = 0.75f;
    float distance  = 3f;
    
    Array<ModelInstance> net;
    
    Cube(int n)
    {
        float l = (n-1) * distance;
        tab = new Empty[n][n][n];
        for(int i = 0 ; i < n ; i ++)
        {
            for(int j = 0 ; j < n ; j++)
            {
                for(int k = 0 ; k < n ; k ++)
                {
                    tab[i][j][k] = new Empty(new Vector3(i*distance -l/2 , j*distance -l/2 , k*distance -l/2) , pointSize);
                }
            }
        }
        
        size = n;
        
    }
    
    
    private boolean fun(Vector3 at, Vector3 v , Vector3 point , float r)
    {
        return false;
    }
    void changeFirstAt(Vector3 at, Vector3 v , int player)
    {
        if(player == 1)
        {
            tab[0][0][0]= new Cross(tab[0][0][0].getPosition() , pointSize);
        }
        else if(player == 0)
        {
            tab[0][0][0] = new Circle(tab[0][0][0].getPosition() , pointSize);
        }
        System.out.println("change");
    }
    
    boolean somebodyWin()
    {
        return false;
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
                    tab[i][j][k].getRenderables(renderables , pool);
                }
            }
        }
    }
}
