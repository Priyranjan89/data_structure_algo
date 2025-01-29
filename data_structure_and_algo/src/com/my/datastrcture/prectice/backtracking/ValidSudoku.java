package com.my.datastrcture.prectice.backtracking;

public class ValidSudoku {
    public static void main(String[] args) {

    }

    public static boolean isItSudoku(int matrix[][]) {
        return solveSudoku(matrix);
    }

    private static boolean solveSudoku(int[][] board) {
        // Iterate through the board to find an empty cell
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == 0) { // Empty cell
                    // Try placing numbers 1 to 9
                    for (int num = 1; num <= 9; num++) {
                        if (isValidPlacement(board, row, col, num)) {
                            board[row][col] = num; // Place the number
                            if (solveSudoku(board)) {
                                return true; // Continue solving
                            }
                            board[row][col] = 0; // Backtrack
                        }
                    }
                    return false; // No valid number found for this cell
                }
            }
        }
        return true; // All cells are filled correctly
    }

    private static boolean isValidPlacement(int[][] board, int row, int col, int num) {
        // Check if the number exists in the row or column
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        // Check the 3x3 subgrid
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true; // Placement is valid
    }
}
