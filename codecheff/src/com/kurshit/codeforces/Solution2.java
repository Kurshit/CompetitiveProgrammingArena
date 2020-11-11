package com.kurshit.codeforces;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution2 {
	static long minProduct = Integer.MAX_VALUE;
	public static void getMinProduct(long a, long b, long x,long y, long n, long t) {
		
		if(a < x || b < y)
			return;
		
		if(t > n)
			return;
		
		minProduct = Math.min(minProduct, a * b);
		
		getMinProduct(a -1, b, x, y, n, t+1);
		getMinProduct(a, b -1, x, y, n, t+1);
		
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
				long x = Long.parseLong(s[2]);
				long y = Long.parseLong(s[3]);
				long n = Long.parseLong(s[4]);
				getMinProduct(a, b, x, y, n, 0);
				System.out.println(minProduct);
				minProduct = Integer.MAX_VALUE;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
