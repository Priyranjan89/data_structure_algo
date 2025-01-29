package com.my.datastrcture.prectice.backtracking;

public class RateInAMazeAllPath {
    public static void main(String[] args) {
        int maze[][] = {{1, 1, 0}, {1, 1, 0}, {1, 1, 1}};
        //int maze[][] = {{1, 1}, {1, 1}};
        int n = maze.length;
        ratInAMaze(maze, n);

    }

    public static void ratInAMaze(int maze[][], int n) {
        int path[][] = new int[n][n];
        printAllPaths(maze, 0, 0, path, n);
    }

    private static void printAllPaths(int maze[][], int i, int j, int path[][], int n) {

        // Check if i,j cell is valid or not
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }
        // Include the cell in current path
        path[i][j] = 1;

        //if already reached destination cell
        if (i == n - 1 && j == n - 1) {
            //Printing the path from start to destination
            printThePath(path, n);
            System.out.println();
            path[i][j] = 0;
            return;
        }

        // Explore further in all directions
        //Top
        printAllPaths(maze, i - 1, j, path, n);

        //Right
        printAllPaths(maze, i, j + 1, path, n);

        //down
        printAllPaths(maze, i + 1, j, path, n);

        //down
        printAllPaths(maze, i, j - 1, path, n);
        path[i][j] = 0;
    }

    private static void printThePath(int[][] path, int n) {
        for (int x = 0; x < n; x++) {
            for (int y = 0; y < n; y++) {
                System.out.print(path[x][y] + " ");
            }
            System.out.println();
        }
    }
}
