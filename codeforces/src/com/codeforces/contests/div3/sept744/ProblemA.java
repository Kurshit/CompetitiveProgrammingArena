package com.codeforces.contests.div3.sept744;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemA {

    public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);

            int T = sc.nextInt();

            while(T-- > 0) {
                String s = sc.next();
                System.out.println(solve(s));
            }

            sc.close();
    }

    public static String solve(String s) {
        Map<Character, Integer> map = new HashMap<> ();

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
        }

        int C1 = map.getOrDefault('A', 0);
        int C2 = map.getOrDefault('B', 0);
        int C3 = map.getOrDefault('C', 0);

        if(C2 < C1 || C2 < C3) {
            return "NO";
        }

        int C2C = C2 - C1;

        if(C2C < C3) {
            return "NO";
        }

        C2 = C2C - C3;

        if(C2 == 0)
            return "YES";
        else return "NO";
    }

}
