package com.kurshit.leetcode.stack;

/*
    Problem : Nearest Greater to right
    Problem Source : https://www.geeksforgeeks.org/next-greater-element/
    Solution Source : https://www.youtube.com/watch?v=T5s96ynzArg&list=PL_z_8CaSLPWdeOezg68SKkeLN4-T_jNHd&index=3
    Statement: Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an element x is the first greater element on the right side of x in the array. Elements for which no greater element exist, consider the next greater element as -1.

    Examples:

    For an array, the rightmost element always has the next greater element as -1.
    For an array that is sorted in decreasing order, all elements have the next greater element as -1.
    For the input array [4, 5, 2, 25], the next greater elements for each element are as follows.
    Element       NGE
       4      -->   5
       5      -->   25
       2      -->   25
       25     -->   -1
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class NearestGreaterToRight {

    public static void main(String[] args) {

        int[] arr = {11, 13, 21, 3};
        printNearestGreater(arr);
        printNearestGreaterBF(arr);

        System.out.println();

        int[] arr1 = {1, 3, 2, 4};
        printNearestGreater(arr1);
        printNearestGreater(arr1);

    }

    /*
        Approach 2 : Using Stack
        Idea : Wherever if you see array problems with O(N2) TC where the inner j loop i dependent on values of i, the stack will most
        likely to be used. Check the brutforce approach

        Store right array to stack
     */

    public static void printNearestGreater(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Stack<Integer> stack = new Stack<>();
         for(int i = N-1; i >= 0; i--) {

            if(stack.isEmpty()) {
               result[i] = -1;
            } else if(stack.peek() > arr[i]) {
                result[i] = stack.peek();
            } else {
                while(!stack.isEmpty() && arr[i] > stack.peek()) {
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

    public static void printNearestGreaterBF(int[] arr) {

        int N  = arr.length;

        int[] result = new int[N];
        Arrays.fill(result, -1);
        for(int i = 0; i < N; i++) {
            for(int j = i+1; j < N; j++) {
                if(arr[j] > arr[i]) {
                    result[i] = arr[j];
                    break;
                }
            }
        }


        System.out.println(Arrays.toString(result));

    }

}
