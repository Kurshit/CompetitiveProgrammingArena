package com.codeforces.contests.div3.jul731;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ProblemB {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();



        while(T-- > 0) {
            String s = sc.next();

            if(isAlpha(s)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }


        sc.close();

    }

    public static boolean isAlpha(String s) {
       int[] arr = new int[26];

       for(int i = 0; i < s.length(); i++) {
           arr[i] = s.charAt(i) -'a';
       }

       if(s.length() == 1 && s.charAt(0) == 'a')
           return true;

       int count = s.length() -1;
       int left = 0;
       int right = s.length() - 1;

       for(; count >= 0; count--) {

           if(arr[left] == count) {
               left++;
               continue;
           }

           if(arr[right] == count) {
               right--;
               continue;
           }

           return false;
       }

       return true;
    }



}
