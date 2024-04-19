package com.my.datastrcture.codingninja.backtracking;

public class ValidSudoku {
    public static void main(String[] args) {
        int[][] validSudoku = {
                {5, 3, 0, 0, 7, 0, 0, 0, 0},
                {6, 0, 0, 1, 9, 5, 0, 0, 0},
                {0, 9, 8, 0, 0, 0, 0, 6, 0},
                {8, 0, 0, 0, 6, 0, 0, 0, 3},
                {4, 0, 0, 8, 0, 3, 0, 0, 1},
                {7, 0, 0, 0, 2, 0, 0, 0, 6},
                {0, 6, 0, 0, 0, 0, 2, 8, 0},
                {0, 0, 0, 4, 1, 9, 0, 0, 5},
                {0, 0, 0, 0, 8, 0, 0, 7, 9}
        };
        System.out.println(isItSudoku(validSudoku));
    }
    public static boolean isItSudoku(int[][] matrix) {
        return solveSudokuHelper(matrix);
    }
    public static void solveSudoku(int[][] sudoku) {
        solveSudokuHelper(sudoku);
    }

    private static boolean solveSudokuHelper(int[][] matrix) {
        int N = 9;
        int row = -1;
        int col = -1;
        boolean isEmpty = true;

        // Find the first empty cell
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
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

        // If there are no empty cells left, the Sudoku is solved
        if (isEmpty) {
            return true;
        }

        // Try digits from 1 to 9
        for (int num = 1; num <= 9; num++) {
            if (isSafe(matrix, row, col, num)) {
                matrix[row][col] = num;
                if (solveSudokuHelper(matrix)) {
                    return true;
                }
                matrix[row][col] = 0; // Backtrack if no solution is found
            }
        }

        return false;
    }

    private static boolean isSafe(int[][] matrix, int row, int col, int num) {
        // Check if num is not already used in current row, column, and 3x3 subgrid
        return !usedInRow(matrix, row, num) &&
                !usedInCol(matrix, col, num) &&
                !usedInBox(matrix, row - row % 3, col - col % 3, num);
    }

    private static boolean usedInRow(int[][] matrix, int row, int num) {
        for (int col = 0; col < 9; col++) {
            if (matrix[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usedInCol(int[][] matrix, int col, int num) {
        for (int row = 0; row < 9; row++) {
            if (matrix[row][col] == num) {
                return true;
            }
        }
        return false;
    }

    private static boolean usedInBox(int[][] matrix, int startRow, int startCol, int num) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (matrix[row + startRow][col + startCol] == num) {
                    return true;
                }
            }
        }
        return false;
    }
}
