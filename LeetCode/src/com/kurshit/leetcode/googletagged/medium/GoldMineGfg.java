package com.kurshit.leetcode.googletagged.medium;

import java.util.Arrays;

/*
 * Problem Source : https://www.geeksforgeeks.org/gold-mine-problem/
 * 
 * Problem : Given a gold mine of n*m dimensions. 
 * Each field in this mine contains a positive integer which is the amount of gold in tons. 
 * Initially the miner is at first column but can be at any row. He can move only (right->,right up /,right down\) that is from a given cell, 
 * the miner can move to the cell diagonally up towards the right or right or diagonally down towards the right. 
 * Find out maximum amount of gold he can collect.
 */

public class GoldMineGfg {

	public static void main(String[] args) {
		
		int[][] mat = {
				{1, 3, 3},
                {2, 1, 4},
                {0, 6, 4}
        };
		
		System.out.println(getMaxGold(mat, mat.length, mat[0].length));

	}
	
	public static int getMaxGold(int[][] mat, int M, int N) {
		
		int[][] result = new int[M][N];
		int rightUp =0;
		int rightDown = 0;
		int right = 0;
		
		for(int col = N-1; col >=0; col--) {
			for(int row = 0; row <M; row++) {
				
				rightUp = row == 0 || col == N-1 ? 0 : result[row-1][col+1];
				right = col == N-1 ? 0 : result[row][col + 1];
				rightDown = row == M-1 || col == N-1 ? 0 : result[row+1][col + 1];
				
				result[row][col]  = mat[row][col] + Math.max(rightUp, Math.max(right, rightDown));
			}
		}
		
		
//		for(int[] a : result) {
//			System.out.println(Arrays.toString(a));
//		}
		
		int maxGold = Integer.MIN_VALUE;
		
		for(int i =0; i < M; i++) {
			maxGold = Math.max(maxGold, result[i][0]);
		}
		
		return maxGold;
	}

}
