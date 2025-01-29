package com.my.datastrcture.prectice.backtracking;

public class RateInAMaze {
    public static void main(String[] args) {
        int maze[][] = {{1,1,0},{1,1,0},{1,1,1}};
        int maze2[][] = {{1,0,1},{1,0,1},{0,1,1}};
        boolean ans = ratInAMaze(maze);
        boolean ans2 = ratInAMaze(maze2);
        System.out.println(ans);
        System.out.println(ans2);
    }
    public static boolean ratInAMaze(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        return findPath(maze, 0, 0, path);
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
}
