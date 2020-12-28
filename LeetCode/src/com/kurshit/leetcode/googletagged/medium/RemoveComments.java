package com.kurshit.leetcode.googletagged.medium;

import java.util.ArrayList;
import java.util.List;

/*
 * Problem Resource : https://leetcode.com/problems/remove-comments/solution/
 * 
 * Solution: 
 * We need to parse the source line by line. Our state is that we either are in a block comment or not.

	1. If we start a block comment and we aren't in a block, then we will skip over the next two characters and change our state to be in a block.
	
	2. If we end a block comment and we are in a block, then we will skip over the next two characters and change our state to be not in a block.
	
	3. If we start a line comment and we aren't in a block, then we will ignore the rest of the line.
	
	4. If we aren't in a block comment (and it wasn't the start of a comment), we will record the character we are at.
	
	5. At the end of each line, if we aren't in a block, we will record the line.

 */

public class RemoveComments {

	public static void main(String[] args) {


		String[] source = {"/*Test program */", "int main()", "{ ", "  // variable declaration ", "int a, b, c;", "/* This is a test", "   multiline  ", "   comment for ", "   testing */", "a = b + c;", "}"};
		List<String> string = removeComments(source);
		
		System.out.println(string);
		
	}
	
	public static List<String> removeComments(String[] source) {
        boolean inBlock = false;
        StringBuilder newline = new StringBuilder();
        List<String> ans = new ArrayList();
        for (String line: source) {
            int i = 0;
            char[] chars = line.toCharArray();
            if (!inBlock) newline = new StringBuilder();
            while (i < line.length()) {
                if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '*') {
                    inBlock = true;
                    i++;
                } else if (inBlock && i+1 < line.length() && chars[i] == '*' && chars[i+1] == '/') {
                    inBlock = false;
                    i++;
                } else if (!inBlock && i+1 < line.length() && chars[i] == '/' && chars[i+1] == '/') {
                    break;
                } else if (!inBlock) {
                    newline.append(chars[i]);
                }
                i++;
            }
            if (!inBlock && newline.length() > 0) {
                ans.add(new String(newline));
            }
        }
        return ans;
    }

}
