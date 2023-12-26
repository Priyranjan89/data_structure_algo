package datastrcture.recursion;

public class DecimalToBinary {

    public static long decimalToBinary(int n) {
        if (n < 0 || n == 0) {
            return 0;
        }
       /* if (n == 1) {
            return 1;
        }*/

        return n % 2 + 10 * decimalToBinary(n / 2);
    }

    public static void main(String[] args) {
        System.out.println(decimalToBinary(5));
        System.out.println(decimalToBinary(7));
        System.out.println(decimalToBinary(10));
        System.out.println(decimalToBinary(14));
        System.out.println(decimalToBinary(-5));
        System.out.println(decimalToBinary(0));
        System.out.println(decimalToBinary(1));
    }
}
