package com.kurshit.google.kickstart.ks2020.roundg;

import java.util.Scanner;

/*
	 * Source: https://codingcompetitions.withgoogle.com/kickstart/round/00000000001a0069/0000000000414bfb
	 * 
	 * Example: Ksenia is very fond of reading so she kicks off each day by reading a fragment from her favourite book before starting with the rest of her morning routine. A fragment is simply a substring of the text. Ksenia is somewhat superstitious and believes that her day will be lucky if the fragment she reads starts with the string KICK, then goes on with 0 or more characters, and eventually ends with the string START, even if the overall fragment makes little sense.
	
	 * Given the text of the book, count the number of different lucky fragments that Ksenia can read before the book gets old and she needs to buy another one. Two fragments are considered to be different if they start or end at different positions in the text, even if the fragments read the same. Also note that different lucky fragments may overlap.
	
	 * Input
	 * The first line of the input gives the number of test cases T. T lines follow, each containing a single string S consisting of upper case English letters only.
	
	 * Output
	 * For each test case, output one line containing Case #x: y, where x is the test case number (starting from 1) and y is the number of different lucky fragments in the text of this test case.
	
	 * Limits:
	 * 
	 * Input
	 	
	 *	Output
		 
	 *	3
	 *	AKICKSTARTPROBLEMNAMEDKICKSTART
	 *	STARTUNLUCKYKICK
	 *	KICKXKICKXSTARTXKICKXSTART
		
		  
	 *	Case #1: 3
	 *	Case #2: 0
	 * 	Case #3: 5
	 * 
	 * 
	 */

public class KickStart {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		KickStart ks = new KickStart();
		for(int i=1; i<= T; i++) {
			System.out.println("Case #" + i + ": "  +ks.getLuckyFragements(sc,i));
		}
		sc.close();
	}
	
	public int getLuckyFragements(Scanner sc, int T) {
		String s = sc.next();
		
		int result = 0;
		int c = 0;
		
		for(int i=0; i < s.length(); i++) {
			if(i+4 <= s.length() && s.substring(i , i+4).equals("KICK"))
				c++;
			
			if(i+5 <= s.length() && s.substring(i , i+5).equals("START"))
				result += c;
		}
		
		return result;
	}

	
/*	
 *  Following code worked for sample input but failed in submission
 * 
  	public int getLuckyFragements(Scanner sc, int T) {
 
		String s = sc.next();
		
		List<String> list = new ArrayList<>();
		
		int ptr = s.indexOf("KICK");
		
		if(ptr == -1)
			return 0;
		
		int result = 0;
		list.add("KICK");
		ptr = ptr + 4;
		while(ptr < s.length()) {
			
			if(ptr + 4 <= s.length() && s.substring(ptr, ptr + 4 ).equals("KICK")) {
				list.add("KICK");
				ptr = ptr + 4;
			} else if(ptr + 5 <= s.length() && s.substring(ptr, ptr + 5 ).equals("START")) {
				result = result + list.size();
				ptr = ptr + 5;
			} else {
				ptr = ptr +1;
			}
		}
		
		return result;
	}
*/
}
