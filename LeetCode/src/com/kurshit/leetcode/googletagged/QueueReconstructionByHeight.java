package com.kurshit.leetcode.googletagged;

/*
 * Problem source : https://leetcode.com/problems/queue-reconstruction-by-height/
 * 
 * Problem : You are given an array of people, people, which are the attributes of some people in a queue (not necessarily in order). 
 * Each people[i] = [hi, ki] represents the ith person of height hi with exactly ki other people in front who have a height greater 
 * than or equal to hi.

 * Reconstruct and return the queue that is represented by the input array people. 
 * The returned queue should be formatted as an array queue, where queue[j] = [hj, kj] is the attributes of the jth person in the 
 * queue (queue[0] is the person at the front of the queue).
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class QueueReconstructionByHeight {
	
	public static void main(String[] args) {
		int[][] people ={{7,0},{4,4},{7,1},{5,0},{6,1},{5,2}};
		int[][] result = reconstructQueue(people);
		//Expected - [[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
		for(int[] a : result) {
			System.out.print(a[0] + " " + a[1]);
			System.out.println();
		}
	}
	
	public static int[][] reconstructQueue(int[][] people) {
		//sort the array in descending order of people[0] - heights.
		//If heights are equal, sort based on people[1] in ascending
		
		Arrays.sort(people, new Comparator<int[]>() {
			public int compare(int[] o1, int[] o2) {
				return o1[0] == o2[0] ? o1[1] - o2[1] : o2[0] - o1[0];
			}
		});
		
				
		List<int[]> list = new ArrayList<>();
		
		for(int[] p : people) {
			list.add(p[1], p);
		}
		
		//following will not work. Because in aboe list.add(index, array), if element is already present at that index, it will shift those elements to the right
		
//		for(int[] p : people) {
//			result[p[1]][0] = p[0];
//			result[p[1]][1] = p[1];
//		}
		
		int n = people.length;
		return list.toArray(new int[n][2]);	
		
	}
}
