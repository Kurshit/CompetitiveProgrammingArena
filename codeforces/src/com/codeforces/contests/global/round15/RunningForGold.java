package com.codeforces.contests.global.round15;

import java.util.*;

public class RunningForGold {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            int[][] grid = new int[N][5];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < 5; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            TreeMap<Integer, Integer> m1 = new TreeMap<>();
            TreeMap<Integer, Integer> m2 = new TreeMap<>();
            TreeMap<Integer, Integer> m3 = new TreeMap<>();
            TreeMap<Integer, Integer> m4 = new TreeMap<>();
            TreeMap<Integer, Integer> m5 = new TreeMap<>();

            for(int i =0; i < N; i++) {
                m1.put(grid[i][0], i + 1);
            }

            for(int i =0; i < N; i++) {
                m2.put(grid[i][1], i + 1);
            }

            for(int i =0; i < N; i++) {
                m3.put(grid[i][2], i + 1);
            }

            for(int i =0; i < N; i++) {
                m4.put(grid[i][3], i + 1);
            }

            for(int i =0; i < N; i++) {
                m5.put(grid[i][4], i + 1);
            }
            int ans = -1;
            for(int i = 0; i < N; i++) {

                if(ans != -1)
                    break;

                Map<Integer, Integer> freqMap = new HashMap<>();

                freqMap.put(m1.get(m1.firstKey()), freqMap.getOrDefault(m1.get(m1.firstKey()), 0) + 1);
                m1.remove(m1.firstKey());

                freqMap.put(m2.get(m2.firstKey()), freqMap.getOrDefault(m2.get(m2.firstKey()), 0) + 1);
                m2.remove(m2.firstKey());

                freqMap.put(m3.get(m3.firstKey()), freqMap.getOrDefault(m3.get(m3.firstKey()), 0) + 1);
                m3.remove(m3.firstKey());

                freqMap.put(m4.get(m4.firstKey()), freqMap.getOrDefault(m4.get(m4.firstKey()), 0) + 1);
                m4.remove(m4.firstKey());

                freqMap.put(m5.get(m5.firstKey()), freqMap.getOrDefault(m5.get(m5.firstKey()), 0) + 1);
                m5.remove(m5.firstKey());

                for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
                    if(entry.getValue() >=3) {
                        ans = entry.getKey();
                        break;
                    }
                }
            }

            System.out.println(ans);


        }
        sc.close();
    }

}
