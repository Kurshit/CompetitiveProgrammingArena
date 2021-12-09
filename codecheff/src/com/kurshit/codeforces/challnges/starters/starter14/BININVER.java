package com.kurshit.codeforces.challnges.starters.starter14;

import java.util.Scanner;

public class BININVER {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            int T = sc.nextInt();

            while(T-- > 0) {
                int N = sc.nextInt();
                int count = 0;
                int[] arr = new int[N];
                boolean done = false;
                for(int i = 0; i < N; i++) {
                    arr[i] = sc.nextInt();

                    if(arr[i] % 2 == 1) {
                        done = true;
                    }
                }

                if(done) {
                    System.out.println(0);
                    continue;
                }

                int result = Integer.MAX_VALUE;
                for(int item : arr ) {
                    int cnt = 0;
                    while(item % 2 != 1) {
                        item = item / 2;
                        cnt++;
                    }

                    result = Math.min(result, cnt);

                }

                System.out.println(result);
            }

        }catch(Exception e) {

        }

        sc.close();

    }
}
