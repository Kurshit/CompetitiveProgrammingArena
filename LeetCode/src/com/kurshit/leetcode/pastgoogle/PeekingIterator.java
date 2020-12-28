package com.kurshit.leetcode.pastgoogle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/*
 * Problem source : https://leetcode.com/problems/peeking-iterator/solution/
 * 
 * Problem :Given an Iterator class interface with methods: next() and hasNext(), design and implement a PeekingIterator that 
 * support the peek() operation -- it essentially peek() at the element that will be returned by the next call to next().
 */

/*
 * Approach 1 : Saving peeked value
 * 
 * Each time we call .next(...), a value is returned from the Iterator. If we call .next(...) again, a new value will 
 * be returned. This means that if we want to use a particular value multiple times, we had better save it.

		Our .peek(...) method needs to call .next(...) on the Iterator. But because .next(...) will return a different 
		value next time, we need to store the value we peeked so when .next(...) is called we return the correct value.
 */


public class PeekingIterator implements Iterator<Integer>{
	
	private Iterator<Integer> itr;
	private Integer peekedValue;
	
	public PeekingIterator(Iterator<Integer> itr) {
		this.itr = itr;
	}
	
	public Integer peek() {
		if(peekedValue != null)
			return peekedValue;
		else {
			if(!itr.hasNext()) {
				throw new NoSuchElementException();
			}
			
			peekedValue = itr.next();
			return peekedValue;
		}
	}


	@Override
	public boolean hasNext() {
		
		if(peekedValue == null) {
			return itr.hasNext();
		} else {
			//If peekedValue is not null, meaning peek() has already brought value in itslef from next()
			return true;
		}
		
	}

	@Override
	public Integer next() {
		
		if(peekedValue == null) {
			
			if(!itr.hasNext()) {
				throw new NoSuchElementException();
			} 
			
			return itr.next();
		} else {
			Integer tempPeekedValue = peekedValue;
			peekedValue = null;
			return tempPeekedValue;			
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		list.add(50);
		
		
		PeekingIterator pItr = new PeekingIterator(list.iterator());
		
		System.out.println(pItr.hasNext());
		System.out.println(pItr.peek());
		System.out.println(pItr.next());
		System.out.println(pItr.next());
		System.out.println(pItr.peek());
		System.out.println(pItr.hasNext());
		System.out.println(pItr.next());
		System.out.println(pItr.next());
		
	}
}
