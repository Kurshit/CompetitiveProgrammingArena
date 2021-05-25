package com.kurshit.codeforces.challnges.longer21.january;


import java.util.Arrays;
import java.util.Scanner;

public class WIPLDP {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				
				int N = sc.nextInt();
				int K = sc.nextInt();
				
				int[] arr = new int[N];
				
				for(int i=0; i < N; i++) {
					arr[i] = sc.nextInt();
				}
				
				
				if(N == 1) {
					System.out.println(-1);
				}else {
					Arrays.sort(arr);
					System.out.println(getMinimumBoxes(arr, N, K));
					
				}
				
				
				
				
			}
			
		} catch(Exception e) {
			
		} finally {
			sc.close();
		}
	}
	
	public static int getMinimumBoxes(int[] arr, int N, int K) {
		
		for(int i=0; i < N/2; i++) {
			swap(arr, i, N-i-1);
		}
		
		int[] pref = new int[N+100];
		int[][] dp = new int[N+100][K+100];
		for(int i = 0; i <= N+10; i++ ) {
			pref[i] = 0;
			
			for(int j=0; j <= K+10; j++) {
				dp[i][j] = -1;
			}
		}
		
		for(int i=1; i <= N; i++) {
			pref[i] = pref[i-1] + arr[i-1];
		}
		
		int ans = findSum(0,0,N, K, arr, pref, dp);
		
		return ans > 100000 ? -1 : ans; 
	}

	private static int findSum(int index, int done, int n, int k, int[] arr, int[] pref, int[][] dp) {
		
		if(done>=k && (pref[index]-done>=k)) 
			return 0;
	    else if(index>=n)  
	    	return 100000;
	    
	    else if(dp[index][done]!=-1) 
	    	return dp[index][done];
	    
	    int c1 = findSum(index+1,Math.min(done+arr[index],pref[index]-done),n,k,arr, pref, dp);
	    int c2 = findSum(index+1,Math.min(pref[index]-done+arr[index],done),n,k,arr, pref, dp);
	    
	    return dp[index][done] = 1+ Math.min(c1,c2);
	}

	private static void swap(int[] arr, int i, int j) {
		
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
		
	}
	

}
