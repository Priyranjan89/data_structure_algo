package com.my.datastrcture.codingninja.recursion;

import java.util.ArrayList;

public class RatInAMazeProblem {
    public static void main(String[] args) {
        int N = 4;
        int m[][] = {{1, 0, 0, 0},{1, 1, 0, 1},{1, 1, 0, 0},{0, 1, 1, 1}};

        ArrayList<String> ans = findPath(m, N);
        ans.forEach(System.out::println);
    }

    public static ArrayList<String> findPath(int[][] m, int n) {
        ArrayList<String> ans = new ArrayList<>();

        if (m[0][0] == 0){
            return ans;
        }

        int srcX = 0;
        int srcY = 0;
        int visited[][] = new int[m.length][m[0].length];

        for (int i = 0; i < visited.length; i++){
            for (int j = 0; j < visited[i].length; j++){
                visited[i][j] = 0;
            }
        }

        StringBuilder path = new StringBuilder();
        solve(m, n, ans, srcX, srcY, visited, path);

        return ans;
    }

    private static void solve(int[][] m, int n,
                              ArrayList<String> ans,
                              int srcX, int srcY,
                              int visited[][], StringBuilder path){

        if (srcX == n-1 && srcY == n-1){
            ans.add(path.toString());
            return;
        }

        visited[srcX][srcY] = 1;

        int newX = srcX+1;
        int newY = srcY;
        if (isSafe(newX, newY, n, visited, m)){
            path.append("D");
            solve(m, n, ans, newX, newY, visited, path);
            path.deleteCharAt(path.length()-1);
        }

        newX = srcX;
        newY = srcY-1;
        if (isSafe(newX, newY, n, visited, m)){
            path.append("L");
            solve(m, n, ans, newX, newY, visited, path);
            path.deleteCharAt(path.length()-1);
        }

        newX = srcX;
        newY = srcY+1;
        if (isSafe(newX, newY, n, visited, m)){
            path.append("R");
            solve(m, n, ans, newX, newY, visited, path);
            path.deleteCharAt(path.length()-1);
        }

        newX = srcX - 1;
        newY = srcY;
        if (isSafe(newX, newY, n, visited, m)){
            path.append("U");
            solve(m, n, ans, newX, newY, visited, path);
            path.deleteCharAt(path.length()-1);
        }

        visited[srcX][srcY] = 0;
    }

    private static boolean isSafe(int x, int y, int n, int visited[][], int[][] m){
        if ((x >= 0) && (x < n) && (y >= 0) && (y < n) && (visited[x][y] == 0) && (m[x][y] == 1)){
            return true;
        } else {
            return false;
        }
    }
}
