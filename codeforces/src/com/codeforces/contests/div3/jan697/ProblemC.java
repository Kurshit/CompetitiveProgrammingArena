package com.codeforces.contests.div3.jan697;

import java.math.BigInteger;
import java.util.Scanner;

public class ProblemC {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);

		try {

			int T = sc.nextInt(); 

			while(T-- > 0) {
				
				int N = sc.nextInt();
				long M = sc.nextLong();
				long[] apps = new long[N];
				long[] conv = new long[N];
				
				for(int i=0; i < N; i++) {
					apps[i] = sc.nextLong();
				}
				
				for(int i=0; i < N; i++) {
					conv[i] = sc.nextLong();
				}
				
				System.out.println(solution(N,M, apps, conv));
				
			}

		} catch(Exception e) {

		} finally {
			sc.close();
		}

	}

	private static long solution(int N, long M, long[] apps, long[] conv) {
		
		if(N == 0 ) {
			return Integer.MAX_VALUE; 
		}
		
		if(M == 0) {
			return 0;
		}
		
		return  Math.min(conv[N-1] + solution(N-1, M - apps[N-1], apps, conv), solution(N-1, M, apps, conv));		
		
	}

	

}
