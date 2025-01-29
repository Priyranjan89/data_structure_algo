package com.my.datastrcture.interview;
/*
HackerRank
P
N
Closest Numbers
First Smaller Number Gap
Video Call
Nakarin Hansawattana
Priyaranjan Singh
Nakarin Hansawattana
Closest Numbers
Description
Given an array of distinct integers, determine the minimum absolute difference between any two elements. Print all element pairs with that difference in ascending order.



Example

numbers = [6,2,4,10]

The minimum absolute difference is 2 and the pairs with that difference are (2,4) and (4,6). When printing element pairs (i,j), they should be ordered ascending first by i and then by j.

2 4
4 6


Function Description

Complete the function closestNumbers in the editor.



closestNumbers has the following parameter(s):

    int numbers[n]:  an array of integers



Returns

    NONE

Prints

    distinct element pairs that share the minimum absolute difference, displayed in ascending order with each pair separated by one space on a single line



Constraints

2 ≤ n ≤ 105
-109 ≤ numbers[i] ≤ 109


Input Format for Custom Testing
Sample Case 0
Sample Input 0

STDIN      Function
-----      --------
4         →   numbers[] size n = 4
4         →   numbers = [4, 2, 1, 3]
2
1
3


Sample Output 0

1 2
2 3
3 4


Explanation 0

The minimum absolute difference between any two elements in the array is 1, and there are three such pairs with this difference: (1, 2), (2, 3), and (3, 4).



import java.io.*;
 **/
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ClosestNumbers {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        //4, 2, 1, 3
        numbers.add(4);
        numbers.add(2);
        numbers.add(1);
        numbers.add(3);
        closestNumbers(numbers);
    }

    public static void closestNumbers(List<Integer> numbers) {

        Collections.sort(numbers);

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.size() - 1; i++) {
            int temp = Math.abs(numbers.get(i + 1) - numbers.get(i));
            min = Math.min(temp, min);
        }

        for (int i = 0; i < numbers.size() - 1; i++) {
            int temp = Math.abs(numbers.get(i + 1) - numbers.get(i));
            if (temp == min){
                System.out.println(numbers.get(i) + " " + numbers.get(i + 1));
            }
        }
    }

}
