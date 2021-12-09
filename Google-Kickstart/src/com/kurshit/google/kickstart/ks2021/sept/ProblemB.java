package com.kurshit.google.kickstart.ks2021.sept;

import java.math.BigInteger;
import java.util.Scanner;
import java.util.Stack;

public class ProblemB {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int c = 1;

        BigInteger count = BigInteger.ZERO;

        while(T--> 0) {

            int N = sc.nextInt();
            String s = sc.next();
            int[] arr = new int[N];
            for(int i = 0; i < N ; i++) {
                arr[i] = s.charAt(i) - '0';
            }

            int[] left = getNearestGreaterToLeftIndices(arr);
            int[] right = getNearestGreaterToRightIndices(arr);

            for(int i = 0; i < N; i++) {

                if(arr[i] == 1) {
                    continue;
                }

                if(left[i] == -1 ) {
                    BigInteger temp =  BigInteger.valueOf(right[i] - i);
                    count= count.add(temp);
                    continue;
                }

                if(right[i] == -1) {

                    BigInteger temp =  BigInteger.valueOf(i - left[i]);
                    count= count.add(temp);
                    continue;
                }


                if(i - left[i] < right[i] - i) {

                    BigInteger temp =  BigInteger.valueOf(i- left[i]);
                    count = count.add(temp);
                } else {

                    BigInteger temp =  BigInteger.valueOf(right[i] - i);
                    count= count.add(temp);
                }
            }

            System.out.println("Case #" + c + ": " + count);
            c++;
        }

        sc.close();

    }

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
}
