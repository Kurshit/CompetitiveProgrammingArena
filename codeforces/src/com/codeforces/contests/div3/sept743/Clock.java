package com.codeforces.contests.div3.sept743;

import java.util.Scanner;

public class Clock {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            String s = sc.next();

            System.out.println(getCount(s, N));

        }

        sc.close();


    }

    private static int getCount(String s, int N) {

        if(N == 0)
            return 0;

        int count = 0;
        int digits = 0;
        for(int i = 0; i < N; i++) {

            int curr = s.charAt(i) - '0';
            count += curr;

            if(i != N-1) {
                if(curr != 0) {
                    digits++;
                }
            }
        }

        return count + digits;
    }
}
