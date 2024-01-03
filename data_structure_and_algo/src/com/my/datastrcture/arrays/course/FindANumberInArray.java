package com.my.datastrcture.arrays.course;

public class FindANumberInArray {
    public static int searchInArray(int[] intArray, int valueToSearch){

        for (int i = 0; i<intArray.length; i++){
            if (intArray[i] == valueToSearch){
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6};
        int valueToSearch = 6;
        System.out.println(searchInArray(arr, valueToSearch));
    }
}
