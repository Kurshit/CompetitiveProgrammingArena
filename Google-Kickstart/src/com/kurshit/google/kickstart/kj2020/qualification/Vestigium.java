package com.kurshit.google.kickstart.kj2020.qualification;

import java.util.Scanner;

/*
 * Source : https://codingcompetitions.withgoogle.com/codejam/round/000000000019fd27/000000000020993c
 */

public class Vestigium {

	public static void main(String[] args) {
	
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int c = 1;
		while(T-- > 0) {
			int N = sc.nextInt();
			int[][] t = new int[N][N];
			
			for(int i =0; i<N; i++) {
				for(int j=0; j < N; j++) {
					t[i][j] = sc.nextInt();
				}
			}		
			
			solve(t,N,c);
			c++;
		}
		sc.close();
	}
	private static void solve(int[][] t, int N, int C) {
		
		//boolean[] r = new boolean[100];
		
		int trace = 0;
		int rc = 0;
		int cc = 0;
		
		for(int i=0; i < N; i++) {
			boolean[] v = new boolean[N+1];
			for(int j=0; j < N; j++) {
				if(v[t[i][j]]) {
					rc++;
					break;
				}else {
					v[t[i][j]] = true;
				}
			}
		}
		
		for(int i=0; i < N; i++) {
			boolean[] v = new boolean[N+1];
			for(int j=0; j < N; j++) {
				if(v[t[j][i]]) {
					cc++;
					break;
				}else {
					v[t[j][i]] = true;
				}
			}
		}
		
		for(int i=0; i < N; i++) {
			trace = trace + t[i][i];
		}
		
		System.out.println("Case #"+ C + ": " + trace + " " + rc + " " + cc);
		
	}

}
