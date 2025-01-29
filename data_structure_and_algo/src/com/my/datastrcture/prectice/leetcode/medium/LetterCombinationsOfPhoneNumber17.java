/*
package com.my.datastrcture.prectice.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfPhoneNumber17 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String n = sc.nextLine();
        List<String> ans = letterCombinations(n);
        for (int i =0; i < ans.size(); i++){
            System.out.println(ans.get(i));
        }
    }

    public static List<String> letterCombinations(String digits) {
        if (digits.length() == 0){

            return new ArrayList<>();
        }
        int newNum = n % 10;
        String ans[] = keypad(n/10);
        String mapping = kayMapping(newNum);
        String finalAns[] = new String[mapping.length()*ans.length];

        int k = 0;
        for (int i = 0; i < ans.length; i++){
            for (int j = 0; j < mapping.length(); j++){
                finalAns[k] = ans[i]+mapping.charAt(j);
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
*/
