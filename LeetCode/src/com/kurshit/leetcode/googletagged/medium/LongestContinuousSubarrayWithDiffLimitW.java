package com.kurshit.leetcode.googletagged.medium;

/*
 * Problem SOurce : https://leetcode.com/problems/longest-continuous-subarray-with-absolute-diff-less-than-or-equal-to-limit/
 * Longest Continuous Subarray With Absolute Diff Less Than or Equal to Limit
 */

import java.util.TreeMap;

public class LongestContinuousSubarrayWithDiffLimitW {
	
	public static void main(String[] args) {
		int[] nums = {10, 1, 2, 4, 7, 2};
		System.out.println(longestSubarray(nums, 5));
		
		int[] nums1 = {4, 2, 2, 2, 4, 4, 2, 2};
		System.out.println(longestSubarray(nums1, 0));
		
		
		
	}
	
	public static int longestSubarray(int[] nums, int limit) {
		
		int result = 1;
		int N = nums.length;
		int i =0;
		
		TreeMap<Integer, Integer> treeMap = new TreeMap<>(); // <number, last index>
		//{10, 1, 2, 4, 7, 2}
        for (int j = 0; j < N; j++)
        {
            treeMap.put(nums[j], j);
            
            // The newly added number is max or min number if > limit
            while (treeMap.lastKey() - treeMap.firstKey() > limit)
            {
                // Remove the min number if the newly added number is the max number
                if (nums[j] == treeMap.lastKey())
                {
                    int minIdx = treeMap.pollFirstEntry().getValue(); // Index of the min numbers
                    i = Math.max(i, minIdx + 1);
                }
                else // Remove the max number if the newly added number is the min number
                {
                    int maxIdx = treeMap.pollLastEntry().getValue(); // Index of the max numbers
                    i = Math.max(i, maxIdx + 1);
                }
            }
            
            result = Math.max(result, j-i+1);
        }
        
        return result;		
		
	}
}
