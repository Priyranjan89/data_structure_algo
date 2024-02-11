package com.my.datastrcture.codingninja.string;

import java.util.Scanner;

public class RemoveCharacterFromString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the String : ");
        String str = sc.nextLine();
        System.out.print("Please enter the Character : ");
        String str1 = sc.nextLine();
        System.out.println("Removed Character from String : "+removeAllOccurrencesOfChar(str, str1.charAt(0)));
    }

    public static String removeAllOccurrencesOfChar(String str, char ch) {
        String ans = "";

        for (int i = 0; i < str.length(); i++){
            if (ch != str.charAt(i)){
                ans += str.charAt(i);
            }
        }
        return ans;
    }
}
