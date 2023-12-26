package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern8 {
    public static void main(String[] args) {
        /*
         *    1
         *    2 3
         *    4 5 6
         *    7 8 9 10
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value on n");
        int n = scanner.nextInt();
        System.out.println();

        int row = 1;
        int count  = 1;
        while (row <= n){
            int col = 1;
            while (col <= row){
                System.out.print(count +" ");
                col++;
                count++;
            }
            row++;
            System.out.println();
        }
    }
}
