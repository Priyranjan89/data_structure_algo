package com.my.datastrcture.codingninja.solution;

public class Literals {
    public static void main(String[] args) {
        byte bt = 010;
        short sh = 0b1110;
        int nt = 0xd;
        long lg = 12_35_423_783;
        Long l = 366464646l;

        float avg = 3.8_64_512f;
        double d = 1e+9;

        Integer i =100;

        //char ch =97;  //ASCII value
        //char ch =a;
        char ch ='\uff74';

        System.out.println(i);
        System.out.println(bt);
        System.out.println(sh);
        System.out.println(nt);
        System.out.println(lg);
        System.out.println(avg);
        System.out.println(d);
        System.out.println(ch);
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.SIZE);

    }
}
