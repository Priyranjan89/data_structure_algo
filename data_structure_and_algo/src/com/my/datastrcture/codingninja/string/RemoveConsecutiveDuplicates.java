package com.my.datastrcture.codingninja.string;

import java.util.Scanner;

public class RemoveConsecutiveDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the String : ");
        String str = sc.nextLine();
        System.out.println("Removed consecutive duplicate String : "+removeConsecutiveDuplicates(str));
    }

    public static String removeConsecutiveDuplicates(String str) {
        String ans = "";
        ans = ans+str.charAt(0);
        int j = 0;
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(j);
            if (ch != str.charAt(i)){
                ans = ans+str.charAt(i);
                j = i;
            }
        }

        return ans;
    }
}
