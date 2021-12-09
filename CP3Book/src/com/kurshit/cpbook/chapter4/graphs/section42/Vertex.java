package com.kurshit.cpbook.chapter4.graphs.section42;

import com.kurshit.cpbook.chapter4.graphs.DGraph;

import java.util.Scanner;

public class Vertex {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int V = sc.nextInt();

        int E = sc.nextInt();
        DGraph graph = new DGraph(V);
        while(E-- > 0) {
            int src = sc.nextInt();
            int dest = sc.nextInt();
            graph.addEdge(src, dest);
        }
        int src = sc.nextInt();
        printUnvisited(graph, src);

        sc.close();

    }

    public static void printUnvisited(DGraph graph, int src) {

        boolean[] visited = new boolean[graph.V];
        dfs(graph, src, visited);

        for(int i = 0; i < graph.V; i++) {
            if(!visited[i]) {
                System.out.println(i);
            }
        }

    }

    public static void dfs(DGraph graph, int src, boolean[] visited) {

        for(int dest : graph.adjList[src]) {
            if(!visited[dest]) {
                visited[dest] = true;
                dfs(graph, dest, visited);
            }
        }
    }
}
