package com.my.datastrcture.codingninja.backtracking;

public class WordSearch1 {
    public static void main(String[] args) {
        /*
        * yqyjmkdqavbxdngvt
5 6
d z s y v u
l r u l o n
k m j y q y
d q b x g v
c a v d n t
*/
        char board[][] = {{'d','z','s','y','v','u'}, {'l', 'r', 'u', 'l', 'o', 'n'}, {'k', 'm', 'j', 'y', 'q', 'y'}, {'d', 'q', 'b', 'x', 'g', 'v'}, {'c', 'a', 'v', 'd', 'n','t'}};
        String word = "yqyjmkdqavbxdngvt";
        System.out.println(present(board, word, 5, 6));
    }

    public static boolean present(char [][]board, String word, int n, int m) {

        int visited[][] = new int[n][m];

        for (int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited[i].length; j++){
                if (board[i][j] == word.charAt(0)){
                    boolean wordFound = search(board, word, visited, 1, i, j, n, m);
                    if (wordFound == true){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private static boolean search(char[][] board, String word, int visited[][], int currentIndex, int i, int j, int n, int m) {
        if (currentIndex == word.length()){
            return true;
        }
        visited[i][j] = 1;

        //right - i j+1
        if (j+1 < m && visited[i][j+1] == 0 && board[i][j+1] == word.charAt(currentIndex)){
            //then we can search in this direction
            if (search(board, word, visited, currentIndex + 1, i, j + 1, n, m)){
                return true;
            }
        }
        //left - i, j -1
        if (j-1 >= 0 && visited[i][j-1] == 0 && board[i][j-1] == word.charAt(currentIndex)){
            //then we can search in this direction
            if (search(board, word, visited, currentIndex + 1, i, j - 1, n, m)){
                return true;
            }
        }
        //top  i-1, j
        if (i-1 >= 0 && visited[i-1][j] == 0 && board[i-1][j] == word.charAt(currentIndex)){
            //then we can search in this direction
            if (search(board, word, visited, currentIndex + 1, i - 1, j, n, m)){
                return true;
            }
        }
        //down i+1, j
        if (i+1 < n && visited[i+1][j] == 0 && board[i+1][j] == word.charAt(currentIndex)){
            //then we can search in this direction
            if (search(board, word, visited, currentIndex + 1, i + 1, j, n, m)){
                return true;
            }
        }
        visited[i][j] = 0;

        return false;
    }
}
