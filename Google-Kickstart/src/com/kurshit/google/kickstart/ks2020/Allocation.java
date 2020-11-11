package com.kurshit.google.kickstart.ks2020;

/*
 * Problem : There are N houses for sale. The i-th house costs Ai dollars to buy. You have a budget of B dollars to spend.

		What is the maximum number of houses you can buy?

 Input
	The first line of the input gives the number of test cases, T. T test cases follow. Each test case begins with a single 	line containing the two integers N and B. The second line contains N integers. The i-th integer is Ai, the cost of the 	i-th house.

 Output
	For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is 	the maximum number of houses you can buy.
 */

/*
 * The code has been accepted and all following approaches are working.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Allocation {

	private static Allocation m = new Allocation();

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {
			int T = sc.nextInt();

			for (int t = 1; t <= T; t++) {
				
				int N = sc.nextInt();
				int B = sc.nextInt();
				int[] price = new int[N];
				
				for(int i=0; i < N; i++) {
					price[i] = sc.nextInt();
				}
				//System.out.println("Case #"+ t +": " +m.maxHousesICanBuy(price, N, B));
				//System.out.println("Case #"+ t +": " +m.maxHousesICanBuyMemoization(price, N, B));
				System.out.println("Case #"+ t +": " +m.maxHousesICanBuySorting(price, N, B));

			}
			sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public int maxHousesICanBuy(int[] price, int n, int B) {

		if (n == 0 || B == 0)
			return 0;

		if (price[n - 1] > B) {
			return maxHousesICanBuy(price, n - 1, B);
		} else {
			return Math.max(1 + maxHousesICanBuy(price, n - 1, B - price[n - 1]), maxHousesICanBuy(price, n - 1, B));
		}		
	}
	
	public int maxHousesICanBuyMemoization(int[] price, int N, int B) {
		int[][] cache = new int[N+1][B+1];
		return maxHousesICanBuyMemoization(price, N, B, cache);
	}
	
	public int maxHousesICanBuyMemoization(int[] price, int N, int B, int[][] cache) {

		if (N == 0 || B == 0)
			return 0;

		if (cache[N][B] != 0)
			return cache[N][B];

		if (price[N - 1] > B) {
			return maxHousesICanBuyMemoization(price, N - 1, B, cache);
		}

		if (price[N - 1] <= B) {
			return cache[N][B] = Math.max(1 + maxHousesICanBuyMemoization(price, N - 1, B - price[N - 1], cache),
					maxHousesICanBuyMemoization(price, N - 1, B, cache));
		}

		return 0;
	}
	
	public int maxHousesICanBuyTopDown(int[] price, int N, int B) {
		int[][] cache = new int[N+1][B+1];;
		return maxHousesICanBuyTopDown(price, N, B, cache);
	}
	
	public int maxHousesICanBuyTopDown(int[] price, int N, int B, int[][] cache) {

		for (int i = 1; i < N + 1; i++) {
			for (int j = 1; j < B + 1; j++) {
				if (price[i - 1] <= j) {
					cache[i][j] = Math.max(1 + cache[i - 1][j - price[i - 1]], cache[i - 1][j]);
				} else {
					cache[i][j] = cache[i - 1][j];
				}
			}
		}

		return cache[N][B];

	}
	
	public int maxHousesICanBuySorting(int[] price, int N, int B) {

		Arrays.sort(price);
		
		int maxHouses = 0;
		
		for(int i =0; i < N; i++) {
			
			if(price[i] <= B) {
				maxHouses++;
				B = B - price[i];
			} else {
				break;
			}
		}
		
		return maxHouses;

	}

}