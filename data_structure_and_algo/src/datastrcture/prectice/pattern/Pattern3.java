package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern3 {
    public static void main(String[] args) {
        /*
         *    1 2 3 4
         *    1 2 3 4
         *    1 2 3 4
         */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please Enter the value of n");
        int n = scanner.nextInt();
        System.out.println();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print(j+" ");
                j++;
            }
            i++;
            System.out.println();
        }

    }
}
