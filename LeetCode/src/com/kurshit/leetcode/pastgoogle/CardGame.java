package com.kurshit.leetcode.pastgoogle;

/*
 * Problem source : https://leetcode.com/discuss/interview-question/537699/
 * 
 *  Problem : Two players are playing a card game where the deck of cards are layed out in a straight line and each card value is 
 *  visible to both the players.
	The value of each card can range from a reasonable [-ve to +ve] number and the length of deck in n.
	
	The rules of the game are such:
	
	Player 1 starts the game
	Each player has 3 option:
	(Option 1: Pick 1st card)
	(Option 2: Pick 1st two cards)
	(Option 3: Pick 1st three cards)
	
	You're only allowed to pick cards from the left side of the deck
	Both players have to play optimally.
	Return the maximum sum of cards Player 1 can obtain by playing optimally.
	
	Example 1:

	Input: cards = [1, 2, -3, 8]
	Output: 3
	Explanation:
	Turn 1: Player 1 picks the first 2 cards: 1 + 2 = 3 points
	Turn 2: Player 2 gets the rest of the deck: -3 + 8 = 5 points
	Example 2:
	
	Input: cards = [1, 1, 1, 1, 100]
	Output: 101
	Explanation:
	Turn 1: Player 1 picks cards[0] = 1 point
	Turn 2: Player 2 picks cards[1] + cards[2] + cards[3] = 3 points
	Turn 3: Player 1 picks cards[4] = 100 points
 * 
 */

public class CardGame {

	public static void main(String[] args) {
		
		int[] arr = {1, 2, -3, 8};
		System.out.println(find(arr));
		
		int[] arr1 = {1, 1, 1, 1, 100};
		
		System.out.println(find(arr1));

	}
	
	public static int find(int[] cards) {
	    if (cards == null || cards.length == 0) {
	        return 0;
	    }

	    int sum = 0;
	    int n = cards.length;
	    int[] dp = new int[n+3];        // dp[i] means the max possible score the 1st player can get starting from index i
	    for (int i = n-1; i>=0; i--) {
	        sum = sum + cards[i];        // sum is the post-sum
	        int min = Integer.MAX_VALUE;
	        for (int j=1; j<=3; j++) {
	            if (dp[i+j] < min) {  // best strategy means we take the option that minimizes the max possible score for our opponent
	                min = dp[i+j];
	            }
	        }
	        dp[i] = sum - min;  // we then get (total - the minimized possible score for our opponent)
	    }
	    return dp[0];
	}

}
