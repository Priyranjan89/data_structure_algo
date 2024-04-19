package com.my.datastrcture.codingninja.recursion;

public class DoesStringSContainStringT {
    public static void main(String[] args) {
        String s = "abchjsgsuohhdhyrikkknddg";
        String t = "coding";
        System.out.println(checkSequence(s, t));
    }

    public static boolean checkSequence(String a, String b) {
        if (b.length() == 0 ){
            return true;
        }

        if (a.length() == 0){
            return false;
        }

        if (a.charAt(0) == b.charAt(0)){
            a = a.substring(1);
            b = b.substring(1);
        } else {
            a = a.substring(1);
        }

        boolean ans = checkSequence(a,b);

        return ans;
    }
}
