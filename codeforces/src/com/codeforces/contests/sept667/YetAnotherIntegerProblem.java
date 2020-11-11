package com.codeforces.contests.sept667;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 *  Source Link : https://codeforces.com/contest/1409/problem/A
 *  Reference : YetAnotherIntegerProblem.txt
 */

public class YetAnotherIntegerProblem {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T-- > 0) {
			String[] str = br.readLine().split(" ");
			int a = Integer.parseInt(str[0]);
			int b = Integer.parseInt(str[1]);
			int diff = Math.abs(a-b);
			System.out.println(diff/10 + (diff %10 == 0 ? 0 : 1));
		}

	}

}
