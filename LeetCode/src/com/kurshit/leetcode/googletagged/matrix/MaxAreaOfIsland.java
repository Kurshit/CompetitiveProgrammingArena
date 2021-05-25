package com.kurshit.leetcode.googletagged.matrix;

/*
 * Problem Source : https://leetcode.com/problems/max-area-of-island/
 * Statement:
 * You are given an m x n binary matrix grid. An island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.) You may assume all four edges of the grid are surrounded by water.

 *	The area of an island is the number of cells with a value 1 in the island.
	
 *	Return the maximum area of an island in grid. If there is no island, return 0.
 *
 * Example: 
 * 
 * 	mat - 
 * 		[1 1 0 0 0]
 * 		[1 1 0 0 0]
 * 		[0 0 0 1 1]
 * 		[0 0 0 1 1]
 * 
 * Output: 4
 */

public class MaxAreaOfIsland {

	int dfs(int[][] grid, int r, int c) {
		int nr = grid.length;
		int nc = grid[0].length;

		if (r < 0 || c < 0 || r >= nr || c >= nc || grid[r][c] == 0) {
			return 0;
		}

		grid[r][c] = 0;
		int up = dfs(grid, r - 1, c);
		int down = dfs(grid, r + 1, c);
		int left = dfs(grid, r, c - 1);
		int right = dfs(grid, r, c + 1);
		
		return 1 + up + down + left + right;
	}

	public int numIslands(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		int nr = grid.length;
		int nc = grid[0].length;
		int maxAreaIsland = 0;
		for (int r = 0; r < nr; ++r) {
			for (int c = 0; c < nc; ++c) {
				if (grid[r][c] == 1) {
					//++num_islands;
					maxAreaIsland = Math.max(dfs(grid, r, c), maxAreaIsland);
				}
			}
		}

		return maxAreaIsland;
	}

	public static void main(String[] args) {

		int M[][] = new int[][] { 
			{ 1, 1, 0, 0, 0 }, 
			{ 1, 1, 0, 0, 0 }, 
			{ 0, 0, 1, 0, 0 }, 
			{ 0, 0, 0, 1, 1 } }; 
			
		MaxAreaOfIsland island = new MaxAreaOfIsland();
		
		System.out.println(island.numIslands(M));
		
		
			
	}

}



