package com.my.datastrcture.codingninja.timecomplexxity;

import java.util.Arrays;

public class PairSumInArray {

    public static void main(String[] args) {
        int arr[] = {1,3,6,2,5,4,3,2,4};
        int num = 7;
        System.out.println(pairSum(arr, num));


    }

    public static int pairSum(int[] arr, int num) {
        Arrays.sort(arr);
       int startIndex = 0;
       int endIndex = arr.length-1;
       int numPair = 0;

       while (startIndex < endIndex){
           if (arr[startIndex] + arr[endIndex] < num){
               startIndex++;
           } else if (arr[startIndex] + arr[endIndex] > num){
               endIndex--;
           } else {
               int eleAtStart = arr[startIndex];
               int eleAtEnd = arr[endIndex];

               if (eleAtStart == eleAtEnd){
                   int eleCount = (endIndex - startIndex + 1);
                   numPair += (eleCount * (eleCount - 1) / 2);
                   return numPair;

               }else {
                   int tempStartIndex = startIndex + 1;
                   int tempEndIndex = endIndex - 1;
                   while (tempStartIndex <= tempEndIndex && arr[tempStartIndex] == eleAtStart){
                       tempStartIndex++;
                   }
                   while (tempStartIndex <= tempEndIndex && arr[tempEndIndex] == eleAtEnd){
                       tempEndIndex--;
                   }
                   int totalEleFromStart = (tempStartIndex - startIndex);
                   int totalEleFromEnd = (endIndex-tempEndIndex);

                   numPair += totalEleFromStart * totalEleFromEnd;

                   startIndex = tempStartIndex;
                   endIndex = tempEndIndex;
               }

           }
       }

       return numPair;
    }
}
