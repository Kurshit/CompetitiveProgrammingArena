package com.kurshit.leetcode.googletagged;

/*
    Problem : Next Permutation #131
    Problem Source : https://leetcode.com/problems/next-permutation/solution/
    Solution SOurce : https://leetcode.com/problems/next-permutation/solution/
    Problem Statement : mplement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

    If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

    The replacement must be in place and use only constant extra memory.

    Input: nums = [1,2,3]
    Output: [1,3,2]
    Example 2:

    Input: nums = [3,2,1]
    Output: [1,2,3]
    Example 3:

    Input: nums = [1,1,5]
    Output: [1,5,1]
    Example 4:

    Input: nums = [1]
    Output: [1]


 */

import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        NextPermutation p = new NextPermutation();
        p.nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
        Approach : Single pass approach
     */

    public void nextPermutation(int[] nums) {
        int N = nums.length;

        int i = nums.length - 2;

        while(i >= 0 && nums[i] >= nums[i+1] ) {
            i--;
        }

        //if this condition is not true, it means array is sorted in decending order, so just reverse it
        if(i >= 0) {
            int j = N -1;

            while(nums[i] >= nums[j]) {
                j--;
            }

            swap(nums, i, j);
        }

        reverse(nums, i+1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int end = nums.length - 1;

        while(start <= end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
