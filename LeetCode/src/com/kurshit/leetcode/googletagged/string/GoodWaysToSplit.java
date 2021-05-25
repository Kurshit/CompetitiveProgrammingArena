package com.kurshit.leetcode.googletagged.string;

import java.util.HashSet;
import java.util.Set;

/*
 * Problem Src : https://leetcode.com/problems/number-of-good-ways-to-split-a-string/
 * Problem Statement : You are given a string s, a split is called good if you can split s into 2 non-empty strings p and q where its 
 * concatenation is equal to s and the number of distinct letters in p and q are the same.
 * 
 * Return number of good splits you can make in S.
 * 
 * Example : s = "aacaba"
 * 
 * Output: 2
 * 
 * 	Explanation: There are 5 ways to split "aacaba" and 2 of them are good. 
 * ("a", "acaba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aa", "caba") Left string and right string contains 1 and 3 different letters respectively.
 * ("aac", "aba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aaca", "ba") Left string and right string contains 2 and 2 different letters respectively (good split).
 * ("aacab", "a") Left string and right string contains 3 and 1 different letters respectively.
 * 
 * Example 2: s = "abcd"
 * Output: 1
 */


public class GoodWaysToSplit {

	public static void main(String[] args) {
		
		String s = "aacaba";
		
		System.out.println(goodSplits(s));

	}
	
	/*
	 * Approach : Calculate the prefix and suffix array for given string.
	 * pref[] - for each int i - pref[i] will tell number of distinct characters till index i from Left of string.
	 * suff[] - fr each int i - suff[i] will tell number of dictinct characters till index i from right of string.
	 * 
	 */
	
	public static int goodSplits(String str) {
		
		int result = 0;
		
		int N = str.length();
		Set<Character> unique = new HashSet<>();
		
		int[] pref = new int[N];
		int[] suff = new int[N];
		
		for(int i =0; i < N; i++) {
			unique.add(str.charAt(i));
			pref[i] = unique.size();
		}
		
		unique.clear();
		
		for(int i= N-1; i >=0; i--) {
			unique.add(str.charAt(i));
			suff[i] = unique.size();
		}
		
		for(int i=0; i < N-1; i++) {
			if(pref[i] == suff[i+1])
				result++;
		}
		
		return result;
	}
	
	

}
