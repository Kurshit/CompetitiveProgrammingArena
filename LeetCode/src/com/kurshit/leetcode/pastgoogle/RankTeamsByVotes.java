package com.kurshit.leetcode.pastgoogle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Problem Source : https://leetcode.com/problems/rank-teams-by-votes/
 * 
 * Problem : In a special ranking system, each voter gives a rank from highest to lowest to all teams participated in the competition.

	The ordering of teams is decided by who received the most position-one votes. If two or more teams tie in the first position, we consider the second position to resolve the conflict, if they tie again, we continue this process until the ties are resolved. If two or more teams are still tied after considering all positions, we rank them alphabetically based on their team letter.

	Given an array of strings votes which is the votes of all voters in the ranking systems. Sort all teams according to the ranking system described above.

	Return a string of all teams sorted by the ranking system.

	Ex: 
	Input: votes = ["ABC","ACB","ABC","ACB","ACB"]
	Output: "ACB"
	Explanation: Team A was ranked first place by 5 voters. No other team was voted as first place so team A is the first team.
	Team B was ranked second by 2 voters and was ranked third by 3 voters.
	Team C was ranked second by 3 voters and was ranked third by 2 voters.
	As most of the voters ranked C second, team C is the second team and team B is the third.

	Ex 2
	Input: votes = ["WXYZ","XYZW"]
	Output: "XWYZ"
	Explanation: X is the winner due to tie-breaking rule. X has same votes as W for the first position but X has one vote as 
	second position while W doesn't have any votes as second position. 

	Input: votes = ["ZMNAGUEDSJYLBOPHRQICWFXTVK"]
	Output: "ZMNAGUEDSJYLBOPHRQICWFXTVK"
	Explanation: Only one voter so his votes are used for the ranking.
	Example 4:

	Input: votes = ["BCA","CAB","CBA","ABC","ACB","BAC"]
	Output: "ABC"
	Explanation: 
	Team A was ranked first by 2 voters, second by 2 voters and third by 2 voters.
	Team B was ranked first by 2 voters, second by 2 voters and third by 2 voters.
	Team C was ranked first by 2 voters, second by 2 voters and third by 2 voters.
	There is a tie and we rank teams ascending by their IDs.

 */ 

public class RankTeamsByVotes {

	public static void main(String[] args) {
		String[] votes = {"ABC","ACB","ABC","ACB","ACB"};
		System.out.println(rankTeams(votes));
		
		String[] votes1 = {"WXYZ","XYZW"};
		System.out.println(rankTeams(votes1));
		
		
		String[] votes2 = {"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
		System.out.println(rankTeams(votes2));
		
		
		String[] votes3 = {"BCA","CAB","CBA","ABC","ACB","BAC"};
		System.out.println(rankTeams(votes3));
		
		

	}

	public static String rankTeams(String[] votes) {
		Map<Character, int[]> map = new HashMap<>();
		int l = votes[0].length();
		for(String vote : votes){
			for(int i = 0; i < l; i++){
				char c = vote.charAt(i);
				map.putIfAbsent(c, new int[l]);
				map.get(c)[i]++;
			}
		}

		List<Character> list = new ArrayList<>(map.keySet());
		Collections.sort(list, (a,b) -> {
			for(int i = 0; i < l; i++){
				if(map.get(a)[i] != map.get(b)[i]){
					return map.get(b)[i] - map.get(a)[i];
				}
			}
			return a - b;
		});

		StringBuilder sb = new StringBuilder();
		for(char c : list){
			sb.append(c);
		}
		return sb.toString();
	}

}
