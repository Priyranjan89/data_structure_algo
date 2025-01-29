package com.my.datastrcture.prectice.leetcode.easy;

public class HappyNumber {
    public static void main(String[] args) {
        int num = 19;
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(num));
    }
    public boolean isHappy(int n) {
        int slow = n;
        int fast = n;

        do {
            slow = findSquareWithSum(slow);
            fast = findSquareWithSum(findSquareWithSum(fast));
        } while (slow != fast);

        if (slow == 1){
            return true;
        }

        return false;
    }

    private int findSquareWithSum(int num){
        int sum = 0;

        while (num > 0){
            int rem = num % 10;
            sum += rem * rem;
            num = num / 10;
        }
        return sum;
    }
}
