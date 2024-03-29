package com.kurshit.codechef.lunchtime;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;



import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;


import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOfPizzas {

    public static void main(String[] args) {
        //Scanner sc =new Scanner(System.in);
        out = new PrintWriter(new BufferedOutputStream(System.out));
        s = new FastReader(System.in);

        try {

            int T = s.nextInt();

            while(T -- > 0) {

                int N = s.nextInt();
                int S = s.nextInt();

                out.println(minPizza(N, S));
                out.flush();
            }

        } catch(Exception e) {

        }

        //sc.close();
    }

    public static long minPizza(int N, int S) {

        if(N == S)
            return 1;

        if(N == 1) {
            return 1;
        }

        if(S > N) {
            if(S % N == 0)
                return 1;

            return N;
        } else {
            if(N % S == 0) {
                return N / S;
            }

            return  N * S;
        }

    }

    static int gcd(int a, int b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }


    public static PrintWriter out;
    public static FastReader s;

    public static class FastReader {

        private InputStream stream;
        private byte[] buf = new byte[4096];
        private int curChar, snumChars;

        public FastReader(InputStream stream) {
            this.stream = stream;
        }

        public int read() {
            if (snumChars == -1) {
                throw new InputMismatchException();
            }
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = stream.read(buf);
                } catch (IOException E) {
                    throw new InputMismatchException();
                }
            }
            if (snumChars <= 0) {
                return -1;
            }
            return buf[curChar++];
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int number = 0;
            do {
                number *= 10;
                number += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return number * sgn;
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            long sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long number = 0;
            do {
                number *= 10L;
                number += (long) (c - '0');
                c = read();
            } while (!isSpaceChar(c));
            return number * sgn;
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = this.nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = this.nextLong();
            }
            return arr;
        }

        public String next() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c)) {
                c = read();
            }
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndofLine(c));
            return res.toString();
        }

        public boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        public boolean isEndofLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }
}
