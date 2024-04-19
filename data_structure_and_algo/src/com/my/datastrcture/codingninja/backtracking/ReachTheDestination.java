package com.my.datastrcture.codingninja.backtracking;

public class ReachTheDestination {
    public static void main(String[] args) {
        System.out.println(reachDestination(1,1, 3, 5));
        System.out.println(reachDestination(1,1, 1, 4));
    }

    public static boolean reachDestination(int sx, int sy, int dx, int dy) {
        if (sx > dx || sy > dy)
            return false;

        // current point is equal to destination
        if (sx == dx && sy == dy)
            return true;

        // check for other 2 possibilities
        return (reachDestination(sx + sy, sy, dx, dy) ||
                reachDestination(sx, sy + sx, dx, dy));
    }

    public static boolean canReachDestination(int sx, int sy, int dx, int dy) {
        boolean[][] visited = new boolean[dx + 1][dy + 1];
        return dfs(sx, sy, dx, dy, visited);
    }

    public static boolean dfs(int sx, int sy, int dx, int dy, boolean[][] visited) {
        if (sx > dx || sy > dy) {
            return false; // Invalid move
        }

        if (visited[sx][sy]) {
            return false; // Already visited this state
        }

        if (sx == dx && sy == dy) {
            return true; // Destination reached
        }

        visited[sx][sy] = true;

        // Try both valid moves
        return dfs(sx + sy, sy, dx, dy, visited) || dfs(sx, sx + sy, dx, dy, visited);
    }
}
