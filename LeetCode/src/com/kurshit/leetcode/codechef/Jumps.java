package com.kurshit.leetcode.codechef;

import java.util.Scanner;
import java.util.Stack;

public class Jumps {

    public static void main(String[] args) {

        Scanner sc = null;

        try {
            sc = new Scanner(System.in);

            int T = sc.nextInt();
             while(T-- > 0) {
                 int N = sc.nextInt();
                 int[] arr = new int[N];

                 for(int i = 0; i < N; i++) {
                     arr[i] = sc.nextInt();
                 }

                 System.out.println(solve(arr, N));

             }


        } catch(Exception e) {

        } finally {
            sc.close();
        }

    }

    public static int solve(int[] arr, int N) {
        int start = arr[0];

        for(int i = 1; i < N; i++) {
            if(arr[i] > start) {
                return -1;
            }
        }

        Stack<Integer> stack = new Stack<>();

        for(int i = 1; i < N; i++) {
            while(stack.size() > 0 && arr[i] >= stack.peek()) {
                stack.pop();
            }

            stack.push(arr[i]);
        }

        return stack.size();

    }

}
