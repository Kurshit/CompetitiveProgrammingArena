package com.codeforces.contests.div3.aug739;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class PowerOfTwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int N = sc.nextInt();
            System.out.println(solve(N));

        }

        sc.close();


    }

    public static int solve(int N) {

        if(isPowerOfTwo(N)) {
            return 0;
        }

        int result = 0;

        Queue<String> q = new LinkedList<>();

        String s = String.valueOf(N);

        q.offer(s);

        while(!q.isEmpty()) {

            int size = q.size();


            if(size == 0)
                return result;

            while(size-- > 0) {

                String temp = q.poll();
                if(temp.isEmpty())
                    continue;
                long K = Long.parseLong(temp);

                if(isPowerOfTwo(K))
                    return result;

                for(int i = 0; i < temp.length(); i++) {
                    double k = Double.parseDouble(temp);
                    if(k >= Long.MAX_VALUE)
                        continue;
                    if(!temp.isEmpty()) {
                        q.offer(temp.substring(0, i) + temp.substring(i+1));
                    }

                    for(int j = 0; j <= 9; j++) {
                        String t = temp + String.valueOf(j);
                        q.offer(t);
                    }

                }
            }

            result++;

        }

        return result;

    }



    static boolean isPowerOfTwo (long x)
    {
      /* First x in the below expression is
        for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0);

    }

}
