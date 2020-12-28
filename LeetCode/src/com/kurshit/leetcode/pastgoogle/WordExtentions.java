package com.kurshit.leetcode.pastgoogle;

/* Problem SOurce : https://leetcode.com/discuss/interview-question/345065/Google-or-Word-Extensions
 * When people send messages on their phones they sometimes modify word spelling by adding extra letters for emphasis. 
 * For example, if you want to emphasize hello you might write it hellloooooooo. Let's call the ls and the os word extensions. 
 * Regular text contains 2 or fewer of the same character in a row, while word extensions have 3 or more of the same character 
 * in a row. Given an input string representing one word, write a method that returns the start and end indices of all 
 * extensions in the word.
 * 
 * Example 1:

	Input: "whaaaaatttsup"
	Output: [[2, 6], [7, 9]]
	Explanation: 
	"aaaaa" and "ttt" are twitching letters, so output their starting and ending points.
	Example 2:
	
	Input: "hellloooooooo"
	Output: [[2, 4], [5, 12]]
	
 */

import java.util.ArrayList;
import java.util.List;

public class WordExtentions {

	public static void main(String[] args) {
		
		String s = "whaaaaatttsup";
//		System.out.println(wordExten(s));
//		s = "hellloooooooo";
//		System.out.println(wordExten(s));
		s = "kurshit";
		System.out.println(wordExten(s));
 
	}
	
	 private static List<List<Integer>> wordExten(String s) {
	        List<List<Integer>> res = new ArrayList<>();
	        int ptr = 0;
	        int  i = 1; 
	        int count = 1;
 	        while(i < s.length()) {
	            if(s.charAt(ptr) == s.charAt(i)) {
	                i++;
	                count++;
	            }
	            else {
	                if(count >= 3) {
	                    List<Integer> list = new ArrayList<>();
	                    list.add(ptr);
	                    list.add(i - 1);
	                    res.add(list);
	                }
	                ptr = i;
	                count = 0;
	            }
	        }
	        
	        if(count >= 3) {
	            List<Integer> list = new ArrayList<>();
	            list.add(ptr);
	            list.add(i);
	            res.add(list);
	        }
	        return res;
	    }

}
