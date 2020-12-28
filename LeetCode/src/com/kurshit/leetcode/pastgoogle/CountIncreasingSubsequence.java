package com.kurshit.leetcode.pastgoogle;

/*Problem SOurce : https://leetcode.com/discuss/interview-question/661336/Google-or-Onsite-or-Count-Increasing-Subsequences
 * Problem: 
 * Given an array arr of size n. Find the number of triples (i, j, k) where:
	
	i < j < k
	arr[i] < arr[j] < arr[k]
	
	Example :
	
		Input: arr = [1, 2, 3, 4, 5]
	Output: 10
	Explanation:
	1. 1 2 3
	2. 1 2 4
	3. 1 2 5
	4. 1 3 4
	5. 1 3 5
	6. 1 4 5
	7. 2 3 4
	8. 2 3 5
	9. 2 4 5
	10. 3 4 5
 * 
 */

public class CountIncreasingSubsequence {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 5};
		int[] nums2 = {1, 2, 3, 5, 4};
		int[] nums3 = {5, 4, 3, 2, 1};
		System.out.println(solve(nums1, 3));
		System.out.println(solve(nums2, 3));
		System.out.println(solve(nums3, 3));
		System.out.println(solve(nums1, 4));
	}

	private static int solve(int[] nums, int k) {
		int[][] dp = new int[k][nums.length];
		for (int i = 0; i < nums.length; i++)
	        dp[0][i] = 1; 
		for (int l = 1; l < k; l++) { 
			for (int i = l; i < nums.length; i++) {
	            for (int j = l - 1; j < i; j++) { 
	                if (nums[j] < nums[i]) { 
	                    dp[l][i] += dp[l - 1][j]; 
	                } 
	            } 
			}	  
		}
		int res = 0;
		for (int i = k - 1; i < nums.length; i++) { 
	        res += dp[k - 1][i]; 
	    } 
		return res;
	}
}
