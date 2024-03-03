import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int[][] sudoku = new int[9][9];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(sc.nextLine());
			for (int j = 0; j < 9; j++) {
				sudoku[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		dfs(0, 0);
	}

	private static void dfs(int row, int col) {
		if (row == 9) {
			for (int[] sudokuRow : sudoku) {
				for (int sudokuNum : sudokuRow) {
					System.out.print(sudokuNum + " ");
				}
				System.out.println();
			}

			System.exit(0);
		}

		if (col == 9) {
			dfs(row + 1, 0);
			return;
		}

		if (sudoku[row][col] == 0) {
			for (int i = 1; i <= 9; i++) {
				if (isPossible(i, row, col)) {
					sudoku[row][col] = i;
					dfs(row, col + 1);
					sudoku[row][col] = 0;
				}
			}
			return;
		}

		dfs(row, col + 1);
	}

	private static boolean isPossible(int num, int row, int col) {
		int rowSquare = row / 3 * 3;
		int colSquare = col / 3 * 3;

		for (int i = 0; i < 9; i++) {
			if (sudoku[i][col] == num || sudoku[row][i] == num) {
				return false;
			}
		}

		for (int i = rowSquare; i < rowSquare + 3; i++) {
			for (int j = colSquare; j < colSquare + 3; j++) {
				if(sudoku[i][j] == num) {
					return false;
				}
			}
		}

		return true;
	}
}