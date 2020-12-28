package com.kurshit.leetcode.googletagged.medium;

import java.util.Arrays;

public class RotateImageClockwise {

	public static void main(String[] args) {
		
		int[][] mat = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		int rows = mat.length;
		int cols = mat[0].length;
		rotateImageClockWise(mat, rows, cols);
		
		//Expected output - 
			
		/*
		 * 	{7, 4, 1},
         *	{8, 5, 2},
		 *	{9, 6, 3}
		 */
		
		for(int[] ar : mat) {
			System.out.println(Arrays.toString(ar));
		}

	}
	
	public static void rotateImageClockWise(int[][] mat, int rows, int cols) {
		
		for(int i=0; i < rows; i++) {
			for(int j=i; j < cols; j++) {
				int temp = mat[i][j];
				mat[i][j] = mat[j][i];
				mat[j][i] = temp;
			}
		}
		
		/*
		 * After above transpose, matrix will look like this - 
		 * 
		 * Before : 
		 * 		{1, 2, 3},   
				{4, 5, 6},
				{7, 8, 9}
			
			After : 
				{1, 4, 7},
				{2, 5, 8},
				{3, 6, 9}
		 *
		 *		
		 */
		
		//Reverse each row to rotate it
		
		for(int[] arr : mat) {
			reverse(arr);
		}
		
	}

	private static void reverse(int[] arr) {
		int i = 0;
		int j = arr.length - 1;
		
		while(i <= j) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
			i++;
			j--;
		}
	}
	
	

	

}
