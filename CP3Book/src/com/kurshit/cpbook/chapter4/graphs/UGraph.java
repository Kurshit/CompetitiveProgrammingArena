package com.kurshit.cpbook.chapter4.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UGraph {

    public int V;
    public List<Integer>[] adjList;

    public UGraph(int V) {
        this.V = V;
        adjList = new LinkedList[V];

        for(int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);
    }

}
