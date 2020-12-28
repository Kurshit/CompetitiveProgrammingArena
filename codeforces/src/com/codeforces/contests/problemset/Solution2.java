package com.codeforces.contests.problemset;

import java.util.Scanner;

public class Solution2 {

	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
				
			int N = sc.nextInt();
			int[] arr = new int[N];
			for(int i=0; i < N ; i++) {
				arr[i] = sc.nextInt();
			}
			
			int[] result = new int[N];
			
			int i=0;
			int ptr = 0;
			while(i < N) {
				
				result[i] = arr[ptr]; 
				ptr++;
				i = i+2;
			}
			
			i = 1;
			ptr = N-1;
			while(i < N) {
				result[i] = arr[ptr];
				i = i +2;
				ptr--;
			}
			
			for(int it : result) {
				System.out.print(it + " ");
			}
			
			System.out.println();
		}
		
		sc.close();
		
		
	}

}
