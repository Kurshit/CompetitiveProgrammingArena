package com.kurshit.codeforces.oct.challange;

import java.util.Scanner;

public class PositiveAND {
	public static boolean flag = true;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			long t = sc.nextInt();
			while (t-- > 0) {
				int n = sc.nextInt();
				getBeautifulPermutation(n);
			}
		} catch (Exception e) {

		} finally {
			sc.close();
		}
	}

	static void getBeautifulPermutation(int n) {
		if (n == 1) {
			System.out.println(n);
			return;
		}
		if (isPowerOfTwo(n)) {
			System.out.println(-1);
			return;
		}
		int i = 1;
		while (i < 18) {
			if (n < Math.pow(2, i) && n > Math.pow(2, i - 1)) {
				i--;
				break;
			}
			i++;
		}
		int j = 4;
		int pow = 2;
		String emptyString = " ";
		StringBuilder sb = new StringBuilder("2 3 1 ");
		while (j <= n) {
			int value = (int) Math.pow(2, pow);
			if (value == j) {
				sb.append((j + 1)).append(emptyString);
			} else if (value + 1 == j) {
				sb.append((j - 1)).append(emptyString);
				pow++;
			} else {
				sb.append(j).append(emptyString);
			}
			j++;
		}
		System.out.println(sb.toString());
	}


	static boolean isPowerOfTwo(int n) {
		if (n == 0)
			return false;
		return (int) (Math.ceil((Math.log(n) / Math.log(2)))) ==
				(int) (Math.floor(((Math.log(n) / Math.log(2)))));
	}
}

