package com.kurshit.codeforces.challnges.longer21.january;

import java.util.Arrays;
import java.util.Scanner;

public class BLKJK {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				int N = sc.nextInt();
				int X = sc.nextInt();
				int Y = sc.nextInt();
				int[] arr = new int[N];
				
				for(int i=0; i < N; i++) {
					arr[i] = sc.nextInt();
				}
				Arrays.sort(arr);
				int[] BIT = createBIT(arr, N);
				
				getMaxSwaps(arr, N, X, Y, BIT);
				
			}
			
			
		}catch(Exception e) {
			
		} finally {
			sc.close();
		}

	}
	
	public static int getMaxSwaps(int[] arr, int N, int X, int Y, int[] BIT) {
		
		int count = 0;
		
		int xfloorIdx = getFloor(BIT, X);
		
		if(xfloorIdx != -1 && BIT[xfloorIdx] == X) {
			return 0;
		}
		
		if(xfloorIdx != -1 && xfloorIdx == N-1) {
			return -1;
		}
		
		int yfloorIdx = getFloor(BIT, Y);
		
		if(xfloorIdx == -1 && yfloorIdx == -1) {
			return -1;
		}
		
		
		
		
		return 0;
	}
	
	public static int getFloor(int[] arr, int key) {
		return getFloor(arr, 0, arr.length - 1, key);
	}

	public static int getFloor(int arr[], int low, int high, int key) 
	{ 

		while(low <= high) {

			// If last element is smaller than x 
			if (key >= arr[high]) 
				return high; 

			// Find the middle point 
			int mid = (low + high) / 2; 

			// If middle point is floor. 
			if (arr[mid] == key) 
				return mid; 

			// If key lies between mid-1 and mid 
			if (mid > 0 && arr[mid - 1] <= key && key < arr[mid]) 
				return mid - 1; 

			// If key is smaller than mid, floor 
			// must be in left half. 
			if (key < arr[mid])  
				high = mid - 1;
			else 	
				low = mid + 1;

		}
		
		return -1;
	}

	

	
	public static int getSum(int[] BIT, int idx) {
		int sum =0;
		
		idx = idx +1;
		
		while(idx > 0) {
			sum = sum + BIT[idx];
			idx = idx - (idx & (-idx));
		}
		
		return sum;
	}
	
	/*
	 * arr - is input array of size N
	 */
		
	public static int[] createBIT(int[] arr, int N) {
		
		int[] BIT = new int[N+1];
		
		for(int i=0; i < N; i++) {
			updateBIT(BIT, N, i, arr[i]);
		}
		
		return BIT;
	}
	
	/*
	 * This update function does NOT directly replaces the new value. But adds this value to exisiting index and recomputes the presum.
	 * This is basically addValue()
	 */
	public static void updateBIT(int[] BIT, int N, int idx, int value) {
		
		idx = idx +1;
		
		while(idx <= N) {
			BIT[idx] = BIT[idx] + value;
			idx = idx + (idx & (-idx));
		}
		
	}



}
