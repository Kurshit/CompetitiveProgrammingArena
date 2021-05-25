package com.kurshit.leetcode.googletagged.matrix;

public class BattleShipInBoard {

	public int countBattleships(char[][] board) {
		int M = board.length;
		int N = board[0].length;
		int result = 0;
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (board[i][j] == 'X') {
					dfs(board, M, N, i, j);
					result = result + 1;
				}
			}
		}

		return result;

	}

	public void dfs(char[][] board, int M, int N, int i, int j) {

		if (i < 0 || i > M - 1 || j < 0 || j > N - 1 || board[i][j] == '.') {
			return;
		}

		board[i][j] = '.';

		dfs(board, M, N, i + 1, j);
		dfs(board, M, N, i - 1, j);
		dfs(board, M, N, i, j + 1);
		dfs(board, M, N, i, j - 1);

	}

}
