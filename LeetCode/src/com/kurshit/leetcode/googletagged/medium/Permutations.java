package com.kurshit.leetcode.googletagged.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/*
 * Problem source : https://leetcode.com/problems/permutations/
 * 
 * Solution : Backtracking it - https://leetcode.com/problems/permutations/solution/
 * 
 *  Formulae is - P(N,K) :  N ! /(N-K) !
 *  
 *  In this case , K is 0. We need to generate all permutations
 *  
 *  So - P(N) :  N!     // 0! - 1
 *  
 */

public class Permutations {

	public static void main(String[] args) {
		
		int[] nums = {1, 2, 3};
		
		List<List<Integer>> list = permute(nums);
		
		//expected total outputs - 3! -> 6 difft values
		
		for(List<Integer> l : list) {
			System.out.println(l);
		}

	}
	
	//The approach is based on backtrack
	
	public static List<List<Integer>> permute(int[] nums) {
		
		List<List<Integer>> result = new LinkedList<>();
		
		List<Integer> numsList = new ArrayList<>();
		
		for(int i: nums) {
			numsList.add(i);
		}
		
		backtrack(numsList, nums.length, result, 0);
		
		return result;
	}

	private static void backtrack(List<Integer> numsList, int N,  List<List<Integer>> result, int first) {
		
		if(first == N) {
			// We need to create new list as numsList will be mutated further
			result.add(new ArrayList<>(numsList));  
		}
		
		for(int i = first; i < N; i++) {
			Collections.swap(numsList, first, i);
			backtrack(numsList, N, result, first + 1);
			Collections.swap(numsList, first, i); // we will reset after backtracking it
		}
		
	}

}
