package datastrcture.arrays.practice;

import java.util.Scanner;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[] = {5, 7, -2, 10, 22, -2, 0, 5, 1, 22};
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the element to search ");
        int key = sc.nextInt();
        // whether 1 is present or not
        boolean isPresent = search(arr, key);
        if (isPresent){
            System.out.println(key+" is presented in array");
        }else {
            System.out.println(key+" is not presented in array");
        }
    }

    public static boolean search(int arr[], int key){

        for (int i = 0; i < arr.length; i++){
            if (arr[i] == key){
                return true;
            }
        }

        return false;
    }
}
