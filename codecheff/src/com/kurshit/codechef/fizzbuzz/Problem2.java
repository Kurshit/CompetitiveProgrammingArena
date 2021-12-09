package com.kurshit.codechef.fizzbuzz;

import java.util.Scanner;

public class Problem2 {

    public static void main(String[] args) {

        {

            Scanner sc = new Scanner(System.in);

            try {
                int T = sc.nextInt();

                while(T-- > 0) {
                    int N = sc.nextInt();
                    String S = sc.next();

                    System.out.println(min(S));

                }
            } catch (Exception e) {

            }



            sc.close();

        }

    }


    public static int min(String s) {

        int min = Integer.MAX_VALUE;

        int bInW = 0;
        int wInB = 0;
        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == 'B') {
                bInW++;
                i++;
                while(i < s.length() && s.charAt(i) == 'B') {
                    i++;
                }
            }

        }

        for(int i = 0; i < s.length(); i++) {

            if(s.charAt(i) == 'W') {
                wInB++;
                i++;
                while(i < s.length() && s.charAt(i) == 'W') {
                    i++;
                }
            }

        }

        return Math.min(bInW, wInB);

    }
}
