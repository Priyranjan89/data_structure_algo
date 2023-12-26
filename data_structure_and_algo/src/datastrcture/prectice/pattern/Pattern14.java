package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern14 {

    public static void main(String[] args) {
        /*
         *    A
         *    B B
         *    C C C
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;

        while (row<= n){
            int col = 1;
            while (col <= row){
                char ch = (char) ('A'+row-1);
                System.out.print(ch+" ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
