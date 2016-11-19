class GameOfLife {

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

	public static void main(String[] args) {

		Board boardLife = new Board();
		int[][] nextBoard = boardLife.getBoard(args[0]);
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
		boardLife.printBoard(nextBoard);
	}
}