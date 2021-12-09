package com.kurshit.leetcode.googletagged.string;

import java.util.*;

public class SortByFrequency {

    public static void main(String[] args) {

        String s = "tree";
        System.out.println(frequencySort(s));
    }

    public static String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for(int i=0; i < s.length(); i++) {

            char c = s.charAt(i);

            map.put(c, map.getOrDefault(c, 0) + 1);

        }

        List<Map.Entry<Character, Integer>> list = new ArrayList<>(map.entrySet());

        Collections.sort(list, (e1, e2) -> e2.getValue() - e1.getValue());

        String result = "";



        for(Map.Entry<Character, Integer> e : list) {

            int freq = e.getValue();

            while(freq-- > 0) {
                result = result + e.getKey();
            }
        }

        return result;
    }


}
