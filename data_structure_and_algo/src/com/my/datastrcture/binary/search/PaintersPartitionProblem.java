package com.my.datastrcture.binary.search;
/**/

import java.util.ArrayList;

public class PaintersPartitionProblem {
    public static void main(String[] args) {
        ArrayList<Integer> boards = new ArrayList<>();
        //10, 20, 30, 40
        //2, 1, 5, 6, 2, 3
        /*boards.add(10);
        boards.add(20);
        boards.add(30);
        boards.add(40);*/
        boards.add(2);
        boards.add(1);
        boards.add(5);
        boards.add(6);
        boards.add(2);
        boards.add(3);

        int k = 2;

        System.out.println("Minimun time to print the one area: "+findLargestMinDistance(boards, k));
    }

    public static int findLargestMinDistance(ArrayList<Integer> boards, int k)
    {
        int start = 0;
        int sum = 0;

        for (int i = 0; i < boards.size(); i++){
            sum += boards.get(i);
        }

        int end = sum;
        int mid = start + (end - start)/2;
        int ans = -1;

        while (start <= end){
            if (isPossible(boards, boards.size(), k, mid)){
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }

            mid = start + (end - start)/2;
        }

        return ans;
    }

    public static boolean isPossible(ArrayList<Integer> boards, int n, int k, int mid){
        int printerCount = 1;
        int boardSum = 0;

        for (int i = 0; i < n; i++){
            if (boardSum + boards.get(i) <= mid){
                boardSum += boards.get(i);
            } else {
                printerCount++;
                if (printerCount > k || boards.get(i) > mid){
                    return false;
                }
                boardSum = boards.get(i);
            }
        }
        return true;
    }
}
