import java.io.File;
import java.util.Scanner;

class GameOfLife {

	static int[][] nextBoard;
	final static int numRounds = 1;

	static int countSurrounding(int[][] board, int a, int b) {
		int count = 0;
		int[][] surrounding = { { a - 1, b - 1 }, { a - 1, b }, { a - 1, b + 1 }, { a, b - 1 }, { a, b + 1 },
				{ a + 1, b - 1 }, { a + 1, b }, { a + 1, b + 1 } };
		for (int i[] : surrounding) {
			try {
				if (board[i[0]][i[1]] == 1) {
					count++;
				}
			} catch (ArrayIndexOutOfBoundsException e) {
			}
		}
		return count;
	}

	static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
		System.out.println();
	}

	private static void parseInput(String entries) {
		int numRowsOrCols = (int) Math.sqrt(entries.length());
		// initialize the board
		nextBoard = new int[numRowsOrCols][numRowsOrCols];
		for (int i = 0; i < numRowsOrCols; i++) {
			for (int j = 0; j < numRowsOrCols; j++) {
				nextBoard[i][j] = (int) entries.charAt(numRowsOrCols * i + j) - 48;
			}
		}
	}

	private static void readFile(String fileName) {
		try {
			Scanner scanner = new Scanner(new File(fileName));
			String entries = "";
			while (scanner.hasNext()) {
				entries += String.valueOf(scanner.next());
			}
			int inputLength = entries.toCharArray().length;
			double rootOfLength = Math.sqrt(inputLength);
			// Since we have non-square input size
			if (rootOfLength - Math.floor(rootOfLength) > 0.0)
				System.err.println("Invalid Input");
			else
				parseInput(entries); // Parse into the 2d array
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public static void main(String[] args) {

		readFile(args[0]);

		int[][] board = new int[nextBoard.length][nextBoard[0].length];

		for (int gen = 0; gen < numRounds; gen++) {

			// COPYING THIS SO THAT WE CAN GENERALIZE LATER ON, TO N ROUNDS
			// Else this line is wasteful
			for (int i = 0; i < nextBoard.length; i++) {
				for (int j = 0; j < nextBoard[i].length; j++) {
					board[i][j] = nextBoard[i][j];
				}
			}
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[i].length; j++) {
					if (board[i][j] == 1
							&& !(countSurrounding(board, i, j) == 2 || countSurrounding(board, i, j) == 3)) {
						nextBoard[i][j] = 0;
					} else if (board[i][j] == 0 && countSurrounding(board, i, j) == 3) {
						nextBoard[i][j] = 1;
					}
				}
			}
		}
		printBoard(nextBoard);
	}
}