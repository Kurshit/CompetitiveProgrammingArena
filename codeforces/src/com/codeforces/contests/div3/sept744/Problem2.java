package com.codeforces.contests.div3.sept744;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();

            int[] arr = new int[N];
            int[] copy = new int[N];
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
                copy[i] = arr[i];
            }

            Arrays.sort(copy);

            int cnt = 0;

            List<int[]> res = new ArrayList<>();

            for(int i = 0; i < N; i++) {

                if(arr[i] == copy[i]) {
                    continue;
                }

                cnt++;

                int minIdx = getMin(arr, i, N);

                int l = i + 1;
                int r = N;
                int d = minIdx - i;

                rotateIt(arr, i, N, minIdx);

                int[] temp = new int[3];

                temp[0] = l;
                temp[1] = r;
                temp[2] = d;

                res.add(temp);
            }
            System.out.println(cnt);
            for(int[] t : res) {
                System.out.println(t[0] + " " + t[1] + " " + t[2]);
            }

        }

        sc.close();
    }

    private static void rotateIt(int[] arr, int start, int N, int d) {

        reverse(arr, start, d-1);
        reverse(arr, d, N-1);
        reverse(arr, start, N-1);

    }

    private static void reverse(int[] arr, int start, int d) {

        int left = start;
        int right = d;

        while(left <= right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }

    }

    private static int getMin(int[] arr, int start, int N) {
        int min = Integer.MAX_VALUE;
        int idx = -1;
        for(int i = start; i < N; i++) {
            if(arr[i] < min) {
                min = arr[i];
                idx = i;
            }
        }

        return idx;
    }


}
