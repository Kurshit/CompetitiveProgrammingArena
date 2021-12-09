package com.codeforces.contests.div3.jul734;

import java.util.Scanner;

public class PolyAndCoins {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int N = sc.nextInt();
            int C2 = 0;
            int C1 = 0;
            if(N % 3 == 0) {
                C2 = N / 3;
            } else if (N % 3 == 1) {
                C2 = (N-1)/3;
            } else {
                C2 = (N + 1) / 3;
            }

            C1 = N - 2 * C2;

            System.out.println(C1 +" " + C2);
        }

        sc.close();
    }


}
