package com.my.datastrcture.codingninja.hashmap;

public class CustomMapUse {
    public static void main(String[] args) {
        CustomMap<String, Integer> map = new CustomMap<>();
        for(int i=0;i<20;i++) {
            map.insert("abc" +i, i+1);
            System.out.println(map.loadFactor());
        }
        map.remove("abc3");
        map.remove("abc7");
        for(int i=0;i<20;i++) {
            System.out.println("abc"+ i+":" + map.getValue("abc" + i));
        }
    }
}
