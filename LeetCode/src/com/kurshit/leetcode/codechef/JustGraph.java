package com.kurshit.leetcode.codechef;

import java.util.*;

public class JustGraph {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {

            int T = sc.nextInt();

            while(T-- > 0) {
                int N = sc.nextInt();

                int[] arr = new int[N];
                Map<Integer, Integer> freq = new HashMap<>();

                for(int i = 0; i < N; i++) {
                    int num = sc.nextInt();

                    arr[i] = num - i -1;

                    freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);

                }

                int count = 0;
                int sum = 0;
                boolean flag = false;
                for(Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                    if(entry.getValue() == N) {
                        System.out.println(N);
                        flag = true;
                        break;
                    }
                }

                if(!flag)
                    System.out.println(1);

            }

        } catch(Exception e) {

        } finally {
            sc.close();
        }
    }


}

class Graph {

    List<Integer>[] adjList;
    int V ;
    public Graph(int V) {
        this.V = V;

        adjList = new ArrayList[V+1];

        for(int i = 1; i <=V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

}
