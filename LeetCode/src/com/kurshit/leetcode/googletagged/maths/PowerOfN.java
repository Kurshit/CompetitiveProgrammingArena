package com.kurshit.leetcode.googletagged.maths;

/*
    Problem : Pow (A, N) #50
    Problem Source : https://leetcode.com/problems/powx-n/
    Problem Statement : Implement pow(x, n), which calculates x raised to the power n (i.e., xn).

        Example 1:

        Input: A = 2.00000, N = 10
        Output: 1024.00000
        Example 2:

        Input: A = 2.10000, N = 3
        Output: 9.26100
        Example 3:

        Input: A = 2.00000, N = -2
        Output: 0.25000
        Explanation: 2-2 = 1/22 = 1/4 = 0.25
 */


public class PowerOfN {

    public static void main(String[] args) {
        PowerOfN p = new PowerOfN();
        double A = 2.00000;
        int N = 10;
        System.out.println(p.myPow(A, N));

        A = 2.10000;
        N = 3;
        System.out.println(p.myPow(A, N));

        A = 2.10000;
        N = -2;
        System.out.println(p.myPow(A, N));

    }

    public double myPow(double A, int N) {
        long bigN = N;

        if(bigN < 0) {
            A = 1 / A;
            bigN = -bigN;
        }

        return myPowUtil(A, bigN);
    }

    public double myPowUtil(double A, long N) {
        if(N == 0)
            return 1.0;

        if(N == 1)
            return A;

        if (N % 2 == 0) {
            double result = myPowUtil(A, N/2);
            return result * result;
        } else {
            double result = myPowUtil(A, N/2);
            return result * result * A;
        }
    }
}
