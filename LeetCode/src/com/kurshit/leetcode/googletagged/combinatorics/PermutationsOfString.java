package com.kurshit.leetcode.googletagged.combinatorics;

/*
 * Problem : Given a string, generate and print all its permutations. 
 * 
 * Example : Str = abc
 * 
 * Output: 	abc acb bac bca cab cba
 * 
 * Solution Source : Sanket Singh, Unacedemy - Backtracking Deep Dive Part 1
 */


/*
 * Approaches : 
 * 
 * Approach 1 : Using recurssion 
 * 
 * Will see why it won't be preffered
 * 
 * Approach 2 : By swapping & Wihtout backtracing but with errors
 * 
 * Approach 3 : Using Backtracking
 */


public class PermutationsOfString {

	public static void main(String[] args) {
		String str = "abc";
		System.out.println("Appraoch 1 :\n");
		printPermsUsingRecurssion(str);
		System.out.println("\nAppraoch 2 :\n");
		printPermsUsingSwapping(str);
		System.out.println("\nAppraoch 3 : Buggy\n");
		printPermsUsingBacktrackingBuggy(str);
		
		System.out.println("\nAppraoch 3 : Backtracking - Working\n");
		printPermsUsingBacktracking(str);
		
	}
	
	/*
	 * Approach 1 : Using Recurssion
	 * 
	 * Idea : If you see sample input "abc", every character gets to become a prefix and then all subsequent characters become part of prefix.
	 * 
	 * For all characters one by one, we will pick it to become a prefix and add it to result string which is empty initially - and then will 
	 * recursively do this for all substring. Keep calling in recurssion function until input string is empty
	 * 
	 * Cons : The solution works fine but finding a substring is a complex operation
	 */
	
	public static void printPermsUsingRecurssion(String str) {
		
		printPermsUsingRecurssionUtil(str, "");
		
	}

	private static void printPermsUsingRecurssionUtil(String str, String result) {
		
		if(str.length() == 0) {
			System.out.println(result);
		} else {
			
			for(int i=0; i < str.length(); i++) {
				char curr = str.charAt(i);
				
				printPermsUsingRecurssionUtil(str.substring(0, i) + str.substring(i+1), result + curr);
			}
		}
		
	}
	
	/*
	 * Approach 2 : Using swapping rather than finding substring each time, but this does NOT work as expected
	 * 
	 * This approach is actually changing the original string in further references.
	 */
	
	/*
	 * Wrong output
	 */
	
	public static void printPermsUsingSwapping(String str) {
		
		int i = 0;
		char[] temp = str.toCharArray();
		printPermsUsingSwappingUtil(temp, i);
		
		
	}
	
	public static void printPermsUsingSwappingUtil(char[] str, int currIdx) {
		
		if(currIdx == str.length - 1) {
			System.out.println(str);
		} else {
			//Not this is starting with 0
			for(int i = 0; i < str.length; i++) {
				swap(str, i, currIdx);
				printPermsUsingSwappingUtil(str, currIdx + 1);
			}
		}
	}
	
	/*
	 * Approach 3: Using backtracking - Bit with duplicates strings - Incorrect
	 * We will retain the original state by backtracking after reswapping characters
	 */
	
	public static void printPermsUsingBacktrackingBuggy(String str) {
		
		int i = 0;
		char[] temp = str.toCharArray();
		printPermsUsingBacktrackingBuggyUtil(temp, i);		
		
	}
	
	public static void printPermsUsingBacktrackingBuggyUtil(char[] str, int currIdx) {
		
		if(currIdx == str.length - 1) {
			System.out.println(str);
		} else {
			//Not this is starting with 0 - BUG
			for(int i = 0; i < str.length; i++) {
				swap(str, i, currIdx);
				printPermsUsingBacktrackingBuggyUtil(str, currIdx + 1);
				swap(str, i, currIdx);
			}
		}
	}
	
	/*
	 * Approach 3 : Working - Using backtracking
	 */
	
	public static void printPermsUsingBacktracking(String str) {
		
		int i = 0;
		char[] temp = str.toCharArray();
		printPermsUsingBacktrackingUtil(temp, i);		
		
	}
	
	public static void printPermsUsingBacktrackingUtil(char[] str, int currIdx) {
		
		if(currIdx == str.length - 1) {
			System.out.println(str);
		} else {
			
			for(int i = currIdx; i < str.length; i++) {
				swap(str, i, currIdx);
				printPermsUsingBacktrackingUtil(str, currIdx + 1);
				swap(str, i, currIdx);
			}
		}
	}
	
	private static void swap(char[] temp, int i, int currIdx) {
		
			
		char c = temp[i];
		temp[i] = temp[currIdx];
		temp[currIdx] = c;
		
		
	}
	
	

}
