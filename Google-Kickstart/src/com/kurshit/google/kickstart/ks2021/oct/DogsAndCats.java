package com.kurshit.google.kickstart.ks2021.oct;

import java.util.Scanner;

public class DogsAndCats {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int cases = 1;
        while(T-- > 0) {
            int N = sc.nextInt();
            long D = sc.nextLong();
            long C = sc.nextLong();
            long M = sc.nextLong();

            String S = sc.next();

            boolean result = areDogsFed(S, N, D, C, M);
            System.out.println("Case #" + cases + ": " + (result ? "YES" : "NO"));
            cases++;
        }

        sc.close();
    }

    private static boolean areDogsFed(String S, long N, long D,  long C, long M) {
        long cnt = 0;
        for(int i = 0; i < N; i++) {
            if(S.charAt(i) == 'D') {
                cnt++;
            }
        }

        if(cnt == 0) {
            return  true;
        }

        for(int i =0; i < N; i++) {

            if(cnt == 0) {
                return true;
            }
            if(S.charAt(i) == 'D') {

                if(D > 0) {
                    D--;
                    cnt--;
                    if(C <= 1000000 && M != 0)
                        C = C + M;
                } else {
                    return false;
                }

            } else {

                if(C > 0) {
                    C--;
                } else {
                    return false;
                }
            }

        }

        return true;

    }


}
