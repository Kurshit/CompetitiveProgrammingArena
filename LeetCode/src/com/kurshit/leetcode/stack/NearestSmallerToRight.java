package com.kurshit.leetcode.stack;

/*
    Problem : Nearest Smaller to left
    Problem Source : https://www.geeksforgeeks.org/find-the-nearest-smaller-numbers-on-left-side-in-an-array/
    Solution Source : https://www.youtube.com/watch?v=85LWui3FlVk&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=4
    Statement: Given an array of integers, find the nearest smaller number for every element such that the smaller element is on left side.

    Examples:

    Input:  arr[] = {1, 6, 4, 10, 2, 5}
    Output:         {_, 1, 1,  4, 1, 2}
    First element ('1') has no element on left side. For 6,
    there is only one smaller element on left side '1'.
    For 10, there are three smaller elements on left side (1,
    6 and 4), nearest among the three elements is 4.

    Input: arr[] = {1, 3, 0, 2, 5}
    Output:        {-1, 1, -1, 0, 2}

 */


import java.util.Arrays;
import java.util.Stack;

public class NearestSmallerToRight {

    public static void main(String[] args) {

        int[] arr = {11, 13, 21, 3};
        printNearestSmallerRight(arr);
        printNearestSmallerRightBF(arr);

        System.out.println();

        int[] arr1 = {1, 3, 2, 4};
        printNearestSmallerRight(arr1);
        printNearestSmallerRightBF(arr1);

    }

    /*
        Approach 2 : Using stack
        Idea : Is same as NearestGreaterToLeft

        Store left array to stack
     */

    public static void printNearestSmallerRight(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        //only this loop changes from left to right
        for(int i = N-1; i >= 0; i--) {

            if(stack.isEmpty()) {
               result[i] = -1;
            } else if(stack.peek() < arr[i]) {
                result[i] = stack.peek();
            } else {
                //only this condition changes for Greater/Smaller elements
                while(!stack.isEmpty() && arr[i] < stack.peek()) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(arr[i]);

        }

        System.out.println(Arrays.toString(result));

    }

    /*
        Approach 1 : Brute force
     */

    public static void printNearestSmallerRightBF(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Arrays.fill(result, -1);
        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(arr[j] < arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }

        System.out.println(Arrays.toString(result));

    }

}
