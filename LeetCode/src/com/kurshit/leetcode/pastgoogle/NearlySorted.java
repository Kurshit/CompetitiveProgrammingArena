package com.kurshit.leetcode.pastgoogle;

import java.util.Arrays;

/*
 * Source : https://leetcode.com/discuss/interview-question/930843/Google-or-L3-or-Onsite
 * Given a sorted n-size array, there are k elements have been changed i.e. [1, 3, 5, 6, 4, 2, 12] 
 * (it might be changed from [1, 3, 5, 6, 7, 8, 12] with k = 2). Important to know is that k is unknown and k is much smaller than n. 
 * The task is to re-sort the entire array.
 * Approach: 
 * 	 a. break the array into two: one sorted array and one unsorted array e.g. [1, 3, 5, 12] and [6, 4, 2]. This takes O(n) 
 * b. Sort the unsorted array. This takes O(klogk) c. Merge two sorted arrays. This takes O(n). 
 * Because k is very small, so in the end O(n) + O(klogk) ~= O(n).
 */

public class NearlySorted {

	public static void main(String[] args) {
		
		int[] arr = {1, 3, 5, 6, 4, 2, 12};
		sort(arr, arr.length);
		
		for(int i : arr) {
			System.out.print(i + " ");
		}
	}
	
	public static int[] sort(int[] arr, int N) {
		
		int[] arr1 = new int[N];
		int[] arr2 = new int[N];
		int s1 = 0, s2=0;
		int lastElement = Integer.MIN_VALUE;
		for(int i=0; i < N; i++) {
			if(arr[i] > lastElement) {
				arr1[s1] = arr[i];
				s1++;
				lastElement = arr[i];
			} else {
				arr2[s2] =arr[i];
				s2++;
			}
		}
		
		Arrays.sort(arr2, 0, s2);
		
		int i =0;
		int j = 0;
		int k = 0;
		while(i < s1 && j < s2) {
			if(arr1[i] < arr2[j]) {
				arr[k] = arr1[i];
				i++;
			} else {
				arr[k] = arr2[j];
				j++;
			}
			k++;
		}
		
		while(i < s1) {
			arr[k] = arr1[i];
			k++;
			i++;
		}
		
		while(j < s2) {
			arr[k] = arr2[j];
			k++;
			j++;
		}
		
		return arr;
	}
	
	

}
