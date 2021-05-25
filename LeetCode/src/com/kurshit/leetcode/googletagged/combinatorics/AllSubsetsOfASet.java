package com.kurshit.leetcode.googletagged.combinatorics;

/*
 * Problem src : https://leetcode.com/problems/subsets/
 * Problem Statement: Given an integer array nums of unique elements, return all possible subsets (the power set).

 *	The solution set must not contain duplicate subsets. Return the solution in any order.
 *
 * Example: nums = [1,2,2]
 * 
 * Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.List;

public class AllSubsetsOfASet {

	public static void main(String[] args) {

		System.out.println("Approach 2 : Using Recurssion " );
		int[] arr = {1, 2 , 3 };
		printSubsetsUsingRecurssion(arr, 3);
		
		System.out.println("Approach 2 : Using Backtracking " );
		printSubsetsUsingBacktracking(arr, 3);
		
		System.out.println("Approach 3 : Using backtracking but different output");
		System.out.println(subsets(arr));

	}
	
	/*
	 * Approach 1 : Using recursion
	 * 
	 * We have two option for every element of array 
	 * 		- To include it
	 * 		- Not to include it
	 * 
	 */
	
	public static void printSubsetsUsingRecurssion(int[] arr, int N) {
		
		printSubsetsUsingRecurssion(arr, N,  "", 0);
		
	}


	private static void printSubsetsUsingRecurssion(int[] arr, int N, String result, int idx) {
		
		if(idx == N) {
			System.out.println(result);
		} else {			 
				int c = arr[idx];
				printSubsetsUsingRecurssion(arr, N, result + c, idx + 1);
				printSubsetsUsingRecurssion(arr, N, result, idx + 1);						
		}		
	}
	
	/*
	 * Approach 2 : Using backtracking
	 * 
	 */
	
	public static void printSubsetsUsingBacktracking(int[] arr, int N) {
		List<Integer> list = new ArrayList<>();
		printSubsetsUsingBacktrackingUtil(arr, N, list, 0);
	}


	private static void printSubsetsUsingBacktrackingUtil(int[] arr, int N, List<Integer> list, int idx) {
		
		if(idx == N) {
			if(!list.isEmpty()) {
				System.out.println(list);
			}
			
			return;
		} 
	
		list.add(arr[idx]);
		printSubsetsUsingBacktrackingUtil(arr, N, list, idx + 1);
		list.remove(list.size() - 1);
		printSubsetsUsingBacktrackingUtil(arr, N, list, idx + 1);
		
	}
	
	/*
	 * Different Output : Output in List<List<Integer>>
	 * 
	 */
	
	 public static List<List<Integer>> subsets(int[] nums) {
	        
	        List<List<Integer>> result = new ArrayList<>();
	        
	        result.add(new ArrayList<>());
	        
	        subsets(nums, result);
	        
	        return result;
	    }
	    
	    public static void subsets(int[] nums, List<List<Integer>> result) {
	        
	        List<Integer> list = new ArrayList<>();
	        subsets(nums, nums.length, result, list,0);
	        
	    }
	    
	    public static void subsets(int[] nums, int N, List<List<Integer>> result, List<Integer> list, int idx ) {
	        
	        if(idx == N) {
	            if(!list.isEmpty()) {
	                result.add(new ArrayList<Integer>(list));
	            }
	            return;
	        }
	        
	        list.add(nums[idx]);
	        subsets(nums,N,result,list,idx+1);
	        list.remove(list.size()-1);
	        subsets(nums,N,result,list,idx+1);
	        
	    }
}
