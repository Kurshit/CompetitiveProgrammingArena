package com.kurshit.leetcode.pastgoogle;

/*
 * Problem Source  : https://leetcode.com/discuss/interview-question/350800/Google-or-Onsite-or-Chocolate-Sweetness
 * Leetcode same problem: https://leetcode.com/problems/divide-chocolate/
 * Problem :
 * Given an array chocolate of n non-negative integers, where the values are sweetness levels of the chocolate. 
 * You are also given a value k which denotes the number of friends you will share this chocolate with. 
 * Your friends are greedy so they will always take the highest sweetness chunk. Find out what is the maximum sweetness 
 * level you could get.
 * 

	Split the array into k non-empty continuous subarrays. Write an algorithm to maximize the minimum sum among these 
	k subarrays. 
	
	Example:

	Input: chocolate = [6, 3, 2, 8, 7, 5], k = 3
	Output: 9
	Explanation:
	The values in array are sweetness level in each chunk of chocolate. Since k = 3, so you have to divide this array in 3 pieces,
	such that you would get maximum out of the minimum sweetness level. So, you should divide this array in
	[6, 3] -> 6 + 3 = 9
	[2, 8] -> 2 + 8 = 10
	[7, 5] -> 7 + 5 = 12
	Your other two friends will take the sweetest chunk, so they will take 12 and 10. The maximum sweetness level you could get is 9.

 */


public class ChodolateSweetness {

	public static void main(String[] args) {
		ChodolateSweetness m = new ChodolateSweetness();
		int[] arr = {6, 3, 2, 8, 7, 5};
		int K = 3;
		System.out.println(m.minSweetness(arr, K));
		
		int[] arr1 = {7, 2, 5, 10, 8};
		K = 2;
		System.out.println(m.minSweetness(arr1, K));
	}
	//{6, 3, 2, 8, 7, 5}
	public int minSweetness(int[] chocolate, int k) {
		int lo = getMin(chocolate);
		int hi = getSum(chocolate);	
		
		while (lo < hi) {
			int mid = (lo + hi) / 2;
			if (split(chocolate, mid) <=k) {
					hi = mid - 1;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
	//{6, 3, 2, 8, 7, 5}
	private int split(int[] chocolate, int minSweetness) {
		int peopleCount = 0;
		int sweetness = 0;
		for (int val : chocolate) {
			sweetness = sweetness + val;
			if (sweetness > minSweetness) {
				peopleCount++;
				sweetness = val;
			}
		}
		return peopleCount;
	}

	private int getMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		for (int val : arr) {
			min = Math.min(min, val);
		}
		return min;
	}

	private int getSum(int[] arr) {
		int sum = 0;
		for (int val : arr) {
			sum += val;
		}
		return sum;
	}

	
}