package com.kurshit.leetcode.googletagged;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Problem sources : https://www.geeksforgeeks.org/find-k-numbers-occurrences-given-array/
 * 
 * 		https://leetcode.com/problems/top-k-frequent-elements/
 * 
 * Problem : 
 *  1. Leetcode : Given a non-empty array of integers, return the k most frequent elements. Return output in any order
 *  
 *   2. GFG :Given an array of n numbers and a positive integer k. The problem is to find k numbers with most occurrences, i.e., 
 *   the top k numbers having the maximum frequency. If two numbers have the same frequency then the larger number should be 
 *   given preference. The numbers should be displayed in decreasing order of their frequencies. 
 *   It is assumed that the array consists of k numbers with most occurrences.
 *   
 *   Solution : Solution ref in GFG are best
 */

public class TopKFrequentIntegers {

	public static void main(String[] args) {
		int[] arr = {1,1,1,2,2,3};
		int K = 2;
		System.out.println(Arrays.toString(getTopKFrequentIntegers(arr, K)));
		System.out.println(Arrays.toString(getTopKFrequentIntegersBySortingMap(arr, K)));

		int[] arr1 = {7, 10, 11, 5, 2, 5, 5, 7, 11, 8, 9};
		K = 4;
		System.out.println(Arrays.toString(getTopKFrequentIntegers(arr1, K)));
		System.out.println(Arrays.toString(getTopKFrequentIntegersBySortingMap(arr1, K)));


	}

	/*
	 * Approach 1 : Using HashMap and PriorityQueue
	 */

	public static int[] getTopKFrequentIntegers(int[] arr, int K) {

		Map<Integer, Integer> freqMap = new HashMap<>();

		for(int i : arr) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}


		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
				new Comparator<Map.Entry<Integer, Integer>>() {
					public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
						return o1.getValue().equals(o2.getValue()) ? 
								Integer.compare(o2.getKey(), o1.getKey()) : Integer.compare(o2.getValue(), o1.getValue());
					}
		});

		for(Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {

			pq.offer(entry);

			//			if(pq.size() > K) {
			//				pq.poll();
			//			}

		}

		int[] result = new int[K];

		for(int i=0; i < K; i++) {
			result[i] = pq.poll().getKey();
		}

		return result;
	}

	/*
	 * Approach 2 : Using HashMap and sorting the hashmap based on values. - Interesting one
	 */

	public static int[] getTopKFrequentIntegersBySortingMap(int[] arr, int K) {

		Map<Integer, Integer> freqMap = new HashMap<>();

		for(int i : arr) {
			freqMap.put(i, freqMap.getOrDefault(i, 0) + 1);
		}


		List<Map.Entry<Integer, Integer>> mapList = new ArrayList<>(freqMap.entrySet());
		
		Collections.sort(mapList, new Comparator<Map.Entry<Integer, Integer>>(){
			public int compare(Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) {
				return e1.getValue().equals(e2.getValue()) ? 
						Integer.compare(e2.getKey(), e1.getKey()) : e2.getValue() - e1.getValue();
			}
		});

		int[] result = new int[K];

		for(int i=0; i < K; i++) {
			result[i] = mapList.get(i).getKey();
		}

		return result;
	}
}
