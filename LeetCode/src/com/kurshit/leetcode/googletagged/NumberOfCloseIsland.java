package com.kurshit.leetcode.googletagged;

/*
 * Problem Source : https://leetcode.com/problems/number-of-closed-islands/
 * 
 * Problem : Given a 2D grid consists of 0s (land) and 1s (water).  
 * An island is a maximal 4-directionally connected group of 0s and a closed island is an island totally (all left, top, right, bottom) 
 * surrounded by 1s.

 *	Return the number of closed islands.
 *
 *	Input: 
		
		grid = {
		{1,1,1,1,1,1,1,0},
		{1,0,0,0,0,1,1,0},
		{1,0,1,0,1,1,1,0},
		{1,0,0,0,0,1,0,1},
		{1,1,1,1,1,1,1,0}
		}
		
		
		Output: 2
		Explanation: 
		Islands in gray are closed because they are completely surrounded by water (group of 1s).
		
	 SOlution Approach : https://www.youtube.com/watch?v=MnD8KhBHgRo&ab_channel=MichaelMuinos
	 
 *	 
 */

public class NumberOfCloseIsland {

	public static void main(String[] args) {
		
		int[][] grid = {
				{1,1,1,1,1,1,1,0},
				{1,0,0,0,0,1,1,0},
				{1,0,1,0,1,1,1,0},
				{1,0,0,0,0,1,0,1},
				{1,1,1,1,1,1,1,0}
		};
		
		System.out.println(getClosedIsland(grid, grid.length, grid[0].length));

	}
	
	/*
	 * Approach : Since the close island has to be surrounded up, down, left and right by 1 - the perimeter can not have close island.
	 * We will not even iterate perimeter but would look elements inside perimeter.
	 * 
	 */
	
	public static int getClosedIsland(int[][] mat, int M, int N) {
		
		if(mat.length == 0)
			return 0;
		
		int closedIsland = 0;
		// Excluding perimeter - 
		
		for(int i= 1; i < M -1; i++) {
			for(int j =1; j < N -1; j++) {
				if(mat[i][j] == 0) {
					//check for closed island to every position from this position
					if(isClosedIsland(mat, i, j, M, N)) {
						closedIsland++;
					}
				}
			}
		}
		
		
		
		return closedIsland;
	}

	private static boolean isClosedIsland(int[][] mat, int i, int j, int m, int n) {
		// -1 visited already
		// 1 - water
		// 0 - land	
		
		//in this, instead is isVisited logic, we make it return true. We only care about 0 - island
		if(mat[i][j] == -1 || mat[i][j] == 1)
			return true;
		
		//Here we know we have a 0 land , check if i and j is on perimeter
		
		if(isOnPerimeter(i, j, m, n))
			return false;
		
		mat[i][j] = -1;
		
		boolean left = isClosedIsland(mat, i, j-1, m, n);
		boolean right = isClosedIsland(mat, i, j+1, m, n);
		boolean up = isClosedIsland(mat, i-1, j, m, n);
		boolean down = isClosedIsland(mat, i+1, j, m, n);
		
		return left && right && up && down;
	}

	private static boolean isOnPerimeter(int i, int j, int m, int n) {
		// TODO Auto-generated method stub
		return i == 0 || j == 0 || i == m-1 || j == n -1;
	}

}
