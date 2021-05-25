package com.kurshit.codeforces.challnges.longer21.january;

import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class ORAND {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		while(T-- > 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			TreeSet<Integer> h1 = new TreeSet<>();
			Stack<Integer> s1 = new Stack<>();
			
			h1.add(0);
			s1.push(0);
			int a[] = new int[N];
			int b[] = new int[M];
			
			for(int i= 0; i < N; i++) {
				a[i] = sc.nextInt();				
			}
			
			for(int i=0;  i < M ; i++) {
				b[i] = sc.nextInt();
			}
			
			while(!s1.isEmpty()) {
				int x = (int) (s1.pop());
				
				for(int i = 0; i < N; i++) {
					int y = a[i];
					
					if(!h1.contains(x|y)) {
						h1.add(x|y);
						s1.push(x|y);
					}
				}
				
				for(int i =0; i < M; i++) {
					int y = b[i];
					if(!h1.contains(x&y)) {
						h1.add(x&y);
						s1.push(x&y);
					}
				}
			}
			
			System.out.println(h1.size());
 		}
	}
	
	

}
