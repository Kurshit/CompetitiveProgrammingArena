package com.codeforces.contests.div3.may719;

/*
 * Editorial : https://codeforces.com/blog/entry/90342
 * 
 * Problem Src : https://codeforces.com/contest/1520/problem/A
 */

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class ProblemA {

	public static void main(String[] args) {
		
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			Set<Character> set = new HashSet<>();
			String s = sc.next();
			int i = 0;
			boolean flag = true;
			for(i=0; i < s.length()-1; i++) {
				
				if(s.charAt(i) == s.charAt(i+1)) {
					continue;
				} else {
					
					if(!set.add(s.charAt(i))) {
						System.out.println("NO");
						flag = false;
						break;
					}
				}
			}
			
			if(!flag)
				continue;
			
			if(set.contains(s.charAt(i))) {
				System.out.println("NO");
			} else {
				System.out.println("YES");
			}
		}
		
		sc.close();
	}
	
	

}
