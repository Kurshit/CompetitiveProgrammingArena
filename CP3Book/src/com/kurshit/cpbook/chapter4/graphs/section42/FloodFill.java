package com.kurshit.cpbook.chapter4.graphs.section42;

/*
    Problem : Flood Fill - Labeling/Coloring the connected Component.

    Given a 2D screen, location of a pixel in the screen and a color, replace color of the given pixel and all adjacent same colored pixels with the given color.
    The neihbours include diagonals cells as well

    Also, calculate the number of cells it changed - Area of new color

    Input:
    screen[M][N] = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
               };

            x = 4, y = 4, newColor = 3
        The values in the given 2D screen
          indicate colors of the pixels.
        x and y are coordinates of the brush,
           newColor is the color that
        should replace the previous color on
           screen[x][y] and all surrounding
        pixels with same color.

        Output:
        Screen should be changed to following.
        screen[M][N] = {{1, 1, 1, 1, 1, 1, 1, 1},
                       {1, 1, 1, 1, 1, 1, 0, 0},
                       {1, 0, 0, 1, 1, 0, 1, 1},
                       {1, 3, 3, 3, 3, 0, 1, 0},
                       {1, 1, 1, 3, 3, 0, 1, 0},
                       {1, 1, 1, 3, 3, 3, 3, 0},
                       {1, 1, 1, 1, 1, 3, 1, 1},
                       {1, 1, 1, 1, 1, 3, 3, 1},
                       };

 */

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {

    public static void main(String[] args) {
        int[][] grid = {
                {1, 1, 1, 1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1, 1, 0, 0},
                {1, 0, 0, 1, 1, 0, 1, 1},
                {1, 2, 2, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 0, 1, 0},
                {1, 1, 1, 2, 2, 2, 2, 0},
                {1, 1, 1, 1, 1, 2, 1, 1},
                {1, 1, 1, 1, 1, 2, 2, 1},
        };
        int M = grid.length;
        int N = grid[0].length;
        int r = 4;
        int c = 4;
        int newColor = 3;
        //System.out.println(floodFillDFS(grid, M, N, r, c, grid[r][c], newColor));
        System.out.println(floodFillBFS(grid, M, N, r, c, grid[r][c], newColor));

        for(int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }

    }

    static int[] dirx = {1, 1, 1, -1, -1, -1, 0, 0};
    static int[] diry = {0, 1, -1, 0, 1, -1, 1, -1};

    public static int floodFillDFS(int[][] grid, int M, int N, int i, int j, int currColor, int newColor) {

        if(i < 0 || i >=M || j < 0 || j >=N || grid[i][j] != currColor) {
            return 0;
        }

        grid[i][j] = newColor;

        int ans = 1;

        for(int d = 0; d < 8; d++) {
            ans = ans + floodFillDFS(grid, M, N, i+ dirx[d], j + diry[d], currColor, newColor);
        }

        return ans;
    }

    public static int floodFillBFS(int[][] grid, int M, int N, int i, int j, int currColor, int newColor) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{i, j});
        int ans = 0;
        while(!q.isEmpty()) {
            int[] currXY = q.poll();

            int x = currXY[0];
            int y = currXY[1];

            for(int d = 0; d < 8; d++) {

                int newX = x + dirx[d];
                int newY = y + diry[d];

                if(isSafe(grid, newX, newY, M,  N, currColor, newColor)) {
                    grid[newX][newY] = newColor;
                    ans++;
                    q.offer(new int[]{newX, newY});

                }
            }
        }

        return ans;

    }

    private static boolean isSafe(int[][] grid, int i, int j, int M, int N, int currColor, int newColor) {

        if(i < 0 || i >=M || j < 0 || j >=N || grid[i][j] != currColor) {
            return false;
        }

        return true;
    }


}
