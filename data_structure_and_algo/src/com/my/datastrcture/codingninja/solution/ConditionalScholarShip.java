package com.my.datastrcture.codingninja.solution;

import java.util.Scanner;

public class ConditionalScholarShip {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter marks value: ");
        int marks = sc.nextInt();
        System.out.println("Please enter GPA value: ");
        float gpa = sc.nextFloat();
        System.out.println("Please enter star value: ");
        int star = sc.nextInt();

        if (marks >= 65 && (gpa >= 3.5) || (star >= 3)){
            System.out.println("Congratulation, You are Eligible for ScholarShip");
        } else {
            System.out.println("You are not Eligible for ScholarShip");
        }



    }
}
