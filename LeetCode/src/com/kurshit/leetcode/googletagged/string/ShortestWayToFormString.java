package com.kurshit.leetcode.googletagged.string;

/*
    Problem Source : https://leetcode.com/problems/shortest-way-to-form-string/
    Problem Solution : https://leetcode.com/problems/shortest-way-to-form-string/discuss/330938/Accept-is-not-enough-to-get-a-hire.-Interviewee-4-follow-up

    Statement : From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

        Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

    Example 1:

        Input: source = "abc", target = "abcbc"
        Output: 2
        Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".

    Example 2:

        Input: source = "abc", target = "acdbc"
        Output: -1

        Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.

    Example 3:

        Input: source = "xyz", target = "xzyxz"
        Output: 3
        Explanation: The target string can be constructed as follows "xz" + "y" + "xz".


 */


import java.util.Arrays;

public class ShortestWayToFormString {

    public static void main(String[] args) {

        String src = "xyz";
        String tar = "xzyxz";

        System.out.println(shortestWayForStringBruteForce(src, tar));
        System.out.println(shortestWayForStringInvertedIndex(src, tar));

    }

    /*
        Approach 1 : Brute force : O(M * N)
     */

    public static int shortestWayForStringBruteForce(String source, String target) {

        int srcLength = source.length();
        int tarLength = target.length();

        int j = 0;
        int result = 0;

        while(j < tarLength) {
            int ptr = j;

            for(int i=0; i < srcLength; i++) {
                if(j < tarLength && source.charAt(i) == target.charAt(j)) {
                    j++;
                }
            }

            if(ptr == j)
                return -1;

            result++;
        }

        return result;
    }

    /*
        Approach 2 : Using inverted index DS O(M+N)

     */
    public static int shortestWayForStringInvertedIndex(String source, String target) {

        char[] s = source.toCharArray();
        char[] t = target.toCharArray();

        int M = s.length;
        int N = t.length;

        // Build inverted index for source
        int[][] dict = new int[M][26];

        Arrays.fill(dict[M-1], -1); // -1 represents no occurrence of the character

        dict[M-1][s[M-1] - 'a'] = M-1;
        for(int x = M - 2; x >= 0; --x) {
            dict[x] = Arrays.copyOf(dict[x+1], 26);
            dict[x][s[x] - 'a'] = x;
        }

        int ans = 0;
        int idx = 0;
        // Go through target and account for each character
        for(char c: t) {
            // If there are no occurrences of c with index greater than 0
            // then it doesn't occur at all. Hence, we cannot get that letter from
            // a subsequence of source.
            if(dict[0][c - 'a'] == -1) return -1;

            // If there are no c's left in source that occur >= idx
            // but there are c's from earlier in the subsequence
            // add 1 to subsequence count and reset idx of source to 0.
            if(dict[idx][c - 'a'] == -1) {
                ++ans;
                idx = 0;
            }

            // Then continue taking letters from the subsequence
            idx = dict[idx][c-'a'] + 1;

            if(idx == M) {
                ++ans;
                idx = 0;
            }
        }

        return ans + (idx == 0? 0: 1);

    }


}
