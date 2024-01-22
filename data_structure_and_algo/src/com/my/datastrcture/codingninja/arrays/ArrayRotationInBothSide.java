package com.my.datastrcture.codingninja.arrays;

public class ArrayRotationInBothSide {
    public static void main(String[] args) {
        int a[] = {20, 6, 9, 68, 61};
        int len = a.length;
        printArray(a);

       /* System.out.println("Right shift (clock wise direction) rotation in Array");
        int right1[] = rightRotation(a, 1, len);
        printArray(right1);

        int right2[] = rightRotation(a, 2, len);
        printArray(right2);*/

        System.out.println("Left shift (Anti-clock wise direction) rotation in Array");
        int left1[] = leftRotation(a, 6, len);
        printArray(left1);

      /*  int left2[] = leftRotation(a, 2, len);
        printArray(left2);
*/

    }
    public static int[] rotateArray(int []a, int x, String dir){
        int len = a.length;
        if (x > len){
            x = x%len;
        }
        int b[] = new int[a.length];
        if (dir.equals("RIGHT")){
            for (int i = 0; i < len; i++){
                int position = (i + x) % len;
                b[position] = a[i];
            }
        } else if (dir.equals("LEFT")){
            for (int i = 0; i < len; i++){
                int position = (i - x + len) % len;
                b[position] = a[i];
            }
        }

        return b;
    }

    public static int[] rightRotation(int a[], int rotation, int len){
        int b[] = new int[len];
        for (int i = 0; i < len; i++){
            int position = (i + rotation) % len;
            b[position] = a[i];
        }
        return b;
    }

    public static int[] leftRotation(int a[], int rotation, int len){
        int b[] = new int[len];
        for (int i = 0; i < len; i++){
            int position = (i - rotation + len) % len;
            b[position] = a[i];
        }
        return b;
    }

    public static void printArray(int[] arr) {
        System.out.print("Printing the Array element : ");
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
