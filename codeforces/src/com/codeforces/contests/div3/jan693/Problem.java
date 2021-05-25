package com.codeforces.contests.div3.jan693;

import java.util.Scanner;

public class Problem {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		try {		
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				int W = sc.nextInt();
				int H = sc.nextInt();
				long N = sc.nextLong();
				
				long count = 1;
				
				if(N == 1) {
					System.out.println("YES");
					continue;
				}					
				
				while( W %2 == 0 || H % 2 == 0) {
					if(W % 2 == 0) {
						count = count * 2;
						W = W/2;
					} else if(H %2 == 0) {
						count = count * 2;
						H = H/2;
					}
				}
				System.out.println(count);
				if(count >= N) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
				
			}
			
		} catch(Exception e) {
			
		} finally {
			sc.close();
		}
	}
	
	static int count = 0;
	
	public static void cutSheet(int w, int h)
	{
		
		if(w%2 != 0 && h%2 != 0)
			return;
		
		
		if(w%2 == 0 && h%2 == 0)
		{
			count++;
			cutSheet(w/2,h);
			cutSheet(w,h/2);
		}
		else if(w%2 == 0)
		{
			count++;
			cutSheet(w/2,h);
			cutSheet(w/2,h);
		}
		else if(h%2 == 0)
		{
			count++;
			cutSheet(w,h/2);
			cutSheet(w,h/2);
		}
		
	}

}
