package com.kurshit.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	
	
	
	
	
	public static long getMin(long a, long b) {
				
		
		a = b - a;
		
		long k = a % 10;
		a = a /10;
		
		if(k == 0)
			return a;
		else 
			return a+1;	
			
	}
	
	public static long getMinMin(long a, long b) {
		
		a = a - b;
		
		long k = a % 10;
		a = a/10;
		
		if(k == 0)
			return a;
		else 
			return a+1;	
			
	}
	
	public static void main(String[] args) {
		
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new InputStreamReader(System.in));
			
			long T = Long.parseLong(br.readLine());
			
			for(int i = 0; i < T; i++) {
				String[] s = br.readLine().split(" ");
				long a = Long.parseLong(s[0]);
				long b = Long.parseLong(s[1]);
				
				if(a == 0)
					System.out.println(0);
				else if( a < b)
					System.out.println(getMin(a, b));
				else 
					System.out.println(getMinMin(a, b));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
