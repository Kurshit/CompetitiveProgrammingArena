package com.kurshit.codeforces.pastcontests.div3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * https://codeforces.com/contest/1454/problem/B
 * 
 * Problem : Let's simplify this game a bit. Formally, there are n participants, the i-th participant chose the number ai. The winner of the game is such a participant that the number he chose is unique (i. e. nobody else chose this number except him) and is minimal (i. e. among all unique values of a the minimum one is the winning one).

 * Your task is to find the index of the participant who won the game (or -1 if there is no winner). 
 * Indexing is 1-based, i. e. the participants are numbered from 1 to n.
 *  
 */

public class UniqueBidAuction {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		UniqueBidAuction u = new UniqueBidAuction();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			int[] arr = new int[N+1];
			for(int i=1; i <= N; i++)
				arr[i] = sc.nextInt();
			
			System.out.println(u.getWinner(arr, N));
		}

	}
	
	public int getWinner(int[] arr, int N) {
		
		if(N == 0)
			return -1;
		
		List<Integer>[] listArr = new ArrayList[N+1];
		
		for(int i =1; i<=N; i++)
			listArr[i] = new ArrayList<>();
		
		for(int i=1; i <= N; i++) {
			listArr[arr[i]].add(i);
		}
		
		for(int i = 1; i <= N; i++) {
			if(listArr[i].size() == 1) {
				return listArr[i].get(0);
			}
		}
		return -1;
		
	}

}
