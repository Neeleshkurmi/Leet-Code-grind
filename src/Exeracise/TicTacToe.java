package Exeracise;

import java.util.Scanner;

public class TicTacToe{
    private static final char PLAYER = 'X';  // Human player
    private static final char AI = 'O';      // AI player
    private static final char EMPTY = '_';   // Empty cell
    private static final int SIZE = 3;       // Board size

    private static char[][] board = new char[SIZE][SIZE];

    // Initialize the board with empty values
    private static void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = EMPTY;
            }
        }
    }

    // Print the board
    private static void printBoard() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Check if a player has won
    private static boolean isWinner(char player) {
        // Check rows, columns, and diagonals
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) return true;
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) return true;
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) return true;
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) return true;

        return false;
    }

    // Check if the board is full (game draw)
    private static boolean isBoardFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    // Minimax algorithm to determine the best move for the AI
    private static int minimax(boolean isMaximizing) {
        if (isWinner(AI)) return 10;
        if (isWinner(PLAYER)) return -10;
        if (isBoardFull()) return 0;

        if (isMaximizing) {
            int bestScore = Integer.MIN_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = AI;
                        int score = minimax(false);
                        board[i][j] = EMPTY;
                        bestScore = Math.max(score, bestScore);
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = Integer.MAX_VALUE;
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    if (board[i][j] == EMPTY) {
                        board[i][j] = PLAYER;
                        int score = minimax(true);
                        board[i][j] = EMPTY;
                        bestScore = Math.min(score, bestScore);
                    }
                }
            }
            return bestScore;
        }
    }

    // Find the best move for the AI
    private static int[] findBestMove() {
        int bestScore = Integer.MIN_VALUE;
        int[] bestMove = {-1, -1};

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (board[i][j] == EMPTY) {
                    board[i][j] = AI;
                    int moveScore = minimax(false);
                    board[i][j] = EMPTY;
                    if (moveScore > bestScore) {
                        bestScore = moveScore;
                        bestMove = new int[]{i, j};
                    }
                }
            }
        }
        return bestMove;
    }

    // Check if the game is over (win or draw)
    private static boolean isGameOver() {
        return isWinner(PLAYER) || isWinner(AI) || isBoardFull();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeBoard();

        System.out.println("*** Tic-Tac-Toe Game: Player vs AI ***");
        printBoard();

        while (!isGameOver()) {
            // Player's turn
            System.out.println("Enter your move (row and column: 0, 1, or 2): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] != EMPTY) {
                System.out.println("Invalid move! Try again.");
                continue;
            }

            board[row][col] = PLAYER;
            printBoard();

            if (isWinner(PLAYER)) {
                System.out.println("Congratulations! You win!");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }

            // AI's turn
            System.out.println("AI is making its move...");
            int[] aiMove = findBestMove();
            board[aiMove[0]][aiMove[1]] = AI;
            printBoard();

            if (isWinner(AI)) {
                System.out.println("AI wins! Better luck next time.");
                break;
            }
            if (isBoardFull()) {
                System.out.println("It's a draw!");
                break;
            }
        }
        scanner.close();
    }
}
