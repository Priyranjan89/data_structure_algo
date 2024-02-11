package com.my.datastrcture.codingninja.oops;

public class TestThis {
    int a;
    int b;


    public TestThis(){
        this(10,20);
        System.out.print("constructor one ");
    }

    public TestThis(int a, int b) {
        this.a = a;
        this.b = b;
        final int c;
        c = 10;
        System.out.print("constructor two ");
    }


    public void set(int a, int b)
    {
        b = a;
        this.b = b;
    }

    void display()
    {
        System.out.println("a=" + a + " b=" + b);
    }

}
