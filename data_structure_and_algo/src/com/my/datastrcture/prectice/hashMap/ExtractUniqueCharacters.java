package com.my.datastrcture.prectice.hashMap;

import java.util.HashMap;

public class ExtractUniqueCharacters {
    public static void main(String[] args) {
        System.out.println("ababacde unique character : "+uniqueChar("ababacde"));
        System.out.println("abcde unique character : "+uniqueChar("abcde"));
    }

    public static String uniqueChar(String str){
        if (str.length() == 0){
            return str;
        }
        HashMap<Character, Boolean> map = new HashMap<>();
        String ans ="";
        for (int i = 0; i < str.length(); i++){
            char ch = str.charAt(i);
            if (map.containsKey(ch)){
                continue;
            }
            map.put(ch, true);
            ans = ans + ch;
        }
        return ans;
    }
}
