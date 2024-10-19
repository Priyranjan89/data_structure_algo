package com.my.datastrcture.prectice;

import java.util.Scanner;

public class LetterCombinationsOfPhoneNumber {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        String ans[] = keypad(n);
        for (int i =0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }

    private static String[] keypad(int n) {

        if (n == 0){
            String ans[] = {""};
            return ans;
        }

        int newNum = n%10;
        String ans[] = keypad(n/10);
        String mapping = kayMapping(newNum);

        String finalAns[] = new String[ans.length * mapping.length()];

        int k = 0;
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < mapping.length(); j++){
                finalAns[k++] = ans[i]+mapping.charAt(j);
            }
        }
        return finalAns;
    }
    private static String kayMapping(int newNum){
        String str[] =  {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
        return str[newNum];
    }
}
