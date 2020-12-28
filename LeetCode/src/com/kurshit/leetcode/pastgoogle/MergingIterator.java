package com.kurshit.leetcode.pastgoogle;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * Problem Source : https://leetcode.com/discuss/interview-question/345744
 * 
 * Solution Source : https://leetcode.com/playground/Eu9epFf5
 * 
 * Problem :Given a list of k sorted iterators. Implement MergingIterator to merge them. 
 * If you are not familiar with Iterators check similar questions
 * 
 * Example: 
 * MergingIterator itr = new MergingIterator([[2, 5, 9], [], [4, 10]]);
		itr.hasNext(); // true
		itr.next(); // 2
		itr.next(); // 4
		itr.next(); // 5
		itr.next(); // 9
		itr.next(); // 10
		itr.hasNext(); // false
		itr.next(); // error
 * 
 * 
 */

public class MergingIterator implements Iterator<Integer>{
	
	private final Queue<PeekingIterator> queue;
	
	public MergingIterator(List<Iterator<Integer>> iterators) {
        queue = new PriorityQueue<>(iterators.size(), (i1, i2) -> Integer.compare(i1.peek(), i2.peek()));
        for (Iterator<Integer> iterator : iterators) {
            if (iterator.hasNext()) {
                queue.add(new PeekingIterator(iterator));
            }
        }
    }

	@Override
	public boolean hasNext() {
		return !queue.isEmpty();
	}

	@Override
	public Integer next() {
		PeekingIterator nextIter = queue.poll();
        Integer next = nextIter.next();
        if (nextIter.hasNext()) {
            queue.add(nextIter);
        }
        return next;
	}
	
	public static void main(String[] args) {
		
		
		Iterator<Integer> it1 = Arrays.asList(2, 5, 9).iterator();
        Iterator<Integer> it2 = Collections.emptyIterator();
        Iterator<Integer> it3 = Arrays.asList(4, 10).iterator();
        
        MergingIterator itr = new MergingIterator(Arrays.asList(it1, it2, it3));
        
		System.out.println(itr.hasNext()); // true
		System.out.println(itr.next()); // 2
		System.out.println(itr.next()); // 4
		System.out.println(itr.next()); // 5
		System.out.println(itr.next()); // 9
		System.out.println(itr.next()); // 10
		System.out.println(itr.hasNext()); // false
		//itr.next(); // error

        
	}

}
