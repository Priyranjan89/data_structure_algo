package datastrcture.prectice;

import java.util.Scanner;

public class WhineTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter number of n");
        int n = scanner.nextInt();

        int i =1;
        int sum =0;

        while (i <= n){
            sum = sum+i;
            i++;
        }
        System.out.println("Sum of n = "+sum);
    }
}
