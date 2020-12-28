package com.kurshit.codeforces.challnges.longer20.december;


import java.util.Scanner;

class PastSubmited {

	public static void main(String[] args) {


		Scanner sc = new Scanner(System.in);
		PastSubmited p = new PastSubmited();
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

		int[] result = new int[N+1];
		boolean isNEven = N % 2 == 0;
		int count = isNEven ? N/2 : (N/2) + 1;

		if(K == N) {
			for(int i =1; i <= N; i++) {
				result[i] = i;
			}
			return result;
		}

		for(int i =1; i <= N; i++) {

			if(isNEven) {
				if(i % 2 ==0) {
					result[i] = i;
				} else {
					result[i] = -i;
				}
			}else {
				if(i%2 == 0) {
					result[i] = -i;
				}else {
					result[i] = i;
				}
			}
		}

		int sum = 0;

		sum = result[1] > 0 ? result[1] : result[2];

		if(count < K) {
			int diff = K - count;

			int ptr = 0;
			int j = N;

			while(j>0 && ptr != diff) {
				if(result[j] <0) {
					result[j] = Math.abs(result[j]);
					ptr++;
					count++;
					if(count == K)
						break;
					j = j-2;
				} else {
					j--;
				}

				
			}
		}

		if(count > K) {
			int diff = count - K;

			int ptr = 0;
			int j = N;

			while(j>0 && ptr != diff) {
				if(result[j] >0) {
					result[j] = -result[j];
					ptr++;
					count--;
					if(count == K)
						break;
					j = j-2;
				} else 
					j--;


				
			}
		}


		return result;

	}
}
