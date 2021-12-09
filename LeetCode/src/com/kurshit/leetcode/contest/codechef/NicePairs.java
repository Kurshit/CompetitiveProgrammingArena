package com.kurshit.leetcode.contest.codechef;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NicePairs {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {
      int T = sc.nextInt();

      while(T-- > 0) {
        int N = sc.nextInt();
        String s = sc.next();
        System.out.println(pairs(s));
      }



    } catch(Exception e) {

    } finally {
      sc.close();
    }

  }

  public static long pairs(String s) {

    Map<Integer, Integer> minusMap = new HashMap<>();

    Map<Integer, Integer> plusMap = new HashMap<>();
    int N = s.length();
    for(int i = 0; i < N; i++) {
      int key1 = i - Integer.parseInt(String.valueOf(s.charAt(i)));
      int key2 = i + Integer.parseInt(String.valueOf(s.charAt(i)));
      minusMap.put(key1, minusMap.getOrDefault(key1, 0) + 1);
      plusMap.put(key2, plusMap.getOrDefault(key2, 0) + 1);

    }

    long ans = 0;

    for(int value : minusMap.values()) {
      if(value > 1) {
        ans += (value * (value - 1)) /2;
      }
    }

    for(int value : plusMap.values()) {
      if(value > 1) {
        ans += (value * (value - 1)) /2;
      }
    }
    return ans;
  }

}
