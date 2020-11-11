package com.kurshit.google.kickstart.ks2020;

import java.util.Scanner;

/*
 * Source : https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d40bb#problem
 */

public class Plates {
	

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		Plates p = new Plates();
		try {
			
			int T = sc.nextInt();
			
			for(int t=1; t <= T; t++) {
				
				int N = sc.nextInt();
				int K = sc.nextInt();
				int P = sc.nextInt();
				
				int[][] arr = new int[51][31];
				int[][] prefix = new int[51][31];

				for(int i=1; i <= N; i++) {
					for(int j=1; j <= K ; j++) {
						arr[i][j] = sc.nextInt();
						prefix[i][j] = prefix[i][j-1] + arr[i][j];
					}
				}
				//int ans = p.getMaxBeautyRecurssion(arr, prefix, 1, 0, N, K, P);
				int ans = p.getMaxBeautyMemoization(arr, prefix, 1, 0, N, K, P);
				System.out.println("Case #" + t + ": " + ans);
				
			}
			
		}catch(Exception e ) {
			
		}

	}
	
	public int getMaxBeautyRecurssion(int[][] arr, int[][] prefix, int idx, int taken, int N, int K, int P) {
		
		if(taken == P)
			return 0;
		
		if(idx > N || taken > P)
			return Integer.MIN_VALUE;
		int maxResult = Integer.MIN_VALUE;
		for(int i=0; i <= K; i++) {
			maxResult = Math.max(maxResult, prefix[idx][i] + getMaxBeautyRecurssion(arr, prefix, idx + 1, taken + i, N, K, P));
		}
		
		return maxResult;
	}
	
	public int getMaxBeautyMemoization(int[][] arr, int[][] prefix, int idx, int taken, int N, int K, int P) {
		int[][] cache = new int[51][51 * 35];
		
		for(int i=0; i< 51; i++) {
			for(int j=0; j < 51*35; j++) {
				cache[i][j] = -1;
			}
		}
		return getMaxBeautyMemoization(arr, prefix, cache, idx, taken, N, K, P);
	}
	
	public int getMaxBeautyMemoization(int[][] arr, int[][] prefix, int[][] cache, int idx, int taken, int N, int K, int P) {
		
		if(taken == P)
			return 0;
		
		if(idx > N || taken > P)
			return Integer.MIN_VALUE;
		
		
		if(cache[idx][taken] != -1) {
			return cache[idx][taken];
		}
		
		int maxResult = Integer.MIN_VALUE;
		for(int i=0; i <= K; i++) {
			maxResult = Math.max(maxResult, prefix[idx][i] + getMaxBeautyMemoization(arr, prefix, cache, idx + 1, taken + i, N, K, P));
		}
		
		return cache[idx][taken] = maxResult;
	}
}
