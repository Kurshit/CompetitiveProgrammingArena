package com.codeforces.contests.problemset;

import java.util.Scanner;

public class Solution {

	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		
		while(t-- > 0) {
			
			int N = sc.nextInt();
			String s = sc.next();
			
//			if(s.contains("2020")) {
//				System.out.println("YES");
//				continue;
//			}
			
			if(s.endsWith("20") && s.startsWith("20")) {
				System.out.println("YES");
				continue;
			}
			
			if(s.startsWith("2020")) {
				System.out.println("YES");
				continue;
			}
			
			if(s.endsWith("2020")) {
				System.out.println("YES");
				continue;
			}
			
			if(s.endsWith("020") && s.startsWith("2")) {
				System.out.println("YES");
				continue;
			}
			
			if(s.endsWith("0") && s.startsWith("202")) {
				System.out.println("YES");
				continue;
			}
			
			System.out.println("NO");
			
//			if(s.contains("020")) {
//				int starteIndex = s.indexOf("020");
//				s = s.substring(0, s.indexOf("020")) + s.substring(starteIndex+2);
//				
//				System.out.println("YES");
//				continue;
//			}
				
			
		}
		
		sc.close();
		
		
	}

}
