package com.kurshit.codeforces.oct.challange;

import java.util.Arrays;
import java.util.Scanner;

public class ReplaceX2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			int T = sc.nextInt();

			while(T-- > 0) {
				ReplaceX2 r = new ReplaceX2();
				System.out.println(r.solve(sc));
			}
		}catch(Exception e) {
			
		}

		sc.close();
	}

/*	public int solve(Scanner sc) {

		int N = sc.nextInt();
		int X = sc.nextInt();
		int P = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N+1];

		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int indexOfX = Arrays.binarySearch(arr, X);
		int count = 0;
		if(indexOfX <0) {
			return -1;
		}

		
		Arrays.sort(arr);
		indexOfX = Arrays.binarySearch(arr, X);
		
		if(P < K && P < indexOfX) {
			return -1;
		}

		return Math.abs(P - indexOfX) + count;

	}*/
	
	public int solve(Scanner sc) {

		int N = sc.nextInt();
		int X = sc.nextInt();
		int P = sc.nextInt();
		int K = sc.nextInt();

		int[] arr = new int[N+1];

		for(int i=1; i<=N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int count = 0;
		Arrays.sort(arr);
		
		if(arr[P] == X) {
			return 0;
		}		
		else if( K >= P && arr[P] >= X) {
						
			int ix = Arrays.binarySearch(arr, X);		
			
			if(ix < 0) {
				arr[K] = X;
				Arrays.sort(arr);
				count = count + 1;
				ix = Arrays.binarySearch(arr, X);
			}
			
			while( ix < N && arr[ix] == arr[ix+1]) {
				ix = ix  +1;
			}
			
			if(ix == P && count !=0) {
				return 1;
			}else  if(ix == P) {
				return 0;
			}
			
			return Math.abs(P - ix) + count;
			
		} else if(K <= P && arr[P] <= X ) {
			int ix = Arrays.binarySearch(arr, X);			
						
			if(ix < 0) {
				arr[K] = X;
				Arrays.sort(arr);
				count = count + 1;
				ix = Arrays.binarySearch(arr, X);
			}
			
			while( ix > 0 && arr[ix] == arr[ix-1]) {
				ix = ix -1;
			}
			
			if(ix == P && count !=0) {
				return 1;
			}else  if(ix == P) {
				return 0;
			}
			
			return Math.abs(P - ix) + count;
			
			
		} else {
			return -1;
		}
		
	}
}
