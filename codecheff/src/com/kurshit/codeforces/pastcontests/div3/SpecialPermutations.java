package com.kurshit.codeforces.pastcontests.div3;

/*
 * https://codeforces.com/contest/1454/problem/B
 * 
 * Let's simplify this game a bit. Formally, there are n participants, the i-th participant chose the number ai. 
 * The winner of the game is such a participant that the number he chose is unique (i. e. nobody else chose this number except him) and is minimal (i. e. among all unique values of a the minimum one is the winning one).

 * Your task is to find the index of the participant who won the game (or -1 if there is no winner). 
 * Indexing is 1-based, i. e. the participants are numbered from 1 to n.

 */


import java.util.Scanner;

public class SpecialPermutations {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		SpecialPermutations s = new SpecialPermutations();
		while(T-- > 0) {
			int N = sc.nextInt();
			s.specialPermutations(N);
			System.out.println();
		}
		
		sc.close();

	}
	
	public void specialPermutations(int N) {
		if(N == 0)
			return;
		int temp = 1;
		for(int i=2; i <=N; i++) {
			System.out.print(i + " ");
		}
		System.out.print(1);
	}

}
