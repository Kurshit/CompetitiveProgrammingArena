package com.kurshit.leetcode.pastgoogle;

/*
    Problem source : https://leetcode.com/problems/find-original-array-from-doubled-array/
    Solution Source : https://leetcode.com/problems/find-original-array-from-doubled-array/discuss/1470959/JavaC%2B%2BPython-Match-from-the-Smallest-or-Biggest-100
            https://www.youtube.com/watch?v=z40B-Mr9_qk
    Statement :
            An integer array original is transformed into a doubled array changed by appending twice the value of every element in original, and then randomly shuffling the resulting array.

        Given an array changed, return original if changed is a doubled array. If changed is not a doubled array, return an empty array. The elements in original may be returned in any order.

     Example 1:

        Input: changed = [1,3,4,2,6,8]
        Output: [1,3,4]
        Explanation: One possible original array could be [1,3,4]:
        - Twice the value of 1 is 1 * 2 = 2.
        - Twice the value of 3 is 3 * 2 = 6.
        - Twice the value of 4 is 4 * 2 = 8.
        Other original arrays could be [4,3,1] or [3,1,4].
        Example 2:

        Input: changed = [6,3,0,1]
        Output: []
        Explanation: changed is not a doubled array.
 */


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class FindOriginalArray {

    public static void main(String[] args) {

        //int[] arr = {1, 2, 3, 4, 6, 8};
        int[] arr = {6, 3, 0, 1};
        //System.out.println(Arrays.toString(findOriginalArrayUsingTreeMap(arr)));
        System.out.println(Arrays.toString(findOriginalArrayUsingGreedy(arr)));

    }
    /*
        Approach 1 : Using Treemap O(N log(n))
     */
    public static int[] findOriginalArrayUsingTreeMap(int[] arr) {

        int N = arr.length;

        if(N % 2  ==1 )
            return new int[]{};

        int[] result = new int[N/2];

        Map<Integer, Integer> freqMap = new TreeMap<>();

        for(int item : arr) {
            freqMap.put(item, freqMap.getOrDefault(item, 0 ) + 1);
        }
        int i = 0;
        for(int x : freqMap.keySet()) {

            if(freqMap.get(x) > freqMap.getOrDefault(2 * x, 0)) {
                return new int[]{};
            }

            for(int j = 0; j < freqMap.get(x); j++) {

                result[i++] = x;
                freqMap.put(2 * x, freqMap.get(2 * x) - 1);
            }

        }

        return result;
    }

    /*
        Approach 2 : Using sorting only and handling zero separately
     */

    public static int[] findOriginalArrayUsingGreedy(int[] arr) {
            int N = arr.length;

            if(N % 2  == 1)
                return new int[]{};

            Arrays.sort(arr);

            Map<Integer, Integer> freqMap = new HashMap<>();

            for(int item : arr) {
                freqMap.put(item, freqMap.getOrDefault(item, 0) + 1);
            }
            int[] result = new int[N/2];
            int i = 0;
            for(int item : arr) {

                if(item == 0 && freqMap.get(item) >= 2) {
                    result[i++] = item;
                    freqMap.put(item, freqMap.get(item) - 2);
                }
                else  if(item > 0 && freqMap.getOrDefault(item, 0) > 0 &&  freqMap.getOrDefault(item * 2, 0) > 0) {
                    freqMap.put(item, freqMap.get(item) - 1);
                    freqMap.put(item * 2, freqMap.get(item * 2) - 1);
                    result[i++] = item;

                }

            }

            if(i == N/2)
                return result;
            else {
                return new int[]{};
            }


    }


}
