package com.kurshit.leetcode.codechef;

import java.util.Scanner;

public class KThMax {

    public static void main(String[] args) {

        Scanner sc = null;

        try {
            sc = new Scanner(System.in);

            int T = sc.nextInt();
             while(T-- > 0) {
                 int N = sc.nextInt();
                 int[] arr = new int[N];
                 int K = sc.nextInt();

                 for(int i = 0; i < N; i++) {
                     arr[i] = sc.nextInt();
                 }

                 int i = 0;
                 int j = 0;
                 int count = 0;
                 int max = Integer.MIN_VALUE;
                 int k = -1;
                 while(j < N) {

                     if(j-i+1 < K) {
                         j++;
                         max = Math.max(max, arr[j]);
                     } else if(j-i + 1 == K){

                         if(arr[j] == max) {
                             count++;
                             k = j;
                             j++;
                         } else {
                             i++;
                         }

                     } else {
                         if(arr[j] > arr[k]) {
                             i++;
                         } else {
                             j++;
                             count++;
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
