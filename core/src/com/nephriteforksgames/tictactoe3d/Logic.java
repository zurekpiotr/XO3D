package com.nephriteforksgames.tictactoe3d;


class Logic {
    private static int size;
    private static int[][][] results;
    private static int[][][] diagonal_results;
    private static int[] coordinates=new int[3];
    private static int[] big_diagonal;
    static void StartGame(int a){
        size=a;
        results=new int[3][size][size];
        diagonal_results=new int[3][2][size];
        big_diagonal=new int[4];
    }
    static void AddPoint(int x, int y, int z, int player){
        coordinates[0]=x;
        coordinates[1]=y;
        coordinates[2]=z;
        if(player==1){
            results[0][x][y]++;
            results[1][x][z]++;
            results[2][y][z]++;
            for(int i=0;i<3;i++){
                for(int j=i;j<3;j++){
                    if(coordinates[i]==coordinates[j]&&i!=j){
                        int k=0;
                        while(k==i||k==j)
                            k++;
                        diagonal_results[k][0][coordinates[k]]++;
                    }
                    if(coordinates[i]==size-1-coordinates[j]&&i!=j){
                        int k=0;
                        while(k==i||k==j)
                            k++;
                        diagonal_results[k][1][coordinates[k]]++;
                    }
                }
            }
            if(x==y&&y==z){
                big_diagonal[0]++;
            }
        }
        else{
            results[0][x][y]--;
            results[1][x][z]--;
            results[2][y][z]--;
            for(int i=0;i<3;i++){
                for(int j=i;j<3;j++){
                    if(coordinates[i]==coordinates[j]&&i!=j){
                        int k=0;
                        while(k==i||k==j)
                            k++;
                        diagonal_results[k][0][coordinates[k]]--;
                    }
                    if(coordinates[i]==size-1-coordinates[j]&&i!=j){
                        int k=0;
                        while(k==i||k==j)
                            k++;
                        diagonal_results[k][1][coordinates[k]]--;
                    }
                }
            }
        }
        CheckWin(x,y,z,player);
    }
    static void CheckWin(int x, int y, int z, int player){
        if(player==0){
            if(results[0][x][y]==-size||results[1][x][z]==-size||results[2][y][z]==-size){
                GdxGame.changeScreenTo(new EndScreen(player));
            }
            for(int i=0;i<3;i++){
                for(int j=0;j<2;j++){
                    for(int k=0;k<3;k++) {
                        if (diagonal_results[i][j][coordinates[k]] == -size){
                            GdxGame.changeScreenTo(new EndScreen(0));
                        }
                    }
                }
            }
        }
        else {
            if (results[0][x][y] == size || results[1][x][z] == size || results[2][y][z] == size) {
                GdxGame.changeScreenTo( new EndScreen( 1 ) );
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        if (diagonal_results[i][j][coordinates[k]] == size) {
                            GdxGame.changeScreenTo( new EndScreen( 1 ) );
                        }
                    }
                }
            }
        }
    }
}
