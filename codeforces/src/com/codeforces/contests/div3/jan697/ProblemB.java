package com.codeforces.contests.div3.jan697;

import java.util.Arrays;
import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			int MAX = 1000005;
			boolean[] multiples = new boolean[MAX];
			
			for(int i=0; i < 1001; i++) {
				for(int j = 0; j < 1001; j++) {
					int index = i * 2020 + j * 2021;
					
					if(index < MAX)
						multiples[index] = true;
				}
			}
			
			while(T-- >0 ) {
				
				int N = sc.nextInt();
				
				if(multiples[N]) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				
			}
			
			
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}
	public static long[] cache;
	
	public static boolean solution(int N) {
		
		if(N == 0)
			return true;
		
		if( N < 0)
			return false;
		
		if(cache[N-1] != -1)
			return cache[N-1] == 1;
		
		boolean result = solution(N-2020) || solution(N - 2021);
		
		cache[N-1] = result ? 1 : 0;
		
		return result;
		
	}

}
