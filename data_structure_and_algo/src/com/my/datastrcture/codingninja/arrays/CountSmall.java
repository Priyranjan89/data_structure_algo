package com.my.datastrcture.codingninja.arrays;

public class CountSmall {
    public static void main(String[] args) {
        int a[] = {4, 5, 6, 7};
        int n = 4;
        printArray(a);
        int b[] = {6, 7};
        int m = 2;
        printArray(b);

        int ans[] = countS(n, m, a, b);
        printArray(ans);
    }

    public static int[] countS(int n, int m, int []a, int []b) {
        int ans[] = new int[n];

        for (int i= 0; i < n; i++){
            int count = 0;
            for (int j =0; j < m; j++){
                if (a[i] >= b[j]){
                    count++;
                }
            }
            ans[i] = count;
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
