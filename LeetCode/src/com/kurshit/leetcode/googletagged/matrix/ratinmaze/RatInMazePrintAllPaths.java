package com.kurshit.leetcode.googletagged.matrix.ratinmaze;

import java.util.Arrays;

public class RatInMazePrintAllPaths {

  public static void main(String[] args) {
    int M = 4;
    int N = 4;
    int[][] grid = {
      {1, 0, 0, 0},
      {1, 1, 0, 1},
      {0, 1, 1, 1},
      {0, 1, 1, 1}
    };
    //total expected paths 4
    printPaths(grid, 4,4);

    M = 7;
    N = 7;
    int[][] grid1 = {
        { 1, 1, 0, 1, 1, 0, 1},
        { 0, 1, 0, 0, 1, 1, 1},
        { 1, 1, 1, 1, 0, 1, 0},
        { 0, 1, 0, 1, 1, 1, 1},
        { 0, 1, 0, 0, 1, 0, 1},
        { 0, 1, 1, 1, 1, 0, 1},
        { 0, 0, 0, 0, 1, 1, 1},
    };

    System.out.println(" ******* ");
    //total expected paths 4
    printPaths(grid1, M, N);

  }

  public static void printPaths(int[][] grid, int M, int N) {
    boolean[][] visited = new boolean[M][N];
    int[][] solution = new int[M][N];
    dfs(grid, 0, 0, M, N, visited, solution);
  }

  private static void dfs(int[][] grid, int i, int j, int M, int N, boolean[][] visited, int[][] solution) {
    if(i < 0 || i >= M || j < 0 || j >= N || visited[i][j] || grid[i][j] == 0) {
      return;
    }

    if(i == M-1 && j == N-1) {
      solution[i][j] = 1;
      printSolution(solution);
      System.out.println();
    }
    visited[i][j] = true;
    solution[i][j] = 1;
    dfs(grid, i, j+1, M, N, visited, solution);
    dfs(grid, i, j-1, M, N, visited, solution);
    dfs(grid, i+1, j, M, N, visited, solution);
    dfs(grid, i-1, j, M, N, visited, solution);
    solution[i][j] = 0;
    visited[i][j] = false;
  }

  private static void printSolution(int[][] solution) {

    for(int[] arr : solution) {
      System.out.println(Arrays.toString(arr));
    }
  }

}
