package com.my.datastrcture.prectice.backtracking;

public class ReachTheDestination {
    public static void main(String[] args) {
        System.out.println(reachDestination(1, 1, 3, 5));
        System.out.println(reachDestination(1, 1, 1, 4));
    }
    public static boolean reachDestination(int sx, int sy, int dx, int dy) {
        if (sx > dx || sy > dy){
            return false;
        }
        if (sx == dx && sy == dy){
            return true;
        }
        return (reachDestination(sx+ sy, sy, dx, dy) ||
                reachDestination(sx, sx + sy, dx, dy));
    }

}
