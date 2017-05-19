package com.nephriteforksgames.tictactoe3d;

import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.Renderable;
import com.badlogic.gdx.graphics.g3d.RenderableProvider;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Plane;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Pool;


public class Cube implements RenderableProvider
{
    Point tab[][][];
    static int size = 0;
    float pointSize = 0.75f;
    float distance = 2f;
    
    
    Cube(int n)
    {
        size = n;
        Logic.StartGame(size);
        float l = (n - 1) * distance;
        tab = new Point[n][n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    tab[i][j][k] = new Empty(new Vector3(i * distance - l / 2, j * distance - l / 2, k * distance - l / 2), pointSize);
                }
            }
        }
        
    }
    
    
    private boolean fun(Vector3 at, Vector3 v, Point point)
    {
        Vector3 node[] = new Vector3[8];
        int i = 0;
        node[i++] = new Vector3(point.getPosition()).add(pointSize, pointSize, pointSize);
        node[i++] = new Vector3(point.getPosition()).add(pointSize, pointSize, -pointSize);
        node[i++] = new Vector3(point.getPosition()).add(-pointSize, pointSize, -pointSize);
        node[i++] = new Vector3(point.getPosition()).add(-pointSize, pointSize, pointSize);
        node[i++] = new Vector3(point.getPosition()).add(pointSize, -pointSize, pointSize);
        node[i++] = new Vector3(point.getPosition()).add(pointSize, -pointSize, -pointSize);
        node[i++] = new Vector3(point.getPosition()).add(-pointSize, -pointSize, -pointSize);
        node[i++] = new Vector3(point.getPosition()).add(-pointSize, -pointSize, pointSize);
        
        Vector3 out = new Vector3();
        Plane plane;
        int t[][] = {{0, 1, 2, 3}, {2, 3, 7, 6}, {1, 2, 6, 5}, {0, 1, 5, 4}, {4, 5, 6, 7}, {0, 3, 7, 4}};
        for (i = 0; i < 6; i++)
        {
            plane = new Plane(node[t[i][0]], node[t[i][1]], node[t[i][2]]);
            if (Intersector.intersectLinePlane(at.x, at.y, at.z, v.x, v.y, v.z, plane, out) >= 0)
            {
                if (Intersector.isPointInTriangle(out, node[t[i][0]], node[t[i][1]], node[t[i][2]]))
                {
                    return true;
                }
                if (Intersector.isPointInTriangle(out, node[t[i][0]], node[t[i][2]], node[t[i][3]]))
                {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    /**
     * change first on ray from at through v
     *
     * @param at
     * @param v
     * @param player
     * @return true if change something
     */
    boolean changeFirstAt(Vector3 at, Vector3 v, int player)
    {
        int a = 0, b = 0, c = 0;
        float len = 1000000;
        boolean found = false;
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                for (int k = 0; k < size; k++)
                {
                    if(tab[i][j][k] instanceof Circle || tab[i][j][k] instanceof Cross)continue;
                    if (fun(at, v, tab[i][j][k]))
                    {
                        if (len > Vector3.dst(at.x, at.y, at.z, tab[i][j][k].getPosition().x, tab[i][j][k].getPosition().y, tab[i][j][k].getPosition().z))
                        {
                            len = Vector3.dst(at.x, at.y, at.z, tab[i][j][k].getPosition().x,
                                              tab[i][j][k].getPosition().y, tab[i][j][k].getPosition().z);
                            a = i;
                            b = j;
                            c = k;
                            found = true;
                            
                        }
                        
                    }
                }
            }
        }
        if (found)
        {
            
            if (player == 1)
            {
                tab[a][b][c] = new Cross(tab[a][b][c].getPosition(), pointSize);
                Logic.AddPoint( a,b,c,player );
            }
            else if (player == 0)
            {
                tab[a][b][c] = new Circle(tab[a][b][c].getPosition(), pointSize);
                Logic.AddPoint( a,b,c,player );
            }
            return true;
        }
        else
        {
            return false;
        }
        
        
    }
    
    /**
     * @return 0 or 1 if someone win
     * else -1
     */
    int somebodyWin()
    {
        return -1;
    }
    
    @Override
    public void getRenderables(Array<Renderable> renderables, Pool<Renderable> pool)
    {
        for (int i = 0; i < size; i++)
        {
            for (int j = 0; j < size; j++)
            {
                for (int k = 0; k < size; k++)
                {
                    tab[i][j][k].getRenderables(renderables, pool);
                }
            }
        }
    }
}
