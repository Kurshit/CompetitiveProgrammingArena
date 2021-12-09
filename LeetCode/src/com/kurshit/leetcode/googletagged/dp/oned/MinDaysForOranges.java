package com.kurshit.leetcode.googletagged.dp.oned;

/*
    Problem Source : https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/discuss/794162/C%2B%2BJavaPython-5-lines
    Solution Ref : https://leetcode.com/problems/minimum-number-of-days-to-eat-n-oranges/discuss/794162/C%2B%2BJavaPython-5-lines
    Problem Statement :

        There are n oranges in the kitchen and you decided to eat some of these oranges every day as follows:

        Eat one orange.
        If the number of remaining oranges (n) is divisible by 2 then you can eat  n/2 oranges.
        If the number of remaining oranges (n) is divisible by 3 then you can eat  2*(n/3) oranges.
        You can only choose one of the actions per day.

        Return the minimum number of days to eat n oranges.

    Example 1:

        Input : n = 10
        Output : 4

        Input : n = 6
        Output : 3

        Input : N = 56
        Output : 6

 */

import java.util.*;

public class MinDaysForOranges {


    public static void main(String[] args) {

        MinDaysForOranges problem = new MinDaysForOranges();
        System.out.println(getMinDaysBFS(10));
        System.out.println(minDaysMemoization(10));
        System.out.println(problem.minDaysUsingDPAndMap(10));
        System.out.println();

        System.out.println(getMinDaysBFS(6));
        System.out.println(minDaysMemoization(6));
        System.out.println(problem.minDaysUsingDPAndMap(6));
        System.out.println();

        System.out.println(getMinDaysBFS(1));
        System.out.println(minDaysMemoization(1));
        System.out.println(problem.minDaysUsingDPAndMap(1));
        System.out.println();

        System.out.println(getMinDaysBFS(198));
        System.out.println(minDaysMemoization(198));
        System.out.println(problem.minDaysUsingDPAndMap(198));
    }

    /*
        Approach 3 : BFS

        Idea : Try to create a decision tree. All such decision problems can really be solved using BFS.
        If you see in decision tree, the leaf nodes will be the actual answer as this is where remaining oranges will get 0. Now the first leaf node you encounter,
        its level is the no of days it took to eat them.

        Now why BFS, because this is the earliest that will give you desired level as this works level wise.
     */

    public static int getMinDaysBFS(int N) {
        int days = 0;

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);

        Set<Integer> visited = new HashSet<>();

        while(!queue.isEmpty()) {

            int size = queue.size();

            while(size-- > 0) {
                int curr = queue.poll();

                //if already visited
                if(!visited.add(curr)) {
                    continue;
                }

                if(curr == 0)
                    return days;

                if(curr % 2 == 0) {
                    queue.offer(curr/2);
                }

                if(curr % 3 == 0) {
                    queue.offer(curr/3);
                }

                queue.offer(curr - 1); // did not get why we have to add curr-1 in each case

            }

            days++;

        }

        return -1;
    }

    /*
        Approach 2 : Using DP and using map instead for dp array.

        As pleasant as it seems, it does not make sense to eat oranges one by one.

        So, the choice we have is to eat n % 2 oranges one-by-one and then swallow n / 2, or eat n % 3 oranges so that we can gobble 2 * n / 3.

        As usual, we use DP to memoise results and avoid re-computation. Since our numbers can be large, it's better to use a hash map instead of an array.

        Why doesn't make sense to eat 2 oranges first, and then do n / 2? Let's say k is one of the divisors we can use. (n - k) / k equals n / k - 1. We can reach n / k - 1 in two actions: n / k and n / k - 1, while (n - k) / k requires k + 1 actions. If k == 2, then we have 2 vs. 3 actions, and the difference grows with k.

     */
    Map<Integer, Integer> map = new HashMap<>();
    public int minDaysUsingDPAndMap(int N) {

        if(N <= 1) {
            return N;
        }

        if(!map.containsKey(N)) {
            map.put(N, 1 + Math.min(N % 2 + minDaysUsingDPAndMap(N/2), N % 3 + minDaysUsingDPAndMap(N/3)));
        }

        return map.get(N);

    }



    static int result;
    static int[] dp;
    public static int minDaysMemoization(int N) {
        result = Integer.MAX_VALUE;
        dp = new int[N + 1];
        return minDaysUtil(N);
    }

    public static int minDaysUtil(int N) {

        if(N == 0)
            return result;

        if(N == 1)
            return 1;

        if(dp[N] != 0)
            return dp[N];

        result = Integer.MAX_VALUE;

        if(N % 2 == 0) {
            result = Math.min(result, 1 + minDaysUtil(N / 2));
        }

        if(N % 3 == 0) {
            result = Math.min(result, 1 + minDaysUtil(N/3));
        }

        if((N-1) % 2 == 0 || (N-1) % 3 == 0) {
            result = Math.min(result, 1 + minDaysUtil(N - 1));
        }

        if((N-2) % 3 == 0) {
            result = Math.min(result, 2 + minDaysUtil(N - 2));
        }

        return dp[N] = result;
    }



}
