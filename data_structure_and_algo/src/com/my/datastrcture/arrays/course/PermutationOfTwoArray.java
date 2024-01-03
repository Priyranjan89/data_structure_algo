package com.my.datastrcture.arrays.course;

public class PermutationOfTwoArray {

    public static boolean permutation(int[] array1, int[] array2){

        if (array1.length != array2.length){
            return false;
        }
        int sum1 = 0;
        int sum2 = 0;
        int mul1 = 1;
        int mul2 = 1;
        for (int i =0; i < array1.length; i++){
            sum1 += array1[i];
            sum2 += array2[i];
            mul1 *= array1[i];
            mul2 *= array2[i];
        }

        if (sum1 == sum2 && mul1 == mul2){
            return true;
        } else {
            return false;
        }

        /*for (int i =0; i < array1.length; i++){
            for (int j = 0; j<array2.length; j++){
                if (array1[i] == array2[j]){
                    break;
                } else {
                    if (j == array2.length-1){
                        return false;
                    }
                }
            }
        }*/
    }

    public static void main(String[] args) {
        int arrray1[] = {2,1,3,5,4,6};
        int arrray2[] = {1,3,2,4,6,5};
        System.out.println(permutation(arrray1, arrray2));
    }
}
