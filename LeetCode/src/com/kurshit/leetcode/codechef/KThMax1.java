package com.kurshit.leetcode.codechef;

import java.util.Scanner;

public class KThMax1 {

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
                
                 int i = 0;
                 int j = 0;
                 int count = 0;
                 int k = -1;


                 while(j < N) {

                     if(j-i+1 < K) {
                         j++;
                     } else {

                         if(arr[i + K-1] == max) {
                             count++;

                             int temp = i;
                             temp++;
                             while(j-temp+1 >= K) {
                                if(arr[temp + K -1] == max) {
                                    count++;
                                }
                                temp++;
                             }

                             j++;
                         } else {
                             i++;
                         }

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
