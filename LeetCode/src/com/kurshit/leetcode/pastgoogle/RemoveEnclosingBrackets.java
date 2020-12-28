package com.kurshit.leetcode.pastgoogle;

/*
 * 
 * Problem SOurce : https://leetcode.com/discuss/interview-question/889130/Google-or-Phone-or-Remove-Enclosing-Bracket
 * Given s String with some characters and brackets. Return String after removing Enclosing Brackets. Also provide a set of test cases for the problem
	For Example:
	(((a))) -> a
	((ab)(bc))d -> ((ab)(bc))d
	() => ""
	((a)(bcd)(e)) -> (a)(bcd)(e)
 */

public class RemoveEnclosingBrackets {

	public static void main(String[] args) {
	
		String s = "(((a)))";
		System.out.println(solve(s));
		
		s = "((ab)(bc))d";
		System.out.println(solve(s));
		
		s = "((a)(bcd)(e))";
		System.out.println(solve(s));
		
		
	}
	
	public static String solve(String s) {
	    int n = s.length();
	    int count = 0;
	    while (count < n && s.charAt(count) == '(' && s.charAt(n - count - 1) == ')') {
	        count++;
	    }
	    int balance = 0;
	    for (int i = count; i < n - count; i++) {
	        if (s.charAt(i) == '(') {
	            balance++;
	        } else if (s.charAt(i) == ')') {
	            if (balance == 0) {
	                count--;
	            } else {
	                balance--;
	            }
	        }
	    }
	    return s.substring(count, n - count);
	}

}
