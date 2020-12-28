package com.kurshit.leetcode.googletagged.medium;

import java.util.TreeMap;

/*
 * Problem Source : https://leetcode.com/problems/my-calendar-i/
 * Problem : Implement a MyCalendar class to store your events. A new event can be added if adding the event will not cause a double booking.

	Your class will have the method, book(int start, int end). Formally, this represents a booking on the half open interval [start, end), 
	the range of real numbers x such that start <= x < end.
	
	A double booking happens when two events have some non-empty intersection (ie., there is some time that is common to both events.)
	
	For each call to the method MyCalendar.book, return true if the event can be added to the calendar successfully without causing a double booking. 
	Otherwise, return false and do not add the event to the calendar.
	
	Your class will be called like this: MyCalendar cal = new MyCalendar();
	
	MyCalendar();
	MyCalendar.book(10, 20); // returns true
	MyCalendar.book(15, 25); // returns false
	MyCalendar.book(20, 30); // returns true
	Explanation: 
	The first event can be booked.  The second can't because time 15 is already booked by another event.
	The third event can be booked, as the first event takes every time less than 20, but not including 20.

 *
 */

public class CalenderI {
	
	//Keeps start and end
	TreeMap<Integer, Integer> bookingsMap = new TreeMap<>();
	
	public CalenderI() {
		
	}
	
	public static void main(String[] args) {
		
		CalenderI c = new CalenderI();
//		System.out.println("Test cases 1");
//		System.out.println("Should be True " + c.hasConflicts(10, 20));
//		System.out.println("Should be False " + c.hasConflicts(15, 25));
//		System.out.println("Should be True " + c.hasConflicts(20, 30));
		
		System.out.println("Test cases 1");
		System.out.println("Should be True " + c.hasConflicts(37, 50));
		System.out.println("Should be False " + c.hasConflicts(33, 50));
		System.out.println("Should be True " + c.hasConflicts(20, 30));
		
		System.out.println();
		System.out.println("Test cases 2");
		System.out.println();
		CalenderI c1 = new CalenderI();
		System.out.println("Should be True " + c1.hasConflicts(47, 50));
		System.out.println("Should be True " + c1.hasConflicts(33, 41));
		System.out.println("Should be False " + c1.hasConflicts(39, 45));
		System.out.println("Should be False " + c1.hasConflicts(33, 42));
		System.out.println("Should be True " + c1.hasConflicts(25, 32));
		System.out.println("Should be False " + c1.hasConflicts(36, 35));
		System.out.println("Should be True " + c1.hasConflicts(19, 25));
		System.out.println("Should be True " + c1.hasConflicts(3, 8));
		System.out.println("Should be True " + c1.hasConflicts(8, 13));
		System.out.println("Should be False " + c1.hasConflicts(18, 27));
	}
	
	/*
	 * The TreeMap will contain the start and end parameters. For each new booking, we will check conflict with previous and next booking in the sequence.
	 * TreeMap is useful here as it will keep track of start and end meeting in sequence of start time in Map.
	 * 
	 * Also, we use floorKey and ceilingKey to fetch adjacent meetings/bookings from TreeMap.
	 */
	
	public boolean hasConflicts(int start, int end) {
		
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
