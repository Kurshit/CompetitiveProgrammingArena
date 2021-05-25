package com.kurshit.leetcode.googletagged;

/*
 * Problem Source : https://leetcode.com/problems/validate-stack-sequences/
 * Problem: Given two sequences pushed and popped with distinct values, return true if and only if this could have been the 
 * result of a sequence of push and pop operations on an initially empty stack.
 * 
 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
	Output: true
	Explanation: We might do the following sequence:
	push(1), push(2), push(3), push(4), pop() -> 4,
	push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
	
	Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
	Output: false
	Explanation: 1 cannot be popped before 2.
 */

import java.util.Stack;

public class ValidateStackSequences {

	public static void main(String[] args) {
		
		int[] push = {1, 2, 3, 4, 5};
		int[] pop = {4, 5, 3, 2, 1};
		//expected - true
		System.out.println(isStackSequenceValid(push, pop));
		
		int[] push1 = {1, 2, 3, 4, 5};
		int[] pop1 = {4, 3, 5, 1, 2};
		//expected = false
		System.out.println(isStackSequenceValid(push1, pop1));


	}
	
	public static boolean isStackSequenceValid(int[] pushed, int[] popped) {
		
		Stack<Integer> stack = new Stack<>();
		int N = pushed.length;
		int j = 0;
		for(int pushItem : pushed) {
			
			stack.push(pushItem);
			
			while(!stack.isEmpty() && j < N && popped[j] == stack.peek()) {
				stack.pop();
				j++;
			}
			
		}
		
	 	
		return j == N;
	}
	
	int[] push = {1, 2, 3, 4, 5};
	int[] pop = {4, 5, 3, 2, 1};

}
