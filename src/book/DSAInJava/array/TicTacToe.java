package book.DSAInJava.array;

/**
 * Tic-Tac-Toe Game.
 */
public class TicTacToe {
	public static final int X = 1, O = -1, EMPTY = 0;
	private int board[][] = new int[3][3];
	private int currentPlayer;
	
	public TicTacToe() {
		clearBoard();
	}
	
	public void clearBoard() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = EMPTY;
			}
		}
		currentPlayer = X;
	}
	
	/*
	 * Puts an X or O mark at position i,j. 
	 */
	public void putMark(int i, int j) {
		if (i < 0 || i > 2 || j < 0 || j > 2) {
			throw new IllegalArgumentException("Invalid board position");
		}
		if (board[i][j] != EMPTY) {
			throw new IllegalArgumentException("Board position occupied");
		}
		board[i][j] = currentPlayer;
		currentPlayer = - currentPlayer;
	}
	
	public boolean isWin(int mark) {
		return ((board[0][0] + board[0][1] + board[0][2] == 3 * mark) 
				|| board[1][0] + board[1][1] + board[1][2] == 3 * mark
				|| board[2][0] + board[2][1] + board[2][2] == 3 * mark
				|| board[0][0] + board[1][0] + board[2][0] == 3 * mark
				|| board[0][1] + board[1][1] + board[2][1] == 3 * mark
				|| board[0][2] + board[1][2] + board[2][2] == 3 * mark
				|| board[0][0] + board[1][1] + board[2][2] == 3 * mark
				|| board[2][0] + board[1][1] + board[0][2] == 3 * mark
				);
	}
	
	public int winner() {
		if (isWin(X)) {
			return X;
		}
		if (isWin(O)) {
			return O;
		}
		return 0;  // tie
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				switch (board[i][j]) {
				case X: sb.append("X"); break;
				case O: sb.append("O"); break;
				case EMPTY: sb.append(" "); break;
				}
				if (j < 2) {
					sb.append("|");
				}
			}
			if (i < 2) {
				sb.append("\n-----\n");
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe();
		
		game.putMark(1,1); game.putMark(0,2);
		game.putMark(2,2); game.putMark(0,0);
		game.putMark(0,1); game.putMark(2,1);
		game.putMark(1,2); game.putMark(1,0);
		game.putMark(2,0);
		
		System.out.println(game);
		
		String[] outcome = {"O wins", "Tie", "X wins"};
		System.out.println(outcome[1 + game.winner()]);
	}
}
