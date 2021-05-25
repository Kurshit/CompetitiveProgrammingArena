package com.kurshit.leetcode.concepts.binary;

public class BinaryConversions {

	public static void main(String[] args) {
		
		int value = 15;
		System.out.println(intToBinary(value));
		String s = "1111";
		System.out.println(binaryStringToDecimal(s));

	}
	
	public static String intToBinary(int value) {
		return Integer.toBinaryString(value);
	}
	
	public static int binaryStringToDecimal(String value) {
			
		return Integer.parseInt(value,2);
	}

}
