package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern10 {
    public static void main(String[] args) {
        /*
         *    1
         *    2 1
         *    3 2 1
         *    4 3 2 1
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value on n");
        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int col = 1;
            while (col <= row){
                System.out.print((row-col+1) +" ");
                col++;
            }
            row++;
            System.out.println();
        }
    }
}
