package com.my.datastrcture.codingninja.oops;

import java.util.Scanner;

public class DynamicArrayTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("How many element you want insert in array : ");
        int len = sc.nextInt();
        DynamicArray array = new DynamicArray();
        System.out.println(array.isEmpty());
        System.out.println(array.size());
        System.out.println("Please enter the "+len+" element for the array");
        for (int i = 0; i < len; i++){
            array.add(i+3);
        }
        System.out.println(array.size());
        array.printArray();
        System.out.println(array.remove());
        array.printArray();
        System.out.println(array.size());
    }
}
