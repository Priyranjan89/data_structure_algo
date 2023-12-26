package datastrcture.prectice;

import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter value of a");
        int a = sc.nextInt();

        System.out.println("Please enter value of b");
        int b = sc.nextInt();

        System.out.println("Please enter the operation what you want to perform");
        String operation = sc.next();

        switch (operation){
            case "+":
                System.out.println("Answer of a + b : "+a+b);
                break;
            case "-":
                System.out.println("Answer of a - b : "+(a-b));
                break;
            case "*":
                System.out.println("Answer of a * b : "+(a*b));
                break;
            case "/":
                System.out.println("Answer of a / b : "+a/b);
                break;
            case "%":
                System.out.println("Answer of a % b : "+a%b);
                break;
            default:
                System.out.println("Operation is not valid");
        }

    }
}
