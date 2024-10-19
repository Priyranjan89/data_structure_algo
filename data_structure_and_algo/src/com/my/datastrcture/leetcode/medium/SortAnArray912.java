package com.my.datastrcture.leetcode.medium;


public class SortAnArray912 {
    public static void main(String[] args) {
        int arr[] = {2, 13, 4, 1, 3, 6, 28};
        int ans[] = sortArray(arr);

        System.out.println();
        for (int i = 0; i < ans.length; i++){
            System.out.print(ans[i] +" ");
        }
        System.out.println();
    }

    public static int[] sortArray(int[] nums) {
        if (nums.length <= 1){
            return nums;
        }

        int a[] = new int[nums.length/2];
        int b[] = new int[nums.length-a.length];

        int j = 0;
        for (int i = 0; i < nums.length/2; i++){
            a[i] = nums[j++];
        }

        for (int i = 0; i < b.length; i++){
            b[i] = nums[j++];
        }
        int ansA[] = sortArray(a);
        int ansB[] = sortArray(b);
        return merge(ansA, ansB, nums);
    }

    private static int[] merge(int[] a, int[] b, int[] nums) {
        int i = 0, j = 0, k = 0;

        while (i < a.length && j < b.length){
            if (a[i] < b[j]){
                nums[k++] = a[i++];
            }else {
                nums[k++] = b[j++];
            }
        }
        while (i < a.length){
            nums[k++] = a[i++];
        }

        while (j < b.length){
            nums[k++] = b[j++];
        }

        return nums;
    }

}
