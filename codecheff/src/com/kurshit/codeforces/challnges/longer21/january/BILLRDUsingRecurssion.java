//package com.kurshit.codeforces.challnges.longer21.january;
//
//import java.util.NoSuchElementException;
//import java.util.Scanner;
//
//public class BILLRDUsingRecurssion {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		
//		try {
//			
//			int T = sc.nextInt();
//			
//			while(T-- > 0) {
//				
//				
//				int N = sc.nextInt();
//				int K = sc.nextInt();
//				int x = sc.nextInt();
//				int y = sc.nextInt();
//				K  = K % 4;
//				int[] result = getCordinates(N, K, x, y);
//				System.out.println(result[0] + " " + result[1]);		
//			}
//			
//		} catch(NoSuchElementException e) { 
//			
//		} catch(OutOfMemoryError e) {
//			e.printStackTrace();
//		} finally {
//			sc.close();
//		}
//	}
//
//	private static int[] getCordinates(int N, int K, int x, int y) {
//		//String currDir = "UR";
//		Count count = new Count();
//		count.dir = "UR";
//		return getCordinates(N, K, x, y, count);		
//	}
//
//	private static int[] getCordinates(int N, int K, int x, int y, Count count) {
//		
//		if(isOnCorner(N,x,y)) {
//			return new int[] {x,y};
//		}
//		
//		if(isTouchingSides(N, x, y,count)) {
//			
//			if(count.c == K) {
//				return new int[] {x,y};
//			}
//			
//		}
//		
//		if(count.dir.equals("UR")) {
//			return getCordinates(N, K, x + 1, y + 1, count);
//		} else if(count.dir.equals("UL")) {
//			return getCordinates(N, K, x  - 1, y + 1, count);
//		} else if(count.dir.equals("DR")) {
//			return getCordinates(N, K, x + 1, y - 1, count);
//		} else {
//			return getCordinates(N, K, x - 1, y - 1, count);
//		}		
//		
//	}
//
//	private static boolean isTouchingSides(int N, int x, int y, Count count) {
//		//RightMost
//		if(x == N) {
//			if(count.dir.equals("UR")) {
//				count.dir = "UL";
//			} else if(count.dir.equals("DR")){
//				count.dir = "DL";
//			}
//			count.c++;
//			return true;
//		}
//		
//		//Bottom
//		if(y == 0) {
//			if(count.dir.equals("DL")) {
//				count.dir = "UL";
//			} else if(count.dir.equals("DR")) {
//				count.dir = "UR";
//			}
//			count.c++;
//			return true;
//		}
//		
//		//Left Most 
//		
//		if(x == 0) {
//			if(count.dir.equals("UL")) {
//				count.dir = "UR";
//			} else if(count.dir.equals("DL")) {
//				count.dir = "DR";
//			}
//			count.c++;
//			return true;
//		}
//		
//		//Upper
//		
//		if(y == N) {
//			if(count.dir.equals("UR")) {
//				count.dir = "DR";
//			} else if(count.dir.equals("UL")) {
//				count.dir = "DL";
//			}
//			count.c++;
//			return true;
//		}
//		
//		return false;
//	}
//
//	private static boolean isOnCorner(int N, int x, int y) {
//		
//		if(x == N && y == N) {
//			return true;
//		}
//		
//		if(x == 0 && y == 0) {
//			return true;
//		}
//		
//		if(x == 0 && y == N) {
//			return true;
//		}
//		
//		if(x == N && y == 0) {
//			return true;
//		}
//		
//		return false;
//	}
//
//}
//
//class Count {
//	int c;
//	String dir;
//}
