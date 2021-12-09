package com.kurshit.math.codencode;

/*
    Problem Source : https://www.youtube.com/watch?v=geLyvdjxQNg&list=PL2q4fbVm1Ik4liHX78IRslXzUr8z5QxsG&index=6
    Solution Source : https://www.youtube.com/watch?v=geLyvdjxQNg&list=PL2q4fbVm1Ik4liHX78IRslXzUr8z5QxsG&index=6
    Statement : Given a number N, print all its Prime Factors.

    Example 1:
              Input : 28

              Output: 2 ^2 , 7

              Input : 48

              Output : 2^4 , 3

                2 x 24  ->  2 x 2 x 12 --> 2 x 2 x 2 x 6 -->  2 x 2 x 2 x 2 x 3
 */

import java.util.Scanner;

public class PrimeFactorizationOfN {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-- > 0) {
            int N = sc.nextInt();
            printPrimeFactorsUptoSqrt(N);
        }
        sc.close();
    }

    /*
            Approach 2 : O(sqrt(N))

            Based on claims -

            Claim :  If N is a composite number then there is at least 1 prime divisor of N below sqrt(N)

            That means, if a number does not have any factor till sqrt of N, then it is a prime no.

            based on this above claim, we can instead of iterating till whole N, stop till sqrt(n)

            Note : Code is same as O(N) approach with one more condition extra to check for.
            if(N>1) - then the remaining number N itself is also a factor.

            Try it with N = 48 example
     */

    public static void printPrimeFactorsUptoSqrt(int N) {

        for(int i = 2; i * i <= N; i++) {

            if(N % i == 0) {
                int count = 0;

                while(N % i == 0) {
                    count++;
                    N = N / i;
                }

                System.out.print(i + "^" + count + "  ");
            }
        }

        //this extra condition is needed here because i does not run here untill N unlike in O(N) approach. Try code with N - 48
        //This is added to consider remaining N as a factor
        if(N > 1) {
            System.out.println(N + "^" + 1);
        }
        System.out.println();
    }



    /*
        Approach 1 : O(N)
     */
    public static void printPrimeFactorsBF(int N) {
        //checking till <= N, because lastly it can also be a factor itself
        for(int i = 2; i <= N; i++) {

            if(N % i == 0) {
                int count = 0;

                while(N % i == 0) {
                    count++;
                    N = N / i;
                }

                System.out.print(i + "^" + count + "  ");
            }
        }
        System.out.println();
    }


}
