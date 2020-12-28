package com.kurshit.leetcode.lccurated.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/*
 * Problem : 1086
 * Source URL : https://leetcode.com/problems/high-five/
 * 
 * Given a list of the scores of different students, items, where items[i] = [IDi, scorei] represents one score from a student with IDi, 
 * calculate each student's top five average.

	Return the answer as an array of pairs result, where result[j] = [IDj, topFiveAveragej] represents the student with IDj and their 
	top five average. Sort result by IDj in increasing order.
	
	A student's top five average is calculated by taking the sum of their top five scores and dividing it by 5 using integer division.
 * 
 */

public class HighFive {

	public static void main(String[] args) {
		int[][] items = {{1,91},{1,92},{2,93},{2,97},{1,60},{2,77},{1,65},{1,87},{1,100},{2,100},{2,76}};
		int[][] result = highFive(items);
		
		for(int[] arr : result) {
			System.out.println(arr[0] + " " + arr[1]);
		}

	}
	
	public static int[][] highFive(int[][] items) {
		Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
		
		for(int[] marks : items) {
			
			int id = marks[0];
			int score = marks[1];
			
			if(!map.containsKey(id)) {
				PriorityQueue<Integer> pq = new PriorityQueue<>();				
				pq.offer(score);
				map.put(id, pq);
			} else {
				PriorityQueue<Integer> pq = map.get(id);
				
				pq.offer(score);
				
				if(pq.size() > 5)
					pq.poll();
			}
		}
		
		int[][] result = new int[map.size()][2];
		
		Set<Integer> ids = map.keySet();
		int index = 0;
		
		for(int key : ids) {
			result[index][0] = key;
			
			PriorityQueue<Integer> pq = map.get(key);
			int sum = 0;
			int size = pq.size();
			while(!pq.isEmpty()) {
				sum = sum + pq.poll();
			}
			
			int avg = sum / size;
			
			result[index][1] = avg;
			index++;
		}
		
		return result;
    }

}
