package com.kurshit.cpbook.chapter4.graphs.section42;

import java.util.HashMap;
import java.util.Map;

public class StickerCollectorRobot {

    public static void main(String[] args) {

        char[][] grid = {
                {'*', '*', '*'},
                {'*', 'N', '*'},
                {'*', '*', '*'}
        };
        int M = 3;
        int N = 3;
        String str = "DE";
        System.out.println(getStickers(grid, M, N, str));

        char[][] grid1 = {
                {'.', '.', '.', '.', '*', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '*', '.', '.'},
                {'.', '.', '.', '.', '.', '*', '.', '.', '.', '.'},
                {'.', '.', '*', '.', '#', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '#', 'N', '.', '*', '.', '.', '*'},
                {'.', '.', '.', '*', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };

        M = 10;
        N = 10;
        str = "FDFFFFFFEEFFFFFFEFDF";

        System.out.println(getStickers(grid1, M, N, str));

    }

    static Map<Character, Character> lmap = new HashMap<>();
    static Map<Character, Character> rmap = new HashMap<>();

    public static int getStickers(char[][] grid, int M, int N, String str) {
        fillLMap();
        fillRMap();

        for(int i = 0; i < M; i++) {
            for(int j = 0; j < N; j++) {
                char curr = grid[i][j];

                if(lmap.containsKey(curr)) {
                    return traverse(grid, M, N, i, j, str, curr);
                }
            }
        }

        return 0;

    }

    private static void fillRMap() {

        rmap.put('N', 'E');
        rmap.put('S', 'W');
        rmap.put('E', 'S');
        rmap.put('W', 'N');
    }

    private static void fillLMap() {
        lmap.put('N', 'W');
        lmap.put('S', 'E');
        lmap.put('E', 'N');
        lmap.put('W', 'S');
    }

    private static int traverse(char[][] grid, int M, int N, int i, int j, String str, char dir) {
        int count = 0;
        for(int k = 0; k < str.length(); k++) {

            char op = str.charAt(k);

            if(op == 'D') {
                dir = rmap.get(dir);
                continue;
            } else if(op == 'E'){
                dir = lmap.get(dir);
                continue;
            } else {

                int x = i;
                int y = j;

                if(dir == 'S') {
                    i = i + 1;
                } else if(dir == 'N') {
                    i = i - 1;
                } else if(dir == 'E') {
                    j = j + 1;
                } else {
                    j = j - 1;
                }

                if(!isSafe(grid, M, N, i, j)) {
                    i = x;
                    j = y;
                } else {
                    if(grid[i][j] == '*') {
                        count++;
                        grid[i][j] = '.';
                    }
                }

            }

        }

        return count;

    }

    private static boolean isSafe(char[][] grid, int M, int N, int i, int j) {

        if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == '#') {
            return false;
        }

        return true;

    }
}
