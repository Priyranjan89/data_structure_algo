package com.my.datastrcture.codingninja.recursion;

import java.text.DecimalFormat;
import java.util.Scanner;

public class GeometricSum {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int k = s.nextInt();
        double ans = findGeometricSum(k);
        DecimalFormat dec = new DecimalFormat("#0.00000");
        System.out.println(dec.format(ans));
    }

    public static double findGeometricSum(int k){
        if (k == 0){
            return 1;
        }

        double result = 1/(Math.pow(2, k));
        return result + findGeometricSum(k-1);
    }

}
