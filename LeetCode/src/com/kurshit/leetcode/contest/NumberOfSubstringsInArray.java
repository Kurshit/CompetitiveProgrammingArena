package com.kurshit.leetcode.contest;

public class NumberOfSubstringsInArray {

    public static void main(String[] args) {
        String[] s = {"a","abc","bc","d"};
        System.out.println(numOfStrings(s, "abc"));
    }

    public static int numOfStrings(String[] patterns, String word) {
        int result = 0;

        for(String s : patterns) {
            if(word.contains(s))
                result++;
        }

        return result;

    }


}
