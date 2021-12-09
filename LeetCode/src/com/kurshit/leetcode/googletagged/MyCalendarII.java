package com.kurshit.leetcode.googletagged;

/*
    Problem : My Calendar II #731
    Problem Source : https://leetcode.com/problems/my-calendar-ii/

    Problem Statement : You are implementing a program to use as your calendar. We can add a new event if adding the event will not cause a triple booking.

    A triple booking happens when three events have some non-empty intersection (i.e., some moment is common to all the three events.).

    The event can be represented as a pair of integers start and end that represents a booking on the half-open interval [start, end), the range of real numbers x such that start <= x < end.

    Implement the MyCalendarTwo class:

    MyCalendarTwo() Initializes the calendar object.
    boolean book(int start, int end) Returns true if the event can be added to the calendar successfully without causing a triple booking. Otherwise, return false and do not add the event to the calendar.

    Example :

        Input
        ["MyCalendarTwo", "book", "book", "book", "book", "book", "book"]
        [[], [10, 20], [50, 60], [10, 40], [5, 15], [5, 10], [25, 55]]
        Output
        [null, true, true, true, false, true, true]

        Explanation
            MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
            myCalendarTwo.book(10, 20); // return True, The event can be booked.
            myCalendarTwo.book(50, 60); // return True, The event can be booked.
            myCalendarTwo.book(10, 40); // return True, The event can be double booked.
            myCalendarTwo.book(5, 15);  // return False, The event ca not be booked, because it would result in a triple booking.
            myCalendarTwo.book(5, 10); // return True, The event can be booked, as it does not use time 10 which is already double booked.
            myCalendarTwo.book(25, 55); // return True, The event can be booked, as the time in [25, 40) will be double booked with the third event, the time [40, 50) will be single booked, and the time [50, 55) will be double booked with the second event.

 */

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class MyCalendarII {
    List<int[]> books = new ArrayList<>();
    MyCalenderI one;

    TreeMap<Integer, Integer> delta;

    public MyCalendarII() {
        one = new MyCalenderI();
        delta = new TreeMap<>();
    }

    public static void main(String[] args) {
        MyCalendarII two = new MyCalendarII();

        System.out.println("Expected : true    Actual : " + two.book(10, 20));
        System.out.println("Expected : true    Actual : " + two.bookBetter(10, 20));

        System.out.println("Expected : true    Actual : " + two.book(50, 60));
        System.out.println("Expected : true    Actual : " + two.bookBetter(50, 60));

        System.out.println("Expected : true    Actual : " + two.book(10, 40));
        System.out.println("Expected : true    Actual : " + two.bookBetter(10, 40));

        System.out.println("Expected : false    Actual : " + two.book(5, 15));
        System.out.println("Expected : false    Actual : " + two.bookBetter(5, 15));

        System.out.println("Expected : true    Actual : " + two.book(5, 10));
        System.out.println("Expected : true    Actual : " + two.bookBetter(5, 10));

        System.out.println("Expected : true    Actual : " + two.book(25, 55));
        System.out.println("Expected : true    Actual : " + two.bookBetter(25, 55));
    }

    /*
        Approach 1 : Using TreeMap (N2) - BETTER

     */

    public boolean bookBetter(int start, int end) {
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int count = 0;

        for(int d : delta.values()) {
            count = count + d;

            if(count > 2) {
                delta.put(start, delta.get(start) - 1);

                if(delta.get(start) == 0) {
                    delta.remove(start);
                }

                delta.put(end, delta.get(end) + 1);

                if(delta.get(end) == 0) {
                    delta.remove(end);
                }

                return false;
            }
        }
        return true;
    }

    /*
        Approach 2 : Using My Calander ! within this code to check overlapping
     */
    public boolean book(int start, int end) {

        for(int[] book : books) {
            if(Math.max(book[0], start) < Math.min(book[1], end)) {
                if(!one.book(Math.max(book[0], start), Math.min(book[1], end))) {
                    return false;
                }
            }
        }

        books.add(new int[] {start, end});
        return true;
    }

}
