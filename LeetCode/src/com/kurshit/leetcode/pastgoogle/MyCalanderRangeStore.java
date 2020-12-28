package com.kurshit.leetcode.pastgoogle;

import java.util.TreeMap;

public class MyCalanderRangeStore {
	
	TreeMap<Integer, Integer> bookingsMap = new TreeMap<>();
	
	public MyCalanderRangeStore() {
		
	}
	
	public static void main(String[] args) {
		MyCalanderRangeStore m = new MyCalanderRangeStore();
		System.out.println(m.book(10, 20)); // returns true
		System.out.println(m.book(15, 25)); // returns false
		System.out.println(m.book(20, 30)); // returns true
	}

	public boolean book(int start, int end) {


		if(bookingsMap.containsKey(start))
			return false;

		int prevKey = bookingsMap.floorKey(start) != null ? bookingsMap.floorKey(start) : -1;

		int nextKey = bookingsMap.ceilingKey(start) != null ? bookingsMap.ceilingKey(start) : -1;

		if((prevKey == -1 || start >= bookingsMap.get(prevKey)) && (nextKey == -1 || end <= nextKey)) {
			bookingsMap.put(start, end);
			return true;
		}

		return false;


	}
}