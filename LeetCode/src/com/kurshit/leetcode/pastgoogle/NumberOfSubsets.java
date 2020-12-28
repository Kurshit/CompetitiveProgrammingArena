package com.kurshit.leetcode.pastgoogle;

/*
 * https://leetcode.com/discuss/interview-question/268604/Google-or-Onsite-or-Number-of-subsets
 * 
 * For a given list of integers and integer K, find the number of non-empty subsets S such that min(S) + max(S) <= K.

	Example 1:
	
	nums = [2, 4, 5, 7]
	k = 8
	Output: 5
	Explanation: [2], [4], [2, 4], [2, 4, 5], [2, 5]
	Example 2:
	
	nums = [1, 4, 3, 2]
	k = 8
	Output: 15
	Explanation: 16 (2^4) - 1 (empty set) = 15
 */

import java.util.Arrays;

public class NumberOfSubsets {

	public static void main(String[] args) {
		int[] nums1 = {2, 1, 3, 4};
		System.out.println(countSubsets(nums1, 8)); // 15

		int[] nums2 = {2, 4, 5, 7};
		System.out.println(countSubsets(nums2, 8)); // 5
	}

	public static int countSubsets(int[] nums, int k) {
		Arrays.sort(nums);
		int count = 0;
		
		int lo = 0;
		int hi = nums.length - 1;
		while(lo <= hi) {
			if (nums[lo] + nums[hi] > k) {
				hi--;
			} else {
				//count = count + (1 << (hi - lo));
				count = count + (int) Math.pow(2, hi-lo);
				lo++;
			}
		}
		return count;
	}
}
