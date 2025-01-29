package com.my.datastrcture.prectice.recursion;

public class ReturnKeypad {
    public static void main(String[] args) {
        int n = 23;
        String output[] = keypad(n);
        for (String str : output){
            System.out.println(str);
        }
    }

    public static String[] keypad(int n){
        if (n == 0){
            String smallOutput[] = {""};
            return smallOutput;
        }
        int rem = n % 10;
        String smallOutput[] = keypad(n/10);

        String mapping = getMapping(rem);
        String output[] = new String[smallOutput.length * mapping.length()];

        int k = 0;
        for (String str : smallOutput){
            for (int i = 0; i < mapping.length(); i++){
                String ans = str + mapping.charAt(i);
                output[k++] = ans;
            }
        }

        return output;
    }
    private static String getMapping(int index){
        String str[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return str[index];
    }
}
