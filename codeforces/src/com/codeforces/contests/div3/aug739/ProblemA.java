package com.codeforces.contests.div3.aug739;

import java.util.Scanner;

public class ProblemA {
    int max = 3000;
    public int[] nums = new int[max];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        int idx = 1;
        ProblemA p = new ProblemA();
        for(int i = 1; i < p.nums.length; i++) {
            if(i % 3 != 0 && (i % 10) != 3) {
                p.nums[idx++] = i;
            }
        }

        while(T-- > 0) {
            int N = sc.nextInt();
            System.out.println(p.nums[N]);

        }

        sc.close();

    }

    public int solve() {

        return 0;
    }
}
