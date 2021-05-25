package com.kurshit.google.kickstart.ks2021.mar;

import java.util.Scanner;

public class ProblemB {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int T = sc.nextInt();
			ProblemB p = new ProblemB();
			for(int i=1; i<= T; i++) {
				System.out.println("Case #" + i + ": "  +p.getCount(sc,i));
			}
		} catch(Exception e) {
			
		} finally {
			sc.close();
		}	
		
		
	}

	public int getCount(Scanner sc, int T) {
			
		int count = 0;
		
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		int[][] grid = new int[R][C];
		for(int i=0; i < R; i++) {
			for(int j=0; j < C; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		
		
		for(int j = 0; j < C; j++) {
			for(int i=0; i < R/2; i++) {
				
			}
		}
		
		
		return count;		
	}
	
	public int getGoodNess(String str) {
		
		int res = 0;
		
		int N = str.length();
		
		for(int i=0; i < (N/2); i++) {
			
			if(str.charAt(i) != str.charAt(N-i-1)) {
				res++;
			}
			
		}	
		
		return res;
		
		
	}

}
