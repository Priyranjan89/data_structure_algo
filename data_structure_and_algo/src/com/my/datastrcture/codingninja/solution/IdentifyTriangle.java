package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class IdentifyTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int X = sc.nextInt();
        int Y = sc.nextInt();
        int Z = sc.nextInt();

        if((X+Y > Z) && (Y+Z > X) && (Z+X > Y)){
            if (X == Y && Y == Z ){
                System.out.println("Equilateral Triangle");
            } else if (X == Y || Y == Z || Z == X) {
                System.out.println("Isosceles Triangle");
            } else {
                System.out.println("Scalene Triangle");
            }
        } else {
            System.out.println("Not a Triangle");
        }
    }
}
