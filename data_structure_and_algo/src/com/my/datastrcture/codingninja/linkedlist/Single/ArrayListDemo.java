package com.my.datastrcture.codingninja.linkedlist.Single;

import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args){
        ArrayList<Integer> arr= new ArrayList<>();
        arr.add(10);
        arr.add(20);
        arr.add(30);
        arr.add(1,80);
        System.out.println(arr.size());

        for(int i=0;i<arr.size();i++){
            System.out.println(arr.get(i));
        }
        arr.set(0,50);
        System.out.println(arr.size());
        for(int i:arr){
            System.out.println(i);
        }

    }
}
