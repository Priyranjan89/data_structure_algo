package datastrcture.recursion;

public class PowerOfNumber {

    public static int power(int base, int exponent){
        if (base == 0 || base < 0 || exponent<0){
            return 0;
        }

        if (exponent == 0){
            return 1;
        }

        return base * power(base, exponent-1);
    }

    public static void main(String[] args) {
        System.out.println(power(2,4));
        System.out.println(power(3,4));
    }
}
