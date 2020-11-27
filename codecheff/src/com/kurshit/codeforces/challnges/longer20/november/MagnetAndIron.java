package com.kurshit.codeforces.challnges.longer20.november;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MagnetAndIron {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MagnetAndIron m = new MagnetAndIron();
        try {

            int T = sc.nextInt();

            while(T-- > 0) {
                System.out.println(m.solution(sc));
            }

        }catch(Exception e) {

        }
    }

    public int solution(Scanner sc) {
        int N = sc.nextInt();
        int K = sc.nextInt();
        String s = sc.next();

        int result = 0;
        int P = K +1;
        int i, j=0, m =0;

        Queue<Integer> magQ = new LinkedList<>();
        Queue<Integer> ironQ = new LinkedList<>();

        for(i=0; i < N; i++) {

            if(s.charAt(i) == 'M')
                magQ.offer(i);

            if(s.charAt(i) == 'I')
                ironQ.offer(i);

            if(s.charAt(i) == 'X' || i == N-1) {
                int l, r, sheet = 0, q;

                while(!magQ.isEmpty() && !ironQ.isEmpty()) {
                    sheet = 0;
                    l = Math.min(magQ.peek(), ironQ.peek());
                    r = Math.max(magQ.peek(), ironQ.peek());
                    for( q = l; q <= r; q++) {
                        if(s.charAt(q) == ':')
                            sheet++;
                    }

                    if((P - Math.abs(l-r) - sheet) > 0) {
                        result++;
                        magQ.poll();
                        ironQ.poll();

                    }else if(magQ.peek() < ironQ.peek()) {
                        magQ.poll();
                    } else {
                        ironQ.poll();
                    }
                }

                while(!magQ.isEmpty())
                    magQ.poll();

                while (!ironQ.isEmpty())
                    ironQ.poll();
            }
        }
        return result;
    }

}
