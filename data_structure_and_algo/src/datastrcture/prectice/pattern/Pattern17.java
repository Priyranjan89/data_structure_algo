package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern17 {
    public static void main(String[] args) {
        /*
         *    D
         *    C D
         *    B C D
         *    A B C D
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        /*while (row <= n){
            int col = 1;
            while (col <= row){
                //char ch = (char) ('A-1+(row+col)-1);
                char ch = (char) ('A'+(n-row+col-1));

                System.out.print(ch+" ");
                col++;
            }
            System.out.println();
            row++;
        }*/

        while (row <= n){
            int col = 1;
            char ch = (char) ('A'+n-row);
            while (col <= row){
                System.out.print(ch+" ");
                ch = (char)(ch+1);
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
