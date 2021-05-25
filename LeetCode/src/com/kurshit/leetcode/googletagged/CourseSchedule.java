package com.kurshit.leetcode.googletagged;

import java.util.LinkedList;
import java.util.List;

/*
 * Problem Source : https://leetcode.com/problems/course-schedule/
 * Problem : There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

 *	For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 *	Return true if you can finish all courses. Otherwise, return false.

 */

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        Graph graph = new Graph(numCourses);
        
        for(int[] arr : prerequisites) {
            graph.addEdge(arr[0], arr[1]);
        }
        
        return !hasCycle(graph);
        
    }
    
    public boolean hasCycle(Graph graph) {
       
        boolean[] visited = new boolean[graph.V];
        boolean[] stack = new boolean[graph.V];
        
        for(int i=0; i < graph.V; i++) {
            if(hasCycleUtil(graph, i, visited, stack))  {
                return true;
            }
        }
        
        return false;
    }
    
    public boolean hasCycleUtil(Graph graph, int src, boolean[] visited, boolean[] stack) {
        
        if(stack[src])
            return true;
        
        if(visited[src])
            return false;
        
        visited[src] = true;
        stack[src] = true;
        
        for(int dest : graph.adjList[src]) {
            if(hasCycleUtil(graph, dest, visited, stack))
                    return true;
            
        }
        
        stack[src] = false;
        return false;
    }
	
	
}

class Graph {
    
    public List<Integer>[] adjList;
    public int V;
    
    public Graph(int V) {
        this.V = V;
        
        adjList = new LinkedList[V];
        
        for(int i=0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
    }
    
}