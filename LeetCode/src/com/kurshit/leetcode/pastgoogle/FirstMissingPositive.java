package com.kurshit.leetcode.pastgoogle;

/*
 * Problem Source : https://leetcode.com/discuss/interview-question/900991/Google-or-Phone-or-First-Missing-Positive
 * Problem How do you find smallest non-negative integer that doesn't exist in the given array (including zero)

 *	array can have duplicates

	follow up:

	can you do it with space complexity O(1)?
	Answer:

	Sort the array
	remove negatives
	return if difference between two numbers is bigger than 1
 */

public class FirstMissingPositive {

	public static void main(String[] args) {
		int[] arr = {3,4,-1,1};
		
		System.out.println(firstMissingPositive(arr));
		
		int[] arr2 = {7,8,9,11,12};
		System.out.println(firstMissingPositive(arr2));
	}


	public static int firstMissingPositive(int[] nums) {
		int n = nums.length;

		// Base case.
		int contains = 0;
		for (int i = 0; i < n; i++)
			if (nums[i] == 1) {
				contains++;
				break;
			}

		if (contains == 0)
			return 1;

		// nums = [1]
		if (n == 1)
			return 2;

		// Replace negative numbers, zeros,
		// and numbers larger than n by 1s.
		// After this convertion nums will contain 
		// only positive numbers.
		for (int i = 0; i < n; i++)
			if ((nums[i] <= 0) || (nums[i] > n))
				nums[i] = 1;

		// Use index as a hash key and number sign as a presence detector.
		// For example, if nums[1] is negative that means that number `1`
		// is present in the array. 
		// If nums[2] is positive - number 2 is missing.
		for (int i = 0; i < n; i++) {
			int a = Math.abs(nums[i]);
			// If you meet number a in the array - change the sign of a-th element.
			// Be careful with duplicates : do it only once.
			if (a == n)
				nums[0] = - Math.abs(nums[0]);
			else
				nums[a] = - Math.abs(nums[a]);
		}

		// Now the index of the first positive number 
		// is equal to first missing positive.
		for (int i = 1; i < n; i++) {
			if (nums[i] > 0)
				return i;
		}

		if (nums[0] > 0)
			return n;

		return n + 1;
	}


}
