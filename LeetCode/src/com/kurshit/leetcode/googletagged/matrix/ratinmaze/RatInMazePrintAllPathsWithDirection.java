package com.kurshit.leetcode.googletagged.matrix.ratinmaze;

import java.util.Arrays;

public class RatInMazePrintAllPathsWithDirection {

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
    String result = "";
    dfs(grid, 0, 0, M, N, visited, result);
  }

  private static void dfs(int[][] grid, int i, int j, int M, int N, boolean[][] visited, String result) {
    if(i < 0 || i >= M || j < 0 || j >= N || visited[i][j] || grid[i][j] == 0) {
      return;
    }

    if(i == M-1 && j == N-1) {
      System.out.println(result);
      System.out.println();
    }
    visited[i][j] = true;

    result = result + 'R';
    dfs(grid, i, j+1, M, N, visited, result);
    result = result.substring(0, result.length() - 1);
    result = result + 'L';
    dfs(grid, i, j-1, M, N, visited, result);
    result = result.substring(0, result.length() - 1);
    result = result + 'D';
    dfs(grid, i+1, j, M, N, visited, result);
    result = result.substring(0, result.length() - 1);
    result = result + 'U';
    dfs(grid, i-1, j, M, N, visited, result);

    result = result.substring(0, result.length() - 1);

    visited[i][j] = false;
  }

  private static void printSolution(int[][] solution) {

    for(int[] arr : solution) {
      System.out.println(Arrays.toString(arr));
    }
  }

}
