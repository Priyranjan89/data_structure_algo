package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern7 {
    public static void main(String[] args) {
        /*
         *    1
         *    2 2
         *    3 3 3
         *    4 4 4 4
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value on n");
        int n = scanner.nextInt();
        System.out.println();

        int row = 1;
        while (row <= n){
            int col = 1;
            while (col <= row){
                System.out.print(row +" ");
                col++;
            }
            row++;
            System.out.println();
        }
    }
}
