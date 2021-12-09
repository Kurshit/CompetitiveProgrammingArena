package com.kurshit.cpbook.chapter4.graphs.section42;

/*
        Problem : UVa459
        Problem Source : https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=6&page=show_problem&problem=400
                    CP 3 Book : Page 125
        Problem : Consider a graph G formed from a large number of nodes connected by
            edges. G is said to be connected if a path can be found in 0 or more steps
            between any pair of nodes in G. For example, the graph below is not
            connected because there is no path from A to C.
            This graph contains, however, a number of subgraphs that are connected, one for each of the following sets of nodes: {A}, {B}, {C}, {D},
            {E}, {A,B}, {B,D}, {C,E}, {A,B,D}
            A connected subgraph is maximal if there are no nodes and edges in
            the original graph that could be added to the subgraph and still leave
            it connected. There are two maximal connected subgraphs above, one
            associated with the nodes {A, B, D} and the other with the nodes {C, E}.
            Write a program to determine the number of maximal connected subgraphs of a given graph.

        Fig :

                        0 -- 1
                             |
                             |
                       2     3
                       |
                       4

         Output : 2

         //Basically, find the number of connected components using both bfs and dfs
 */

import com.kurshit.cpbook.chapter4.graphs.UGraph;

import java.util.LinkedList;
import java.util.Queue;

public class GraphConnectivity {

    public static void main(String[] args) {
        UGraph graph = new UGraph(5);

        graph.addEdge(0, 1);
        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        System.out.println(getConnectedComponents(graph));
    }

    public static int getConnectedComponents(UGraph graph) {

        boolean[] visited = new boolean[graph.V];
        int count = 0;

        for(int i = 0; i < graph.V; i++) {
                if(!visited[i]) {
                    //dfs(graph, i, visited); both dfs and bfs wil work
                    bfs(graph, i, visited);
                    count++;
                }
        }

        return count;
    }

    public static void dfs(UGraph graph, int src, boolean[] visited) {

        visited[src] = true;

        for(int dest : graph.adjList[src]) {
            if(!visited[dest]) {
                dfs(graph, dest, visited);
            }
        }
    }

    public static void bfs(UGraph graph, int src, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        q.offer(src);

        while(!q.isEmpty()) {
            src = q.poll();

            for(int dest : graph.adjList[src]) {
                if(!visited[dest]) {
                    q.offer((dest));
                    visited[dest] = true;
                }
            }
        }
    }
}
