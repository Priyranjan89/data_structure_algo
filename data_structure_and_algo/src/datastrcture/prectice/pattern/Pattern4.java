package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern4 {
    public static void main(String[] args) {
        /*
         *    4 3 2 1
         *    4 3 2 1
         *    4 3 2 1
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the value of n");
        int n = scanner.nextInt();
        System.out.println();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print((n-j+1)+" ");
                j++;
            }
            i++;
            System.out.println();
        }

    }
}
