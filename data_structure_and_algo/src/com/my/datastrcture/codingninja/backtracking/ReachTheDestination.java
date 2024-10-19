package com.my.datastrcture.codingninja.backtracking;

import java.util.HashMap;
import java.util.Map;
import java.util.*;

public class ReachTheDestination {
    public static void main(String[] args) {
        System.out.println(reachDestination(1,1, 3, 5));
        System.out.println(reachDestination(1,1, 1, 4));
    }


    public static boolean reachDestination(int sx, int sy, int dx, int dy) {

        // Reach the destination
        if (sx == dx && sy == dy) {
            return true;
        }
        //base case
        if (sx > dx || sy > dy) {
            return false;
        }

        //Recursive call
       if (dx > dy){
           return reachDestination(sx, sy, dx-dy, dy);
       } else {
           return reachDestination(sx, sy, dx, dy-dx);
       }

    }
}
