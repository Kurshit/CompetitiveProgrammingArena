package com.kurshit.codeforces.challnges.longer21.january;

import java.util.Scanner;

public class DECODEIT {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				int N = sc.nextInt();
				
				String S = sc.next();
				
				StringBuilder sb = new StringBuilder("");
				
				int start = 0;
				int end = 4;
				
				while(end <= N) {
					String temp = S.substring(start, end);
					int value = Integer.parseInt(temp, 2);
					
					char result = (char) (value + 97);
					sb.append(result);
					
					start = start + 4;
					end = end + 4;
				}
				
				System.out.println(sb);
			}
			
		} catch(Exception e ) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

}
