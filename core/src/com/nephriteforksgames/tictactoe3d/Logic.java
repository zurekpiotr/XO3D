package com.nephriteforksgames.tictactoe3d;

/**
 * Created by Marcin on 14.05.2017.
 */
public class Logic {
    static int size=Cube.size;
    static int[][] first=new int[size][size];
    static int[][] second=new int[size][size];
    static int[][] third=new int[size][size];
    static void AddPoint(int x, int y, int z, int player){
        if(player==1){
            first[x][y]++;
            second[x][z]++;
            third[y][z]++;
        }
        else{
            first[x][y]--;
            second[x][z]--;
            third[y][z]--;
        }
        if(first[x][y]==size||second[x][z]==size||third[y][z]==size){
            //SomebodyWin(1);
        }
        if(first[x][y]==-size||second[x][z]==-size||third[y][z]==-size){
            //SomebodyWin(0);
        }

    }
}
