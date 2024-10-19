package com.my.datastrcture.prectice;

public class BitwiseTest {
    public static void main(String[] args) {
        int a = 4;
        int b = 6;
        int mid =5, divisor=2;
        System.out.println("mid << divisor :"+(mid<<(divisor-1)));

        System.out.println("a & b :"+(a&b));
        System.out.println("a | b :"+(a|b));
        System.out.println("~a :  "+(~a));
        System.out.println("a ^ b :"+(a^b));


        System.out.println("17 >> 1 :"+(17>>1));
        System.out.println("17 >> 2 :"+(17>>2));
        System.out.println("19 << 1 :"+(19<<1));
        System.out.println("21 << 2 :"+(21<<2));
        System.out.println("\n");
        int i =1;
        int j = 2;
        if( i-- > 0 && j++ > 2){
            System.out.println("count 1");
        } else {
            System.out.println("count 2");
        }
        System.out.println("i : "+i+", j : "+j);
    }
}
