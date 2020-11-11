package com.kurshit.math.codencode;

public class PrimalityTest {
	
	public static boolean isPrime(int N) {
		
		if(N == 1)
			return false;
		
		for(int i =2; i * i <= N; i++) {
			
			if(i % N == 0)
				return false;
		}
		
		return true;
		
	}

	public static void main(String[] args) {
		
		System.out.println(isPrime(17));
		System.out.println(isPrime(57));
		System.out.println(isPrime(73));
		System.out.println(isPrime(733));

	}

}
