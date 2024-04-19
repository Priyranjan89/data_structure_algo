package com.my.datastrcture.codingninja.backtracking;

public class PrintRatInAMazeAllPath {
    public static void main(String[] args) {
        int maze[][] = {{1, 0, 1},{1, 1, 1},{1, 1, 1}};
        int n = 3;
        ratInAMaze(maze, n);
    }

    /*public static void ratInAMaze(int maze[][], int n){
        int path[][] = new int[n][n];
        solveMazePrint(maze, 0, 0, path);
    }

    public static void solveMazePrint(int maze[][], int i, int j, int path[][]){
        int n = maze.length;
        // Check if i,j cell is valid or not
        if(i  < 0 || i >= n || j < 0 || j >= n  || maze[i][j] == 0
                || 	path[i][j] == 1){
            return;
        }
        // Include the cell in current path
        path[i][j] = 1;
        // Destination cell
        if(i == n - 1 && j == n - 1){
            for (int r = 0; r < n; r++){
                for (int c = 0; c < n; c++){
                    System.out.print(path[r][c]+" ");
                }
                System.out.println();
            }
            System.out.println();
            path[i][j] = 0;
            return;
        }

        // Explore further in all directions
        boolean pathPossible = false;
        // top
        solveMazePrint(maze, i - 1, j, path);
        //right
        solveMazePrint(maze, i, j + 1, path);
        // Down
        solveMazePrint(maze, i + 1 , j, path);
        // Left
        solveMazePrint(maze, i, j - 1, path);
        path[i][j] = 0;
    }*/

    public static void ratInAMaze(int maze[][], int n) {
        int[][] solution = new int[20][20];
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                solution[i][j] = 0;
            }
        }
        solveMaze(maze, solution, 0, 0, n);
    }
    private static void solveMaze(int maze[][], int solution[][], int x, int y, int n)
    {
        if (x == n - 1 && y == n - 1)
        {
            solution[x][y] = 1;
            printSolution(solution, n);
            System.out.println();
            return;
        }
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0)
        {
            return;
        }
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0 || maze[x][y] == 0 || solution[x][y] == 1)
        {
            return;
        }
        solution[x][y] = 1;
        solveMaze(maze, solution, x - 1, y, n);
        solveMaze(maze, solution, x + 1, y, n);
        solveMaze(maze, solution, x, y - 1, n);
        solveMaze(maze, solution, x, y + 1, n);
        solution[x][y] = 0;
    }
    private static void printSolution(int[][] solution, int n)
    {
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                System.out.print(solution[i][j] + " ");
            }
        }
    }
}
