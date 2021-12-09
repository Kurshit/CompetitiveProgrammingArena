package com.codeforces.contests.div3.sept744;



import java.util.LinkedList;
import java.util.Scanner;

public class ProblemC {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            int[] arr = new int[N];
            String result;
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }

            result = String.valueOf(arr[0]);

            list.addLast(arr[0]);

            for(int i = 1; i <  N; i++) {
                String s1 = result + arr[i];
                String s2 = arr[i] + result;

                if(s1.length() < s2.length()) {
                    list.addLast(arr[i]);
                    result = result + arr[i];
                    continue;
                }

                if(s1.length() > s2.length()) {
                    list.addFirst(arr[i]);
                    result = arr[i] + result;
                    continue;
                }

                if(s1.compareTo(s2) < 0) {
                    list.addLast(arr[i]);
                    result = result + arr[i];
                } else {
                    list.addFirst(arr[i]);
                    result = arr[i] + result;
                }
            }

            for(int item : list) {
                System.out.print(item + " ");
            }
            System.out.println();


        }

        sc.close();
    }
}
