package com.kurshit.google.kickstart.kj2020.qualification;

import java.util.Scanner;

/*
 * Source: https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/0000000000209a9f
 * 
 */

public class NestingDepth {
	
	public static void solve(String s, int N, int C) {
		
		int opened = 0;
		String r = "";
		for(int i=0; i< N; i++) {
			
			int curr = Integer.parseInt(String.valueOf(s.charAt(i)));
			
			while(curr > opened) {
				r = r + '(';
				opened++;
			}
			
			while(curr < opened) {
				r = r + ')';
				opened--;
			}
			
			r = r + curr;
			
		}
		
		while(opened-- > 0) {
			r = r + ')';
		}
		
		System.out.println("Case #" + C + ": " + r);
	}
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int C = 1;
		while(T-- > 0) {
			
			String s = sc.next();
			solve(s, s.length(), C);
			C++;			
		}
		
		sc.close();

	}

}
