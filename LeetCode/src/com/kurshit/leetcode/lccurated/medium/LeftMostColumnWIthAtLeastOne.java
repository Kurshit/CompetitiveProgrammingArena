package com.kurshit.leetcode.lccurated.medium;

/*
 * Source URL : https://leetcode.com/problems/leftmost-column-with-at-least-a-one/
 * 
 * Problem : A binary matrix means that all elements are 0 or 1. For each individual row of the matrix, this row is sorted in non-decreasing order.

	Given a row-sorted binary matrix binaryMatrix, return leftmost column index(0-indexed) with at least a 1 in it. If such index doesn't exist, return -1.
	
	You can't access the Binary Matrix directly.  You may only access the matrix using a BinaryMatrix interface:
	
	BinaryMatrix.get(row, col) returns the element of the matrix at index (row, col) (0-indexed).
	BinaryMatrix.dimensions() returns a list of 2 elements [rows, cols], which means the matrix is rows * cols.
	Submissions making more than 1000 calls to BinaryMatrix.get will be judged Wrong Answer.  Also, any solutions that attempt to circumvent the judge will result in disqualification.
	
	For custom testing purposes you're given the binary matrix mat as input in the following four examples. You will not have access the binary matrix directly.
 * 
 * 
 * 
 */

public class LeftMostColumnWIthAtLeastOne {

	public static void main(String[] args) {
		
		int[][] grid = {
						{0, 0, 0, 0, 0},
						{0, 0, 0, 0, 1},
						{0, 0, 0, 1, 1},
						{0, 0, 0, 1, 1},
						{0, 0, 0, 1, 1},
						{0, 1, 1, 1, 1},
		};
		
		System.out.println(getLastColumnIndexWithOne(grid));
		
		int[][] grid1 = {
				{0, 0},
				{0, 0}
		};
				

		System.out.println(getLastColumnIndexWithOne(grid1));
	}
	
	public static int getLastColumnIndexWithOne(int[][] grid) {
		
		int M = grid.length;
		int N = grid[0].length;
		
		int currRow = 0;
		int currColum = N-1;
		
		while(currRow < M && currColum >=0) {
			
			if(grid[currRow][currColum] == 0) {
				currRow++;
			} else {
				currColum--;
			}
		}
		
		return currColum == N - 1 ? -1: currColum + 1;
	}

}
