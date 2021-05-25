package com.kurshit.leetcode.googletagged;

/* 
 * Problem Source : https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/
 * Problem : There are several cards arranged in a row, and each card has an associated number of points The points are given in 
 * the integer array cardPoints.

	In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
	
	Your score is the sum of the points of the cards you have taken.
	
	Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
	
	Example : 
	
	Input: cardPoints = [1,2,3,4,5,6,1], k = 3
	Output: 12
	Explanation: After the first step, your score will always be 1. However, choosing the rightmost card first 
	will maximize your total score. The optimal strategy is to take the three cards on the right, 
	giving a final score of 1 + 6 + 5 = 12.
	
	Example 2: 
	
	Input: cardPoints = [2,2,2], k = 2
	Output: 4
	Explanation: Regardless of which two cards you take, your score will always be 4.
 */

public class MaximumPointsFromCards {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 1};
		int K = 3;
		System.out.println(getMaxPoints(arr, K));

	}
	
	public static int getMaxPoints(int[] cards, int K) {
		
		int maxPoints  = Integer.MIN_VALUE;
		
		int[] leftSum = new int[K+1];
		int[] rightSum = new int[K+1];
		
		leftSum[0] = 0;
		
		for(int i=1; i <= K; i++) {
			leftSum[i] = leftSum[i-1] + cards[i-1];
		}
		
		for(int i=1; i<= K; i++) {
			rightSum[i] = rightSum[i-1] + cards[cards.length - i];
		}
		
		for(int i=0; i <=K; i++) {
			int sum = leftSum[i] + rightSum[K-i];
			maxPoints = Math.max(maxPoints, sum);
		}
		
		return maxPoints;
	}
}
