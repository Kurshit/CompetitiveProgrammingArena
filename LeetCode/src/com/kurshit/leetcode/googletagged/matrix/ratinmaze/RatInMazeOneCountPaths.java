package com.kurshit.leetcode.googletagged.matrix.ratinmaze;

/*
 * Problem: Given a grid of m X n, There is a rat at position 0,0 and needs to go to m-1, n1 positon.
 * There are several squares which are blocked and indicated by 0 and Valid path with 1. You need to tell number of available valid paths
 * for rat to reach to destination with following constraint.  
 * 
 * Constraint : 
 * 	1. Rat can move in four directions - U, L, R, D
 *  2. Every cell can be visited only once
 * 
 * Example: 
 * 
 * 		m = 5, n = 4
 * 
 * 		{ 1, 1, 1, 1}
 * 		{ 1, 1, 1, 0}
 * 		{ 1, 1, 1, 0}
 * 		{ 1, 0, 1, 1}
 * 		{ 1, 0, 1, 1}
 * 
 * 	Output : 24
 * 
 */

public class RatInMazeOneCountPaths {

	public static void main(String[] args) {
		int M = 7, N = 7;
		int[][] grid= {
				{ 1, 1, 0, 1, 1, 0, 1},
				{ 0, 1, 0, 0, 1, 1, 1},
				{ 1, 1, 1, 1, 0, 1, 0},
				{ 0, 1, 0, 1, 1, 1, 1},
				{ 0, 1, 0, 0, 1, 0, 1},
				{ 0, 1, 1, 1, 1, 0, 1},
				{ 0, 0, 0, 0, 1, 1, 1},
		};

		//expected output : 4
		System.out.println(countPaths(grid, M, N));

		int[][] grid1 = {
				{1, 1, 1, 1},
				{1, 1, 1, 0},
				{1, 1, 1, 0},
				{1, 0, 1, 1},
				{1, 0, 1, 1}
		};
		M = 5;
		N = 4;
		//expected output : 24
		System.out.println(countPaths(grid1, M, N));

	}

	static int count;

	public static int countPaths(int[][] grid, int M, int N ) {
		count = 0;
		boolean[][] visited = new boolean[M][N];
		dfs(grid, 0, 0, M, N, visited);	
		return count;
	}
	
	public static void dfs(int[][] grid, int i, int j, int M, int N, boolean[][] visited) {

		if(i < 0 || i >= M || j < 0 || j >= N || grid[i][j] == 0 || visited[i][j] == true) {
			return;
		}

		if(i == M-1 && j == N-1) {
			count = count + 1;
			return;
		}
		

		visited[i][j] = true;
		
		dfs(grid, i - 1, j, M, N, visited);
		dfs(grid, i + 1, j, M, N, visited);
		dfs(grid, i , j - 1, M, N, visited);
		dfs(grid, i, j + 1 , M, N, visited);
		visited[i][j] = false;
	}
	

}
