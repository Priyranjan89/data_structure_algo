package com.my.datastrcture.codingninja.backtracking;

import java.util.ArrayList;

public class NinjaAndHisDessert {
    public static void main(String[] args) {
        int n = 2;
        int m = 3;
        int target = 10;
        ArrayList<Integer> baseCosts = new ArrayList<>();
        baseCosts.add(1);
        baseCosts.add(7);
        ArrayList<Integer> toppings = new ArrayList<>();
        toppings.add(1);
        toppings.add(2);
        toppings.add(3);
        int ans = closestCost(n, m, baseCosts, toppings, target);
        System.out.println(ans);
    }

    public static int closestCost(int n, int m, ArrayList<Integer> baseCosts, ArrayList<Integer> toppings, int target){
       int ans = Integer.MAX_VALUE;
       for (int currentBase : baseCosts){
           if (currentBase <= target) {
               ans = getAns(ans, currentBase + currBaseHelper(toppings, m-1, 0, target - currentBase), target);
           }
           ans = getAns(ans, currentBase, target);
       }

       return ans;
    }

    private static int currBaseHelper(ArrayList<Integer> toppings, int currToppingIndex, int numCurrTopping, int target) {
        if (currToppingIndex < 0){
            return 0;
        }
        int takeTop = 0, notTake = 0;
        if (numCurrTopping < 2){
            takeTop = toppings.get(currToppingIndex) +
                    currBaseHelper(toppings, currToppingIndex, numCurrTopping + 1, target - toppings.get(currToppingIndex));
        }
        notTake = currBaseHelper(toppings, currToppingIndex -1, 0, target);
        return getAns(takeTop, notTake, target);
    }

    private static int getAns(int currAns, int newAns, int target) {
        int diff1 = Math.abs(target - currAns);
        int diff2 = Math.abs(target - newAns);
        if (diff1 == diff2){
            return Math.min(currAns, newAns);
        }
        return diff1 < diff2 ? currAns : newAns;
    }
}
