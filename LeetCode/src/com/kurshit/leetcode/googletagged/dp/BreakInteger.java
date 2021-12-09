package com.kurshit.leetcode.googletagged.dp;

/*
    Problem : Integer Break #343
    Problem Source : https://leetcode.com/problems/integer-break/submissions/
    Problem Statement : Given an integer n, break it into the sum of k positive integers, where k >= 2, and maximize the product of those integers.

    Return the maximum product you can get.

    Example 1:

    Input: n = 2
    Output: 1
    Explanation: 2 = 1 + 1, 1 × 1 = 1.
    Example 2:

    Input: n = 10
    Output: 36
    Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.



 */

public class BreakInteger {

    public static void main(String[] args) {
        int N = 10;
        System.out.println(integerBreakDp(N));
        System.out.println(integerBreakMaths(N));
    }

    public static int integerBreakDp(int N) {

        int[] dp = new int[N +1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i =2; i <= N; i++) {
            for(int j =1; j < i; j++) {
                dp[i] = Math.max(dp[i], j * Math.max(i-j, dp[i-j]));
            }
        }

        return dp[N];

    }

    public static int integerBreakMaths(int N) {

        if(N == 1)
            return 1;

        if(N == 2)
            return 1;

        if(N == 3)
            return 2;

        int product = 1;

        while(N > 4) {
            product = product * 3;
            N = N - 3;
        }

        product = product * N;

        return product;

    }


}
