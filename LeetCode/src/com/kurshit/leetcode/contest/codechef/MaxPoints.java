package com.kurshit.leetcode.contest.codechef;

import java.util.Scanner;

public class MaxPoints {

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);

    try {
      int T = sc.nextInt();

      while(T-- > 0) {
        long N = sc.nextLong();
        long A = sc.nextLong();
        long B = sc.nextLong();
        System.out.println(maxPoints(N, A, B));
      }

    } catch(Exception e) {

    } finally {
      sc.close();
    }

  }

  public static long maxPoints(long N, long A, long B) {

    return maxUtil(N, A, B, 0);


  }

  static long max = Integer.MIN_VALUE;
  public static long maxUtil(long N, long A, long B, long sum) {

    if(N < 1) {
      return 0;
    }

    if(N == 1) {
      return 0;
    }


    if(N == 2) {
      return A;
    }

    if(N == 3) {
      return B;
    }
    long s = 0;
    long max = Long.MIN_VALUE;
    for(int i = 2; i <= Math.sqrt(N); i++) {
      if(N % i == 0) {
        s = s + maxUtil(N/i, A, B, sum);
        max = Math.max(max, s);
      }
    }

    return max;

  }

  public static long lowestDivisor(long N) {
    if(N % 2 == 0) {
      return 2;
    } else {
      for(int i = 3; i <= Math.sqrt(N); i++ ) {
        if(N % i == 0) {
          return i;
        }
      }
    }

    return N;
  }

}
