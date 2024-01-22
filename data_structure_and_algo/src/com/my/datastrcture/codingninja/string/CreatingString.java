package com.my.datastrcture.codingninja.string;

import java.util.Scanner;

public class CreatingString {
    public static void main(String[] args) {
        //String literal
        String s1 = "Welcome";
        System.out.println(s1);

        //using new key word
        String str1 = new String("Hello Friend");
        System.out.println(str1);

        //Using character array
        char ch[] = {'c', 'o', 'd', 'i', 'n', 'g'};
        String str2 = new String(ch);
        System.out.println(str2);

        //using Byte Array
        byte bt[] = {97, 98, 99, 100, 101};
        String str3 = new String(bt);
        System.out.println(str3);
    }
}
