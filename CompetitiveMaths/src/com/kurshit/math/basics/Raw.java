package com.kurshit.math.basics;

import java.math.BigInteger;
import java.util.Scanner;

public class Raw {
	static long totalSum = 0;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Raw c = new Raw();
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

		try {
			BigInteger X = sc.nextBigInteger();			
			
			System.out.println(1 +" " + X.add(BigInteger.valueOf(-1)));
			

		}catch(Exception e) {
			
		}
		
	}
}

