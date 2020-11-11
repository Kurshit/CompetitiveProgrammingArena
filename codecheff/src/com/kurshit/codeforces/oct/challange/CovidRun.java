package com.kurshit.codeforces.oct.challange;

import java.util.Scanner;

public class CovidRun {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			int T = sc.nextInt();
			
			while(T-- > 0) {
				CovidRun cr = new CovidRun();
				cr.solve(sc);
			}
		}catch(Exception e) {
			
		}
		

	}
	
	public void solve(Scanner sc) {
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		int X = sc.nextInt();		
		int Y = sc.nextInt();		
		
		int i = X;
		
		do {
			
			if(i == Y) {
				System.out.println("YES");
				return;
			}
			
			i = (i + K) % N;
		}while(i != X);
		
		System.out.println("NO");
	}

}
