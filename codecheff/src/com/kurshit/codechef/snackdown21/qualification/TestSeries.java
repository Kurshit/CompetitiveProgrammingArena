package com.kurshit.codechef.snackdown21.qualification;

import java.util.Scanner;

public class TestSeries {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {

            int[] arr = new int[5];
            int[] res = new int[3];
            for(int i = 0; i < 5; i++) {
                arr[i] = sc.nextInt();

                res[arr[i]]++;
            }

            if(res[1] == res[2]) {
                System.out.println("DRAW");
            } else if(res[1] > res[2]) {
                System.out.println("INDIA");
            } else {
                System.out.println("ENGLAND");
            }

        }

        sc.close();

    }


}
