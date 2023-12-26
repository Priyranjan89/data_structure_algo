package datastrcture.prectice;

import java.util.Scanner;

public class FibonacciSeries {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of n");
        int n = sc.nextInt();

        fibonacciSeries(n);

    }

    private static void fibonacciSeries(int n) {
        int a = 0;
        int b = 1;
        int c = 0;
        System.out.print(a+" ");
        System.out.print(b+" ");
        for (int i = 1; i <= n; i++){
            c = a+b;
            System.out.print(c+" ");
            a = b;
            b = c;

        }
    }
}
