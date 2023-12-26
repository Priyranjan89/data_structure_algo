package datastrcture.recursion;

public class Factorial {

    public static long factorial(int num) {

        if (num < 0) {
            return -1;
        }
        if (num == 0 || num == 1) {
            return 1;
        }

        return num * factorial(num - 1);
    }

    public static void main(String[] args) {
        System.out.println(factorial(4));
        System.out.println(factorial(5));
        System.out.println(factorial(6));
        System.out.println(factorial(7));
        System.out.println(factorial(8));
    }
}
