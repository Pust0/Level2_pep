package nov13;
import java.util.*;

public class sudokuOptimised {
	public boolean solveSudoku(char[][] board, int idx, ArrayList<Integer> cells, boolean[][] rows, boolean[][] cols,
			boolean[][][] mat) {
		if (idx == cells.size()) {
			return true;
		}

		int r = cells.get(idx) / 9, c = cells.get(idx) % 9;

		for (int num = 1; num <= 9; ++num) {

			if (!rows[r][num] && !cols[c][num] && !mat[r / 3][c / 3][num]) {
				board[r][c] = (char) ('0' + num);
				rows[r][num] = cols[c][num] = mat[r / 3][c / 3][num] = true;
				if (solveSudoku(board, idx + 1, cells, rows, cols, mat)) {
					return true;
				}
				rows[r][num] = cols[c][num] = mat[r / 3][c / 3][num] = false;
				board[r][c] = '.';
			}
		}

		return false;

	}

	public void solveSudoku(char[][] board) {
		ArrayList<Integer> cells = new ArrayList<>();
		boolean[][] rows = new boolean[9][10];
		boolean[][] cols = new boolean[9][10];
		boolean[][][] mat = new boolean[3][3][10];

		for (int i = 0; i < 9; ++i) {
			for (int j = 0; j < 9; ++j) {
				if (board[i][j] == '.') {
					cells.add(i * 9 + j);
				} else {
					int num = board[i][j]-'0';
					rows[i][num] = cols[j][num] = mat[i/3][j/3][num] = true;
				}
			}
		}

		solveSudoku(board, 0, cells, rows, cols, mat);
	}
}
