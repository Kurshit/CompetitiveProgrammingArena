package com.kurshit.leetcode.googletagged;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {
		
		int[][] intervals = {{1,3},{2,6},{8,10},{15,18}};
		int[][] result = merge(intervals);
		for(int[] arr : result) {
			System.out.println(Arrays.toString(arr));
		}
	}

	public static int[][] merge(int[][] intervals) {
		
		//Arrays.sort(intervals, (int[] a1, int[] a2) -> a1[0] - a2[0]);
		Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
		
		LinkedList<int[]> merged = new LinkedList<>();
		
		for(int[] anInterval : intervals) {
			
			if(merged.isEmpty() || merged.getLast()[1] < anInterval[0]) {
				merged.add(anInterval);
			} else {
				merged.getLast()[1] = Math.max(merged.getLast()[1], anInterval[1]);
			}
		}
		
		return merged.toArray(new int[merged.size()][]);
		
	}

}