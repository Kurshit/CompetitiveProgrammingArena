package com.codeforces.contests.div3.jul731;

import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();
            int E = sc.nextInt();

            int F = sc.nextInt();

            int result = Math.abs(A-C) + Math.abs(B - D);

            if(A == C) {
                if(E == A && F >= Math.min(B, D) && F <= Math.max(B, D)) {
                    result += 2;
                }
            }

            if(B == D) {
                if(F == B && E >= Math.min(A, C) && E <= Math.max(A, C)) {
                    result += 2;
                }
            }

            System.out.println(result);
        }

        sc.close();

    }

}
