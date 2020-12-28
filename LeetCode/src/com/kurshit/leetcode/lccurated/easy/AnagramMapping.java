package com.kurshit.leetcode.lccurated.easy;

/* Problem : 760
 * Source URL : https://leetcode.com/problems/find-anagram-mappings/
 * Given two lists A and B, and B is an anagram of A. B is an anagram of A means B is made by randomizing the order of the elements in A.

	We want to find an index mapping P, from A to B. A mapping P[i] = j means the ith element in A appears in B at index j.
	
	These lists A and B may contain duplicates. If there are multiple answers, output any of them.
	
	For example, given
	
	A = [12, 28, 46, 32, 50]
	B = [50, 12, 32, 46, 28]

 * 
 */

import java.util.HashMap;
import java.util.Map;

public class AnagramMapping {
	
	public static void main(String[] args) {
		
		int[] A = {12, 28, 46, 32, 50};
		int[] B = {50, 12, 32, 46, 28};
		
		int[] res = anagramMappings(A, B);
		
		for(int i : res) {
			System.out.print(i + " ");
		}
		
	}
	
	public static int[] anagramMappings(int[] A, int[] B) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i= 0; i < B.length; i++) {
			map.putIfAbsent(B[i], i);
		}
		int[] result = new int[B.length];
		for(int i=0; i < A.length; i++) {
			result[i] = map.get(A[i]);
		}
		
		return result;
	}
}
