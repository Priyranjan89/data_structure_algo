package com.my.datastrcture.codingninja.graphs;

import java.io.IOException;
import java.util.*;

public class GetPathBFS {
    public static void main(String[] args)  throws NumberFormatException, IOException {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int edges[][] = new int[V][V];
        for (int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            edges[sv][ev] = 1;
            edges[ev][sv] = 1;
        }
        int V1 = s.nextInt();
        int V2 = s.nextInt();
        boolean visited[] = new boolean[V];
        ArrayList<Integer> ans = getPathBFS(edges, visited, V1, V2);
        if (ans != null) {
            for (int elem : ans) {
                System.out.print(elem + " ");
            }
        }
    }

    public static ArrayList<Integer> getPathBFS(int[][] edges, boolean[] visited, int sv, int ev) {
        if (sv == ev) {
            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans.add(sv);
            visited[sv] = true;
            return ans;
        }
        Queue<Integer> q = new LinkedList<>();
        HashMap<Integer, Integer> h = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        q.add(sv);
        visited[sv] = true;
        while (!q.isEmpty()) {
            int first = q.remove();
            for (int i = 0; i < edges.length; i++) {
                if (edges[first][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.add(i);
                    h.put(i, first);
                    if (i == ev) {
                        ans.add(i);
                        while (!ans.contains(sv)) {
                            int b = h.get(i);
                            ans.add(b);
                            i = b;
                        }
                        return ans;
                    }
                }
            }
        }
        return null;
    }

}
