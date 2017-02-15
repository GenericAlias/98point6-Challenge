// Danial Chowdhry
// danialc@uw.edu
// DropToken.java - A class created to play a game of drop token.
// Created for the 98point6 coding challenge.
import java.util.*;
import java.util.regex.Pattern;
// A class that represents a game of drop token
public class DropToken {
	// Two dimensional array representing the board
	private int[][] board;
	// List of columns inserted into thus far
	private ArrayList<Integer> moves;
	// Constant variable indicating the dimension of the board
	public final static int BOARD_SIZE = 4;

	// Constructor that starts a new game of drop token
	public DropToken() {
		this.board = new int[BOARD_SIZE][BOARD_SIZE];
		this.moves = new ArrayList<Integer>();
	}

	// Constructor for testing
	public DropToken(int[][] board) {
		this.board = board;
		this.moves = new ArrayList<Integer>();
	}

	// Takes in a column and a player number. Attempts to place a piece into that column
	// if there is room. Returns 0 if successfully placed, -1 if placement failed,
	// and 1 if victory is achieved
	public int place(int column, int player) {
		if (column >= BOARD_SIZE) {
			throw new IllegalArgumentException("Column is out of bounds");
		}
		if (player <= 0 || player > 2) {
			throw new IllegalArgumentException("Only players 1 and 2 allowed");
		}
		for (int i = BOARD_SIZE - 1; i >= 0; i--) {
			if (this.board[i][column] == 0) {
				this.board[i][column] = player;
				this.moves.add(column);
				return (isWinner(i, column, player) ? 1 : 0);
			}
		}
		return -1;
	}

	// Returns a copy of the board
	public int[][] getBoard() {
		return Arrays.copyOf(this.board, this.board.length);
	}

	// Returns a copy of the moves list
	public ArrayList<Integer> getMoves() {
		return new ArrayList<Integer>(this.moves);
	}

	// Checks the top row of the board to see if it is full
	public boolean isFull() {
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (board[0][i] == 0) {
				return false;
			}
		}
		return true;
	}
	// Checks the board to see if a winner has been determined. Returns false if no winner,
	// otherwise returns true.
	private boolean isWinner(int row, int column, int player) {
		int rowCount = 0;
		int columnCount = 0;
		boolean checkLeftDiagonal = (row == column);
		boolean checkRightDiagonal = (row == BOARD_SIZE - column - 1);
		int leftDiagCount = 0;
		int rightDiagCount = 0;
		// Count the pieces for the column, row and diagonal of the move
		for (int i = 0; i < BOARD_SIZE; i++) {
			if (this.board[i][column] == player) {
				columnCount++;
			}
			if (this.board[row][i] == player) {
				rowCount++;
			}
			if (checkLeftDiagonal && this.board[i][i] == player) {
				leftDiagCount++;
			}
			if (checkRightDiagonal && this.board[i][BOARD_SIZE - i - 1] == player) {
				rightDiagCount++;
			}
 		}
		// If a player has 4 in a row for a column, row, or diagonal, return true, false otherwise
 		return (rowCount == 4 || columnCount == 4 || leftDiagCount == 4 || rightDiagCount == 4);
	}

	// Static helper method to print the board with
	public static void printBoard(int[][] board) {
		for (int[] arr: board) {
			System.out.print("|");
			for(int i: arr) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
		System.out.println("+--------");
		System.out.println("  1 2 3 4");
	}

	// Static helper method to print the moves list with
	public static void printMoves(List<Integer> moves) {
		for (int i: moves) {
			System.out.println(i + 1);
		}
	}

	// Static helper method to interpret the results of a placement
	public static void printPutRes(int res, DropToken game) {
		if (res == 0) {
			System.out.println("OK");
		} else if (res == 1) {
			System.out.println("WIN");
		} else if (game.isFull()){
			// Print draw if the board is full
			System.out.println("DRAW");
		} else {
			System.out.println("ERROR");
		}
	}

	public static void main(String args[]) {
		System.out.println("Starting game of DropToken");
		Scanner sc = new Scanner(System.in);
		DropToken game = new DropToken();
		// Keeping track of the turn the game is on
		int turn = 0;
		String input = (sc.nextLine()).trim();
		// Loop until the user enters "EXIT"
		while (!input.equals("EXIT")) {
			if (input.equals("GET")) {
				// Show moves thus far
				ArrayList<Integer> moves = game.getMoves();
				printMoves(moves);
			} else if (input.equals("BOARD")) {
				// Print the board
				int[][] board = game.getBoard();
				printBoard(board);
			} else if (Pattern.matches("^PUT [1-4]$", input)) {
				// Update the game state based on user input
				int res = game.place(Integer.parseInt(input.substring(input.length() - 1)) - 1, (turn % 2) + 1);
				// If placement was successful, advance the turn count
				if (res == 0 || res == 1) {
					turn++;
				}
				printPutRes(res, game);
			} else if (!input.equals("EXIT")) {
				// Faulty user input. Print error statement and continue looping.
				System.out.println("Cannot read input. Please try again.");
			}
			input = (sc.nextLine()).trim();
		}

	}
}