package com.kurshit.leetcode.googletagged.matrix;

/*
 * Problem Source : https://leetcode.com/problems/path-with-maximum-gold/
 * 
 *   Problem : In a gold mine grid of size m * n, each cell in this mine has an integer representing the amount of gold in that cell, 0 if it is empty.

	Return the maximum amount of gold you can collect under the conditions:
	
	Every time you are located in a cell you will collect all the gold in that cell.
	From your position you can walk one step to the left, right, up or down.
	You can't visit the same cell more than once.
	Never visit a cell with 0 gold.
	You can start and stop collecting gold from any position in the grid that has some gold.
 	Input: grid = [[0,6,0],[5,8,7],[0,9,0]]

	Output: 24
	Explanation:
	[[0,6,0],
	 [5,8,7],
	 [0,9,0]]
	Path to get the maximum gold, 9 -> 8 -> 7.
	
	NOTE : We can start/stop at any position 
	
	Solution : https://www.youtube.com/watch?v=8nlmcgy7vso&ab_channel=MichaelMuinos

 */

public class GoldMineLeetCode {

	public static void main(String[] args) {
		
		int[][] mat = {
				{1,0,7},
				{2,0,6},
				{3,4,5},
				{0,3,0},
				{9,0,20}
		};
		
		//expected output - 28
		int M = mat.length;
		int N = mat[0].length;
		System.out.println(getMaxPath(mat, M, N));

	}
	
	// TC : O(M * N)
	// TC O(M*N)
	
	public static int getMaxPath(int[][] mat, int M, int N) {
		int maxGold = Integer.MIN_VALUE;
		for(int i=0; i < M; i++ ) {
			for(int j=0; j < N; j++) {
				if(mat[i][j] != 0) {
					int result = dfs(mat,M, N, i, j, new boolean[M][N]);
					maxGold = Math.max(maxGold, result );
				}
			}
		}
		
		return maxGold;
	}

	private static int dfs(int[][] mat, int M, int N, int i, int j, boolean[][] visited) {
		
		/*
		 * Return if -
		 * 1. Out of boundary
		 * 2. already visited
		 * 3. cell is 0 
		 */
		
		if(i < 0 || i >= M || j <0 || j >= N || mat[i][j] == 0 || visited[i][j])
			return 0;
		
		visited[i][j] = true;
		int left = dfs(mat, M, N, i, j - 1, visited);
		int right = dfs(mat, M, N, i , j + 1, visited);
		int up = dfs(mat, M, N, i -1 , j , visited);
		int down = dfs(mat, M, N, i + 1 , j, visited);
		visited[i][j] = false;
		
		//don't forget to add value of current cell 
		
		return mat[i][j] + Math.max(left, Math.max(right, Math.max(up, down)));
	}
}
