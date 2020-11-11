package com.kurshit.math.basics;

/*
 *  LCM( Least Common Multiple) : of two numbers is the smallest number which can be divided by both numbers. 
 *	For example, LCM of 15 and 20 is 60, and LCM of 5 and 7 is 35.
 */

public class LCM {
	
	/*
	 * Solution is based on following formulae:
	 * 
	 * 	a x b = LCM(a, b) * GCD (a, b)

   	 * 	LCM(a, b) = (a x b) / GCD(a, b)
	 */
	
	public static int lcm(int a, int b) {
		
		return (a * b)/ GCD.gcd(a, b);
	}
	
	

	public static void main(String[] args) {
		
		System.out.println(lcm(15,20 ));
		System.out.println(lcm(15,25));

	}

}
