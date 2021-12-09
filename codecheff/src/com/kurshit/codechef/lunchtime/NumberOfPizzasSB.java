package com.kurshit.codechef.lunchtime;

import java.io.*;
import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberOfPizzasSB {

    public static void main(String[] args) {
        //Scanner sc =new Scanner(System.in);
        //out = new PrintWriter(new BufferedOutputStream(System.out));
//        BufferedWriter out = new BufferedWriter(
//                new OutputStreamWriter(System.out));

        StringBuilder sb = new StringBuilder("");
        s = new FastReader(System.in);

        try {

            int T = s.nextInt();

            while(T -- > 0) {

                int N = s.nextInt();
                int S = s.nextInt();
                minPizza(N, S, sb);
                //out.println(minPizza(N, S));
                //out.write(minPizza(N, S));
                //out.flush();
            }
            String s= sb.toString().trim();
            System.out.println(s);

        } catch(Exception e) {

        }

        //sc.close();
    }

    public static void minPizza(int N, int S, StringBuilder sb) {

        if(N == S) {
            sb.append(1 +  "\n");
            return;
        }


        if(N == 1) {
            sb.append(1 +  "\n");
            return;
        }

        if(S > N) {
            if(S % N == 0) {
                sb.append(1 +  "\n");
                return;
            }

            long result = lcm(N, S);
            result = result / S;
            sb.append(result + "\n");
            //sb.append(N + "\n");
            return;
        } else {
            if(N % S == 0) {
                long result = N / S;
                sb.append( result + "\n");
                return;
            }
            long result = lcm(N, S);
            result = result / S;
            sb.append(result + "\n");
            //BigInteger b1 = BigInteger.valueOf(N);
            //BigInteger b2 = BigInteger.valueOf(S);
            //BigInteger result = b1.multiply(b2);
            //long result = (long)N * (long)S;
            //sb.append(result + "\n");
            return;
        }

    }

    static long gcd(long a, long b)
    {
        if (a == 0)
            return b;
        return gcd(b % a, a);
    }

    // method to return LCM of two numbers
    static long lcm(long a, long b)
    {
        return ( a / gcd(a, b)) * b;
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
