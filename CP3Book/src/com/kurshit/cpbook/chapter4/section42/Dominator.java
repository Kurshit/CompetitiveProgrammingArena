package com.kurshit.cpbook.chapter4.section42;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
 * Problem : UVa 11902 Dominator
 * 
 * Problem Source : https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=3053
 * 
 * Problem : In graph theory, a node X dominates a node Y if every path
			from the predefined start node to Y must go through X. If
			Y is not reachable from the start node then node Y does not
			have any dominator. By definition, every node reachable from
			the start node dominates itself. In this problem, you will be
			given a directed graph and you have to find the dominators
			of every node where the 0-th node is the start node.
			As an example, for the graph shown right, 3 dominates 4
			since all the paths from 0 to 4 must pass through 3. 1 doesn’t
			dominate 3 since there is a path 0-2-3 that doesn’t include 1.

			Input
			The first line of input will contain T (≤ 100) denoting the
			number of cases.
			Each case starts with an integer N (0 < N < 100) that
			represents the number of nodes in the graph. The next N lines contain N integers each. If the j-th (0
			based) integer of i-th (0 based) line is ‘1’, it means that there is an edge from node i to node j and
			similarly a ‘0’ means there is no edge.

			Output
			For each case, output the case number first. Then output 2N + 1 lines that summarizes the dominator
			relationship between every pair of nodes. If node A dominates node B, output ‘Y’ in cell (A, B),
			otherwise output ‘N’. Cell (A, B) means cell at A-th row and B-th column. Surround the output with
			‘|’, ‘+’ and ‘-’ to make it more legible. Look at the samples for exact format


			2
			5
			0 1 1 0 0
			0 0 0 1 0
			0 0 0 1 0
			0 0 0 0 1
			0 0 0 0 0
			1
			1
			Sample Output
			Case 1:
			+---------+
			|Y|Y|Y|Y|Y|
			+---------+
			|N|Y|N|N|N|
			+---------+
			|N|N|Y|N|N|
			+---------+
			|N|N|N|Y|Y|
			+---------+
			|N|N|N|N|Y|
			+---------+
			Case 2:
			+-+
			|Y|
			+-+

 * 
 */


public class Dominator {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();

		while(T-- > 0) {
			
			int V = sc.nextInt();
			
			int[][] graph = new int[V][V];
			

			for(int i=0; i < V; i ++) {
				for(int j=0; j < V; j++) {
					graph[i][j] = sc.nextInt();
				}
			}
			
			usingDFS(graph, V);
			
			System.out.println();
			
			usingBFS(graph, V);

			
		}
		

		sc.close();

	}

	public static void dfs(int[][] graph, boolean[] visited, int src, int dest) {

		if(src == dest) {
			return;
		}

		visited[src] = true;

		for(int i= 0; i < graph.length; i++) {
			if(graph[src][i] == 1 && !visited[i]) {
				dfs(graph,visited, i, dest);
			}
		}

	}
	
	public static void usingDFS(int[][] graph, int V) {
		
		boolean[] visited = new boolean[105];
		int[][] result = new int[V][V];
		
		boolean[] fused = new boolean[105];

		for(int j = 0; j < V; j++)
			visited[j] = false;

		dfs(graph, visited, 0, -1);

		for(int i = 0; i < V; i++) {
			fused[i] = visited[i];
		}
		
		for(int i = 0; i < V; i++) {
			
			for(int j = 0; j < V; j++)
				visited[j] = false;

			dfs(graph, visited, 0, i);
			
			for(int j = 0; j < V; j++) {
				if(fused[j] && !visited[j])
					result[i][j] = 1;
				else
					result[i][j] = 0;
			}
			
			result[i][i] = fused[i] ? 1 : 0;

		}
		
		for(int i=0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
	
	public static void usingBFS(int[][] graph, int V) {	
		
		boolean[] visited = new boolean[105];
		int[][] result = new int[V][V];
		
		boolean[] fused = new boolean[105];

		for(int j = 0; j < V; j++)
			visited[j] = false;

		bfs(graph, visited, 0, -1);

		for(int i = 0; i < V; i++) {
			fused[i] = visited[i];
		}
		
		for(int i = 0; i < V; i++) {
			
			for(int j = 0; j < V; j++)
				visited[j] = false;

			dfs(graph, visited, 0, i);
			
			for(int j = 0; j < V; j++) {
				if(fused[j] && !visited[j])
					result[i][j] = 1;
				else
					result[i][j] = 0;
			}
			
			result[i][i] = fused[i] ? 1 : 0;

		}
		
		for(int i=0; i < result.length; i++) {
			System.out.println(Arrays.toString(result[i]));
		}
	}
	
	public static void bfs(int[][] graph, boolean[] visited, int src, int dest) {
						
		Queue<Integer> q = new LinkedList<>();
		q.offer(src);
		
		while( !q.isEmpty()) {
			
			src = q.poll();
			
			if(src == dest) {
				return;
			}
			
			visited[src] = true;
						
			
			for(int i= 0; i < graph.length; i++) {
				if(graph[src][i] == 1 && !visited[i]) {
					q.offer(i);					
				}
			}
		}		
		
	}


}
