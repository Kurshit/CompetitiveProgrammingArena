
package com.kurshit.leetcode.pastgoogle;

/*
 * Problem Source : https://leetcode.com/discuss/interview-question/339111/
 * 
 * Solution : Ref from comments - https://leetcode.com/discuss/interview-question/339111/
 * 
 * Problem :
 * https://leetcode.com/discuss/interview-question/339111/
 * 
 *  Given 2 binary expression trees tree1 and tree2. The leaves of a binary expression tree are variable names and the other nodes contain operators. Find out if the expressions represented by these trees are equal or not.
		There are only plus signs + and letters in the tree. Input is guaranteed to be valid.
		
		Example 1:
		
		Input:
			 tree1
			   +
			 /   \
			a     b
		
			 tree2
			   +
			 /   \
			b     a
		Output: true
		Explanation: a + b = b + a
		Example 2:
		
		Input:
			 tree1
				+
			  /   \
			 a     +
				  / \
				 c   de
		
			 tree2
				+
			  /   \
			 +     de
			/ \
		   a   c
		
		Output: true
		Explanation: a + (c + de) == (a + c) + de
 *
 */

import java.util.HashMap;

public class ExpressionTreeEval {

	public static void main(String[] args) {

		CharNode rootFirst1 = TestSample.testCaseFirst1();
		
		CharNode rootFirst2 = TestSample.testCaseFirst2();

		ExpressionTreeEval e1 = new ExpressionTreeEval();

		System.out.println(e1.isEqual(rootFirst1, rootFirst2));
		
		CharNode rootSecond1 = TestSample.testCaseSecond1();
		
		CharNode rootSecond2 = TestSample.testCaseSecond2();
		ExpressionTreeEval e2 = new ExpressionTreeEval();
		System.out.println(e2.isEqual(rootSecond1, rootSecond2));
		
		CharNode rootSecond3 = TestSample.testCaseSecond3();
		ExpressionTreeEval e3 = new ExpressionTreeEval();
		System.out.println(e3.isEqual(rootSecond1, rootSecond3));

	}

	HashMap<Character, Integer> freqs = new HashMap<>();

	public  boolean isEqual(CharNode rootA, CharNode rootB){
		fillFreqs(rootA, 1);
		fillFreqs(rootB, -1);
		for(int freq : freqs.values()){
			if(freq!=0)
				return false; 
		}
		return true;
	}


	public  void fillFreqs(CharNode curr,int signParent){
		if(curr == null) 
			return;
		
		if(curr.data == '+'){
			fillFreqs(curr.left, signParent);
			fillFreqs(curr.right, signParent);
		}else if(curr.data == '-'){
			fillFreqs(curr.left, signParent);
			fillFreqs(curr.right, -signParent);
		}else{
			freqs.put(curr.data, freqs.getOrDefault(curr.data, 0) + signParent);
		}
	}

}

class CharNode {
	char data;
	CharNode left, right;

	public CharNode(char data) {
		this.data = data;
	}
}

class TestSample {

	public static CharNode testCaseFirst1() {

		CharNode root1 = new CharNode('+');
		root1.left = new CharNode('a');
		root1.right = new CharNode('b');
		return root1;
	}

	public static CharNode testCaseFirst2() {

		CharNode root1 = new CharNode('+');
		root1.left = new CharNode('b');
		root1.right = new CharNode('a');
		return root1;
	}
	
	public static CharNode testCaseSecond1() {

		CharNode root1 = new CharNode('-');
		root1.left = new CharNode('+');
		root1.right = new CharNode('b');
		
		root1.left.left = new CharNode('a');
		root1.left.right = new CharNode('c');
		return root1;
	}

	public static CharNode testCaseSecond2() {

		CharNode root1 = new CharNode('+');
		root1.left = new CharNode('-');
		root1.right = new CharNode('c');
		
		root1.left.left = new CharNode('b');
		root1.left.right = new CharNode('a');
		return root1;
	}
	
	public static CharNode testCaseSecond3() {

		CharNode root1 = new CharNode('+');
		root1.left = new CharNode('-');
		root1.right = new CharNode('c');
		
		root1.left.left = new CharNode('a');
		root1.left.right = new CharNode('b');
		return root1;
	}



}