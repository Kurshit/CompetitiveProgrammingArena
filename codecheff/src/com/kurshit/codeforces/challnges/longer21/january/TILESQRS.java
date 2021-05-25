package com.kurshit.codeforces.challnges.longer21.january;


import java.util.NoSuchElementException;
import java.util.Random;
import java.util.Scanner;

class TILESQRS {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		try {

			int T = sc.nextInt();

			while (T-- > 0) {

				int N = sc.nextInt();
				long Q = sc.nextLong();
				long K = sc.nextLong();
				int[][] grid = createMatrix(N, K);
				//int count = 0;
				boolean isGuessed = false;
				//while(true) {
				long score = -1;
				for(int q=0; q < Q; q++) {

					int x = getRandomNumber(1, N+1);
					int y = getRandomNumber(1, N+1);

					System.out.println(1 + " " + x + " " + y);
					System.out.flush();
					x = x-1;
					y = y-1;
					if (grid[x][y] == 0) {
						grid[x][y] = 1;
					} else {
						grid[x][y] = 0;
					}
					score = sc.nextLong();
					long currentKCount = countSquares(grid, N);
					if(score == K ) {

						if(currentKCount == score) {
							System.out.println(2);

							//int[][] result = createMatrix(N, score);

							for(int i=0; i < N; i++) {
								for(int j=0; j< N; j++) {
									System.out.print(grid[i][j] + " ");
								}

								System.out.println();
							}
						} else if(currentKCount != score) {

							grid = createMatrix(N, score);
							System.out.println(2);

							//int[][] result = createMatrix(N, score);

							for(int i=0; i < N; i++) {
								for(int j=0; j< N; j++) {
									System.out.print(grid[i][j] + " ");
								}

								System.out.println();
							}
						}


						System.out.flush();

						int output = sc.nextInt();


						isGuessed = true;
						break;

					}
				}

				if(!isGuessed ) {

					System.out.println(2);

					//int[][] result = createMatrix(N, score);

					for(int i=0; i < N; i++) {
						for(int j=0; j< N; j++) {
							System.out.print(grid[i][j] + " ");
						}

						System.out.println();
					}

					System.out.flush();

					int output = sc.nextInt();				

				}


			}

			//}

		} catch (NoSuchElementException e) {

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}

	}

	public static int getRandomNumber(int min, int max) {
		Random random = new Random();
		return random.nextInt(max - min) + min;
	}

	public static int[][] createMatrix(int N, long K) {

		int[][] grid = new int[N][N];
		int count = 0;
		for(int i = 1; i < N; i++) {
			for(int j=1; j < N; j++) {

				if(count < K && grid[i-1][j-1] != 1) {
					grid[i][j] = 0;
					grid[i-1][j] = 1;
					grid[i][j-1] = 1;
					count++;
				} 

			}
		}


		return grid;
	}

	public static long countSquares(int[][] grid, int N) {
		long count = 0;

		for (int i = 0; i < N - 1; i++) {
			for (int j = 0; j < N - 1; j++) {

				if (grid[i][j] == 0 && grid[i][j + 1] == 1 && grid[i + 1][j + 1] == 0 && grid[i + 1][j] == 1) {
					count++;
				}
			}
		}

		return count;
	}


}
