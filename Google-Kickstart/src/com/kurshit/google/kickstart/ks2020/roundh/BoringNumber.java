package com.kurshit.google.kickstart.ks2020.roundh;

import java.math.BigInteger;
import java.util.Scanner;


/*
 * Source : https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ff49/000000000043b0c6
 * 
 * Ron read a book about boring numbers. According to the book, a positive number is called boring if all of the digits 
 * at even positions in the number are even and all of the digits at odd positions are odd. 
 * The digits are enumerated from left to right starting from 1. For example, the number 1478 is boring as the odd positions include the digits {1, 7} which are odd and even positions include the digits {4, 8} which are even.
 * Given two numbers L and R, Ron wants to count how many numbers in the range [L, R] (L and R inclusive) are boring. 
 * Ron is unable to solve the problem, hence he needs your help.
 * Input
 * 	The first line of the input gives the number of test cases, T. T test cases follow. Each test case consists of a single line with two numbers L and R.
 * Output
 * 	For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the count of boring numbers.
 * 
 *  Input
 *	
 * 	
 * 	3
 * 	5 15
 * 	120 125
 * 	779 783
 * 
 * Output:
 *
 *	Case #1: 6
 *	Case #2: 3
 *	Case #3: 2
 *
 */


public class BoringNumber {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {


			int T = sc.nextInt();

			for(int i=1; i <= T; i++) {
				BoringNumber m = new BoringNumber();
				System.out.println("Case #" + i + ": " + m.getBoringNumerCountUsingDP(sc));
			}

		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}



	}

	private long getBoringNumerCount(Scanner sc) {
		// TODO Auto-generated method stub
		BigInteger L = sc.nextBigInteger();
		BigInteger R = sc.nextBigInteger();

		return f(R) - f(L.subtract(BigInteger.ONE));
	}

	public long f(BigInteger x) {

		if(x.intValue() == 0)
			return 0;

		String s = x.toString();

		long less =0, curr = 1;

		for(long i = 1; i < s.length(); i++) {
			curr = curr * 5;
			less = less + curr;
		}

		long ok = 0, eq = 1;

		for(int i = 0; i < s.length(); i++) {
			long c = s.charAt(i) - '0';
			long v;
			if ((i + 1) % 2 == 0) 
				v = c / 2 + 1;
			else 
				v = (c + 1) / 2;

			long nok = 0, neq = 0;

			nok += ok * 5;

			if (c % 2 == (i + 1) % 2) {
				--v;
				neq = eq;
				nok += eq * v;
			} else {
				nok += eq * v;
			}

			ok = nok;
			eq = neq;
		}



		return less + ok + eq;
	}

	int[][][] dp = new int[20][20][2];
	
	private long getBoringNumerCountUsingDP(Scanner sc) {
		// TODO Auto-generated method stub
		BigInteger L = sc.nextBigInteger();
		BigInteger R = sc.nextBigInteger();
		L = L.subtract(BigInteger.ONE);
		String l = L.toString();
		String r = R.toString();
		
		initializeArray(dp, -1);
		int ans = calc(0, 0, 0, r, 0);
		initializeArray(dp, -1);
		ans = ans - calc(0, 0, 0, l, 0);
		return ans;
	}

	private int calc(int pos, int zeros, int small, String r, int ans) {
		// TODO Auto-generated method stub
		if(pos == r.length()){
			return 1;
		}
		ans = dp[pos][zeros][small];
		
		if(ans != -1) 
			return ans;
		
		ans = 0;
		
		if(pos == zeros){
			ans += calc(pos+1,zeros+1,1,r, ans);
		}
		
		if((pos - zeros)%2 == 0){
			for(int i = 1; i < 10; i += 2){
				if(small > 0 || (i < (r.charAt(pos) - '0')))
					ans += calc(pos+1,zeros,1,r, ans);
				else if(i == (r.charAt(pos) - '0'))
					ans += calc(pos+1,zeros,0,r, ans);
			}
		}
		else {
			for(int i = 0; i < 10; i += 2){
				if(small > 0 || (i < (r.charAt(pos) - '0')))
					ans += calc(pos+1,zeros,1,r, ans);
				else if(i == ( r.charAt(pos) - '0'))
					ans += calc(pos+1,zeros,0,r, ans);
			}
		}
		return ans;
	}

	private void initializeArray(int[][][] dp2, int value) {
		
		for(int i = 0; i < 20; i++) {
			for(int j=0; j < 20; j++) {
				for(int k = 0; k < 2; k++) {
					dp[i][j][k] = value;
				}
			}
		}
		
	}
	
	


}
