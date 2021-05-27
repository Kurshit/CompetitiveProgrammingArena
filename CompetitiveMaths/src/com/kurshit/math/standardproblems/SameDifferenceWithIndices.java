package com.kurshit.math.standardproblems;

/*
	Problem Source : https://codeforces.com/contest/1520/problem/D

	Problem Solution: https://codeforces.com/blog/entry/90342


	You are given an array 𝑎 of 𝑛 integers. Count the number of pairs of indices (𝑖,𝑗) such that 𝑖<𝑗 and 𝑎𝑗−𝑎𝑖=𝑗−𝑖.

	Input
	The first line contains one integer 𝑡 (1≤𝑡≤104). Then 𝑡 test cases follow.

	The first line of each test case contains one integer 𝑛 (1≤𝑛≤2⋅105).

	The second line of each test case contains 𝑛 integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤𝑛) — array 𝑎.

	It is guaranteed that the sum of 𝑛 over all test cases does not exceed 2x10^5.

	Output
		For each test case output the number of pairs of indices (𝑖,𝑗) such that 𝑖<𝑗 and 𝑎𝑗−𝑎𝑖=𝑗−𝑖.
	Sample Input:
		4
		6
		3 5 1 4 6 6
		3
		1 2 3
		4
		1 3 3 4
		6
		1 6 3 4 5 6
	Output:
		1
		3
		3
		10

 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SameDifferenceWithIndices {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while(T-- > 0) {
			int N = sc.nextInt();

			int[] arr = new int[N];

			for(int i =0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			System.out.println(getPairs(arr, N));
		}


		sc.close();

	}

	/*
	 * Approach :
	 *	et's rewrite the original equality a bit:
					𝑎𝑗−𝑎𝑖=𝑗−𝑖,
					𝑎𝑗−𝑗=𝑎𝑖−𝑖
	 *
	 */

	public static int getPairs(int[] arr, int N ) {

		Map<Integer, Integer> map = new HashMap<>();

		for(int i = 0; i < N; i++) {
			arr[i] = arr[i] - i;
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}

		int result = 0;

		for(int freq : map.values()) {
			if(freq >= 2) {
				result = result + (freq * (freq -1) / 2);
			}
		}

		return result;

	}
}
