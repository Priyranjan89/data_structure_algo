package com.my.datastrcture.codingninja.graphs;

import java.io.IOException;
import java.util.*;

public class HasPath {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] strNums;
        strNums = sc.nextLine().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int e = Integer.parseInt(strNums[1]);

        int edges[][] = new int[n][n];
        for (int i = 0; i < e; i++){
            String[] strNums1;
            strNums1 = sc.nextLine().split("\\s");
            int fv = Integer.parseInt(strNums1[0]);
            int sv = Integer.parseInt(strNums1[1]);
            edges[fv][sv] = 1;
            edges[sv][fv] = 1;

        }
        String[] strNums1;
        strNums1 = sc.nextLine().split("\\s");

        int sv = Integer.parseInt(strNums1[0]);
        int ev = Integer.parseInt(strNums1[1]);
        System.out.println(hasPath(edges, sv, ev));
    }

    public static boolean hasPath(int[][] edges, int sv, int ev){
        boolean visited[] = new boolean[edges.length];
        return BFS(edges, sv, ev, visited);
    }
    public static boolean BFS(int[][] edges, int sv, int ev, boolean[] visited) {
        if (sv > (edges.length-1) || ev > (edges.length-1)){
            return false;
        }
        if (edges[sv][ev] == 1){
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        visited[sv] = true;
        queue.add(sv);

        while (!queue.isEmpty()){
            int front = queue.remove();
            for (int i = 0; i < edges.length; i++){
                if (edges[front][i] == 1 && !visited[i]){
                    if (i == ev){
                        return true;
                    } else {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }
        return false;
    }
}
