package com.kurshit.codeforces.challnges.longer20.december;

import java.util.Scanner;

public class PositivePrefixesCopy {

	public static void main(String[] args) {
		

		Scanner sc = new Scanner(System.in);
		PositivePrefixesCopy p = new PositivePrefixesCopy();
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				int N = sc.nextInt();
				int K = sc.nextInt();
				int[] result = p.getPrefixes(N, K);
				
				for(int i =1; i <=N; i++) {
					System.out.print(result[i] + " ");
				}
				System.out.println();
			}
			
		} catch(Exception e) {
			
		} finally {
			sc.close();
		}

	}
	
	
	public int[] getPrefixes(int N, int K) {
		
		
		int[] pArr = new int[N+1];
		
		for(int i = 1; i <=N; i++) {
			pArr[i] = pArr[i-1] + i; 
		}
		
		int count = 0;
		int sum = pArr[N];
		int i = 1;
		int[] result = new int[N+1];
		
		int soFar = 0;
		while(i <= N) {
			sum = pArr[i-1] - soFar;
			if(count <= K) {
				
				if(count == K && sum <= i) {
					while(i <= N) {
						result[i] = -i;
						i++;
					}
					break;
				}				
				
				result[i] = i;
				i++;
				count++;
				//continue;
			}
			
			if(count > K) {
				
				
				int temp = i;
				i = i-2;
				if(pArr[i+1] - i > 0) {
					count--;
					soFar = soFar + i;
					result[i] = -i;
					
				}
					
				while(count > K) {
					if(pArr[i] - i*2 <=0 && result[i] > 0) {
						count--;
						soFar = soFar + i*2;
						result[i] = -i;
						break;
					}
					i--;
				}
				
				i = temp;
				
			}
			
		}
		
		return result;
		
	}
}
