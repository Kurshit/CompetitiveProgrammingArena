package com.codeforces.contests.div3.aug739;

import java.util.Scanner;

public class WhoOpposite {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int A = sc.nextInt();

            int B = sc.nextInt();

            int C = sc.nextInt();

            System.out.println(solve(A, B, C));



        }



        sc.close();
    }

    public static int solve(int A, int B, int C) {

        int d = Math.abs(A-B);
        int max = d * 2;

        if(A > max || B > max || C > max) {
            return -1;
        }

        int R1 = C + d;

        if(R1 > max) {
            return C - d;
        } else {
            return R1;
        }



    }
}
