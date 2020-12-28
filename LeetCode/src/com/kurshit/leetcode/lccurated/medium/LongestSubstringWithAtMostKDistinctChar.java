package com.kurshit.leetcode.lccurated.medium;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/*
 * Given a string s , find the length of the longest substring t  that contains at most K distinct characters.

	Example 1:

	Input: "eceba", K = 2
	Output: 3
	Explanation: t is "ece" which its length is 3.
 */

public class LongestSubstringWithAtMostKDistinctChar {

	public static void main(String[] args) {

		String s = "eceba";
		int K = 2;
		System.out.println(getLongestSubstringWithKDistinctCharacters(s, K));


		s = "ccaabbb";
		K = 2;
		System.out.println(getLongestSubstringWithKDistinctCharacters(s, K));


	}

	public static int getLongestSubstringWithKDistinctCharacters(String s, int K) {

		int i = 0;
		int j = 0;
		int maxLength = 0;
		Map<Character, Integer> map = new HashMap<>();

		while(j < s.length()) {

			char currChar = s.charAt(j);

			map.put(currChar, j);
						
			if(map.size() == K+1) {
				int lastSeenCharIndex = Collections.min(map.values());
				map.remove(s.charAt(lastSeenCharIndex));
				i = lastSeenCharIndex + 1;
				

			} 
			
			maxLength = Math.max(maxLength, j-i+1);

			j++;

		}

		return maxLength;

	}

}
