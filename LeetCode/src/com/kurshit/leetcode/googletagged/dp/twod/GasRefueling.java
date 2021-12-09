package com.kurshit.leetcode.googletagged.dp.twod;

import java.util.Collections;
import java.util.PriorityQueue;

public class GasRefueling {

    public static void main(String[] args) {

        int[][] arr= {{10,60},{20,30},{30,30},{60,40}};
        int N = arr.length;

        int target = 100;
        int startFuel = 10;

        System.out.println(minRefuelStops(target, startFuel, arr));



    }

    public static int minRefuelStops(int target, int startFuel, int[][] stations) {
        int curFuel = startFuel, count = 0;
        if (curFuel >= target) return 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int[] station : stations) {
            int stationPos = station[0];
            int stationFuel = station[1];
            // check if we can reach this station
            // if we cannot reach this station, refuel the gas from the previous station with most gas
            while (curFuel < stationPos) {
                if (pq.isEmpty()) return -1;
                curFuel += pq.poll();
                count++;
            }
            pq.offer(stationFuel);
        }

        // now we have reached the last station, check if we can reach the target
        while (curFuel < target) {
            if (pq.isEmpty()) return -1;
            curFuel += pq.poll();
            count++;
        }

        return count;
    }
}
