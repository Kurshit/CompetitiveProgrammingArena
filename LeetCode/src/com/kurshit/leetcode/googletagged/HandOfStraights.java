package com.kurshit.leetcode.googletagged;

/*
 * Problem source : https://leetcode.com/problems/hand-of-straights/
 * 
 * Problem: Alice has a hand of cards, given as an array of integers.

	Now she wants to rearrange the cards into groups so that each group is size W, and consists of W consecutive cards.
	
	Return true if and only if she can.
 *	Note: This question is the same as 1296: https://leetcode.com/problems/divide-array-in-sets-of-k-consecutive-numbers/
 *
 *	Input: hand = [1,2,3,6,2,3,4,7,8], W = 3
	Output: true
	Explanation: Alice's hand can be rearranged as [1,2,3],[2,3,4],[6,7,8]
	
	Note : The created group will have unique values only
 *
 */

import java.util.TreeMap;

public class HandOfStraights {

	public static void main(String[] args) {
		int[] nums = {1,2,3,6,2,3,4,7,8};
		int W = 3;
		System.out.println(hasHandOfStraights(nums, W));
		
		int[] nums1 = {1,2,3,4,5};
		W = 4;
		System.out.println(hasHandOfStraights(nums1, W));
		
		int[] nums2 = {1,2,2,3,3,4,7,8,9};
		W = 3;
		System.out.println(hasHandOfStraights(nums2, W));
		
		int[] nums3 = {1,2,2,3,4,4,7,8,9};
		W = 3;
		System.out.println(hasHandOfStraights(nums3, W));

	}
	
	/*
	 * Approach : O(n2)
	 * 
	 *  Create a TreeMap with freqeuncies of each card. Now untill the TreeMap is empty, retrive firstKey() always from map and in group of W,
	 *  keep removing elements from key one at a time. While doing so, update frequency count from map.
	 */
	
	public static boolean hasHandOfStraights(int[] nums, int W) {
		
		TreeMap<Integer, Integer> map = new TreeMap<>();
		
		for(int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		
		while(!map.isEmpty()) {
			
			int firstKey = map.firstKey();
			
			for( int card = firstKey; card < firstKey + W; card++) {
				
				if(!map.containsKey(card))
					return false;
				
				int count = map.get(card);
				
				if(count == 1)
					map.remove(card);
				else {
					map.put(card, count-1);
				}
				
			}	
			
		}
		
		return true;		
		
	}

}
