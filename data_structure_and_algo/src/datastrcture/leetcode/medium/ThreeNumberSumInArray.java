package datastrcture.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ThreeNumberSumInArray {
    public static void main(String[] args) {
        int arr[] = {10, 5, 5, 5, 2};
        int n = 5;
        int k = 12;

        ArrayList<ArrayList<Integer>> threeSum = findTriplets(arr, n, k);
        threeSum.stream().forEach(System.out::println);
    }

    public static ArrayList<ArrayList<Integer>> findTriplets(int[] arr, int n, int K) {

        /*Two Pointer Approach
        *  Arrays.sort(arr);

        Set<ArrayList<Integer>> s = new HashSet<>();

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            int j = i + 1, k = n - 1;

            while (j < k) {

                int sum = arr[i] + arr[j] + arr[k];

                if (sum == K) {

                    s.add(new ArrayList<>(Arrays.asList(arr[i], arr[j], arr[k])));

                    j++;

                    k--;

                } else if (sum > K) {

                    k--;

                } else {

                    j++;

                }

            }

        }

        res.addAll(s);

        return res;*/

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        Arrays.sort(arr);

        Set<ArrayList<Integer>> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    ArrayList<Integer> temp =new ArrayList<>();
                    if ((arr[k] + arr[j] + arr[i]) == K) {
                        temp.add(arr[k]);
                        temp.add(arr[j]);
                        temp.add(arr[i]);
                        set.add(temp);
                    }
                }

            }

        }
        if (!set.isEmpty()){
            result.addAll(set);
        } else {
            result.add(new ArrayList<>(Arrays.asList(-1)));
        }

        return result;

    }
}
