package com.thealgorithms.others;

/**
 * A class that provides methods to solve a 9x9 Sudoku puzzle using a backtracking approach.
 * The Sudoku board is represented as a 2D array, and the methods are designed to
 * check for safe placements of numbers, solve the puzzle recursively, and print the board.
 */
final class Sudoku {

    private Sudoku() {
    }

    /**
     * Checks if placing a number in a specific position on the Sudoku board is safe.
     * The number is considered safe if it does not violate any of the Sudoku rules:
     * - It should not be present in the same row.
     * - It should not be present in the same column.
     * - It should not be present in the corresponding 3x3 subgrid.
     *
     * @param board The current state of the Sudoku board.
     * @param row   The row index where the number is to be placed.
     * @param col   The column index where the number is to be placed.
     * @param num   The number to be placed on the board.
     * @return True if the placement is safe, otherwise false.
     */
    public static boolean isSafe(int[][] board, int row, int col, int num) {
        // Check the row for duplicates
        for (int d = 0; d < board.length; d++) {
            if (board[row][d] == num) {
                return false;
            }
        }

        // Check the column for duplicates
        for (int r = 0; r < board.length; r++) {
            if (board[r][col] == num) {
                return false;
            }
        }

        // Check the corresponding 3x3 subgrid for duplicates
        int sqrt = (int) Math.sqrt(board.length);
        int boxRowStart = row - row % sqrt;
        int boxColStart = col - col % sqrt;

        for (int r = boxRowStart; r < boxRowStart + sqrt; r++) {
            for (int d = boxColStart; d < boxColStart + sqrt; d++) {
                if (board[r][d] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    /**
     * Solves the Sudoku puzzle using backtracking.
     * The algorithm finds an empty cell and tries placing numbers from 1 to 9.
     * The standard version of Sudoku uses numbers from 1 to 9, so the algorithm can be
     * easily modified for other variations of the game.
     * If a number placement is valid (checked via `isSafe`), the number is placed and the function
     * recursively attempts to solve the rest of the puzzle.
     * If no solution is possible, the number is removed (backtracked), and the process is repeated.
     *
     * @param board The current state of the Sudoku board.
     * @param n     The size of the Sudoku board (typically 9 for a standard puzzle).
     * @return True if the Sudoku puzzle is solvable, false otherwise.
     */
    public static boolean solveSudoku(int[][] board, int n) {
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        // Find the next empty cell
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 0) {
                    row = i;
                    col = j;
                    isEmpty = false;
                    break;
                }
            }
            if (!isEmpty) {
                break;
            }
        }

        // No empty space left
        if (isEmpty) {
            return true;
        }

        // Try placing numbers 1 to n in the empty cell (typically n=9)
        for (int num = 1; num <= n; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solveSudoku(board, n)) {
                    return true;
                } else {
                    // replace it
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    /**
     * Prints the current state of the Sudoku board in a readable format.
     * Each row is printed on a new line, with numbers separated by spaces.
     *
     * @param board The current state of the Sudoku board.
     * @param n     The size of the Sudoku board (typically 9 for a standard puzzle).
     */
    public static void print(int[][] board, int n) {
        // Print the board in a nxn grid format
        for (int r = 0; r < n; r++) {
            for (int d = 0; d < n; d++) {
                System.out.print(board[r][d]);
                System.out.print(" ");
            }
            System.out.print("\n");

            if ((r + 1) % (int) Math.sqrt(n) == 0) {
                System.out.print("");
            }
        }
    }

    /**
     * The driver method to demonstrate solving a Sudoku puzzle.
     * A sample 9x9 Sudoku puzzle is provided, and the program attempts to solve it
     * using the `solveSudoku` method. If a solution is found, it is printed to the console.
     *
     * @param args Command-line arguments (not used in this program).
     */
    public static void main(String[] args) {
        int[][] board = new int[][] {
            {3, 0, 6, 5, 0, 8, 4, 0, 0},
            {5, 2, 0, 0, 0, 0, 0, 0, 0},
            {0, 8, 7, 0, 0, 0, 0, 3, 1},
            {0, 0, 3, 0, 1, 0, 0, 8, 0},
            {9, 0, 0, 8, 6, 3, 0, 0, 5},
            {0, 5, 0, 0, 9, 0, 6, 0, 0},
            {1, 3, 0, 0, 0, 0, 2, 5, 0},
            {0, 0, 0, 0, 0, 0, 0, 7, 4},
            {0, 0, 5, 2, 0, 6, 3, 0, 0},
        };
        int n = board.length;

        if (solveSudoku(board, n)) {
            print(board, n);
        } else {
            System.out.println("No solution");
        }
    }
}
