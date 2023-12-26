package datastrcture.prectice.pattern;

import java.util.Scanner;

public class Pattern16 {

    public static void main(String[] args) {
        /*
         *    A
         *    B C
         *    C D E
         *    D E F G
         */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter the value of n ");

        int n = scanner.nextInt();

        int row = 1;
        while (row <= n){
            int col = 1;
            while (col <= row){
                //char ch = (char) ('A-1+(row+col)-1);
                char ch = (char) ('A'+(row+col)-2);
                System.out.print(ch+" ");
                col++;
            }
            System.out.println();
            row++;
        }
    }
}
