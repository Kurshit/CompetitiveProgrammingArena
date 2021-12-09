package com.kurshit.leetcode.googletagged.string;

/*
    Problem source : https://leetcode.com/problems/decode-string/
    Solution Source : https://leetcode.com/problems/decode-string/discuss/210284/Java-Recursive

    Statement : Given an encoded string, return its decoded string.

    The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.

    You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

    Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].

    Example 1:

    Input: s = "3[a]2[bc]"
    Output: "aaabcbc"
    Example 2:

    Input: s = "3[a2[c]]"
    Output: "accaccacc"
    Example 3:

    Input: s = "2[abc]3[cd]ef"
    Output: "abcabccdcdcdef"
    Example 4:

    Input: s = "abc3[cd]xyz"
    Output: "abccdcdcdxyz"

 */

import java.util.LinkedList;
import java.util.Queue;

public class DecodeStrings {

    public static void main(String[] args) {
        String s = "3[a]2[bc]";
        System.out.println(decodeString(s));
    }

    /*
        Approach 1 : Using queue and recurssion
    */

    public static String decodeString(String s) {

        Queue<Character> q = new LinkedList<>();

        int num = 0;

        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            q.offer(curr);
        }

        return decodeHelper(q);
    }

    public static String decodeHelper(Queue<Character> q) {

        int idx = 0;
        StringBuilder sb = new StringBuilder();
        int num = 0;
        while(!q.isEmpty()) {

            char curr = q.poll();

            if(Character.isDigit(curr)) {
                num = num * 10 + curr - '0';
            } else if(curr == '[') {
                String sub = decodeHelper(q);
                for(int i = 0; i < num; i++) {
                    sb.append(sub);
                }
                num = 0;
            } else if(curr == ']') {
                break;
            } else {
                sb.append(curr);
            }
        }
        return sb.toString();
    }
}
