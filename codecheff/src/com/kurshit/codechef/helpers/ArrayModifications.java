package com.kurshit.codechef.helpers;

import java.io.IOException;

class ArrayModifications {
	public static void main(String[] args) throws IOException {
		Reader sc = new Reader();
		int t = sc.nextInt();
		while (t-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int q = sc.nextInt();
			int row[] = new int[n + 1];
			int col[] = new int[m + 1];
			long rowEven = n, rowOdd = 0, colEven = m, colOdd = 0;
			for (int i = 0; i < q; i++) {
				int r = sc.nextInt();
				int c = sc.nextInt();
				row[r]++;
				col[c]++;
				if ((row[r] & 1) == 1) {
					rowOdd++;
					rowEven--;
				} else if ((row[r] & 1) != 1) {
					rowOdd--;
					rowEven++;
				}

				if ((col[c] & 1) == 1) {
					colOdd++;
					colEven--;
				} else if ((col[c] & 1) != 1) {
					colOdd--;
					colEven++;
				}
			}
			System.out.println(colOdd * rowEven + colEven * rowOdd);
		}
	}

}

/*
 
class Codechef {

	public static int oddsInMatrix(int[][] arr, int N, int M) {

		int count = 0;

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (arr[i][j] % 2 != 0)
					count++;
			}

		}

		return count;
	}

	public static void matrixQOperations(int[][] arr, int N, int M, int x, int y) {

		for (int i = 1; i <= M; i++) {
			arr[x][i] = arr[x][i] + 1;
		}

		for (int i = 1; i <= N; i++) {
			arr[i][y] = arr[i][y] + 1;
		}

	}

	public static void main(String[] args) throws NumberFormatException, IOException {

		// BufferedReader br = null;
		BufferInput reader = new BufferInput();
		try {

			// br = new BufferedReader(new InputStreamReader(System.in));

			int T = reader.nextInt();

			for (int t = 0; t < T; t++) {

				String[] inputArray = reader.readLine().split(" ");

				int N = Integer.parseInt(inputArray[0]);
				int M = Integer.parseInt(inputArray[1]);
				int Q = Integer.parseInt(inputArray[2]);

				int[][] arr = new int[N + 1][M + 1];

				for (int i = 1; i <= N; i++) {
					for (int j = 1; j <= M; j++) {
						arr[i][j] = 0;
					}
				}

				for (int q = 0; q < Q; q++) {

					String[] temp = reader.readLine().split(" ");

					int x = Integer.parseInt(temp[0]);
					int y = Integer.parseInt(temp[1]);

					matrixQOperations(arr, N, M, x, y);

				}


				int result = oddsInMatrix(arr, N, M);
				System.out.println(result);

			}

		} catch (NumberFormatException e) {

		} 
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
		catch (Exception e) {

			e.printStackTrace();

		}

	}

}

*/
