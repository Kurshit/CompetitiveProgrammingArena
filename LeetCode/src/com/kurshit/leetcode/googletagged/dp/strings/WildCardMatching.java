package com.kurshit.leetcode.googletagged.dp.strings;

/*
    Problem : Wildcard Matching - Leetcode # 44
    Problem Statement : https://leetcode.com/problems/wildcard-matching/submissions/
    Solution Source : https://www.youtube.com/watch?v=3ZDZ-N0EPV0&t=892s - Tushar Roy

    Statement : Given an input string (s) and a pattern (p), implement wildcard pattern matching with support for '?' and '*' where:

            '?' Matches any single character.
            '*' Matches any sequence of characters (including the empty sequence).
            The matching should cover the entire input string (not partial).
    Example :
            Input : s = "aa", p ="a"
            Output : false

            Input : s = "adceb", p = "*a*b";
            Output : true

 */

public class WildCardMatching {

    public static void main(String[] args) {
        String s = "aa";
        String p = "a";
        System.out.println(isMatch(s, p));

        s = "aa";
        p = "a?";
        System.out.println(isMatch(s, p));

        s = "aa";
        p = "*";
        System.out.println(isMatch(s, p));

        s = "cb";
        p = "?a";
        System.out.println(isMatch(s, p));

        s = "adceb";
        p = "*a*b";
        System.out.println(isMatch(s, p));

        s = "acdckb";
        p = "a*c?b";
        System.out.println(isMatch(s, p));

        s = "cb";
        p = "?a";
        System.out.println(isMatch(s, p));

        s = "cb";
        p = "*";
        System.out.println(isMatch(s, p));

        s = "";
        p = "****";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {

        StringBuilder patternBuillder = new StringBuilder();
        char last = ' ';
        for(int i = 0; i < p.length(); i++) {

            if(p.charAt(i) == '*') {

                if(last == '*') {
                    last = '*';
                    continue;
                } else {
                    patternBuillder.append(p.charAt(i));
                    last = '*';
                }

            } else {
                patternBuillder.append(p.charAt(i));
                last = ' ';
            }
        }

        String pattern = patternBuillder.toString();

        int M = s.length();
        int N = pattern.length();
        boolean[][] dp = new boolean[M+1][N+1];

        if(N >= 1 && pattern.charAt(0) == '*') {
            dp[0][1] = true;
        }

        dp[0][0] = true;

        for(int i = 1; i <= M; i++) {
            for(int j=1; j <= N; j++) {
                if(pattern.charAt(j-1) == '?' || s.charAt(i-1) == pattern.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1];
                } else if(pattern.charAt(j-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }

        return dp[s.length()][pattern.length()];
    }
}
