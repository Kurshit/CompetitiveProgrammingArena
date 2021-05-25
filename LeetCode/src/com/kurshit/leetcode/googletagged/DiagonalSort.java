package com.kurshit.leetcode.googletagged;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DiagonalSort {

	public static void main(String[] args) {
		
		int[][] arr = { 
				{3, 3, 1, 1},
				{2, 2, 1, 2},
				{1, 1, 1, 2}					
		};
		
		int[][] result = sortDiagonally(arr);
		
		for(int i=0; i< result.length; i++) {
			for(int j=0; j < result[0].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}

	}
	
	public static int[][] sortDiagonally(int[][] arr) {
		int[][] result = new int[arr.length][arr[0].length];
		
		Map<Integer, List<Integer>> map = new HashMap<>();
		int M = arr.length;
		int N = arr[0].length;
		for(int i=0; i < M; i++) {
			for(int j=0; j<N; j++) {
				
				int index = i-j;
				
				if(map.containsKey(index)) {
					map.get(index).add(arr[i][j]);
				} else {
					List<Integer> list = new ArrayList<>();
					list.add(arr[i][j]);
					map.put(index, list);
				}
				
			}
		}
		
		for(List<Integer> value : map.values()) {
			Collections.sort(value);
		}
		
		for(int i=0; i < M; i++) {
			for(int j=0; j < N; j++) {
				int index = i-j;
				result[i][j] = map.get(index).get(0);
				map.get(index).remove(0);
			}
		}
		
		
		return result;
	}

}
