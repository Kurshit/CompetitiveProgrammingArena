package com.kurshit.leetcode.googletagged;

import java.util.*;

public class AsteroidCollision {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int[] arr = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollision(arr)));

        int[] arr1 = {8, -8};
        System.out.println(Arrays.toString(asteroidCollision(arr1)));

        int[] arr2 = {10, 2, -5};
        System.out.println(Arrays.toString(asteroidCollision(arr2)));

        int[] arr3 = {-2, -1, 1, 2};
        System.out.println(Arrays.toString(asteroidCollision(arr3)));

        int[] arr4 = {-2, -2, 1, -2};
        System.out.println(Arrays.toString(asteroidCollision(arr4)));

        sc.close();

    }

    public static int[] asteroidCollision(int[] arr) {

        List<Integer> negatives = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int N = arr.length;
        int[] result = {};
        for(int i = 0; i < N; i++) {

            int curr = arr[i];

            if(curr > 0) {
                stack.push(curr);
                continue;
            }

            if(stack.isEmpty()) {
               negatives.add(curr);
            } else {

                if(Math.abs(curr) > stack.peek()) {
                    while(!stack.isEmpty() && Math.abs(curr) > stack.peek()) {
                        stack.pop();
                    }

                    if(stack.isEmpty())
                        negatives.add(curr);
                } if(!stack.isEmpty() && Math.abs(curr) < stack.peek()) {
                    continue;
                } else {

                    while(!stack.isEmpty() && stack.peek() == Math.abs(curr)) {
                        stack.pop();
                    }
                }
            }

        }

        result = new int[negatives.size() + stack.size()];

        int idx = 0;

        for(int item : negatives) {
            result[idx++] = item;
        }
        int j = result.length - 1;
        while(!stack.isEmpty() && j >= idx) {
            result[j--] = stack.pop();
        }

        return result;
    }
}
