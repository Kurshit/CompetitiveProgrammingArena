package com.kurshit.codeforces.challnges.longer20.december;

import java.util.Scanner;

public class VACCINE2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			int T = sc.nextInt();

			while(T-- > 0) {
				int N = sc.nextInt();
				long D = sc.nextInt();
				int[] arr = new int[N];
				int risk = 0;
				int nRisk = 0;
				for(int i =0; i < N ; i++ ) {
					arr[i] = sc.nextInt();
					if(arr[i] >= 80 || arr[i] <=9)
						risk++;
					else 
						nRisk++;					
				}
				
				long result = (long) (Math.ceil((risk * 1.0)/D) + Math.ceil((nRisk * 1.0)/D));
						
				System.out.println(result);

			}

		} catch(Exception e) {

		} finally {
			sc.close();
		}

	}



}
