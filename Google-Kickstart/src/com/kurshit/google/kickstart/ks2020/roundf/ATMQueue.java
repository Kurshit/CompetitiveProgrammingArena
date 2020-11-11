package com.kurshit.google.kickstart.ks2020.roundf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ATMQueue {
	
	public static void solve(Scanner sc, int T) {
		int N = sc.nextInt();
		int X = sc.nextInt();
		
		Map<Integer, List<Integer>> map = new TreeMap<>();
		
		for(int i=1; i <= N; i++) {
			int result = (sc.nextInt() - 1) /X;
			
			/*
			 *  substracting -1 to deal with test case where giben no exactly divides by X.
			 *  
			 *  Ex:  5 5
			 *  	10 9 8 7 6 5
			 *  
			 *  Expected output : 1 2 3 4 5
			 */
			
			if(map.containsKey(result)) {
				map.get(result).add(i);
			}else {
				List<Integer> temp = new ArrayList<>();
				temp.add(i);
				map.put(result, temp);
			}
		}
		
		System.out.print("Case #" + T + ": ");
		
		for(Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			for(int i : e.getValue()) {
				System.out.print(i + " ");
			}
		}
		
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int count = 1;
		while(count <= T) {
			solve(sc, count);
			System.out.println();
			count++;
		}

	}

}
