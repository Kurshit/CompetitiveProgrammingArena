package com.kurshit.codeforces.challnges.longer20.december;

import java.util.Scanner;

public class EvenPairSum {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				long A = sc.nextLong();
				long B = sc.nextLong();
				
				boolean isBEven = B % 2 == 0;
				
				if(isBEven) {
					System.out.println((B/2) * A);					
				} else {
					System.out.println(((B/2) * A) + (long) Math.ceil((A * 1.0)/2));
				}
				
			}
			
		}catch(Exception e) {
			
			
		} finally {
			sc.close();
		}

	}
	
	

}
