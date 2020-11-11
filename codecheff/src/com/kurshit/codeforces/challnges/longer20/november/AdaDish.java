package com.kurshit.codeforces.challnges.longer20.november;

import java.util.Arrays;
import java.util.Scanner;

public class AdaDish {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		try {
			
			AdaDish a = new AdaDish();
			
			int T =sc.nextInt();
			
			while(T-- > 0) {
				int N = sc.nextInt();
				int[] arr = new int[N];
				
				for(int i=0; i <N; i++) {
					arr[i] = sc.nextInt();
				}
				
				System.out.println(a.solve(arr, N));			
			}

		}catch(Exception e ) {
			
		} finally {
			sc.close();
		}
				
	}
	
	public int solve(int[] arr, int N) {
		
		if( N == 1)
			return arr[0];
		
		Arrays.sort(arr);
		
		int i = N-1;
		
		int B1 = 0;
		int B2 = arr[i];
		int result = 0;
		while(i>0) {
			i--;
			if(B1 > B2) {
				result = result + B2;
				B1 = B1 - B2;
				B2 = arr[i];
			} else
			{
				result = result + B1;
				B2 = B2 - B1;
				B1 = arr[i];
			}
		}
		
		if(B1 != 0 || B2 != 0) {
			result = result + Math.max(B1, B2);
		}
		
		
		return result;
	}
}
