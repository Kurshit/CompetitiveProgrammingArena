package com.kurshit.codeforces.challnges.starters.starter14;

import java.util.Scanner;

public class DIAGMOVE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            int T = sc.nextInt();

            while(T-- > 0) {
                int x = sc.nextInt();
                int y = sc.nextInt();

                System.out.println(solve(x, y));

            }
        } catch(Exception e) {

        }



        sc.close();

    }

    private static String solve(int x, int y) {

        if(x == y) {
            return "YES";
        }

        if(Math.abs(x) % 2 == 0 && Math.abs(y) % 2 == 0) {
            return "YES";
        }

        if((Math.abs(x) % 2 == 1 && Math.abs(y) % 2 == 1)) {
            return "YES";
        }

        return "NO";


    }

}
