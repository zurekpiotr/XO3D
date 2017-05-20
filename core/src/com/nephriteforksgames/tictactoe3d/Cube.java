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
    int player = 0;
    int fromX , toX , fromY ,toY , fromZ , toZ;
    Vector3 position = new Vector3(0,0,0);
    
    Cube(int n , int whoStart)
    {
        size = n;
        
        Logic.StartGame(size);
        
        player = whoStart;
        
        float l = (n - 1) * distance;
        tab = new Point[n][n][n];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                for (int k = 0; k < n; k++)
                {
                    tab[i][j][k] = new Empty(new Vector3(k * distance - l / 2, j * distance - l / 2, i * distance - l / 2), pointSize);
                }
            }
        }
        changeVisionRange( 0, size , 0 , size , 0 , size);
        
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
     * @return true if change something
     */
    boolean changeFirstAt(Vector3 at, Vector3 v)
    {
        int a = 0, b = 0, c = 0;
        float len = 1000000;
        boolean found = false;
        for (int i = fromZ; i < toZ; i++)
        {
            for (int j = fromY; j < toY; j++)
            {
                for (int k = fromX; k < toX; k++)
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
            change(a,b,c);
            return true;
        }
        else
        {
            return false;
        }
        
        
    }
    
    void change( int  x , int y , int z )
    {
    
        if (player == 1)
        {
            tab[x][y][z] = new Cross(tab[x][y][z].getPosition(), pointSize);
        }
        else if (player == 0)
        {
            tab[x][y][z] = new Circle(tab[x][y][z].getPosition(), pointSize);
        }
        
        player++;
        player%=2;
    }
    
    char whoseRound()
    {
        if(player == 1)return 'x';
        else return 'o';
    }
    
    void changeVisionRange(int fromX , int toX , int fromY , int toY , int fromZ , int toZ )
    {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
        this.fromZ = fromZ;
        this.toZ = toZ;
    }
    void changeVisionRange(Vector3 lookFrom , float percent)
    {
        int ile = size - ((int) ((float)size * percent*0.99f)+1);
        Vector3 pom = new Vector3(lookFrom);
        System.err.print(pom);
        
        pom.sub(position);
        System.err.println("   "+pom);
        
        float absX = Math.abs(pom.x);
        float absY = Math.abs(pom.y);
        float absZ = Math.abs(pom.z);
        
        if(absX > absY && absX > absZ)
        {
            if(pom.x>0)changeVisionRange( 0 , size-ile , 0 , size , 0 , size);
            else changeVisionRange( 0+ile , size , 0 , size , 0 , size);
        }
        if(absY > absX && absY > absZ)
        {
            if(pom.y>0)changeVisionRange( 0 , size , 0 , size-ile , 0 , size);
            else changeVisionRange( 0 , size , 0+ile , size , 0 , size);
        }
        if(absZ > absX && absZ > absY)
        {
            if(pom.z>0)changeVisionRange( 0 , size , 0 , size , 0 , size-ile);
            else changeVisionRange( 0 , size , 0 , size , 0+ile , size);
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
        
        for (int z = fromZ; z < toZ; z++)
        {
            for (int y = fromY; y < toY; y++)
            {
                for (int x = fromX; x < toX; x++)
                {
                    tab[z][y][x].getRenderables(renderables, pool);
                }
            }
        }
    }
}
