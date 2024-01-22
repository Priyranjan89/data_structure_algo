package com.my.datastrcture.codingninja.solution;

public class Implicit {
    public static void main(String[] args) {
        short currentYear = 2030;
        byte age = 39;
        short birthYear = (short) (currentYear - age);

        int my_int = 9;
        double my_double = my_int;

        double d = 9.85;
        int r = (int)d;
        System.out.println(r);

        //int birthYear = currentYear - age;
        System.out.println(currentYear - age);
        System.out.println(birthYear);
    }
}
