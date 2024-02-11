package com.my.datastrcture.codingninja.oops;

public class Car extends Vehicle{
    public static void main(String[] args) {
        Vehicle v = new Vehicle();
        v.colour = "white";
        v.set(1010) ;
        System.out.println(v.colour + " " + v.get());
    }
}
