package com.kurshit.google.kickstart.ks2020.rounde;

import java.util.Scanner;

/*
 * Source : https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff47/00000000003bf4ed
 * 
 * Problem: 
 * 
 * An arithmetic array is an array that contains at least two integers and the differences between consecutive integers are 
 * equal. For example, [9, 10], [3, 3, 3], and [9, 7, 5, 3] are arithmetic arrays, while [1, 3, 3, 7], [2, 1, 2], and [1, 2, 4] are not arithmetic arrays.

 * Sarasvati has an array of N non-negative integers. The i-th integer of the array is Ai. She wants to choose a 
 * contiguous arithmetic subarray from her array that has the maximum length. Please help her to determine the length of the longest contiguous arithmetic subarray.

 *	Input
		The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with 
		a line containing the integer N. The second line contains N integers. The i-th integer is Ai.
	
 *	Output
		For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) 
		and y is the length of the longest contiguous arithmetic subarray.
 */

public class LongestArithmetic {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		LongestArithmetic l = new LongestArithmetic();
		for(int t=1; t <= T; t++) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i =0; i < N; i++) {
				arr[i] = sc.nextInt();
			}			
			int result = l.getLongestArithmetic(arr, N);
			System.out.println("Case #" + t +": " + result);
		}
		sc.close();
	}
	
	public int getLongestArithmetic(int[] arr, int N ) {
		int result = 0;
			
		int count = 0;
		int prev = -1;
		for(int i = 0; i < arr.length-1; i++) {
			
			int diff = arr[i] - arr[i+1];
			if(diff == prev)
				count++;
			else {
				result = Math.max(result, count + 1);
				prev = diff;
				count = 1;
			}
		}		
		
		result = Math.max(result, count+1);
		
		return result;
	}
	
	

}
