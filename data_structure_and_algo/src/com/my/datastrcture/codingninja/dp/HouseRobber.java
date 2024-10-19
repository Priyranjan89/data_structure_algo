package com.my.datastrcture.codingninja.dp;

import java.util.ArrayList;

public class HouseRobber {
    public static void main(String[] args) {
        int arr[] = {1, 5, 1, 2, 6};
        System.out.println(houseRobber(arr));
    }
    public static long houseRobber(int[] valueInHouse) {
        int n = valueInHouse.length;

        if (valueInHouse.length == 1){
            return valueInHouse[0];
        }
        ArrayList<Integer> first = new ArrayList<>();
        ArrayList<Integer> second = new ArrayList<>();

        for (int i = 0; i < n; i++){
            if (i != n-1){
                first.add(valueInHouse[i]);
            }
            if (i != 0){
                second.add(valueInHouse[i]);
            }
        }
        return Math.max(helper(first), helper(second));
    }

    private static long helper(ArrayList<Integer> nums){
        int n = nums.size();

        long prev2 = 0;
        long prev1 = nums.get(0);
        for (int i = 1; i < n; i++){
            long inc = prev2 + nums.get(i);
            long excl = prev1 +0;;
            long ans = Math.max(inc, excl);
            prev2 = prev1;
            prev1 = ans;
        }
        return prev1;
    }
}
