package com.my.datastrcture.codingninja.string;

import java.util.Scanner;

public class CheckPermutationWithTwoInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the 1st string : ");
        String str1 = sc.nextLine();
        System.out.print("Please enter the 2nd string : ");
        String str2 = sc.nextLine();

        System.out.println("Is Permutation of String '"+str1+"' and '"+str2+"' : "+isPermutation(str1, str2));
    }

    public static boolean isPermutation(String str1, String str2) {

        if (str1.length() != str2.length()){
            return false;
        }
        boolean isPerm = true;
        char count[] = new char[256];

        for (int i = 0; i < str1.length(); i++){
            count[str1.charAt(i)] += 1;
        }

        for (int i = 0; i < str2.length(); i++){
            count[str2.charAt(i)] -= 1;
        }

        for (int i = 0; i < count.length; i++){
            if (count[i] != 0){
                isPerm = false;
            }
        }
        return isPerm;
    }
}
