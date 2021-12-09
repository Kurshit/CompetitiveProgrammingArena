package com.kurshit.codechef.snackdown21.qualification;

import java.util.Scanner;

public class LuckyNum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            int T = sc.nextInt();

            while(T-- > 0) {
                int A = sc.nextInt();
                int B = sc.nextInt();
                int C = sc.nextInt();

                if(A == 7 || B == 7 || C  ==7) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }

        } catch(Exception e) {

        } finally {
            sc.close();
        }
    }
}
