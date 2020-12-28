package com.kurshit.leetcode.lccurated.easy;

/*
 * Problem: 1165
 * 
 * Source URL : https://leetcode.com/problems/single-row-keyboard/
 * 
 * There is a special keyboard with all keys in a single row.

	Given a string keyboard of length 26 indicating the layout of the keyboard (indexed from 0 to 25), initially your finger is at index 0. To type a character, you have to move your finger to the index of the desired character. The time taken to move your finger from index i to index j is |i - j|.
	
	You want to type a string word. Write a function to calculate how much time it takes to type it with one finger.
	
	Input: keyboard = "abcdefghijklmnopqrstuvwxyz", word = "cba"
	Output: 4
	Explanation: The index moves from 0 to 2 to write 'c' then to 1 to write 'b' then to 0 again to write 'a'.
	Total time = 2 + 1 + 1 = 4. 
 */

public class SingleRowKeyboard {

	public static void main(String[] args) {
		String keyboard = "abcdefghijklmnopqrstuvwxyz";
		String word = "cba";
		System.out.println(getTimeTaken(keyboard, word));
		keyboard = "pqrstuvwxyzabcdefghijklmno";
		word = "leetcode";
		System.out.println(getTimeTaken(keyboard, word));
		

	}
	
	public static int getTimeTaken(String keyboard, String word) {
		
		// Index of this array will indicate a character of a keyword/word. THe values at these indexes are actual indexes
		// given in input keyboard string.
		
		int[] kb = new int[26];
		
		for(int i=0; i < keyboard.length(); i++) {
			int index = keyboard.charAt(i) - 'a';
			kb[index] = i;
		}
		
		int ans = 0;
		int last = 0;
		for(int i=0; i < word.length(); i++) {
			int index = word.charAt(i) - 'a';
			int curr = kb[index];
			
			ans = ans + Math.abs(curr - last);
			last = curr;
		}
		
		return ans;
	}
	
}
