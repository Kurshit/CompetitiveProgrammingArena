package com.kurshit.leetcode.contest;

public class MinDays {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3};
        int time = 3;
        System.out.println(getMin(arr, time));
    }

    public static int getMin(int[] arr, int time) {
        return util(arr, arr.length, time);
    }

    public static int util(int[] arr, int N, int time) {

        if(N == 0) {
            return 0;
        }

        if(time == 0) {
            return 1;
        }

        if(arr[N-1] > time) {
            return util(arr, N-1, time);
        } else {
            return Math.min(util(arr, N-1, time-arr[N-1]), util(arr, N-1, time));
        }


    }
}
