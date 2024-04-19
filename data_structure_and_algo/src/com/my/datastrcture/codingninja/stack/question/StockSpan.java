package com.my.datastrcture.codingninja.stack.question;


import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        //int[] price = {100, 80, 60, 70, 60, 75, 85};
        int[] price = {60, 70, 80, 100, 90, 75, 80, 120};

        int ans[] = stockSpan(price);
        for (int n : ans){
            System.out.print(n+" ");
        }
    }

    public static int[] stockSpan(int[] price) {

        int span[] = new int[price.length];
        if (price.length == 0){
            return span;
        }

        Stack<Integer> days = new Stack<>();
        days.push(0);
        span[0] = 1;

        for (int i = 1; i < price.length; i++){
            while (!days.isEmpty() && price[days.peek()] < price[i]){
                days.pop();
            }

            if (!days.isEmpty()){
                span[i] = i - days.peek();
            } else {
                span[i] = i+1;
            }
            days.push(i);
        }

        return span;
    }
}
