package com.kurshit.math.standardproblems;

import java.util.Scanner;

/*
 * Prblem source : https://codeforces.com/contest/1520/problem/B
 * Problem Editorial : https://codeforces.com/blog/entry/90342
 *  
 * Solution :
 * 
 *  Statement : Let's call a positive integer n ordinary if in the decimal notation all its digits are the same. For example, 1, 2 and 99 are ordinary numbers, but 719 and 2021 are not ordinary numbers.

 *	For a given number n, find the number of ordinary numbers among the numbers from 1 to n
 *
 *Input
	The first line contains one integer t (1≤t≤104). Then t test cases follow.
	
	Each test case is characterized by one integer n (1≤n≤109).
	
	Output
 *		For each test case output the number of ordinary numbers among numbers from 1 to n.
 *
 *	Sample Input: 
 *		6
		1
		2
		3
		4
		5
		100
 	
 	Sample Output : 
 		
 		1
		2
		3
		4
		5
		18

	
  */


public class CountSameDigitsNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			System.out.println(count(N));
			System.err.println(countOrinaryNumber(N));
			System.out.println();
		}
		
		
		
		sc.close();

	}
	
	/*
	 * Solution Approach : All ordinary numbers are :
	 * 
	 *  	1 2 3 4 5 6 7 8 9  --> 9
	 *  
	 *  	11 22 33 44 55 66  77  88  99 -> 9
	 *  
	 *  	111 222 333 444 555 666 777 888 999 
	 *  
	 *  	1111 2222 .... 9999
	 *  	
	 *  	11111 22222 .... 99999
	 *  	
	 *  	111111 222222 .... 999999
	 *  
	 *  	1111111 2222222 ... 9999999  // 7 times 
	 *  	
	 *  	11111111  ... 99999999  //8 times 9
	 *  
	 *  	111111111  ... 999999999  //9 times 9
	 *  	
	 *  	In total we have - 9 * 9 = 81 ordinary numbers upto 10^9.
	 * 
	 * 		Just do this pattern for every queried N and keep finding this until this range is <= N
	 */
	
	public static int count(int N) {
		
		int result = 0;
		
		for(int i=1; i <= 9; i++) {
			long X = 0;
			for(int j=1; j <= 10; j++) {
				
				X = X * 10 + i;
				
				if(X <= N)
					result++;
			}
		}
		
		return result;
	}
	
	// Same approach with reduced loops
	
	public static int countOrinaryNumber(int N) {
		
		int result = 0;
		
		for(int i=1; i <= 9; i++) {
			
			for(long num= i; num <= N; ) {
				
				result++;				
				num = (num * 10) + 1;
			}
		}
		
		return result;
	}

}
