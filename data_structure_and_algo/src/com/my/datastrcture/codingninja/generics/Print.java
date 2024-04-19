package com.my.datastrcture.codingninja.generics;

public class Print {

    public static<T> void printArray(T arr[]){
        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i] + " ");
        }
    }
    public static void main(String[] args) {
        Integer arr[] = {5, 6, 3, 8, 9, 4};
        printArray(arr);
        String str[] = {"abc", "def", "ghi", "xyz"};
        printArray(str);

        Vehicle vehicle[] = new Vehicle[5];
        for (int i = 0; i < vehicle.length; i++){
            vehicle[i] = new Vehicle(20*i, "Tata");
        }
        printArray(vehicle);
    }
}
