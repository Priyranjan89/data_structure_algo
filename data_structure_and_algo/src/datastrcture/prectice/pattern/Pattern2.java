package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern2 {
    public static void main(String[] args) {
        /*
         *    1 1 1
         *    2 2 2
         *    3 3 3
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the value of n");
        int n = scanner.nextInt();
        System.out.println();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(i+" ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
