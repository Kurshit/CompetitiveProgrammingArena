package com.codeforces.contests.problemset;

import java.util.Scanner;

public class Problem1395A {

	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			int r = sc.nextInt();
			int g = sc.nextInt();
			int b = sc.nextInt();
			int w = sc.nextInt();
			
			int oc = 0;
			
			if(r %2 != 0)
				oc++;
			if(g %2 != 0)
				oc++;
			if(b %2 != 0)
				oc++;
			if(w %2 != 0)
				oc++;
						
			if(oc == 0 || oc  == 1) {
				System.out.println("YES");
				continue;
			}
			
			oc = 0;
			
			if(w < 3) {
				System.out.println("NO");
				continue;
			}
			
			if((w -3) % 2 == 0) {
				if((r +1) %2 != 0)
					oc++;
				if((g+1) %2 != 0)
					oc++;
				if((b+1) %2 != 0)
					oc++;
				
				if(oc == 1 || oc == 0) {
					System.out.println("YES");
					continue;
				}else {
					System.out.println("NO");
					continue;
				}
					
			} else {
				
				if((r +1) %2 != 0)
					oc++;
				if((g+1) %2 != 0)
					oc++;
				if((b+1) %2 != 0)
					oc++;
				
				if(oc !=0) {
					System.out.println("NO");
					continue;
				}
			}
			
			
		}
		
		
	}

}
