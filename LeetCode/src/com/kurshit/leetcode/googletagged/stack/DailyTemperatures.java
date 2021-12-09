package com.kurshit.leetcode.googletagged.stack;

import com.kurshit.leetcode.stack.NearestGreterSmallerIndex;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperatures {

    public static void main(String[] args) {

        DailyTemperatures temp = new DailyTemperatures();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString(temp.dailyTemperatures(temperatures)));

    }

    /*
        Approach is similar to nearest greater to right
     */

    public int[] dailyTemperatures(int[] temperatures) {
        int N = temperatures.length;

        int[] result = NearestGreterSmallerIndex.getNearestGreaterToRightIndices(temperatures);

        for(int i =0; i < N; i++) {
            if(result[i] == -1) {
                result[i] = 0;
            } else {
                result[i] = result[i] - i;
            }
        }

        return result;
    }



}
