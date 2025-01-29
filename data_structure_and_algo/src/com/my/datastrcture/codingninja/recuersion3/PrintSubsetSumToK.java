package com.my.datastrcture.codingninja.recuersion3;
/*Let’s examine each part of this method.

Base Case (Stopping Condition)
java
Copy code
if (startIndex == input.length) {
    if (k == 0) {
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }
    return;
}
When startIndex reaches the end of input[]:
If k is 0, it means the elements in output[] sum up to the original target k.
We print the subset in output[].
If k is not 0, we just return without printing because the subset doesn’t sum to k.
Recursive Case (Building Subsets)
The core of the recursive logic consists of two recursive calls that simulate:

Excluding the current element from the subset.
Including the current element in the subset.
To do this:

Create a New Array newOutput[] to Include Current Element:

We create newOutput[] with a length of output.length + 1 to include the current element.
We copy all elements from output[] into newOutput[].
Set the last position of newOutput[] to input[startIndex], so it now includes the current element.
Recursive Calls:

java
Copy code
printSubsetsSumTokHelper(input, k, output, startIndex + 1);
printSubsetsSumTokHelper(input, k - input[startIndex], newOutput, startIndex + 1);

First Call (Excludes input[startIndex]):
We call printSubsetsSumTokHelper with the same output[] and the same k.
This effectively skips input[startIndex], meaning it’s not included in the subset.
Second Call (Includes input[startIndex]):
We call printSubsetsSumTokHelper with newOutput[], which now includes input[startIndex].
We reduce k by input[startIndex] since we included this element, updating the remaining sum we need to reach.
Example Walkthrough
Let’s go through an example with the input {5, 12, 3, 17, 1, 18, 15, 3, 17} and k = 6:

First Call (startIndex = 0, k = 6):

input[0] = 5
Two recursive branches are created:
Exclude 5: printSubsetsSumTokHelper(input, 6, output, 1)
Include 5: printSubsetsSumTokHelper(input, 6 - 5 = 1, newOutput = [5], 1)
Continue Down the Tree:

This recursive process continues, exploring every combination of including and excluding each element.
When a subset adds up to k = 6, the base case k == 0 triggers, and the subset is printed.
Paths that Succeed
For instance:

Path [3, 3]:
Include 3 at index 2 → new k = 3
Include 3 at index 7 → new k = 0 (prints [3, 3])
Path [5, 1]:
Include 5 at index 0 → new k = 1
Include 1 at index 4 → new k = 0 (prints [5, 1])*/
public class PrintSubsetSumToK {
    public static void main(String[] args) {
        int input[] = {5,12,3,17,1,18,15,3,17};
        int k = 6;
        printSubsetsSumTok(input, k);
    }

    public static void printSubsetsSumTok(int input[], int k) {
        printSubsetsSumTokHelper(input, k, new int[0],0);
    }

    public static void printSubsetsSumTokHelper(int input[], int k, int output[], int startIndex) {
        if (startIndex == input.length){
            if (k == 0){
                for (int i = 0; i < output.length; i++){
                    System.out.print(output[i]+" ");
                }
                System.out.println();
                return;
            } else
                return;
        }
        int newOutput[] = new int[output.length+1];
        int i;
        for (i = 0; i<output.length; i++){
            newOutput[i] = output[i];
        }
        newOutput[i] = input[startIndex];
        printSubsetsSumTokHelper(input, k , output, startIndex+1);
        printSubsetsSumTokHelper(input, k - input[startIndex], newOutput, startIndex+1);

    }
}
