package com.kurshit.leetcode.lccurated.medium;

import java.util.Arrays;

/*
 * Source URL : https://leetcode.com/problems/the-maze-ii/
 * Problem statement : There is a ball in a maze with empty spaces and walls. The ball can go through empty spaces by rolling up, down, 
 * left or right, but it won't stop rolling until hitting a wall. When the ball stops, it could choose the next direction.

	Given the ball's start position, the destination and the maze, find the shortest distance for the ball to stop at the destination. 
	The distance is defined by the number of empty spaces traveled by the ball from the start position (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
	
	The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space. 
	You may assume that the borders of the maze are all walls. The start and destination coordinates are represented by row and column indexes.
 */

import java.util.LinkedList;
import java.util.Queue;

public class TheMaze {

	public static void main(String[] args) {

		int[][] maze = {
				{0,0,1,0,0},
				{0,0,0,0,0},
				{0,0,0,1,0},
				{1,1,0,1,1},
				{0,0,0,0,0}
		};
		int[] start = {0,4}; 
		int[] dest = {4,4};

		System.out.println(countPathToDestination(maze, start, dest));

		int[][] maze1 = {
						{0,0,1,0,0},
						{0,0,0,0,0},
						{0,0,0,1,0},
						{1,1,0,1,1},
						{0,0,0,0,0}
					};
		
		
		int[] start1 = {0,4}; 
		int[] dest1 = {3,2};

		System.out.println(countPathToDestination(maze1, start1, dest1));


	}

	public static int countPathToDestination(int[][] maze, int[] start, int[] dest) {
		
		int[][] distance = new int[maze.length][maze[0].length];
		
		for(int[] arr : distance) {
			Arrays.fill(arr, Integer.MAX_VALUE);
		}
		
		distance[start[0]][start[1]] = 0;
		
		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[maze.length][maze[0].length];
		
		int[][] dir = {{0,1},{0,-1},{1,0}, {-1,0}};

		queue.offer(start);

		visited[start[0]][start[1]] = true;

		while(!queue.isEmpty()) {

			int[] curr = queue.poll();
		
			for(int[] d : dir) {

				int x = curr[0];
				int y = curr[1];
				int count = 0;
				while(isValid(maze, x+d[0], y + d[1])) {
					x = x + d[0];
					y = y + d[1];
					count++;
				}

				if(distance[curr[0]][curr[1]] + count < distance[x][y]) {
					distance[x][y] = distance[curr[0]][curr[1]] + count;
					queue.offer(new int[]{x,y});
				}

			}

		}

		return distance[dest[0]][dest[1]] == Integer.MAX_VALUE ? -1 : distance[dest[0]][dest[1]];

	}

	private static boolean isValid(int[][] maze, int x, int y) {
		return x >=0 && x < maze.length && y >=0 && y < maze[0].length && maze[x][y] !=1;

	}

}
