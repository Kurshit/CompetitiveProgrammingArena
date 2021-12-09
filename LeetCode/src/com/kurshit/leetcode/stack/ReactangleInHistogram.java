package com.kurshit.leetcode.stack;

public class ReactangleInHistogram {

    public static void main(String[] args) {

        //int[] arr = {2,1,5,6,2,3};
        int[] arr = {1,1};
        System.out.println(largestRectangleArea(arr));

    }

    public static int largestRectangleArea(int[] arr) {

        int N = arr.length;
        int[] nearestSmallerToLeftIdx = NearestGreterSmallerIndex.getNearestSmallerToLeftIndices(arr);
        int[] nearestSmallerToRightIdx = NearestGreterSmallerIndex.getNearestSmallerToRightIndices(arr);

        for(int i = 0; i < N; i++) {
            if(nearestSmallerToRightIdx[i] == -1)
                nearestSmallerToRightIdx[i] = N;
        }


        //width = right - left - 1
        int[] width = new int[N];
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < N; i++) {
            width[i] = nearestSmallerToRightIdx[i] - nearestSmallerToLeftIdx[i] - 1;
            maxArea = Math.max(maxArea, arr[i] * width[i]);
        }

        return maxArea;

    }
}
