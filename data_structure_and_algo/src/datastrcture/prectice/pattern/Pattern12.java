package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern12 {

    public static void main(String[] args) {
        /*
         *    A B C
         *    D E F
         *    G H I
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        int count = 1;
        while (row <= n){
            int col = 1;
            while (col <= n){
                char ch = (char) ('A'+(count-1));
                System.out.print(ch+" ");
                col++;
                count++;
            }
            System.out.println();
            row++;
        }
    }
}
