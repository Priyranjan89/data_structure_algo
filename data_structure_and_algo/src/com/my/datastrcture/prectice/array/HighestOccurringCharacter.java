package com.my.datastrcture.prectice.array;

import java.util.HashMap;
import java.util.Map;

public class HighestOccurringCharacter {
    public static void main(String[] args) {
        String str = "abcdeapapqarr";
        System.out.println(highestOccurringChar(str));
    }
    public static char highestOccurringChar(String str) {
        char ansCh = '\0';
        int max= 0;

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++){
            if (map.containsKey(str.charAt(i))){
                map.put(str.charAt(i), map.get(str.charAt(i))+1);
                max = Math.max(max, map.get(str.charAt(i)));
            } else {
                map.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < str.length(); i++){
            if (map.get(str.charAt(i)) == max){
                ansCh = str.charAt(i);
                break;
            }
        }

        return ansCh;
    }
}
