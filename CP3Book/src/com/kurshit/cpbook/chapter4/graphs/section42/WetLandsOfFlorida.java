package com.kurshit.cpbook.chapter4.graphs.section42;

/*
        //This is basically an application of floodfill
        Problem : UVa 469 Wetlands of Florida  Page no : 126
        Problem Source : https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=410
        Problem :

        Given a 2-D grid containing characters L - Land & W - water.
        You will be given a source cordinate of Water (W) and your task is to calculate the are occupied by surronding water of cource.
        Each cell adds up to area of 1 unit.

        It is given src is always W

        The adjacent directions are 8 diagonally included.


                    U
                 UL |  UR
                L--CURR -- R
                 LL |  LR
                    D

         Example :

           char[][] = {
            {'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'}
            {'L', 'L', 'W', 'W', 'L', 'L', 'W', 'L', 'L'}
            {'L', 'W', 'W', 'L', 'L', 'L', 'L', 'L', 'L'}
            {'L', 'W', 'W', 'W', 'L', 'W', 'W', 'L', 'L'}
            {'L', 'L', 'L', 'W', 'W', 'W', 'L', 'L', 'L'}
            {'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'}
            {'L', 'L', 'L', 'W', 'W', 'L', 'L', 'W', 'L'}
            {'L', 'L', 'W', 'L', 'W', 'L', 'L', 'L', 'L'}
            {'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'}

           };

           src = 2, 1 n// 0 index based

           Output : 12

           src = 6,4

           Output : 4

        //This is same as FloodFill

 */


import java.util.LinkedList;
import java.util.Queue;

public class WetLandsOfFlorida {

    public static void main(String[] args) {

        char[][] grid= {
            {'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'},
            {'L', 'L', 'W', 'W', 'L', 'L', 'W', 'L', 'L'},
            {'L', 'W', 'W', 'L', 'L', 'L', 'L', 'L', 'L'},
            {'L', 'W', 'W', 'W', 'L', 'W', 'W', 'L', 'L'},
            {'L', 'L', 'L', 'W', 'W', 'W', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'W', 'W', 'L', 'L', 'W', 'L'},
            {'L', 'L', 'W', 'L', 'W', 'L', 'L', 'L', 'L'},
            {'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L', 'L'}

        };

        int M = grid.length;
        int N = grid[0].length;


        //Try with any- both works
        System.out.println(areaOfWetLandDFS(grid, M, N, 2, 1));
        //System.out.println(areaOfWetLandBFS(grid, M, N, 2, 1));

    }

    //                   D, LR, LL, U, UR, UL, R, L
    static int[] dirx = {1, 1, 1, -1, -1, -1, 0, 0};  // row
    static int[] diry = {0, 1, -1, 0, 1, -1, 1, -1}; // col

    /*
           Note : The original array will be changed. Id you do not want that, create visited array
     */

    /*
        TC : O (V + E)
     */

    public static int areaOfWetLandDFS(char[][] grid, int M, int N, int i, int j) {

        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 'L') {
            return 0;
        }

        grid[i][j] = 'L';
        int ans = 1;

        for(int d = 0; d < 8; d++) {
            ans = ans + areaOfWetLandDFS(grid, M, N, i + dirx[d], j + diry[d]);
        }

        return ans;

    }
    /*
        TC : O (V + E)
     */


    public static int areaOfWetLandBFS(char[][] grid, int M, int N, int i, int j) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        int ans = 0;
        while(!q.isEmpty()) {

            int[] currXY = q.poll();

            int x = currXY[0];
            int y = currXY[1];

            for(int d =0; d < 8; d++) {

                int newX = x + dirx[d];
                int newY = y + diry[d];

                if(isSafe(grid, newX, newY, M, N)) {
                    ans++;
                    q.offer(new int[]{newX, newY});
                    grid[newX][newY] = 'L';
                }
            }
        }

        return ans;

    }

    private static boolean isSafe(char[][] grid, int i, int j, int M, int N) {

        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 'L') {
            return false;
        }

        return true;
    }
}
