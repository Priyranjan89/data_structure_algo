package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class Fibonacci {
    public static void main(String[] args) {
        ArrayList<Integer> db = new ArrayList<>(7);
        int n = 6;
        for (int i = 0; i <= n; i++){
            db.add(-1);
        }
        System.out.println(fib2(n, db));
    }

    //Memoization
    public static int fib(int n, ArrayList<Integer> db){
        if (n <= 1){
            return n;
        }
        if (db.get(n) != -1){
            return db.get(n);
        }
        int temp = fib(n-1, db) + fib(n-2, db);
        db.set(n, temp);
        return temp;
    }

    //Tabulation
    public static int fib2(int n, ArrayList<Integer> db){
        db.set(0, 0);
        db.set(1, 1);
        for (int i = 2; i <= n; i++){
            db.set(i, db.get(i-1) + db.get(i-2));
        }
        return db.get(n);
    }
}
