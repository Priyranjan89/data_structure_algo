package datastrcture.prectice;

import java.util.Scanner;

public class EvenAndOddCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("please enter the value of n");
        int n = sc.nextInt();
        System.out.println("Is "+n+" Even number "+isEven(n));
    }

    public static boolean isEven(int num){
        if ((num&1) == 1){
            return false;
        }
        return true;
    }
}
