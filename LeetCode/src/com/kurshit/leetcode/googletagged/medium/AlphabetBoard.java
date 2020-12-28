package com.kurshit.leetcode.googletagged.medium;


/*
 * Probelm Source : https://leetcode.com/problems/alphabet-board-path/
 * Problem : On an alphabet board, we start at position (0, 0), corresponding to character board[0][0].

 *		Here, board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"], as shown in the diagram below.
 * 
 * 			a b c d e
 * 			f g h i j
 * 			k l m n o
 * 			p q r s t
 * 			u v w x y
 * 			z
 * 
 *  We may make the following moves:

	'U' moves our position up one row, if the position exists on the board;
	'D' moves our position down one row, if the position exists on the board;
	'L' moves our position left one column, if the position exists on the board;
	'R' moves our position right one column, if the position exists on the board;
	'!' adds the character board[r][c] at our current position (r, c) to the answer.
	(Here, the only positions that exist on the board are positions with letters on them.)
	
	Return a sequence of moves that makes our answer equal to target in the minimum number of moves.  
	You may return any path that does so.
	
	Input: target = "leet"
	Output: "DDR!UURRR!!DDD!"
 */

public class AlphabetBoard {

	public static void main(String[] args) {
		String target = "leet";
		System.out.println(getPathFromAlphabetBoard(target));

	}
	
	/* The sequence matters in following nested while loops to go either L, R , U or D.
	 * 
	 *  U and L has to be before D because in case of we have "z" only in the last row as signle element.
	 *  
	 *  If we go down first and reach z, we can not move up and right. 
	 *  
	 *  Hence U, R and L should be before D.
	 *  
	 *  Sequence : L, U, R D, !
	 *  
	 *  Operation : ydiff > 0, xdiff >0, ydiff < xdiff <0, xdiff = y diff = 0 respectively
	 *  
	 * 
	 */
	
	public static String getPathFromAlphabetBoard(String s) {
		
		StringBuilder sb = new StringBuilder();
		
		int[] currentPos = {0 ,0};
		
		for(char currentChar : s.toCharArray() ) {
			
			int row = (currentChar - 'a') / 5;
			int col = (currentChar - 'a') % 5;
			
			int xDiff = currentPos[0] - row;
			int yDiff = currentPos[1] - col;
			
			while(yDiff > 0) {
				sb.append("L");
				yDiff--;
			}
			
			while(xDiff > 0) {
				sb.append("U");
				xDiff--;
			}
			
			while(yDiff < 0) {
				sb.append("R");
				yDiff++;				
			}
			
			while(xDiff < 0) {
				sb.append("D");
				xDiff++;
			}
			
			if(xDiff == 0 && yDiff == 0) {
				sb.append("!");
			}
			
			currentPos[0] = row;
			currentPos[1] = col;
			
		}
		
		
		
		return sb.toString();
	}

}
