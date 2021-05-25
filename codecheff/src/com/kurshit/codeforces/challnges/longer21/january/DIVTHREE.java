package com.kurshit.codeforces.challnges.longer21.january;

import java.util.Scanner;

public class DIVTHREE {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while (T-- > 0) {
				int N = sc.nextInt();
				int K = sc.nextInt();
				int D = sc.nextInt();
				int sum = 0;
				for(int i=0; i< N; i++) {
					sum = sum + sc.nextInt();
				}
				
				int result = sum / K;
				
				if(result >= D) {
					System.out.println(D);
				} else {
					System.out.println(result);
				}
			}
			
			
		}catch(Exception e) {
			
		} finally {
			sc.close();
		}

	}

}
