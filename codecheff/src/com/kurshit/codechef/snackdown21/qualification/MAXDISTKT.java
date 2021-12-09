package com.kurshit.codechef.snackdown21.qualification;

import java.util.*;

public class MAXDISTKT {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            int T = sc.nextInt();

            while(T-- > 0) {

                int N = sc.nextInt();
                List<Pair> list = new ArrayList<>(N);
                for(int i = 0; i < N; i++) {

                    int x = sc.nextInt();


                    list.add(new Pair(x, i));

                }

                Collections.sort(list, (p1, p2) -> { return p1.value - p2.value;} );
                int k = 0;
                for(int i = 0; i < list.size(); i++) {
                    if(k < list.get(i).value ) {
                        list.get(i).value = k;
                        k++;
                    }
                }

                Collections.sort(list, (p1, p2) -> {return p1.idx - p2.idx;});
                StringBuilder sb = new StringBuilder("");
                for(int i = 0; i < N; i++) {
                    sb.append(list.get(i).value);
                    sb.append(" ");
                    //System.out.print(list.get(i).value + " ");
                }

                System.out.println(sb);


            }

        } catch(Exception e) {

        }

        sc.close();

    }
}

class Pair {
    public int value;
    public int idx;

    public Pair(int v, int i) {
        this.value = v;
        this.idx = i;
    }


}
