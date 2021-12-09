package com.kurshit.leetcode.googletagged.maths;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        PlusOne one = new PlusOne();

        int[] nums = {1,2,3};
        System.out.println(Arrays.toString(one.plusOne(nums)));

        int[] nums1 = {1, 2, 3, 9};
        System.out.println(Arrays.toString(one.plusOne(nums1)));

        int[] nums2 = {9, 9, 9};
        System.out.println(Arrays.toString(one.plusOne(nums2)));

        int[] nums3 = {1,0,9};
        System.out.println(Arrays.toString(one.plusOne(nums3)));
    }

    public int[] plusOne(int[] nums) {
        int N = nums.length;

        for(int i = N-1; i>=0; i--) {
            if(nums[i] == 9) {
                nums[i] = 0;
            } else {
                nums[i]++;
                return nums;
            }
        }

        int[] result = new int[N+1];
        result[0] = 1;

        return result;

    }
}
