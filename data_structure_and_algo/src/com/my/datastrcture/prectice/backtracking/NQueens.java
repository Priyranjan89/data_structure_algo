package com.my.datastrcture.prectice.backtracking;

public class NQueens {
    public static void main(String[] args) {
        int n = 4;
        placeNQueens(n);
    }
    public static void placeNQueens(int n){
        int board[][] = new int[n][n];
        placeQueens(board, n, 0);

    }

    private static void placeQueens(int board[][], int n, int row){
        if (row == n){
            printBoard(board, n);
            return;
        }
        //check for all columns
        for (int j = 0; j < n; j++){
            //check if it is safe to place queens
            if (isBoardSafe(board, row, j, n)){
                //if it is safe -> then place the queen and move to next row
                board[row][j] = 1;
                placeQueens(board, n, row+1);
                board[row][j] = 0;
            }
        }
    }

    private static boolean isBoardSafe(int[][] board, int row, int col, int n) {
        //vertical direction
        for (int i = row-1; i >=0; i--){
            if (board[i][col] == 1)
                return false;
        }
        //Left Diagonal direction
        for (int i = row-1, j = col-1; i >= 0 && j >= 0; i--, j--){
            if (board[i][j] == 1)
                return false;
        }

        //Right Diagonal direction
        for (int i = row-1, j = col+1; i >= 0 && j < n; i--, j++){
            if (board[i][j] == 1)
                return false;
        }
        return true;
    }

    private static void printBoard(int[][] board, int n) {
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
