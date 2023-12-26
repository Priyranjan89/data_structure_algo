package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern18 {

    public static void main(String[] args) {
        /*
         *        *
         *      * *
         *    * * *
         *  * * * *
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int space = n-row;
            while (space>=1){
                System.out.print(" ");
                space--;
            }
            int col = 1;
            while (col <= row){
                System.out.print("*");
                col++;
            }
            System.out.println();
            row++;
        }

    }
}
