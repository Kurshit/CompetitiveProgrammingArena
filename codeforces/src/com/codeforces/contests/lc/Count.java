package com.codeforces.contests.lc;

import java.util.HashMap;
import java.util.Map;

public class Count {

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,4};
        int k = 2;
        System.out.println(countKDifference(arr, k));
    }

    public static int countKDifference(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for(int item : nums) {

            map.put(item, map.getOrDefault(item, 0) + 1);

        }

        int count = 0;

        for(int item : nums) {

            int curr = item + k;

            if(map.containsKey(curr)) {
                count += map.get(curr);
            }
        }

        return count;
    }


}
