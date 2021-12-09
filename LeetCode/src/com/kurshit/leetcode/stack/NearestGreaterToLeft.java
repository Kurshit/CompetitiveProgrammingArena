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

public class NearestGreaterToLeft {

    public static void main(String[] args) {

        int[] arr = {11, 13, 21, 3};
        printNearestGreaterLeft(arr);
        printNearestGreatLefterBF(arr);

        System.out.println();

        int[] arr1 = {1, 3, 2, 4};
        printNearestGreaterLeft(arr1);
        printNearestGreatLefterBF(arr1);

    }

    /*
        Approach 2 : Using stack
        Idea : Is same as NearestGreaterToRight

        Store left array to stack
     */

    public static void printNearestGreaterLeft(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
        int resultIdx = 0;
        //only this loop changes from left to right
        for(int i = 0; i < N; i++) {

            if(stack.isEmpty()) {
               result[resultIdx++] = -1;
            } else if(stack.peek() > arr[i]) {
                result[resultIdx++] = stack.peek();
            } else {
                while(!stack.isEmpty() && arr[i] > stack.peek()) {
                    stack.pop();
                }

                if(stack.isEmpty()) {
                    result[resultIdx++] = -1;
                } else {
                    result[resultIdx++] = stack.peek();
                }
            }
            stack.push(arr[i]);

        }

        System.out.println(Arrays.toString(result));

    }

    /*
        Approach 1 : Brute force
     */

    public static void printNearestGreatLefterBF(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Arrays.fill(result, -1);
        for(int i = 0; i < N; i++) {
            for(int j = i-1; j >= 0; j--) {
                if(arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }


        System.out.println(Arrays.toString(result));

    }

}
