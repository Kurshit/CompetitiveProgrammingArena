package com.kurshit.math.basics;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CF {
	public static void main(String[] args) {
		
		 
//		CF c = new CF();
//		int[] s1 = {3,1,2,2,2};
//		int[] s2 = {1,2,2,2,2,2,3};
//		int[] s3 = {1,1,2,3,4,5,6};
//		int[] s4 = {3,2,2,2,2};
//		int[] s5 = {3,1,2,2,2};
//		int[] s6 = {5,4,3,3,2};
//		int[] s7 = {1,2,1,2,1};
//		int[] s8 = {1,2,3,4,5};
//		int[] s9 = {3,1,2,2};
//		int[] s10 = {1,2,2,3,1,2};
//		
//		System.out.println(c.lengthOfLongestSubstring(s1));
//		System.out.println(c.lengthOfLongestSubstring(s2));
//		System.out.println(c.lengthOfLongestSubstring(s3));
//		System.out.println(c.lengthOfLongestSubstring(s4));
//		System.out.println(c.lengthOfLongestSubstring(s5));
//		System.out.println(c.lengthOfLongestSubstring(s6));
//		System.out.println(c.lengthOfLongestSubstring(s7));
//		System.out.println(c.lengthOfLongestSubstring(s8));
//		System.out.println(c.lengthOfLongestSubstring(s9));
//		System.out.println(c.lengthOfLongestSubstring(s10));
//		
		
		Scanner sc = new Scanner(System.in);
		CF c = new CF();
		try {
			
			long T = sc.nextInt();
			
			while(T-- > 0) {
				c.solve(sc);		
			}
			

		}catch(Exception e) {
			
		}finally {
			sc.close();
		}
	}
	
	public void solve(Scanner sc) {
		int result = 0;
		try {
			int N = sc.nextInt();
			int Q = sc.nextInt();
			int[] s = new int[N];
			for(int i = 0; i < N; i++) {
				s[i] = sc.nextInt();
			}
			
			for( int i =0; i < Q; i++) {
				int X = sc.nextInt();
				int Y = sc.nextInt();
				s[X-1] = Y;
				result = lengthOfLongestSubstring(s);
				System.out.println(result);
			}

		}catch(Exception e) {
			
		}
		
		
		
	}
	
	 public int lengthOfLongestSubstring(int[] s) {
	        int n = s.length, ans = 0;
	        Map<Integer, Integer> map = new HashMap<>(); // current index of character
	        // try to extend the range [i, j]
	        for (int j = 0, i = 0; j < n; j++) {
	            if (map.containsKey(s[j])) {
	                if(j > 0 && (s[j-1] == s[j] || map.containsKey(s[j])))	            	
	                	i = Math.max(map.get(s[j]), i);
	            }
	            ans = Math.max(ans, j - i + 1);
	            map.put(s[j], j + 1);
	        }
	        return ans;
	  }


}

