package com.my.datastrcture.prectice.recursion;

public class PrintKeypad {
    public static void main(String[] args) {
        //printKeypad(23);
        printKeypad(79);
    }

    public static void printKeypad(int input){
        printKeypadHelper(input, "");
    }

    private static void printKeypadHelper(int input, String ans){
        if (input == 0){
            System.out.println(ans);
            return;
        }
        String mapping = getMapping(input%10);
        for (int  i = 0; i < mapping.length(); i++){
            printKeypadHelper(input/10,mapping.charAt(i)+ans);
        }
    }
    private static String getMapping(int index){
        String str[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        return str[index];
    }
}
