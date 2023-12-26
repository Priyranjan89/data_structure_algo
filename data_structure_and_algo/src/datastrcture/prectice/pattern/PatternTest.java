package datastrcture.prectice.pattern;

import java.util.Scanner;

public class PatternTest {
    public static void main(String[] args) {
        /*
         *    1
         *    2 3
         *    3 4 5
         *    4 5 6 7
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value on n");
        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int col = 0;
            while (col < row){
                System.out.print((row+col) +" ");
                col++;
            }
            row++;
            System.out.println();
        }
    }
}
