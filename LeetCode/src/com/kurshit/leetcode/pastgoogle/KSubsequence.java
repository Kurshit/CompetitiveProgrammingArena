package com.kurshit.leetcode.pastgoogle;

import java.util.Objects;

/*
 * Source : https://leetcode.com/discuss/interview-question/930843/Google-or-L3-or-Onsite
 * 
 * Problem : 
 * 		Given an array i.e. [1, 2, 3, 5, 6, 7, 8] and a value k i.e. 3. 
 * If there is a subarray with length of 2k satisfies a sequence [a, a + 1, a + 2 ... a + k - 1, b, b + 1, b + 2... b + k - 1]. 
 * Return the beginning index of this subarray. So with given array [1, 2, 3, 5, 6, 7, 8] and k = 3, it can return 0 as [1, 2, 3, 5, 6, 7] 
 * satisfies the sequence requirement. 
 * If with given array [1, 3, 5, 6, 7, 8] and k = 3, it return -1 as there is no such subarray exsits.
 */

public class KSubsequence {

	public static void main(String[] args) {
		int[] arr = {1,2,3,5,6,7,9};
		int k = 3;
		System.out.println(getIdxSubArr(arr, k));
		int[] arr1 = {1,3,5,6,7,8};
		k = 3;
		System.out.println(getIdxSubArr(arr1, k));
		
		int[] arr2 = {1,5,6,7,10,11,12,18};
		k = 3;
		System.out.println(getIdxSubArr(arr2, k));
	}
	
	 public static int getIdxSubArr(int[] nums, int k) {
	        Objects.requireNonNull(nums);
	        
	        if (nums.length < k*2 || k < 0) 
	        	return -1;
	        
	        if (k <= 1) return 0;

	        boolean isValidHalf = false;
	        int count = 1;
	        int target = k*2;
	        
	        for (int i = 1; i < nums.length; i++) {
	            if (nums[i] - nums[i-1] == 1) {
	                count++;
	                if (count == target || (isValidHalf && count == k))
	                    return i - target + 1;
	            }
	            else {
	                isValidHalf = count >= k;
	                count = 1;
	            }
	        }
	        return -1;
	    }

}
