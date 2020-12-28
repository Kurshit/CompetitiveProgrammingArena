package com.kurshit.leetcode.googletagged.medium;

public class KthMissingElementStartingFromFirst {

	public static void main(String[] args) {
		
		int[] arr =  {4, 7, 9, 10};
		int K = 1;
		System.out.println(getKthMissingNumber(arr, K));
				
		K = 3;
		System.out.println(getKthMissingNumber(arr, K));
		
		int[] arr2 =  {1, 2, 4};
		K = 3;
		System.out.println(getKthMissingNumber(arr2, K));

	}
	
	/*
	 * TC : O(N+K)
	 */
	public static int getKthMissingNumber(int[] arr, int K) {
		
		if(arr.length == 0)
			return 0;
		
		int start = arr[0];
		int count = 0;
		int result = -1;
		
		int last = arr[arr.length - 1];
		int i =0;
		while(start < last) {
			int curr = arr[i];
			
			if(start == curr) {
				start++;
				i++;
			} else {
				count++;
				
				if(count == K) {
					result = start;
					break;
				}
				start++;
			}
		}
		
		if(count != K) {
			result = start + (K-count);
			
		}
		
		return result;
	}

}
