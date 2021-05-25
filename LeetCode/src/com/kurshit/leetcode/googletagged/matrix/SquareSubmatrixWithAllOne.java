package com.kurshit.leetcode.googletagged.matrix;

/*
 * Problem Source: https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 * 
 * Problem Statement : 
 * 	Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
	
		Example 1:
		
		Input: matrix =
		[
		  [0,1,1,1],
		  [1,1,1,1],
		  [0,1,1,1]
		]
		Output: 15
		Explanation: 
		There are 10 squares of side 1.
		There are 4 squares of side 2.
		There is  1 square of side 3.
		Total number of squares = 10 + 4 + 1 = 15.
 * 
 */

/*
 * Solution approach : https://www.youtube.com/watch?v=ojz8xZc8pog&ab_channel=thecodingworld
 * 
 * For each cell, calculate minimum of previous row, previous column and previous diagonal element and add one to the min.
 * For each cell, it indicates how many sub square matrices can be formed at that cell.
 * Once we have got value for each cell in resultant matrix - add all cell values to get final result.
 * 
 * result matrix should be m+1 and n+1 and initialize first rows and columns with 0; by default those will be 0;
 */

public class SquareSubmatrixWithAllOne {

	public static void main(String[] args) {
		
		int[][] mat = {
				{0, 1, 1, 1},
				{1, 1, 1, 1},
				{0, 1, 1, 1}
				
		};
		
		System.out.println(countSquares(mat));
		System.out.println(countSquaresLC(mat));
		
		int[][] mat1 = {
				{1, 0, 1},
				{1, 1, 0},
				{1, 1, 0}
				
		};
		
		System.out.println(countSquares(mat1));

	}
	
	public static int countSquares(int[][] mat) {
		int m=mat.length, n=mat[0].length;
		int[][] result = new int[m+1][n+1];
		int count = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
            	if(mat[i-1][j-1] == 1) {
            		result[i][j] = 1 + Math.min(result[i][j-1], Math.min(result[i-1][j-1], result[i-1][j]));
            	}
            }
        }
        
        for(int i=0; i<= m; i++) {
        	for(int j=0; j<= n; j++) {
        		count = count + result[i][j]; 
        	}
        }
        return count;
	}

	
	
	//Approach 2 : Leetcode approach 
	public static int countSquaresLC(int[][] mat) {
		int m=mat.length, n=mat[0].length, result=0;
        int[] dp= new int[n+1];
        
        for(int i=1; i<=m; i++){
            int prev=dp[0];
            
            for(int j=1; j<=n; j++){
                if(mat[i-1][j-1] == 0){
                    dp[j]=0;
                    continue;
                }
                int temp = dp[j];
                dp[j] = 1 + Math.min(prev, Math.min(dp[j-1], dp[j]));
                prev = temp;
                result += dp[j];
            }
        }
        return result;
	}

}
