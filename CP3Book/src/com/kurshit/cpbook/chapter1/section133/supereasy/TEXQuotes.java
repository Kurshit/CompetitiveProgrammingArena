package com.kurshit.cpbook.chapter1.section133.supereasy;

/*
 * Problem : 272 - TEX Quotes - 
 * Problem Source : https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&page=show_problem&problem=208
 * 
 * If the source contained
	"To be or not to be," quoth the bard, "that is the question."
	then the typeset document produced by TEX would not contain the desired form:
	“To be or not to be,” quoth the bard, “that is the question.”
	In order to produce the desired form, the source file must contain the sequence:
	``To be or not to be,'' quoth the bard, ``that is the question.''
	You are to write a program which converts text containing double-quote (") characters into text
	that is identical except that double-quotes have been replaced by the two-character sequences required
	by TEX for delimiting quotations with oriented double-quotes. The double-quote (") characters should
	be replaced appropriately by either `` if the " opens a quotation and by '' if the " closes a quotation.
	Notice that the question of nested quotations does not arise: The first " must be replaced by ``, the
	next by '', the next by ``, the next by '', the next by ``, the next by '', and so on.
	Input
	Input will consist of several lines of text containing an even number of double-quote (") characters.
	Input is ended with an end-of-file character.
	Output
	The text must be output exactly as it was input except that:
	• the first " in each pair is replaced by two ` characters: `` and
	• the second " in each pair is replaced by two ' characters: ''.

 */

import java.util.Scanner;  
//272 - TEX Quotes
public class TEXQuotes {  
    public static void main(String[] args) {  
         Scanner scanner = new Scanner(System.in);  
         String line;  
         boolean open = true;  
         
         while(scanner.hasNextLine()) {  
              line = scanner.nextLine();  
              for(int i = 0; i < line.length(); i++) {  
                   if(line.charAt(i) == '\u001a'){                    
                        break;  
                   }  
                   if(line.charAt(i) == '\"') {  
                        if(open == true) {  
                             System.out.print("``");  
                             open = false;  
                             continue;  
                        } else {  
                             System.out.print("''");  
                             open = true;  
                             continue;  
                        }  
                   }  
                   System.out.print(line.charAt(i));  
              }  
              System.out.print("\n");       
         }  
    }  
}  