 package com.kurshit.leetcode.pastgoogle;

/*
 * Problem Source : https://leetcode.com/problems/split-two-strings-to-make-palindrome/
 * You are given two strings a and b of the same length. Choose an index and split both strings at the same index, splitting a into two strings: aprefix and asuffix where a = aprefix + asuffix, and splitting b into two strings: bprefix and bsuffix where b = bprefix + bsuffix. Check if aprefix + bsuffix or bprefix + asuffix forms a palindrome.

	When you split a string s into sprefix and ssuffix, either ssuffix or sprefix is allowed to be empty. For example, if s = "abc", then "" + "abc", "a" + "bc", "ab" + "c" , and "abc" + "" are valid splits.
	
	Return true if it is possible to form a palindrome string, otherwise return false.
	
	Notice that x + y denotes the concatenation of strings x and y.
	
	Example 1:

	Input: a = "x", b = "y"
	Output: true
	Explaination: If either a or b are palindromes the answer is true since you can split in the following way:
	aprefix = "", asuffix = "x"
	bprefix = "", bsuffix = "y"
	Then, aprefix + bsuffix = "" + "y" = "y", which is a palindrome.
	Example 2:
	
	Input: a = "abdef", b = "fecab"
	Output: true
	Example 3:
	
	Input: a = "ulacfd", b = "jizalu"
	Output: true
	Explaination: Split them at index 3:
	aprefix = "ula", asuffix = "cfd"
	bprefix = "jiz", bsuffix = "alu"
	Then, aprefix + bsuffix = "ula" + "alu" = "ulaalu", which is a palindrome.
 */

public class SplitStringToMakePalindrome {

	public static void main(String[] args) {
		
		String a = "x";
		String b = "y";
		System.out.println(check(a, b)); //true
		
		a = "ulacfd";
		b = "jizalu";
		System.out.println(check(a, b));  //true
		
		a = "abdef";
		b = "fecab";
		
		System.out.println(check(a, b)); // false
		

	}
	
	static boolean isPalindrome(String s, int i, int j) {
	    while (i < j && s.charAt(i) == s.charAt(j)) {
	        ++i;
	        --j;
	    }
	    return i >= j;
	}
	
	static boolean check(String a, String b) {
	    int i = 0, 
	    j = a.length() - 1;
	    while (i < j && a.charAt(i) == b.charAt(j)) {
	        ++i;
	        --j;
	    }
	    return isPalindrome(a, i, j) || isPalindrome(b, i, j);
	}    
	
	public static boolean checkPalindromeFormation(String a, String b) {
	    return check(a, b) || check(b, a);
	}

}
//"ulacfd";
//"jizalu";