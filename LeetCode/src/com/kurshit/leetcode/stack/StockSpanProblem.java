package com.kurshit.leetcode.stack;

/*
    Problem : Stock Span Problem
    Problem Source : https://www.geeksforgeeks.org/the-stock-span-problem/
    Solution Source : https://www.youtube.com/watch?v=p9T-fE1g1pU&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=6
    Problem : The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate span of stock’s price for all n days.
    The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
    For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}

 */

import java.util.Arrays;

public class StockSpanProblem {

    public static void main(String[] args) {
        int price[] = { 10, 4, 5, 90, 120, 80 };
        int[] result = getStockSpan(price);
        System.out.println(Arrays.toString(result));
    }

    /*
        Approach : Using Stack - NearestGreaterElementToLeft

        Idea : Use concept of finding NearestGreaterToLeft - Now find the count of in-between elements.
        Instead of storing actual greater element, store indices of such elements for each input array.Excepti
     */

    public static int[] getStockSpan(int[] arr) {
        int N = arr.length;
        int[] nearestIndices = NearestGreterSmallerIndex.getNearestGreaterToLeftIndices(arr);

        int[] result = new int[N];

        for(int i = 0; i < arr.length; i++) {
            result[i] = i - nearestIndices[i];
        }

        return result;

    }
}
