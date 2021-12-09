package com.kurshit.math.modulartarithmatic;

/*
        Problem Source : https://unacademy.com/class/basic-mathematics/VWWGTPLN
        Solution Source : https://unacademy.com/class/basic-mathematics/VWWGTPLN
        Problem Statement : Given an integer A, find power of A to the rest N. A^N
        Do not use Math.pow(a, n).

        Example :
            Input : 2 10O
            Output : 1024

        TC : O(logN)
 */

import java.util.Scanner;

public class CalculatePowerOfNumber {

    public static void main(String[] args) {

        CalculatePowerOfNumber power = new CalculatePowerOfNumber();

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int A = sc.nextInt();
            int N = sc.nextInt();
            System.out.println(power.powerBF(A, N));
            System.out.println(power.power(A, N));
        }
        sc.close();
    }


    /*
        Approach 2 : Using recurssion : O(logN)
        This approach is also called Binary Exponentiation
        Recurrence :

                pow(a,N)  :

                    square(pow(a, N/2))         : if N is Event

                    square(pow(a, N/2)) * a     : if N is odd

                    1                           : if N = 0

                    A                           : if N = 1


     */

    public int power(int A, int N) {

        if( N == 0)
            return 1;

        if(N == 1)
            return A;

        if(N % 2 == 0) {
            //even

            int result = power(A, N/2);
            return result * result;
        } else {
            int result = power(A, N/2);
            return result * result * A;
        }
    }

    /*
            Approach 1 : Brute Force : O(N)
     */

    public int powerBF(int A, int N) {

        int ans = 1;

        for(int i =1; i <= N; i++) {
            ans = ans * A;
        }
        return ans;
    }

}
