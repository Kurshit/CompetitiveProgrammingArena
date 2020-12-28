package com.codeforces.contests.problemset;

import java.util.Scanner;

public class Solution4 {
	

    static int min;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        while(t-- > 0){
            int x = sc.nextInt();
            min = 123456789;
            if(x > 45)
                sb.append("-1\n");
            else if(x < 10)
                sb.append(x+"\n");

            else {
                boolean[] vis = new boolean[10];
                dfs("", x , vis,0);
                sb.append(min+"\n");
            }
        }

        System.out.print(sb);
    }

    static void dfs(String s , int x , boolean[] vis , int sum){

        if(sum == x)
            min = Math.min(min,Math.min(Integer.parseInt(s), Integer.parseInt(new StringBuilder(s).reverse().toString())));

        for(int i=9; i > 0; i--){
            if(!vis[i]) {
                vis[i] = true;
                sum += i;
                if(sum <= x)
                    dfs(s+i,x,vis,sum);
                sum -= i;
                vis[i] = false;
            }

        }
    }
	

}
