package com.kurshit.leetcode.lccurated.easy;

/*
 *  The k-digit number N is an Armstrong number if and only if the k-th power of each digit sums to N.

	Given a positive integer N, return true if and only if it is an Armstrong number.
	
	
 */

public class ArmStrongNumber {

	public static void main(String[] args) {
		int N = 153;
		System.out.println(isArmStrong(N));
		N = 155;
		System.out.println(isArmStrong(N));
		
	}
	
	public static boolean isArmStrong(int N) {
				
		int order = getOrder(N);
		
		int ans = 0;
		
		int temp = N;
		
		while(temp != 0) {
			int m = temp % 10;
			ans = (int) (ans + Math.pow(m, order));
			temp = temp / 10;
		}
		
		return ans == N;
	}

	private static int getOrder(int N) {
		
		int c = 0;
		
		while(N != 0) {
			N = N/10;
			c++;
		}
		return c;
	}
	


}
