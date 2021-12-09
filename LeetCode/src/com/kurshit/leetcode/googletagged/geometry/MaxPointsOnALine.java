package com.kurshit.leetcode.googletagged.geometry;

/*
    Problem : Maximum points on line #149
    Problem Source : https://leetcode.com/problems/max-points-on-a-line/
    Problem : Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.

    Example :

    Input: points = [[1,1],[2,2],[3,3]]
    Output: 3

    Input: points = [[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]
    Output: 4
 */

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnALine {

    public static void main(String[] args) {


        int[][] points = {{1,1}, {3, 2}, {5, 3}, {4,1}, {2,3}, {1,4}};
        System.out.println(maxPoints(points));

        int[][] points1 = {{2,3}, {3, 3}, {-5, 3}};
        System.out.println(maxPoints(points1));


    }

    public static int maxPoints(int[][] points) {

        Map<Float, Integer> dict = new HashMap<>();
        int N = points.length;
        int max = 0;
        float slope = -1;
        for(int i = 0; i < N - max -1; i++ ) {
            int iMax = 0;
            for(int j = i+1; j < N; j++) {
                if(points[j][0] - points[i][0] == 0)
                    slope = Integer.MAX_VALUE;
                else {
                    slope = (float) (points[j][1] - points[i][1])/ (float) (points[j][0] - points[i][0]);
                }

                if(slope == -0.0){
                    slope = 0;
                }

                dict.put(slope, dict.getOrDefault(slope, 0) + 1);

                iMax = Math.max(iMax, dict.get(slope));
            }

            dict.clear();
            max = Math.max(max, iMax);
        }

        return max + 1;

    }
}
