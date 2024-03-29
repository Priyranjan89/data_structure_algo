package com.my.datastrcture.codingninja.oops;

public class Fraction {
    private int numerator;
    private int denominator ;

    public Fraction(int numerator, int denominator) {
        if (denominator == 0){
            denominator = 1;
        }

        this.denominator = denominator;
        this.numerator = numerator;
        simplify();
    }

    public int getNumerator() {
        return numerator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
        simplify();
    }

    public int getDenominator() {
        return denominator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0){
            return;
        }
        this.denominator = denominator;
        simplify();
    }

    public void print(){
        System.out.println(numerator+"/"+denominator);
    }

    private void simplify(){
        int gcd = 1;
        int smaller = Math.min(numerator, denominator);
        for (int i = 2; i <= smaller; i++){
            if (numerator % i == 0 && denominator % i == 0){
                gcd = i;
            }
        }
        numerator = numerator / gcd;
        denominator = denominator / gcd;
    }

    public void increment(){
        numerator = numerator + denominator;
        simplify();
    }

    public void add(Fraction f2){
        //First Fraction is the fraction on which function is called
        //Second Fraction is passes as argument
        this.numerator = this.numerator * f2.denominator + f2.numerator * this.denominator;
        this.denominator = this.denominator * f2.denominator;
        simplify();
    }

    public static Fraction add(Fraction f1, Fraction f2){
        int newNumerator = f1.numerator * f2.denominator + f2.numerator * f1.denominator;
        int newDenominator = f1.denominator * f2.denominator;

        Fraction f3 = new Fraction(newNumerator, newDenominator);

        return f3;
    }
}
