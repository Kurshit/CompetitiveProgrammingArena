package com.kurshit.leetcode.lccurated.medium;

import java.util.Arrays;

/*
 * Problem source : https://leetcode.com/problems/4-keys-keyboard/
 * 
 * Problem : Imagine you have a special keyboard with the following keys:

	Key 1: (A): Print one 'A' on screen.
	
	Key 2: (Ctrl-A): Select the whole screen.
	
	Key 3: (Ctrl-C): Copy selection to buffer.
	
	Key 4: (Ctrl-V): Print buffer on screen appending it after what has already been printed.
	
	Now, you can only press the keyboard for N times (with the above four keys), find out the maximum numbers of 'A' you can print on screen.
	
	Example 1:
	Input: N = 3
	Output: 3
	Explanation: 
	We can at most get 3 A's on screen by pressing following key sequence:
	A, A, A
 * 
 * Solution Approach : https://www.youtube.com/watch?v=nyR8K63F2KY&t=754s&ab_channel=IDeserve
 */

public class FourKeysKeyboard {
	public static void main(String[] args) {
		
		int N = 7;
		System.out.println(getMaxAs(N));
	}
	
	public static int getMaxAs(int N) {
		
		int[] result = new int[N];
		Arrays.fill(result,-1);
		
		return getMaxAsUtil(N, result);
	}
	
	public static int getMaxAsUtil(int N, int[] result) {
			if( N == 0)
				return -1;
			
			if(N <= 6)
				return N;
			int maxSoFar = 0;
			int multiplier = 2;
			for(int i = N-3; i >=0; i--) {
				
				if(result[i] ==-1) {
					result[i] = getMaxAsUtil(i, result);				
				}
				
				int maxTillHere = multiplier * result[i];
				
				if(maxTillHere > maxSoFar) {
					maxSoFar = maxTillHere;
				}
				
				multiplier++;
				
			}
			
			return maxSoFar;
	}
}
