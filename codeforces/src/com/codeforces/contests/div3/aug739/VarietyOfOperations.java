package com.codeforces.contests.div3.aug739;

import javax.jws.soap.SOAPBinding;
import java.util.Scanner;

public class VarietyOfOperations {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while(T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            if(a == 0 && b == 0) {
                System.out.println(0);
                continue;
            }


            if(a == b) {
                System.out.println(1);
                continue;
            }


            if(Math.abs(a-b) % 2 != 0) {
                System.out.println(-1);
                continue;
            }

            System.out.println(2);


        }

        sc.close();

    }


}
