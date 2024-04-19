package com.my.datastrcture.codingninja.recuersion3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniqueSubsets {
    /*public static void helper(int i, int[] arr, List<Integer> subset, List<List<Integer>> ans) {
        // when we have traversed the entire arr[], then we should put arr into ans[]
        if (i >= arr.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        // pick the ith element
        subset.add(arr[i]);

        // picked ith element and recursion will find the remaining subsets with ith element
        helper(i + 1, arr, subset, ans);

        // firstly, we need to backtrack and undo the changes that we have made
        subset.remove(subset.size() - 1);

        // ensure we don't pick any other occurrences of i-th element in order to generate Unique Subsets
        while (i + 1 < arr.length && arr[i] == arr[i + 1])
            i++;

        // currentIndex will now point to the Last Occurrence of ith Element
        // we ignored ith element and now recursion will do find the remaining subsets without the ith element
        // skip the ith element
        helper(i + 1, arr, subset, ans);
    }

    public static List<List<Integer>> uniqueSubsets(int[] arr) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();

        // to ensure our logic works, we need a sorted array
        Arrays.sort(arr);
        helper(0, arr, subset, ans);

        // this is specific to the given problem, they wanted each subset in sorted order
        ans.sort((list1, list2) -> {
            String str1 = list1.toString();
            String str2 = list2.toString();
            return str1.compareTo(str2);
        });
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        List<List<Integer>> result = uniqueSubsets(arr);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }*/

    public static void helper(int i, int[] arr, List<Integer> subset, ArrayList<ArrayList<Integer>> ans) {
        if (i >= arr.length) {
            ans.add(new ArrayList<>(subset));
            return;
        }

        subset.add(arr[i]);

        helper(i + 1, arr, subset, ans);
        subset.remove(subset.size() - 1);
        while (i + 1 < arr.length && arr[i] == arr[i + 1])
            i++;
        helper(i + 1, arr, subset, ans);
    }

    public static ArrayList<ArrayList<Integer>> uniqueSubsets(int n, int[] arr) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subset = new ArrayList<>();

        Arrays.sort(arr);
        helper(0, arr, subset, ans);

        ans.sort((list1, list2) -> {
            String str1 = list1.toString();
            String str2 = list2.toString();
            return str1.compareTo(str2);
        });
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 1, 2};
        ArrayList<ArrayList<Integer>> result = uniqueSubsets(arr.length, arr);
        for (List<Integer> subset : result) {
            System.out.println(subset);
        }
    }

}