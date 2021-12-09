package com.codeforces.contests.global.round15;

import java.util.Arrays;
import java.util.Scanner;

public class SubsequencePermutations {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            String s = sc.next();

            char[] temp = s.toCharArray();

            Arrays.sort(temp);
            int count = 0;
            for(int i=0; i < N; i++) {
                if(temp[i] != s.charAt(i))
                    count++;
            }
            System.out.println(count);
        }


        sc.close();
    }
}
