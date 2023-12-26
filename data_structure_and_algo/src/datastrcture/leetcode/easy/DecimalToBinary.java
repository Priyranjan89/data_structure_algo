package datastrcture.leetcode.easy;

import java.util.Scanner;

import static java.lang.Math.pow;

public class DecimalToBinary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();

        int ans = 0;
        int i =0;

        while (n != 0){
            int bit = n&1;
            ans = (int) (bit* pow(10,i) +ans);
            n = n>>1;
            i++;
        }

        System.out.println("Binary number of n is "+ans);
    }
}
