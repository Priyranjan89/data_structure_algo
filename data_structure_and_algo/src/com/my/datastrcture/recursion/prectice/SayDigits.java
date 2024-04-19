package com.my.datastrcture.recursion.prectice;

public class SayDigits {
    public static void main(String[] args) {
        int num = 412;
        System.out.println(sayDigits(num));
    }
     public static String sayDigits(int num){
        if (num == 0){
            return "";
        }
        int rem = num %10;
        String ans = sayDigits(num/10);
        ans = ans +" "+getDigit(rem);
        return ans;
     }

     private static String getDigit(int n){
        String arr[] = {"Zero","One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
        return arr[n];
     }
}
