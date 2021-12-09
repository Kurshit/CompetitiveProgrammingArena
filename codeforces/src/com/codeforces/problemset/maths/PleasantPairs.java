package com.codeforces.problemset.maths;

/*
    Problem Source :https://codeforces.com/problemset/problem/1541/B
    Problem B: Pleasant Pairs  -- Contest #728
    Statment : You are given an array 𝑎1,𝑎2,…,𝑎𝑛 consisting of 𝑛 distinct integers. Count the number of pairs of indices (𝑖,𝑗) such that 𝑖<𝑗 and 𝑎𝑖⋅𝑎𝑗=𝑖+𝑗.

    Input
    The first line contains one integer 𝑡 (1≤𝑡≤104) — the number of test cases. Then 𝑡 cases follow.

    The first line of each test case contains one integer 𝑛 (2≤𝑛≤105) — the length of array 𝑎.

    The second line of each test case contains 𝑛 space separated integers 𝑎1,𝑎2,…,𝑎𝑛 (1≤𝑎𝑖≤2⋅𝑛) — the array 𝑎. It is guaranteed that all elements are distinct.

    It is guaranteed that the sum of 𝑛 over all test cases does not exceed 2⋅105.

    Output
    For each test case, output the number of pairs of indices (𝑖,𝑗) such that 𝑖<𝑗 and 𝑎𝑖⋅𝑎𝑗=𝑖+𝑗.

    Example :

        3
        2
        3 1
        3
        6 1 5
        5
        3 1 5 9 2

    Output:
        1
        1
        3

 */

import java.util.*;

public class PleasantPairs {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            long[] arr = new long[N+1];
            Map<Long, Long> idxMap = new HashMap<>();

            for(int i=1; i <= N;  i++) {
                arr[i] = sc.nextInt();
                idxMap.put(arr[i], (long) i);
            }

            System.out.println("Brute force : " + getPairsBF(arr, N));
            //System.out.println("Using map : "  + getPairs(arr, N, idxMap));
            System.out.println("Using constant space : " + getPairsEfficient(arr, N));
            System.out.println();
        }
    }

    /*
        Approach 1 : Brute force - TLE
     */
    private static int getPairsBF(long[] arr, int N) {

        int result = 0;

        for(int i =1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {
                if(arr[i] * arr[j] == i + j)
                    result++;
            }
        }

        return result;
    }

    /*
        Approach 2 : Using hashmap & sorting
        Note : Mind the constraints here

        //This method call is commented because it changes the sorting order
     */

    private static long getPairs(long[] arr, long N, Map<Long, Long> idxMap) {

        long result = 0;

        Arrays.sort(arr);

        for(int i = 1; i <= N; i++) {
            for(int j = i+1; j <= N; j++) {

                if((arr[i] * arr[j]) > (2 *N))
                    break;

                if(arr[i] * arr[j] == (idxMap.get(arr[i]) + idxMap.get(arr[j]))) {
                    result++;
                }
            }
        }

        return result;
    }

    /*
        Approach 3 : Without using any space
     */

    private static long getPairsEfficient(long[] arr, long N) {

        long result = 0;

        for(int i = 1; i <= N; i++) {
            for(int j = (int)arr[i] - i; j <= N; j = j + (int) arr[i]) {

                if(j >= 0 && i < j) {
                    if(arr[i] * arr[j] == i + j) {
                        result++;
                    }
                }
            }
        }

        return result;
    }

}
