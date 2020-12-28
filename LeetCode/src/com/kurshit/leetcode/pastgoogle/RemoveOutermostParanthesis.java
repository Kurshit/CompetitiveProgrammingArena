package com.kurshit.leetcode.pastgoogle;

/*
 * Problem Source : https://leetcode.com/problems/remove-outermost-parentheses/
 * 
 * Problem : A valid parentheses string is either empty (""), "(" + A + ")", or A + B, where A and B are valid parentheses strings, and + represents string concatenation.  For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.

	A valid parentheses string S is primitive if it is nonempty, and there does not exist a way to split it into S = A+B, with A and B nonempty valid parentheses strings.
	
	Given a valid parentheses string S, consider its primitive decomposition: S = P_1 + P_2 + ... + P_k, where P_i are primitive valid parentheses strings.
	
	Return S after removing the outermost parentheses of every primitive string in the primitive decomposition of S.
	
	Example : Input: "(()())(())"
			Output: "()()()"
			
			Input: "(()())(())(()(()))"
			Output: "()()()()(())"
 */

public class RemoveOutermostParanthesis {

	public static void main(String[] args) {
		
		String s = "(()())(())(()(()))";
		System.out.println(removeOuterParentheses(s));
		
		s = "(()())(())";
		System.out.println(removeOuterParentheses(s));
	}
	
	public static String removeOuterParentheses(String S) {
        StringBuilder s = new StringBuilder();
        int opened = 0;
        for (char c : S.toCharArray()) {
            if (c == '(' && opened++ > 0) {
            	s.append(c);
            }
            if (c == ')' && opened-- > 1) { 
            	s.append(c);
            }
        }
        return s.toString();
    }

}
