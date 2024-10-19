package com.my.datastrcture.codingninja.graphs;

import java.io.IOException;
import java.util.Scanner;

public class IsConnected {
    public static void main(String[] args) throws NumberFormatException, IOException {

        /* Write Your Code Here
         * Complete the Rest of the Program
         * You have to take input and print the output yourself
         */
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int edges[][] = new int[V][V];
        if (V == 0 && E == 0) {
            System.out.println("true");
            return;
        }

        for (int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            edges[sv][ev] = 1;
            edges[ev][sv] = 1;
        }
        boolean ans = isConnected(edges);
        System.out.println(ans);
    }

    public static boolean isConnected(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        DFS(edges, 0, visited);
        for (boolean elem : visited) {
            if (elem == false)
                return false;
        }
        return true;
    }

    public static void DFS(int[][] edges, int startver, boolean[] visited) {
        visited[startver] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[startver][i] == 1 && !visited[i]) {
                visited[i] = true;
                DFS(edges, i, visited);

            }
        }
    }
}
