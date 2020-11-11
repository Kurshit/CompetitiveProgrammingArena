package com.kurshit.math.projecteuler;

/*
 * A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
 *
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * 
 * Source : https://projecteuler.net/problem=4
 */

public class Problem4 {
	
	public static long largestPalindromeProduct(int digit) {
		
		long upperTwoDigitLimit = 1;
		long lowerTwoDigitLimit = 0;
		
		for(int i=1 ; i <= digit; i++) {
			upperTwoDigitLimit = upperTwoDigitLimit * 10;
		}
		
		upperTwoDigitLimit = upperTwoDigitLimit - 1;
		
		lowerTwoDigitLimit = (upperTwoDigitLimit/10) + 1;
		long maxProduct = 0;
		for(long i = upperTwoDigitLimit; i >= lowerTwoDigitLimit; i--) {
			for(long j= i; j >= lowerTwoDigitLimit; j--) {
				long product = i * j;
				
				if(isPalindrome(product)) {
					maxProduct = Math.max(maxProduct, product);
				}
			}
		}
		
		return maxProduct;
	}
	
	public static boolean isPalindrome(long number) {
		long copyOfNumber = number;
		long reverse = 0;
		while(copyOfNumber > 0) {
			long lastDigit = copyOfNumber % 10;
			reverse = lastDigit + reverse * 10;
			copyOfNumber = copyOfNumber / 10;
		}
		
		return number == reverse;		
		
	}
	
	public static void main(String[] args) {
		System.out.println(largestPalindromeProduct(2));
		System.out.println(largestPalindromeProduct(3));
	}
}
