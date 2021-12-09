package com.kurshit.google.kickstart.ks2021.jul;

import java.util.*;

public class ProblemA {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        int T = sc.nextInt();
        int c = 1;
        while (T-- > 0) {
            int A = sc.nextInt();
            int B = sc.nextInt();
            int C = sc.nextInt();
            int D = sc.nextInt();
            int E = -1;
            int F = sc.nextInt();
            int G = sc.nextInt();
            int H = sc.nextInt();
            int I = sc.nextInt();

            //not mid

            int count = 0;

            count = checkAP(A, D, G);
            count += checkAP(A, B, C);
            count += checkAP(C, F, I);
            count += checkAP(G, H, I);

            Map<Integer, Integer> map = new HashMap<>();

            add(map, A, I);
            add(map, B, H);
            add(map, C, G);
            add(map, D, F);

            int max = 0;
            for (int item : map.values()) {
                max = Math.max(max, item);
            }

            System.out.println("Case #" + c + ": " + (max + count));
            c++;
        }

        sc.close();

    }

    public static void add(Map<Integer, Integer> map, int x, int y) {
        int s = x + y;
        if (s % 2 != 0)
            return;
        map.put(s / 2, map.getOrDefault(s / 2, 0) + 1);
    }

    public static int checkAP(int X, int Y, int Z) {
        if (X + Z == Y * 2)
            return 1;

        return 0;
    }
}
