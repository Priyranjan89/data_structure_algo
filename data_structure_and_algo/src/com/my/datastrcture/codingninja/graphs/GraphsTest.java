package com.my.datastrcture.codingninja.graphs;

import java.util.*;

public class GraphsTest {
    public static void dfTraversal(int adjMatrix[][], int currVertex, boolean visited[]){
        visited[currVertex] = true;
        System.out.print(currVertex+" ");
        for (int i = 0; i < adjMatrix.length; i++){
           if (adjMatrix[currVertex][i] == 1 && visited[i] == false){
               dfTraversal(adjMatrix, i, visited);
           }
        }
    }

    public static void dfTraversal(int adjMatrix[][]){
        boolean visited[] = new boolean[adjMatrix.length];
        for (int i =0; i < adjMatrix.length; i++) {
            if (!visited[i]) {
                dfTraversal(adjMatrix, i, visited);
                System.out.println();
            }
        }
    }

    public static void bfTraversal(int adjMatrix[][]){
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];
        pendingVertices.add(0);
        visited[0] = true;

        while (!pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex+" ");
            for (int i = 0; i < adjMatrix.length; i++){
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    // i is unvisited neighbor of currentVertex
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }


    public static ArrayList<Integer> getPathBFS(int adjMatrix[][], int s, int e){
        Queue<Integer> pendingVertices = new LinkedList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean visited[] = new boolean[adjMatrix.length];
        pendingVertices.add(s);
        visited[s] = true;
        map.put(s, -1);
        boolean foundPath = false;

        while (!pendingVertices.isEmpty()){
            int currentVertex = pendingVertices.poll();
            for (int i = 0; i < adjMatrix.length; i++){
                if (adjMatrix[currentVertex][i] == 1 && !visited[i]){
                    pendingVertices.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);
                    if (i == e){
                        foundPath = true;
                        break;
                    }
                }
            }
        }

        if (foundPath){
            ArrayList<Integer> ans = new ArrayList<>();
            int currentVertex = e;

            while (currentVertex != -1){
                ans.add(currentVertex);
                int parent = map.get(currentVertex);
                currentVertex = parent;
            }
            return ans;
        } else {
            return null;
        }

    }

    public static void bfTraversalWithMultipleGraphs(int adjMatrix[][]){
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMatrix.length];

        for (int k =0; k < adjMatrix.length; k++) {
            if (!visited[k]) {
                pendingVertices.add(k);
                visited[k] = true;

                while (!pendingVertices.isEmpty()){
                    int currentVertex = pendingVertices.poll();
                    System.out.print(currentVertex+" ");
                    for (int i = 0; i < adjMatrix.length; i++){
                        if (adjMatrix[currentVertex][i] == 1 && !visited[i]){
                            // i is unvisited neighbor of currentVertex
                            pendingVertices.add(i);
                            visited[i] = true;
                        }
                    }
                }
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfV = sc.nextInt();
        int edges = sc.nextInt();

        int adjMatrix[][] = new int[numOfV][numOfV];

        for (int i = 0; i < edges; i++){
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            adjMatrix[v1][v2] = 1;
            adjMatrix[v2][v1] = 1;
        }
        dfTraversal(adjMatrix);
        //bfTraversal(adjMatrix);

       /* for (int i =0; i < numOfV; i++){
            for (int j = 0; j < numOfV; j++){
                System.out.print(edgesMatrix[i][j] +" ");
            }
            System.out.println();
        }*/
    }
}
