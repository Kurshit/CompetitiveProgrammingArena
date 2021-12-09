package com.kurshit.leetcode.stack;

/*
    Problem : Nearest Greater to left
    Problem Source : https://www.geeksforgeeks.org/next-greater-element/
    Solution Source : https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3
    Statement: Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the left side of x in the array. Elements for which no greater element exist, consider the next greater element as -1.

    Examples:

    For an array, the rightmost element always has the next greater element as -1.
    For an array that is sorted in decreasing order, all elements have the next greater element as -1.
    For the input array {11, 13, 21, 3}, the next greater elements for each element are as follows.
    Element       NGE
       4      -->   -1
       5      -->   -1
       2      -->   -1
       25     -->   21
 */


import java.util.Arrays;
import java.util.Stack;

public class NearestGreterSmallerIndex {

    public static void main(String[] args) {

//        int[] arr = {11, 13, 21, 3};
//        System.out.println("Actual array : " + Arrays.toString(arr));
//
//        int[] result = getNearestGreaterToLeftIndices(arr);
//        System.out.println(Arrays.toString(result));
//        result = getNearestSmallerToLeftIndices(arr);
//        System.out.println(Arrays.toString(result));
//        result = getNearestSmallerToRightIndices(arr);
//        System.out.println(Arrays.toString(result));

        //int[] arr = {1, 1};
        int[] arr = {11, 13, 21, 3};
        int[] result = getNearestSmallerToLeftIndices(arr);
        //System.out.println(Arrays.toString(result));

        result = getNearestGreaterToRightIndices(arr);
        System.out.println(Arrays.toString(result));

    }

    /*
        Approach 2 : Using stack
        Idea : Is same as NearestGreaterToRight

        Store left array to stack
     */

    public static int[] getNearestGreaterToLeftIndices(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        //only this loop changes from left to right
        for(int i = 0; i < N; i++) {

            if(stack.isEmpty()) {
               result[i] = -1;
            } else if(arr[stack.peek()] > arr[i]) {
                result[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(i);

        }

        return result;

    }

    public static int[] getNearestGreaterToRightIndices(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        //only this loop changes from left to right
        for(int i = N-1; i >= 0; i--) {

            if(stack.isEmpty()) {
                result[i] = -1;
            } else if(arr[stack.peek()] > arr[i]) {
                result[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && arr[i] >= arr[stack.peek()]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(i);

        }

        return result;

    }


    public static int[] getNearestSmallerToLeftIndices(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        //only this loop changes from left to right
        for(int i = 0; i < N; i++) {

            if(stack.isEmpty()) {
                result[i] = -1;
            } else if(arr[stack.peek()] < arr[i]) {
                result[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(i);

        }

        return result;

    }

    public static int[] getNearestSmallerToRightIndices(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();

        //only this loop changes from left to right
        for(int i = N-1; i >= 0; i--) {

            if(stack.isEmpty()) {
                result[i] = -1;
            } else if(arr[stack.peek()] < arr[i]) {
                result[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    result[i] = -1;
                } else {
                    result[i] = stack.peek();
                }
            }
            stack.push(i);

        }

        return result;

    }

    /*
        Approach 1 : Brute force
     */

    public static int[] getNearestGreaterTOLeftIndicesBF(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Arrays.fill(result, -1);
        for(int i = 0; i < N; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i]) {
                    result[i] = j;
                    break;
                }
            }
        }


        return result;

    }

}
