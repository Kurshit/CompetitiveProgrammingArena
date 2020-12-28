package com.kurshit.leetcode.googletagged.medium;

/*
 * Problem source : https://www.geeksforgeeks.org/longest-palindrome-substring-set-1/
 * 
 * 
 */

public class LongestPalindromicSubstring {

	public static void main(String[] args) {
		
		//String s = "geeksskeeg";
		String s = "aabb";
		System.out.println(printAndGetLongestPalindromicSubstring(s));
		s = "Geeks";
		//System.out.println(printAndGetLongestPalindromicSubstring(s));

	}
	
	public static int printAndGetLongestPalindromicSubstring(String S) {
		
		int N = S.length();

		// Table[i][j] will be false if substring str[i..j] is not palindrome.
        // Else table[i][j] will be true
		int[][] table = new int[N][N];
		
		int maxLength = -1;
		
		// All substrings of length 1 are palindromes
		for(int i=0; i < N; i++)
			table[i][i] = 1;
		
		//check for substring of length 2
		int start = 0;
 
		for (int i = 0; i < N - 1; i++) {
            if (S.charAt(i) == S.charAt(i + 1)) {
                table[i][i + 1] = 1;
                start = i;
                maxLength = 2;
            }
        }
		
		// Check for lengths greater than 2.
        // k is length of substring 
		for(int k=3; k <= N; k++ ) {
			
			for(int i=0; i < N -k +1; i++) {
				
				int j = i + k - 1;
				
				if(table[i+1][j-1] == 1 && S.charAt(i) == S.charAt(j)) {
					table[i][j] = 1;
					
					if(k > maxLength) {
						start = i;
						maxLength = k;
						
					}
				}
			}
			
		}
		
		System.out.println("Longest palindromic string is : " + S.substring(start, start + maxLength));
		return maxLength;
	}

}
