package com.my.datastrcture.codingninja.arrays;

import java.util.Scanner;

public class InsertionIntuitionOfArray {

    public static int takeInput(String str){
        Scanner sc = new Scanner(System.in);

        System.out.print(str);
        return sc.nextInt();
    }

    public static String takeUserInput(String str){
        Scanner sc = new Scanner(System.in);

        System.out.print(str);
        return sc.next();
    }

    public static void main(String[] args) {

        int capacity = takeInput("Please enter the capacity of Array : ");
        int arr[] = new int[capacity];

        int size = takeInput("Please enter the size of Array : ");

        for (int i = 0; i < size; i++){
            arr[i] = takeInput("Enter the element at "+i+" index in Array : ");
        }
        printArray(arr);

        String isInsert = "n";
        String isDelete = "n";

        do {
            int position = takeInput("Please enter the position for array where you want to insert the value : ");
            int element = takeInput("Please enter the element to insert in Array : ");

            size = insertionIntuition(arr, element, position, size);
            printArray(arr);
            isInsert = takeUserInput("Do you want continue insert the value than please enter Y Or N : ");
            System.out.println();

        }while (isInsert.toLowerCase().equals("y"));

        do {
            isDelete = takeUserInput("Do you want continue insert the value than please enter Y Or N : ");
            if (isDelete.toLowerCase().equals("y") ){
                int position = takeInput("Please enter the position for array where you want to delete the value : ");

                size = deletionIntuition(arr, position, size);
                printArray(arr);
                System.out.println();
            }

        }while (isDelete.toLowerCase().equals("y"));

    }

    public static int insertionIntuition(int arr[], int valueToInsert, int position, int size){
        for (int i = size; i > position; i--){
            arr[i] = arr[i-1];
        }
        arr[position] = valueToInsert;
        size++;

        return size;
    }

    public static int deletionIntuition(int arr[], int position, int size){
        for (int i = position; i < size; i++){
            arr[i] = arr[i+1];
            if (i == size-1){
                arr[i] = 0;
            }
        }
        size--;

        return size;
    }
    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }

}
