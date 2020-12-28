package com.kurshit.cpbook.chapter2.section22.excercise;

import java.util.*;
import java.io.*;

/*
 * Problem Source : https://onlinejudge.org/index.php?option=onlinejudge&Itemid=8&page=show_problem&problem=166
 * Problem : 
 * 
 * 			When a borrower takes out or returns a book, the computer keeps a record of the title. Periodically,
	the librarians will ask your program for a list of books that have been returned so the books can be
	returned to their correct places on the shelves. Before they are returned to the shelves, the returned
	books are sorted by author and then title using the ASCII collating sequence. Your program should
	output the list of returned books in the same order as they should appear on the shelves. For each
	book, your program should tell the librarian which book (including those previously shelved) is already
	on the shelf before which the returned book should go.
	Input
	First, the stock of the library will be listed, one book per line, in no particular order. Initially, they are
	all on the shelves. No two books have the same title. The format of each line will be:
	title" by author
	The end of the stock listing will be marked by a line containing only the word:
	END
	Following the stock list will be a series of records of books borrowed and returned, and requests
	from librarians for assistance in restocking the shelves. Each record will appear on a single line, in one
	of the following formats:
	BORROW title
	RETURN title
	SHELVE
	The list will be terminated by a line containing only the word:
	END
	Output
	Each time the SHELVE command appears, your program should output a series of instructions for the
	librarian, one per line, in the format:
	Put title1 after title2	
	or, for the special case of the book being the first in the collection:
	Put title first
	After the set of instructions for each SHELVE, output a line containing only the word:
	END
	Assumptions & Limitations:
	1. A title is at most 80 characters long.
	2. An author is at most 80 characters long.
	3. A title will not contain the double quote (") character.
	Sample Input
	"The Canterbury Tales" by Chaucer, G.
	"Algorithms" by Sedgewick, R.
	"The C Programming Language" by Kernighan, B. and Ritchie, D.
	END
	BORROW "Algorithms"
	BORROW "The C Programming Language"
	RETURN "Algorithms"
	RETURN "The C Programming Language"
	SHELVE
	END
	Sample Output
	Put "The C Programming Language" after "The Canterbury Tales"
	Put "Algorithms" after "The C Programming Language"
	END
 * 
 */

public class Borrower {

	public static void main(String[] args) throws IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String s;
		PrintWriter out = new PrintWriter(System.out);
		ArrayList<Book> list = new ArrayList<Book>();
		
		while(!(s = br.readLine() ).equals("END") )
		{
			int last = s.lastIndexOf('"');
			String title = s.substring(0,last+1);
			String author = s.substring( last+1 );
			list.add(new Book(title,author));
		}
		Collections.sort(list);		
		boolean [] returned = new boolean[list.size()];
		boolean [] taken = new boolean[list.size()];
		while(!(s = br.readLine() ).equals("END") )
		{
			if(s.charAt(0)=='R')
			{
				String titl = s.substring(s.indexOf('"'));
				for (int i = 0; i < list.size(); i++) {
					if(list.get(i).title.equals(titl))
					{
						returned[i] = true;
						taken[i] = true;
						break;
					}
				}
			}
			else
			{
				if(s.charAt(0)=='S')
				{
					String after = "";
					for (int i = 0; i < list.size(); i++) {
						if(taken[i] && returned[i])
						{
							if(after.equals(""))
								out.append("Put "+list.get(i).title+" first\n");
							else
								out.append("Put "+list.get(i).title+" after "+after+"\n");
							taken[i] = false;
						}
						if(!taken[i])
						{
							after = list.get(i).title;
						}
					}
					out.append("END\n");

				}
				else
				{
					String titl = s.substring(s.indexOf('"'));
					for (int i = 0; i < list.size(); i++) {
						if(list.get(i).title.equals(titl))
						{
							taken[i] = true;
							returned[i] = false;
							break;
						}
					}
				}
			}
		}
		out.flush();
		br.close();
	} 

	static class Book implements Comparable<Book> {
		String title,author;
		
		public Book(String t,String a) {
			title = t;
			author = a;
		}
		
		@Override
		public int compareTo(Book o) {
			
			if(this.author.equals(o.author)) {
				return this.title.compareTo(o.title);
			} else {
				return this.author.compareTo(o.author);
			}			
		}
		
		public String toString()
		{
			return "Title: "+title+" Author: "+author+"\n";
		}
	}
}