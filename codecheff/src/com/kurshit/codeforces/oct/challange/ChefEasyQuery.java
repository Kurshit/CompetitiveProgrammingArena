package com.kurshit.codeforces.oct.challange;

import java.util.Scanner;

public class ChefEasyQuery {
	static long totalSum = 0;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ChefEasyQuery c = new ChefEasyQuery();
		try {
			
			long T = sc.nextInt();
			
			while(T-- >0) {
				System.out.println(c.solve(sc));				
			}
			

		}catch(Exception e) {
			
		}finally {
			sc.close();
		}
	}
	
	public long solve(Scanner sc) {

		try {
			int N = sc.nextInt();			
			int K = sc.nextInt();
			
			if(N == 0)
				return 0;
			
			long sum = 0;
//			long day = 0;
			long[] arr = new long[N];
//			
			for(int i =0; i <arr.length; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i =0; i < N; i++) {
				
				sum = sum + arr[i];
				if((sum/K) < i+1)
					return i+1;
			}			
			
			return sum/K + 1;

		}catch(Exception e) {
			
		}
		
		return 0;
	}


//	public long solve(Scanner sc) {
//
//		try {
//			int N = sc.nextInt();
//			if(N == 0)
//				return 0;
//			int K = sc.nextInt();
//			if( K == 0)
//				return 1;
//			long sum = 0;
//			long day = 0;
//			long[] arr = new long[N];
//			
//			for(int i =0; i < N; i++) {
//				arr[i] = sc.nextInt();
//			}
//			
//			for(int i =0; i < N; i++) {
//				sum = sum + arr[i];
//				day++;
//				
//				if(sum <K)
//					return day;
//				
//				if(sum == K)
//					return day + 1;
//				
//				sum = sum - K;
//
//			}
//
//			day = day + sum/K + 1;
//
//			return day;
//
//		}catch(Exception e) {
//			
//		}
//		
//		return 0;
//	}

}
