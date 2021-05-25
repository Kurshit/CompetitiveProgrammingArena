package com.codeforces.contests.div3.jan697;

/* 
 * Contest : Div 3 #697: 
 * Problem : https://codeforces.com/blog/entry/87188 - #1475
 * Problem A : https://codeforces.com/contest/1475/problem/A
 * 
 */

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		try {

			int T = sc.nextInt(); 

			while(T-- > 0) {

				long N = sc.nextLong();

				System.out.println(solution(N));
			}

		} catch(Exception e) {

		} finally {
			sc.close();
		}

	}
	
	/*
	 * Approach 1 : 
	 */

/*
 * 	public static String solution(long N ) {
 
				
		while(N % 2 == 0) {
			N = N /2;
		}
		
		if(N == 1) {
			return "NO";
		} else {
			return "YES";
		}
		
	}

*/
	
	public static String solution(long N ) {
		
		if( (N & (N-1)) == 0) {
			return "NO";
		} else {
			return "YES";
		}
		
	}
}
