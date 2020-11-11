package com.kurshit.math.basics;

/*
 *  GCD/ HCF:
 *  
 *  HCF of of two numbers is the largest number that divides both of them. 
 *  
 *  Example: 
 *  	36 = 2 * 2 * 3 * 3
 *  	60 = 2 * 2 * 3 * 5
 *  
 *   HCF : 2 * 2 * 3 => 12
 *   
 */

public class GCD {
	
	/*
	 * SOlution : Euclidean Algorithm
	 * 
	 * Algo : 
	 * 	The algorithm is based on below facts.

     * 	1. If we subtract smaller number from larger (we reduce larger number), GCD doesn’t change. So if we keep subtracting repeatedly the larger of two, we end up with GCD.
     * 	2. Now instead of subtraction, if we divide smaller number, the algorithm stops when we find remainder 0.
     *  
	 */
	
	public static int gcd(int a, int b) {
		if(a  == 0)
			return b;
		
		return gcd(b % a, a);
	}
	
	public static void main(String[] args) {
		System.out.println(gcd(60,36));
		System.out.println(gcd(600,360));
		System.out.println(gcd(13,17));

	}

}
