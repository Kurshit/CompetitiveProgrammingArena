package com.kurshit.google.leetcode.arraysandstrings;

/*
 * Source : https://leetcode.com/explore/interview/card/google/59/array-and-strings/3047/
 * 
 * Problem : Given a string s, find the length of the longest substring without repeating characters.
 * 
 * Constraint : s consists of English letters, digits, symbols and spaces.
 * 
 * Example 1:
 * 		Input: s = "abcabcbb"
 * 		Output: 3
 *		
 *		Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2: 
 * 		Input: s = "bbbbb"
 * 		Output: 1
 * 		Explanation: The answer is "b", with the length of 1.
 * 
 * Example:
 * 		Input : s ="";
 * 		Output : 0
 */

public class LongestSubstringWithoutRepeatition {

	public static void main(String[] args) {
		
		String s = "abcabcb";
		System.out.println(lengthOfLongestSubstring(s));
		s = "bbbb";
		System.out.println(lengthOfLongestSubstring(s));
		s = "pwwkew";
		System.out.println(lengthOfLongestSubstring(s));
		s = "au";
		System.out.println(lengthOfLongestSubstring(s));
		s = "";
		System.out.println(lengthOfLongestSubstring(s));
		s = " ";
		System.out.println(lengthOfLongestSubstring(s));

	}
	
	public static int lengthOfLongestSubstring(String s) {
		int max = 0;
		String temp = "";
		if(s.length() == 1) {
			return 1;
		}
		for(int i = 0; i < s.length(); i++) {
			temp = String.valueOf(s.charAt(i));
			
			for(int j = i+1; j < s.length(); j++) {
				if(temp.contains(String.valueOf(s.charAt(j)))) {
					break;
				} else {
					temp += s.charAt(j);
				}
			}
			
			max = Math.max(max, temp.length());
		}
		
		return max;
	}

}
