package com.kurshit.leetcode.codechef;

import java.util.Scanner;

public class KThMax2 {

    public static void main(String[] args) {

        Scanner sc = null;

        try {
            sc = new Scanner(System.in);

            int T = sc.nextInt();
             while(T-- > 0) {
                 int N = sc.nextInt();
                 int[] arr = new int[N];
                 int K = sc.nextInt();
                 int max = Integer.MIN_VALUE;
                 for(int i = 0; i < N; i++) {
                     arr[i] = sc.nextInt();
                     max = Math.max(max, arr[i]);
                 }

                 long count = 0;

                 for(int i = 0; i < N; i++) {
                     int jump = i + K -1;
                     if(jump < N && arr[jump] == max) {
                         count = count + N - jump;
                     }

                 }

                 System.out.println(count);

             }


        } catch(Exception e) {

        } finally {
            sc.close();
        }

    }

}
