package com.kurshit.leetcode.pastgoogle;

import java.util.HashMap;
import java.util.Set;

/*
 * Problem Source : https://leetcode.com/discuss/interview-question/930843/Google-or-L3-or-Onsite
 * Problem : 	First describe a situation you missed a deadline and what you have learnt from it. Then coding question: Card has 4 attributes (color, count, shading, shape), each attribute can have value 0, 1 or 2. 3 cards are considered as a set if for each attribute, 3 cards either have the same value or have different value from each other. For example:
	card1 (2, 0, 1, 2), card2 (1, 0, 0, 1) and card3(0, 0, 2, 0) are 1 set.
	card1(2, 0, 1, 2), card2 (1, 1, 0, 1) and card3(0, 1, 2, 0) are not 1 set.
	
	Write a boolean function with 3 cards as input. This function returns true if they are 1 set, otherwise returns false.
	Now given a collection of cards, return true if there is a set of cards exsits, otherwise return false. The interviewer wants O(n^2) solution.

 */

public class ThreeCardsSet {

	public static void main(String[] args) {
		
		int[][] arr = { {2, 0, 1, 2},
						{1, 0, 0, 1},
						{0, 0, 2, 0}
					};
		
		System.out.println(isValidSet(arr));
		
		int[][] arr1 = {{2, 0, 1, 2},
						{1, 1, 0, 1},
						{0, 1, 2, 0}
			};
		System.out.println(isValidSet(arr1));


	}
	
	public static boolean isValidSet(int[][] arr) {
		
		HashMap<Character, Set<Integer>> map = new HashMap<>();
		
		int M = 3;
		int N = 4;
		
		for(int j =0; j < N; j++ ) {
						
			int first = arr[0][j];
			int second = arr[1][j];
			int third = arr[2][j];
			
			if(first == second && second == third) {
				continue;
			}
			
			if(first != second && second != third) {
				continue;
			}
				
			return false;
		}
		
		return true;
	}
}
