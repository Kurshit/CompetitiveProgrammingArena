package com.codeforces.contests.div3.jul734;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WonderfulColoring {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            String s = sc.next();
            System.out.println(getCount(s));
        }

        sc.close();

    }

    public static int getCount(String S) {

        int result = 0;

        Map<Character, Integer> map = new HashMap<>();

        for(int i = 0; i < S.length(); i++) {

            char curr = S.charAt(i);


            if(map.containsKey(curr)) {

                if(map.get(curr) < 2) {
                    map.put(curr, 2);
                }

            } else {
                map.put(curr, 1);
            }
        }

        for(int item : map.values()) {
            result += item;
        }

        return result/2;
    }
}
