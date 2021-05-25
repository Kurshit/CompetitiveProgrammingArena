package com.kurshit.codeforces.challnges.longer21.january;


import java.util.Arrays;
import java.util.Scanner;

class FAIRELCT {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				int N = sc.nextInt();
				int M = sc.nextInt();
				
				int[] arr1 = new int[N];
				int[] arr2 = new int[M];
				
				int s1 = 0;
				int s2 = 0;
				
				for(int i=0; i < N; i++) {
					arr1[i] = sc.nextInt();
					s1 = s1 + arr1[i];
				}
				
				for(int i=0; i < M; i++) {
					arr2[i] = sc.nextInt();
					s2 = s2 + arr2[i];
				}
				
				System.out.println(getMaxSwaps(arr1, N, arr2, M, s1, s2));
			}
			
		} catch(Exception e) {
			
		} finally {
			sc.close();
		}

	}
	
	public static int getMaxSwaps(int[] arr1, int N, int[] arr2, int M, int s1, int s2) {
		
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		if(s1 > s2)
			return 0;
		
		int start =0;
		int end = arr2.length -1;
		int result = 0;
		while(start < arr1.length && end >= 0) {
			
			int diff = arr2[end] - arr1[start];
			
			s1 = s1 + diff;
			s2 = s2 - diff;
			result++;
			if(s1 > s2) {
				break;
			} 
			
			start++;
			end--;
		}
		if(s1 < s2 || s1 == s2) {
			return -1;
		}
		
		
		return result;
	}

}
