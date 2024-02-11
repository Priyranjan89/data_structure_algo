package com.my.datastrcture.codingninja.oops;

public class FractionTest {
    public static void main(String[] args) {
        Fraction f1 = new Fraction(4, 6);
        f1.print();
        /*f1.increment();
        f1.print();*/
        Fraction f2 = new Fraction(1, 2);
        f2.print();
        f1.add(f2);
        f1.print();

        Fraction f3 = Fraction.add(f1, f2);
        f3.print();
    }
}
