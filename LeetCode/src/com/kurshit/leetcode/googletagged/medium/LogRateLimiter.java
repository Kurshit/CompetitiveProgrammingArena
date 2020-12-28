package com.kurshit.leetcode.googletagged.medium;

import java.util.HashSet;
import java.util.LinkedList;

/*
 * Design a logger system that receive stream of messages along with its timestamps, each message should be printed if and only if it is not printed in the last 10 seconds.

 *	Given a message and a timestamp (in seconds granularity), return true if the message should be printed in the given timestamp, otherwise returns false.
	
 *	It is possible that several messages arrive roughly at the same time.
 *
 *	Logger logger = new Logger();

	// logging string "foo" at timestamp 1
	logger.shouldPrintMessage(1, "foo"); returns true; 
	
	// logging string "bar" at timestamp 2
	logger.shouldPrintMessage(2,"bar"); returns true;
	
	// logging string "foo" at timestamp 3
	logger.shouldPrintMessage(3,"foo"); returns false;
	
	// logging string "bar" at timestamp 8
	logger.shouldPrintMessage(8,"bar"); returns false;
	
	// logging string "foo" at timestamp 10
	logger.shouldPrintMessage(10,"foo"); returns false;
	
	// logging string "foo" at timestamp 11
	logger.shouldPrintMessage(11,"foo"); returns true;


 */

public class LogRateLimiter {

	public static void main(String[] args) {
		
		LogRateLimiter logger = new LogRateLimiter();

		// logging string "foo" at timestamp 1
		System.out.println(logger.shouldPrintMessage(1, "foo")); //returns true; 

		// logging string "bar" at timestamp 2
		System.out.println(logger.shouldPrintMessage(2,"bar")); //returns true;

		// logging string "foo" at timestamp 3
		System.out.println(logger.shouldPrintMessage(3,"foo")); //returns false;

		// logging string "bar" at timestamp 8
		System.out.println(logger.shouldPrintMessage(8,"bar")); //returns false;

		// logging string "foo" at timestamp 10
		System.out.println(logger.shouldPrintMessage(10,"foo")); //returns false;

		// logging string "foo" at timestamp 11
		System.out.println(logger.shouldPrintMessage(11,"foo")); //returns true;
		
	}
	

	  private LinkedList<Pair<String, Integer>> msgQueue;
	  private HashSet<String> msgSet;

	  /** Initialize your data structure here. */
	  public LogRateLimiter() {
	    msgQueue = new LinkedList<Pair<String, Integer>>();
	    msgSet = new HashSet<String>();
	  }

	  /**
	   * Returns true if the message should be printed in the given timestamp, otherwise returns false.
	   */
	  public boolean shouldPrintMessage(int timestamp, String message) {

	    // clean up.
	    while (msgQueue.size() > 0) {
	      Pair<String, Integer> head = msgQueue.peek();
	      if (timestamp - head.second >= 10) {
	        msgQueue.removeFirst();
	        msgSet.remove(head.first);
	      } else
	        break;
	    }

	    if (!msgSet.contains(message)) {
	      Pair<String, Integer> newEntry = new Pair<String, Integer>(message, timestamp);
	      msgQueue.addLast(newEntry);
	      msgSet.add(message);
	      return true;
	    } else
	      return false;

	  }
	
	

}

class Pair<U, V> {
	  public U first;
	  public V second;

	  public Pair(U first, V second) {
	    this.first = first;
	    this.second = second;
	  }
}