package com.my.datastrcture.codingninja.timecomplexxity;

public class PairStar {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(addStars(str));
    }

    public static String addStars(String s) {
        if (s.length() <= 1){
            return s;
        }

        String next = addStars(s.substring(1));
        if (s.charAt(0) == s.charAt(1)){
            return s.charAt(0) + "*" + next;
        } else {
            return s.charAt(0) + next;
        }
    }
}
