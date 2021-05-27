package com.codeforces.contests.div3.may719;

import java.util.Scanner;

/*
 * Prblem source : https://codeforces.com/contest/1520/problem/B
 * Problem Editorial : https://codeforces.com/blog/entry/90342
 *  
 * Solution :
 * 
 *  Statement : Let's call a positive integer n ordinary if in the decimal notation all its digits are the same. For example, 1, 2 and 99 are ordinary numbers, but 719 and 2021 are not ordinary numbers.

 *	For a given number n, find the number of ordinary numbers among the numbers from 1 to n
 *
 *Input
	The first line contains one integer t (1≤t≤104). Then t test cases follow.
	
	Each test case is characterized by one integer n (1≤n≤109).
	
	Output
 *		For each test case output the number of ordinary numbers among numbers from 1 to n.
 *
 *	Sample Input: 
 *		6
		1
		2
		3
		4
		5
		100
 	
 	Sample Output : 
 		
 		1
		2
		3
		4
		5
		18

	
  */


public class BOrdinaryNumber {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			System.out.println(countOrinaryNumberEditorialApproach(N));
			//System.out.println(count(N));
			//System.out.println(countOrinaryNumber(N));		

		}
		
		sc.close();

	}
	
	/*
	 * Solution Approach : All ordinary numbers are :
	 * 
	 *  	1 2 3 4 5 6 7 8 9  --> 9
	 *  
	 *  	11 22 33 44 55 66  77  88  99 -> 9
	 *  
	 *  	111 222 333 444 555 666 777 888 999 
	 *  
	 *  	1111 2222 .... 9999
	 *  	
	 *  	11111 22222 .... 99999
	 *  	
	 *  	111111 222222 .... 999999
	 *  
	 *  	1111111 2222222 ... 9999999  // 7 times 
	 *  	
	 *  	11111111  ... 99999999  //8 times 9
	 *  
	 *  	111111111  ... 999999999  //9 times 9
	 *  	
	 *  	In total we have - 9 * 9 = 81 ordinary numbers upto 10^9.
	 * 
	 * 		Just do this pattern for every queried N and keep finding this until this range is <= N
	 */
	
	
	/*
	 * Approach : Best one : Maintains order and can be printed all such numbers in seq
	 * 
	 * Idea : Pattern is as follwos
	 * 
	 * 	1 X 1 = 1	11 X 1 = 11		111 X 1 = 111
	 * 	1 X 2 = 2   11 X 2 = 22		111 X 2 = 222
	 *  1 X 3 = 3	11 X 3 = 33		111 X 3 = 333
	 *  1 X 4 = 4	11 X 4 = 44		111 X 4 = 444
	 *  1 X 5 = 5	11 X 5 = 55		111 X 5 = 555
	 *  1 X 6 = 6	11 X 6 = 66		111 X 6 = 666
	 *  1 X 7 = 7	11 X 7 = 77		111 X 7 = 777
	 *  1 X 8 = 8	11 X 8 = 88		111 X 8 = 888
	 *  1 X 9 = 9	11 X 9 = 99		111 X 9 = 999
	 *  
	 *  pw - 1 to pw = pw * 10 + 1 -- untill pw <= N
	 *  
	 *  for each pw - 
	 *  	d = 1 to d < = 9
	 *  
	 *   	pw * d is the ans
	 *  
	 *  
	 */
	
	public static int countOrinaryNumberEditorialApproach(int N) {
		
		int result = 0;
		
		for(long pw=1; pw <= N; pw = pw * 10 + 1) {
			
			for(int d= 1; d <= 9; d++) {
				
				if(pw * d <= N) {
					result++;
					//System.out.println(pw * d); // Uncomment this to print all ordinary numbers insequence
				}
				
			}
		}
		
		return result;
	}

	
	public static int count(int N) {
		
		int result = 0;
		
		for(int i=1; i <= 9; i++) {
			long X = 0;
			for(int j=1; j <= 10; j++) {
				
				X = X * 10 + i;
				
				if(X <= N) {
					System.out.println(X);
					result++;
				}
			}
		}
		
		return result;
	}
	
	// Same approach with reduced loops
	
	public static int countOrinaryNumber(int N) {
		
		int result = 0;
		
		for(int i=1; i <= 9; i++) {
			
			for(long num= i; num <= N; ) {
				
				//result++;
				System.out.println(num);
				num = (num * 10) + 1;
			}
		}
		
		return result;
	}
	

}
