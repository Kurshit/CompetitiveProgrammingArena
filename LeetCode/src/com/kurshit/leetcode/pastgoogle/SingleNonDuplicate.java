package com.kurshit.leetcode.pastgoogle;

/*
 * Source : https://leetcode.com/problems/single-element-in-a-sorted-array/solution/
 * 
 * Problem: You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

 * Follow up: Your solution should run in O(log n) time and O(1) space.
 * 
 * Ex:  Input: nums = [1,1,2,3,3,4,4,8,8]
 * 		Output: 2
 * 
 * Ex:  Input: nums = [3,3,7,7,10,11,11]
		Output: 10
 */


public class SingleNonDuplicate {

	public static void main(String[] args) {
		int[] arr = {1,1,2,3,3,4,4,8,8};
		System.out.println(getSingleElement(arr));
	}
	
	/*
	 * Approach : Do the binary search on even index. If you notice, if no had not been missing, the pair would always start 
	 * at even index and end at odd index 
	 * 	arr:    1, 1, 2, 3, 3, 4, 4, 8, 8
	 *  indexs: 0  1  2  3  4  5  6  7  8
	 *  
	 *  Now just do binary search on these index and check mid and mid+1 element. If those are not equal, it means the result
	 *  is in left half of array. If equal, then to the right of it.
	 *  
	 *  Note: Have check of mid % 2 == 0 to confirm mid is always at even index
	 */
	public static int getSingleElement(int[] arr) {
		
		int low = 0;
		int high = arr.length;
		
			
		while(low < high) {
			
			int mid = (low + high) / 2;
			
			if(mid %2 != 0)
				mid--;
			//if sequence is right - even index will have first digit followed by its pair on odd index
			if(arr[mid] == arr[mid+1]) {
				low = mid + 2;
			} else {
				high = mid;
			}
		}
		
		return arr[low];
	}
	
	

}
