package com.my.datastrcture.prectice.backtracking;

public class PrintRateInAMazePath {
    public static void main(String[] args) {
        int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
        ratInAMaze(maze);

    }
    public static void ratInAMaze(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];

        findPath(maze, 0, 0, path);
    }

    private static boolean findPath(int maze[][], int i, int j, int path[][]){
        int n = maze.length;

        // Check if i,j cell is valid or not
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }
        // Include the cell in current path
        path[i][j] = 1;

        //if already reached destination cell
        if (i == n-1 && j == n-1){
            //Printing the path from start to destination
            printThePath(path, n);
            System.out.println();
            path[i][j] = 0;
            return true;
        }

        // Explore further in all directions
        //Top
        if (findPath(maze, i - 1, j, path)){
            return true;
        }

        //Right
        if (findPath(maze, i, j + 1, path)){
            return true;
        }

        //down
        if (findPath(maze, i + 1, j, path)){
            return true;
        }

        //down
        if (findPath(maze, i, j - 1, path)){
            return true;
        }

        return false;
    }

    private static void printThePath(int[][] path, int n) {
        for (int x = 0; x < n; x++){
            for (int y = 0; y < n; y++){
                //If you wanted to print cell
                /*if (path[x][y] == 1){
                    System.out.print("["+x+" "+y+"] ");
                }*/
                System.out.print(path[x][y]+" ");
            }
            System.out.println();
        }
    }
}
