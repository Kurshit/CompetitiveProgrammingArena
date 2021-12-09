package com.kurshit.leetcode.contest.aug256;

import java.util.Arrays;

public class MinDifferenceHighestSmallest {

    public static void main(String[] args) {
        int[] arr = {9, 4, 1, 7};
        int K = 2;
        System.out.println(minimumDifference(arr, K));
    }

    public static int minimumDifference(int[] nums, int K) {

        int i = 0;
        int j = 0;
        int N = nums.length;
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;
        while(j < N) {

            if(j - i + 1 < K) {
                j++;
            } else if(j-i+1 == K) {
                min = Math.min(min, nums[j] - nums[i]);
                j++;
                i++;
            }

        }

        return min;

    }

}
