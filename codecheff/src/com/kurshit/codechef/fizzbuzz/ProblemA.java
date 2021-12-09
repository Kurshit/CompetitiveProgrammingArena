package com.kurshit.codechef.fizzbuzz;

import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        try {
            while(T-- > 0) {

                int X = sc.nextInt();
                int Y = sc.nextInt();
                int K = sc.nextInt();

                boolean result = hasPath(X, Y, K);

                if(result) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
        } catch (Exception e) {

        }



        sc.close();

    }

    public static boolean hasPath(int x, int y, int k) {

        if(x % k == 0 && y % k == 0) {
            return true;
        }

        return false;


    }


}
