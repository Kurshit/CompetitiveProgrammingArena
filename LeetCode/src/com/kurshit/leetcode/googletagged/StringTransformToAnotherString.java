package com.kurshit.leetcode.googletagged;

/*
 * Problem Source : https://leetcode.com/problems/string-transforms-into-another-string/
 */

import java.util.HashMap;
import java.util.HashSet;

public class StringTransformToAnotherString {

	public static void main(String[] args) {
		
		String str1 = "aabcc", str2 = "ccdee";
		
		System.out.println(canConvert(str1, str2));
		
		str1 = "leetcode";
		str2 = "codeleet";
		System.out.println(canConvert(str1, str2));
	}
	
	public static boolean canConvert(String str1, String str2) {
        if(str1.equals(str2))
            return true;
        HashMap<Character,Character>mp=new HashMap<>();
        for(int i=0;i<str1.length();i++)
        {
            if(mp.containsKey(str1.charAt(i)) && mp.get(str1.charAt(i))!=str2.charAt(i))
                return false;
            mp.put(str1.charAt(i),str2.charAt(i));
        }
        return new HashSet<Character>(mp.values()).size()<26;
    }

}
