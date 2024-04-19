package com.my.datastrcture.test;

import java.util.Scanner;

public class ReturnKeypadString {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int n = sc.nextInt();
        String ans[] = keypad(n);
        for (int i =0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
    }

    public static String[] keypad(int n){

        if (n == 0){
            String ans[] = {""};
            return ans;
        }

        int newNum = n % 10;
        String smallAns[] = keypad(n/10);
        String mapping = kayMapping(newNum);
        String finalAns[] = new String[mapping.length()*smallAns.length];

        int k = 0;
        for (int i = 0; i < smallAns.length; i++){
            for (int j = 0; j < mapping.length(); j++){
                finalAns[k] = smallAns[i] + mapping.charAt(j);
                k++;
            }
        }
        return finalAns;
    }
    private static String kayMapping(int newNum){
        String str[] =  {"", "", "abc", "def", "ghi", "jkl","mno","pqrs","tuv","wxyz"};
        return str[newNum];
    }
}
