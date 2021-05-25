package com.kurshit.leetcode.googletagged;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * Problem Source : https://leetcode.com/problems/top-k-frequent-words/ 
 * 
 * Solution Source : https://leetcode.com/problems/top-k-frequent-words/discuss/108346/My-simple-Java-solution-using-HashMap-and-PriorityQueue-O(nlogk)-time-and-O(n)-space
 *
 */

public class TopKFrequentWords {

	public static void main(String[] args) {
		
		String[] arr = {"i", "love", "leetcode", "i", "love", "coding"};
		
		int K = 2;
		
		System.out.println(topKFrequent(arr, K));

	}
	
	public static List<String> topKFrequent(String[] words, int K) {
		
		Map<String, Integer> freqMap = new HashMap<>();
		
		for(String word : words) {
			freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
		}
		
		PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((e1, e2) -> e1.getValue().equals(e2.getValue()) ? e2.getKey().compareTo(e1.getKey())
				: e1.getValue() - e2.getValue());
		
		
		for(Map.Entry<String, Integer> entry : freqMap.entrySet()) {
			
			pq.offer(entry);
			
			if(pq.size() > K)
				pq.poll();
		}
		int i = pq.size()-1;
		List<String> result = new ArrayList<>(i+1);
		
		while(!pq.isEmpty()) {
			result.add(0, pq.poll().getKey()); // adding at 0th index
			i--;
		}
		
		return result;
	}

}
