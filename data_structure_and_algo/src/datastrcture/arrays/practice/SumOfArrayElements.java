package datastrcture.arrays.practice;

import java.util.Scanner;

public class SumOfArrayElements {
    public static void main(String[] args) {
        int arr[] = new int[6];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of Array");
        for (int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.print("Value of Array : ");
        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i]+" ");
        }

        int sum = sumOfArray(arr);
        System.out.println("\nSum of array element: "+sum);
    }

    public static int sumOfArray(int arr[]){
        int sum = 0;
        for (int i = 0; i < arr.length; i++){
            sum = sum + arr[i];
        }
        return sum;
    }
}
