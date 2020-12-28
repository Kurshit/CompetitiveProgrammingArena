package com.kurshit.leetcode.pastgoogle;

/*
 * Source : https://leetcode.com/discuss/interview-question/758045/
 * 
 * Varient of - Same as ShortestSubarrayWithSumLeastK
 * 
 * 
 */

public class LongestSubarrayWithSumAtMostK {

	public static void main(String[] args) {
		int[] arr = {5,-10,7,-20,57};
		int K = -22;
		System.out.println(longestSubArrayWithSumAtMostK(arr, K)); //{-10,7,-20} -> 3

	}
	
	public static int longestSubArrayWithSumAtMostK(int[] arr, int K) {
		int N = arr.length;
		int s = 0;
		int ans = 0;
		
		int[] temp = new int[N];
		
		for(int i=0; i < N; i++) {
			s = s + arr[i];
			if(s <= K) 
				ans = i +1;
			else {
				while( ( i-ans > 0) && temp[i- ans - 1] >= s - K) {
					ans++;
				}
			}
			
			if(i == 0)
				temp[i] = s;
			else {
				temp[i] = Math.max(temp[i-1], s);
			}
		}
		
		return ans;
	}

}
