package com.kurshit.codeforces.challnges.longer21.january;

import java.util.NoSuchElementException;
import java.util.Scanner;

public class BILLRD {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		try {
			
			int T = sc.nextInt();
			
			while(T-- > 0) {
				
				
				int N = sc.nextInt();
				int K = sc.nextInt();
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				if(K % 4 == 0) {
					K = 4;
				} else {
					K = K %4;
				}
				
				int[] result = getCordinates(N, K, x, y);
				System.out.println(result[0] + " " + result[1]);		
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	private static int[] getCordinates(int N, int K, int x, int y) {
		//String currDir = "UR";
		Count count = new Count();
		count.dir = "UR";
		return getCordinates(N, K, x, y, count);		
	}

	private static int[] getCordinates(int N, int K, int x, int y, Count count) {
		
		while(true) {
			
			if(isOnCorner(N,x,y)) {
				return new int[] {x,y};
			}
			
			if(isTouchingSides(N, x, y,count)) {
				
				if(count.c == K) {
					return new int[] {x,y};
				}
				
			}
			
			if(count.dir.equals("UR")) {
				//return getCordinates(N, K, x + 1, y + 1, count);
				
				if(y == 0) {					
					y = N - x;
					x = N;
				} else if(x == 0) {
					x = N -y;
					y = N;
				} else {
					if(x == y) {
						x = N;
						y = N;
					}
					else if(x > y) {
						y =  y + (N - x);
						x = N;
					} else {
						x = x + (N - y);
						y = N;
					}
				}
				
				
			} else if(count.dir.equals("UL")) {
				//return getCordinates(N, K, x  - 1, y + 1, count);
				int temp = x;
				x = y;
				y = temp;
			} else if(count.dir.equals("DR")) {
				//return getCordinates(N, K, x + 1, y - 1, count);
				int temp = x;
				x = y;
				y = temp;
				
			} else {
				//return getCordinates(N, K, x - 1, y - 1, count);
				
				if(x == N) {					
					x = N - y;
					y = 0;
				} else if (y == N) {					
					y = N - x;
					x = 0;
				}
			}		 

		}
		
				
	}

	private static boolean isTouchingSides(int N, int x, int y, Count count) {
		//RightMost
		if(x == N) {
			if(count.dir.equals("UR")) {
				count.dir = "UL";
			} else if(count.dir.equals("DR")){
				count.dir = "DL";
			}
			count.c++;
			return true;
		}
		
		//Bottom
		if(y == 0) {
			if(count.dir.equals("DL")) {
				count.dir = "UL";
			} else if(count.dir.equals("DR")) {
				count.dir = "UR";
			}
			count.c++;
			return true;
		}
		
		//Left Most 
		
		if(x == 0) {
			if(count.dir.equals("UL")) {
				count.dir = "UR";
			} else if(count.dir.equals("DL")) {
				count.dir = "DR";
			}
			count.c++;
			return true;
		}
		
		//Upper
		
		if(y == N) {
			if(count.dir.equals("UR")) {
				count.dir = "DR";
			} else if(count.dir.equals("UL")) {
				count.dir = "DL";
			}
			count.c++;
			return true;
		}
		
		return false;
	}

	private static boolean isOnCorner(int N, int x, int y) {
		
		if(x == N && y == N) {
			return true;
		}
		
		if(x == 0 && y == 0) {
			return true;
		}
		
		if(x == 0 && y == N) {
			return true;
		}
		
		if(x == N && y == 0) {
			return true;
		}
		
		return false;
	}

}

class Count {
	int c;
	String dir;
}
