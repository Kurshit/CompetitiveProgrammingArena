package com.kurshit.codeforces.challnges.longer21.january;

import java.util.Arrays;

public class CountSubMatricesPattern {

	public static void main(String[] args) {
	
//		int[][] grid = {
//				{0,1},
//				{1,0}
//		};
//		
//		System.out.println(countSquares(grid, 2));
//		
//		int[][] grid0 = {
//				{0, 1, 0, 1},
//				{1, 0, 1, 0},
//				{0, 1, 0, 1},
//				{1, 0, 1, 0}
//		};
//		
//		System.out.println(countSquares(grid0, 4));
//		
//		int[][] grid1 = {
//				{0, 1, 0, 1},
//				{0, 0, 1, 0},
//				{0, 1, 0, 0},
//				{1, 0, 0, 0}
//		};
//		
//		System.out.println(countSquares(grid1, 4));
		
		int[][] result1 = createMatrix(2, 1);
		
		for(int[] a : result1) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(" --> " +countSquares(result1, 2));
		
		int[][] result2 = createMatrix(4, 10);
		
		System.out.println();
		
		for(int[] a : result2) {
			System.out.println(Arrays.toString(a));
		}
		System.out.println(" --> " +countSquares(result2, 4));
		
		int[][] result3 = createMatrix(3, 2);
		
		System.out.println();
		
		for(int[] a : result3) {
			System.out.println(Arrays.toString(a));
		}
		
		System.out.println(" --> " +countSquares(result3, 3));
	}
	
	public static int countSquares(int[][] grid, int N) {
		int count = 0;
		
		
		for(int i=0; i < N-1 ; i++) {
			for(int j=0; j < N-1; j++) {
				
				if(grid[i][j] == 0 && grid[i][j+1] == 1 && grid[i+1][j+1] == 0 && grid[i+1][j] == 1) {
					count++;
				}
			}
		}	
		
		return count;
	}
	
	public static int[][] createMatrix(int N, int K) {
		
		int[][] grid = new int[N][N];
		int count = 0;
		for(int i = 1; i < N; i++) {
			for(int j=1; j < N; j++) {
				
				if(count < K && grid[i-1][j-1] != 1) {
					grid[i][j] = 0;
					grid[i-1][j] = 1;
					grid[i][j-1] = 1;
					count++;
				} 
				
			}
		}
		
		
		return grid;
	}

}
