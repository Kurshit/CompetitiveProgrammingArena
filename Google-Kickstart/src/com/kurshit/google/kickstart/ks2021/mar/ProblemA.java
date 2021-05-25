package com.kurshit.google.kickstart.ks2021.mar;

import java.util.Scanner;

public class ProblemA {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			int T = sc.nextInt();
			ProblemA p = new ProblemA();
			for(int i=1; i<= T; i++) {
				System.out.println("Case #" + i + ": "  +p.getCount(sc,i));
			}
		} catch(Exception e) {
			
		} finally {
			sc.close();
		}	
		
		
	}

	public int getCount(Scanner sc, int T) {
			
		int count = 0;
		
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		String str = sc.next();
		
		int GS = getGoodNess(str);
		
		if(GS == K)
			return 0;
		
		count = Math.abs(K-GS);
		
		return count;
		
	}
	
	public int getGoodNess(String str) {
		
		int res = 0;
		
		int N = str.length();
		
		for(int i=0; i < (N/2); i++) {
			
			if(str.charAt(i) != str.charAt(N-i-1)) {
				res++;
			}
			
		}	
		
		return res;
		
		
	}

}
