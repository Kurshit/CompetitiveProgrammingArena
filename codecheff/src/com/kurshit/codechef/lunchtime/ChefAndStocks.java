package com.kurshit.codechef.lunchtime;

import java.util.Scanner;

public class ChefAndStocks {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        try {

            int T = sc.nextInt();

            while(T-- > 0) {

                int S = sc.nextInt();
                int A = sc.nextInt();
                int B = sc.nextInt();
                int C = sc.nextInt();

                boolean result = canHeBuy(S, A, B, C);

                if(result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        }catch (Exception e) {

        }

        sc.close();
    }

    private static boolean canHeBuy(int S, int A, int B, int C) {
        boolean isFall = false;
        if(C < 0) {
            isFall = true;
            C = Math.abs(C);
        }

        if(C == 0) {
            return S >= A && S <=B ? true : false;
        }

        double change = (C/100.0) * S;
        double result = 0.0;
        if(isFall) {
            result = (double) S - change;
        } else {
            result = (double) S + change;
        }

        if(result >= A && result <=B) {
            return true;
        } else {
            return false;
        }

    }
}
