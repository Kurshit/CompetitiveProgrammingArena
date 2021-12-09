package com.codeforces.contests.div3.jul734;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WonderfulColoring2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];

            for(int i=0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            printCount(arr, N, K);
            System.out.println();
        }

        sc.close();

    }

    public static void printCount(int[] arr, int N, int K) {

        Map<Integer, CPair> map = new HashMap<>();

        for(int item : arr) {

            if(!map.containsKey(item)) {
                map.put(item, new CPair(1, 1));
            } else {

                CPair curr = map.get(item);

                if(curr.t < K) {
                    curr.t = curr.t + 1;
                }

            }
        }
        long count = 0;
        for(CPair pair : map.values()) {
            count += pair.t;
        }

        long allowed = count - (count % K);

        for(int i = 0; i < N; i++) {
            int item = arr[i];
            CPair curr = map.get(item);

            if(curr.next <= K && allowed > 0) {
                if(i == N-1)
                    System.out.print(curr.next);
                else
                    System.out.print(curr.next + " ");

                curr.next = curr.next + 1;
                allowed--;
            } else {
                if(i == N-1)
                    System.out.print(0);
                else
                    System.out.print(0 + " ");
            }
        }



    }
}

class CPair {
    int t;
    int next;

    public CPair(int t, int next) {
        this.t = t;
        this.next = next;
    }
}
