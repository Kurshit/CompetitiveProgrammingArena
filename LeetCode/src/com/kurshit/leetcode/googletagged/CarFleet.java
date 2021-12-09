package com.kurshit.leetcode.googletagged;
/*
    Problem : Car Fleet #853

    Problem Source : https://leetcode.com/problems/car-fleet/
    Problem Statement : There are n cars going to the same destination along a one-lane road. The destination is target miles away.

    You are given two integer array position and speed, both of length n, where position[i] is the position of the ith car and speed[i] is the speed of the ith car (in miles per hour).

    A car can never pass another car ahead of it, but it can catch up to it, and drive bumper to bumper at the same speed.

    The distance between these two cars is ignored (i.e., they are assumed to have the same position).

    A car fleet is some non-empty set of cars driving at the same position and same speed. Note that a single car is also a car fleet.

    If a car catches up to a car fleet right at the destination point, it will still be considered as one car fleet.
    Return the number of car fleets that will arrive at the destination.

    Example 1:

        Input: target = 12, position = [10,8,0,5,3], speed = [2,4,1,1,3]
        Output: 3
        Explanation:
        The cars starting at 10 and 8 become a fleet, meeting each other at 12.
        The car starting at 0 doesn't catch up to any other car, so it is a fleet by itself.
        The cars starting at 5 and 3 become a fleet, meeting each other at 6.
        Note that no other cars meet these fleets before the destination, so the answer is 3.

    Example 2:

        Input: target = 10, position = [3], speed = [3]
        Output: 1


 */

import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class CarFleet {

    public static void main(String[] args) {
        int target = 12;
        int[] position = {10,8,0,5,3};
        int[] speed = {2,4,1,1,3};
        System.out.println(maxFleet(target, position, speed));
        System.out.println(maxFleetUsingTreeMap(target, position, speed));
    }

    public static int maxFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        double[][] cars = new double[N][2];

        for(int i = 0; i < N; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a1, a2) -> Double.compare(a1[0], a2[0]));
        int fleet = 0;
        double curr = Integer.MIN_VALUE;

        for(int i = N-1; i >= 0; i--) {

            double temp = (double) (target - cars[i][0]) / (double) cars[i][1];

            if(temp > curr) {
                fleet++;
                curr = temp;
            }
        }
        return fleet;
    }

    public static int maxFleetUsingTreeMap(int target, int[] position, int[] speed) {

        Map<Integer, Double> map = new TreeMap<>(Collections.reverseOrder());
        int N = position.length;
        for(int i=0; i < N; i++) {
            map.put(position[i], (double) (target - position[i])/speed[i]);
        }

        int fleet = 0;
        double curr = Double.MIN_VALUE;

        for(double item : map.values()) {
            if(item > curr) {
                fleet++;
                curr = item;
            }
        }
        return fleet;
    }
}
