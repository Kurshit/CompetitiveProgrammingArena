package com.kurshit.cpbook.chapter4.graphs.section42;

import java.util.HashMap;
import java.util.Map;

public class RobotMotion {

    public static void main(String[] args) {

        char[][] grid = {
                {'N', 'E', 'E', 'S', 'W', 'E'},
                {'W', 'W', 'W', 'E', 'S', 'S'},
                {'S', 'N', 'W', 'W', 'W', 'W'},
        };

        int M = 3;
        int N = 6;
        int col = 5;

        System.out.println(moves(grid, M, N, col));

        char[][] grid1 = {
                {'S','E','S','W','E'},
                {'E','E','S','N','W'},
                {'N','W','E','E','N'},
                {'E','W','S','E','N'},
        } ;

        M = 4;
        N = 5;
        col = 1;

        System.out.println(moves(grid1, M, N, col));

    }



    public static int moves(char[][] grid, int M, int N, int col) {

        int i = 0;
        int j = col-1;
        int count = 0;
        while(true) {

            if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == '*')
                break;

            char curr = grid[i][j];
            grid[i][j] = '*';
            count++;
            if(curr == 'S') {
                i = i + 1;
            } else if(curr == 'E') {
                j = j + 1;
            } else if(curr == 'W') {
                j = j - 1;
            } else {
                i = i - 1;
            }

        }

        return count;
    }
}
