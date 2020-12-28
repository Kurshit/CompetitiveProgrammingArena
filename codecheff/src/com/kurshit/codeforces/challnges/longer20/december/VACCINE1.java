package com.kurshit.codeforces.challnges.longer20.december;

import java.util.Scanner;

public class VACCINE1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			//int T = sc.nextInt();
			VACCINE1 v = new VACCINE1();
			//while(T-- > 0) {

				int D1 = sc.nextInt();
				int V1 = sc.nextInt();
				int D2 = sc.nextInt();
				int V2 = sc.nextInt();
				int P = sc.nextInt();

				System.out.println(v.getDays(D1, V1, D2, V2, P));
			//}
		} catch(Exception e) {

		} finally {
			sc.close();
		}

	}

	public int getDays(int D1, int V1, int D2, int V2, int P) {
		int initialDays = 0;
		if(D1 == D2) {

			if(D1 > 1) {
				initialDays = D1-1;
			}

			int temp = (int) Math.ceil( (double) P / (double) (V1+V2));
			return initialDays + temp;
		} else {			
			if(D1 > D2) {
				initialDays = D2 - 1;

				int diffDays = D1 - D2;
				int t = P / V2;
				if(t == 0)
					return 1;
				
				if(diffDays > t) {
					return initialDays + t;
				}

				int diffVaccines = diffDays * V2;

				if(diffVaccines >= P) {
					return diffDays + initialDays;
				}

				int temp = ( (P - diffVaccines) % (V1+V2) == 0) ? ( (P - diffVaccines) / (V1 + V2)) : ( (P - diffVaccines) / (V1 + V2)) + 1 ;
				return initialDays + diffDays + temp;

			} else {
				initialDays = D1 - 1;

				int diffDays = D2 - D1;
				int t = P / V1;
				
				if(t == 0)
					return 1;
				
				if(diffDays > t) {
					return initialDays + t;
				}

				int diffVaccines = diffDays * V1;

				if(diffVaccines > P) {
					return diffDays + initialDays;
				}

				int temp = ( (P - diffVaccines) % (V1+V2) == 0) ? ( (P - diffVaccines) / (V1 + V2)) : ( (P - diffVaccines) / (V1 + V2)) + 1 ;
				return initialDays + diffDays + temp;
			}

		}	

	}
}
