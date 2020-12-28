package com.kurshit.leetcode.pastgoogle;

/*
 * You want to invite as many friends to your party as possible. 
 * You're given list of tuples where each tuple consists of two friend ids and they don't like each other. 
 * Your task is to invite as many friends as possible. Output of the task - max number of friends you can invite which don't have 
 * conflicts with each other.
 * 
 * Example : Input: [(1, 2), (2, 3), (3, 4)]
	Ouput: 2 (it's either (1, 3) or (2, 4) or (1, 4)
 */

public class MaxFriendsAtParty {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	 * Solution Approach : This is based on bipartite graph. Create a bipartitie graph out of input and return the length of max
	 * colored vertices - i.e. color[] would be having 1 & 0 values for each index. Whichever count between 1 & 0 is max. return it.
	 */
	
	

}
