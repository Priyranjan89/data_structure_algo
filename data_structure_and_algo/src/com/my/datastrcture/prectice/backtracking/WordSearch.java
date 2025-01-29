package com.my.datastrcture.prectice.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = {{'q', 'v', 'm', 'h'}, {'d', 'e', 's', 'i'},{'d', 'g', 'f', 'g'}, {'e', 'c', 'p', 'n'}};
        String word = "design";
        int n = board.length;
        int m =  board[0].length;

        boolean ans = present(board, word, n, m);
        System.out.println(ans);
    }

    public static boolean present(char [][]board, String word, int n, int m) {
        int visited[][] = new int[n][m];

        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++){
                if (board[i][j] == word.charAt(0)){
                    if (search(board, word, visited, 1, i, j, n, m)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean search(char[][] board, String word, int visited[][], int index, int i, int j, int n, int m) {
        visited[i][j] = 1;

        if (index == word.length()){
            return true;
        }

        //Right i, j+1
        if (j+1 < m && visited[i][j+1] == 0 && board[i][j+1] == word.charAt(index)){
            //Then we can search in this direction
            if (search(board, word, visited, index+1, i, j+1, n, m)){
                return true;
            }
        }

        //Left i, j-1
        if (j-1 >= 0 && visited[i][j-1] == 0 && board[i][j-1] == word.charAt(index)){
            //Then we can search in this direction
            if (search(board, word, visited, index+1, i, j-1, n, m)){
                return true;
            }
        }

        //Top i-1, j
        if (i-1 >= 0 && visited[i-1][j] == 0 && board[i-1][j] == word.charAt(index)){
            //Then we can search in this direction
            if (search(board, word, visited, index+1, i-1, j, n, m)){
                return true;
            }
        }

        //Down i+1, j
        if (i+1 < n && visited[i+1][j] == 0 && board[i+1][j] == word.charAt(index)){
            //Then we can search in this direction
            if (search(board, word, visited, index+1, i+1, j, n, m)){
                return true;
            }
        }

        visited[i][j] = 0;

        return false;
    }
}
