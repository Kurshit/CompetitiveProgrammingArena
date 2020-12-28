package com.kurshit.leetcode.googletagged.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class TimeNeededToInformAllEmployees {

	public static void main(String[] args) {
		int headId = 0;
		int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
		int[] informTime = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
		System.out.println(getTime(15, headId, manager, informTime));

	}
	
	public static int getTime(int n, int headId, int[] manager, int[] informTime) {
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		
		
		for(int i=0; i <n; i++) {
			
			if(map.containsKey(manager[i])) {
				map.get(manager[i]).add(i);
			} else {
				List<Integer> list = new ArrayList<>();
				list.add(i);
				map.put(manager[i], list);
			}
		}
		
		Queue<int[]> q = new LinkedList<>();
		
		q.offer(new int[]{headId, 0});
		int result = Integer.MIN_VALUE;
		while(!q.isEmpty()) {
			
			int curr[] = q.poll();
			
			int id = curr[0];
			int time = curr[1];
			
			int timeSoFar = time + informTime[id];
			result = Math.max(result, timeSoFar);
			
			if(!map.containsKey(id))
				continue;
			
			for(int item : map.get(id)) {
				q.offer(new int[] {item, timeSoFar});
			}
			
		}
		
		return result;
	}

}
