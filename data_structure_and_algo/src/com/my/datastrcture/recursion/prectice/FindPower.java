package com.my.datastrcture.recursion.prectice;

public class FindPower {
    public static void main(String[] args) {
        int a = 2;
        int b = 7;
        System.out.println(power(a, b));
    }

    public static int power(int a, int b){
        if (b == 0){
            return 1;
        }
        if (b == 1){
            return a;
        }

        int ans  = power(a, b/2);
        if (b % 2 == 0){
            return ans = ans * ans;
        } else {
            return ans = a * ans * ans;
        }

    }
}
