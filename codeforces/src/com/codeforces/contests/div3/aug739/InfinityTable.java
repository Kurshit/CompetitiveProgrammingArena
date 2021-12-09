package com.codeforces.contests.div3.aug739;

import java.util.Scanner;

public class InfinityTable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int N = sc.nextInt();

            int common = (int) Math.ceil(Math.sqrt(N));

            int center = (common * common) - (common -1);
            int X = -1;
            int Y = -1;
            if(center - N > 0) {
                Y = common;
                int diff = center - N;
                X = common - diff;
            } else if(center - N < 0) {
                X = common;
                int diff = N - center;
                Y = common - diff;
            } else {
                X = common;
                Y = common;
            }

            System.out.println(X + " " + Y);



        }

        sc.close();
    }


}
