package com.kurshit.leetcode.googletagged.sortingbased;

/*
    Problem Source : https://leetcode.com/problems/reverse-pairs/
    Solution Source : https://leetcode.com/problems/reverse-pairs/discuss/97315/Java-merge-sort-solution-O(nlog(n))
                        https://www.youtube.com/watch?v=S6rsAlj_iB4&t=897s
    Problem Statement : Given an integer array nums, return the number of reverse pairs in the array.

    A reverse pair is a pair(i,j) where 0 <= i < j < nums.length and nums[i] > 2 * nums[j]

    Example :

        input : nums = {1,3,2,3,1}
        Output : 2

        input : nums = {2,4,3,5,1};
        Output : 3

 */

import java.util.Arrays;

public class ReversePairs {

    public static void main(String[] args) {

        int[] arr = {1, 3, 2, 3,1};
        int N = arr.length;

        System.out.println(reversePairs(arr, N));

    }

    public static int result;

    public static int reversePairs(int[] arr, int N) {

        result = 0;
        mergeSort(arr, N, 0, N-1);
        return result;
    }

    public static void mergeSort(int[] arr, int N, int start, int end) {
        if(start >= end)
            return;

        int mid = start + (end - start) / 2;

        mergeSort(arr, N, start, mid);
        mergeSort(arr, N, mid +1, end);

        int count = 0;
        for(int i = start, j = mid + 1; i <= mid ;) {
            if(j > end || (long) arr[i] <=  (long) 2 * arr[j]) {
                i++;
                result = result + count;
            } else {
                j++;
                count++;
            }
        }

        Arrays.sort(arr, start, end + 1);
    }
}
