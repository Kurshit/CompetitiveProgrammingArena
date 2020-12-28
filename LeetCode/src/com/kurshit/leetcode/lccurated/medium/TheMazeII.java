package com.kurshit.leetcode.lccurated.medium;

/*
 * Source URL : https://leetcode.com/problems/the-maze/
 * Problem statement : There is a ball in a maze with empty spaces (represented as 0) and walls (represented as 1). 
 * The ball can go through the empty spaces by rolling up, down, left or right, but it won't stop rolling until hitting a wall. 
 * When the ball stops, it could choose the next direction.
   Given the maze, the ball's start position and the destination, where start = [startrow, startcol] and destination = [destinationrow, destinationcol], 
   return true if the ball can stop at the destination, otherwise return false.
 */

import java.util.LinkedList;
import java.util.Queue;

public class TheMazeII {

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

		System.out.println(doesBallCanReachDestination(maze, start, dest));

		int[][] maze1 = {
						{0,0,1,0,0},
						{0,0,0,0,0},
						{0,0,0,1,0},
						{1,1,0,1,1},
						{0,0,0,0,0}
					};
		
		
		int[] start1 = {0,4}; 
		int[] dest1 = {3,2};

		System.out.println(doesBallCanReachDestination(maze1, start1, dest1));


	}

	public static boolean doesBallCanReachDestination(int[][] maze, int[] start, int[] dest) {

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[maze.length][maze[0].length];

		int[][] dir = {{0,1},{0,-1},{1,0}, {-1,0}};

		queue.offer(start);

		visited[start[0]][start[1]] = true;

		while(!queue.isEmpty()) {

			int[] curr = queue.poll();

			if(curr[0] == dest[0] && curr[1] == dest[1])
				return true;

			for(int[] d : dir) {

				int x = curr[0];
				int y = curr[1];

				while(isValid(maze, x+d[0], y + d[1])) {
					x = x + d[0];
					x = y + d[1];
				}

				if(!visited[x][y]) {
					visited[x][y] = true;
					queue.offer(new int[]{x,y});
				}

			}

		}

		return false;

	}

	private static boolean isValid(int[][] maze, int x, int y) {
		return x >=0 && x < maze.length && y >=0 && y < maze[0].length && maze[x][y] !=1;

	}

}
