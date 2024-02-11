package com.my.datastrcture.codingninja.sort;

public class MergeTwoSortedArrays {
    public static void main(String[] args) {
        int arr1[] = {1, 3, 4, 7, 11};
        int arr2[] = {2, 4, 6, 13};
        printArray(arr1);
        printArray(arr2);
        int ans[] = merge(arr1, arr2);
        printArray(ans);
    }

    public static int[] merge(int arr1[], int arr2[]) {
        int i = 0, j = 0, k = 0;
        int ans[] = new int[arr1.length+arr2.length];

        while (i < arr1.length && j < arr2.length){
            if (arr1[i] < arr2[j]){
                ans[k++] = arr1[i++];
                //i++;
                //k++;
            } else {
                ans[k++] = arr2[j++];
                //j++;
                //k++;
            }
        }

        while (i < arr1.length){
            ans[k++] = arr1[i++];
            //i++;
            //k++;
        }

        while (j < arr2.length){
            ans[k++] = arr2[j++];
            //j++;
            //k++;
        }

        return ans;
    }

    public static void printArray(int arr[]){
        for (int i : arr){
            System.out.print(i+" ");
        }
        System.out.println();
    }
}
