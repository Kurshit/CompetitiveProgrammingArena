package com.codeforces.contests.problemset.maths;

import java.util.Scanner;

/*
 * Source : http://codeforces.com/problemset/problem/9/C
 *  Problem C : Hexadecimal's Numbers
 *  
 *  Given N integer ranging from 1 to N - find how many of these numbers represent binary represntation of it.
 *  Example: 
 *  	Input:	N = 10
 *  	Output: 2   (1 and 10)
 *  
 *  	Input: N = 20
 *  	Output 3  (1, 10, 11)
 *  
 */

public class Problem9C {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		solve(sc);
	}
	
	/*
	 * 	ACCEPTED
	 * 
	 * 	Idea: Java has - for an int N - Ingteger.toBinaryString(N) - which converts the given integer to its 
	 *  binary represntation in string form. Ex: Integer.parseInt(2) - 10.
	 *  
	 *  Fact : From integer range 1 to N, when we convert every ith number to its binary representation, the int number itself
	 *  if isBinary - then it would never exceed N.  
	 */
	
	private static void solve(Scanner sc) {
		
		int N = sc.nextInt();
		
		int count = 0;
		
		for(int i=1; Integer.parseInt(Integer.toBinaryString(i)) <= N; i++) {
			count++;
		}
		
		System.out.println(count);
	}
	
	/*
	 * Not accepted brute forces approach 1.
	 * 
	 * Verdict : Time limit exceeded
	 */
	
	private static void usingIsBinBF(Scanner sc) {
		int N = sc.nextInt();
		int count = 0;
		for(int i = 1; i <= N; i++ ) {
			
			if(isBin(i))
				count++;
		}
		System.out.println(count);
	}
	
	private static void usingIsBinRegex(Scanner sc) {
		int N = sc.nextInt();
		int count = 0;
		for(int i = 1; i <= N; i++ ) {
			
			if(Integer.toString(i).matches("[10]*"))
				count++;
		}
		System.out.println(count);
	}
	
	private static boolean isBin(int N) {
		while(N != 0) {
			
			if(N%10 > 1)
				return false;
			
			N = N /10;
		}
		
		return true;
	}

}
