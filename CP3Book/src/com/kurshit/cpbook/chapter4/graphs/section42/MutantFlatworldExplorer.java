package com.kurshit.cpbook.chapter4.graphs.section42;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MutantFlatworldExplorer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int M = sc.nextInt();
        int N = sc.nextInt();
        int[][] grid = new int[M + 1][N + 1];

        while (T-- > 0) {
            int i = sc.nextInt();
            int j = sc.nextInt();
            char dir = sc.next().charAt(0);
            String route = sc.next();
            printPath(grid, M, N, i, j, dir, route);
        }


        sc.close();


    }

    private static Map<Character, Character> lmap = new HashMap<>();
    private static Map<Character, Character> rmap = new HashMap<>();

    /*                 W
                   S      N
                       E
     */

    public static void printPath(int[][] grid, int M, int N, int i, int j, char dir, String route) {
        boolean isLost = false;
        int r = -1;
        int c = -1;
        fillLMap();
        fillRMap();
        for(int k = 0; k < route.length(); k++) {

            char currRoute = route.charAt(k);

            if(currRoute == 'R') {
                dir = rmap.get(dir);
            } else if(currRoute == 'L') {
                dir = lmap.get(dir);
            }
            else {
                r = i;
                c = j;

                if(dir == 'N') {
                    j = j + 1;
                } else if(dir == 'E') {
                    i = i + 1;
                } else if(dir == 'S') {
                    j = j - 1;
                } else {
                    i = i - 1;
                }

                if(!isSafe(grid, M, N, i, j) && grid[r][c] == 1) {
                    i = r;
                    j = c;
                    continue;
                } else if(!isSafe(grid, M, N, i, j)) {
                    isLost = true;
                    grid[r][c] = 1;
                    break;
                }
            }

        }

        if(isLost) {
            System.out.println(r + " " + c + " " + dir + " " + "L");
        } else {
            System.out.println(i + " " + j + " " + dir);
        }

    }

    /*                 W
                  S      N
                      E
    */

    private static void fillLMap() {
        lmap.put('N', 'W');
        lmap.put('E', 'N');
        lmap.put('S', 'E');
        lmap.put('W', 'S');
    }

    private static void fillRMap() {
        rmap.put('N', 'E');
        rmap.put('E', 'S');
        rmap.put('S', 'W');
        rmap.put('W', 'N');
    }


    private static boolean isSafe(int[][] grid, int M, int N, int i, int j) {

        if( i < 0 || i > M || j < 0 || j > N) {
            return false;
        }

        return true;
    }
}
