package com.my.datastrcture.codingninja.searching;

public class FindSquareRoot {
    public static void main(String[] args) {
        long n = 7777777;
        System.out.println(sqrtN(n));
    }

    public static int sqrtN(long N) {
        long left = 2;
        long right = N;
        long mid = left+(right -left)/2;

        if (N == 0 || N == 1){
            return (int)N;
        }
        while (left < right){
            if (mid <= (N/mid)){
                left = mid+1;
            } else {
                right = mid;
            }

            mid = left+(right -left)/2;
        }

        return (int)left-1;
    }
}
