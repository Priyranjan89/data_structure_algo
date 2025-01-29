package com.my.datastrcture.codingninja.recursion.hard;

import java.util.ArrayList;
/*generateCodes is a recursive method that builds decoded strings by exploring both single-digit and two-digit mappings.

Parameters
input: The remaining portion of the numeric string to be decoded.
currentCodes: The current decoded string built so far.
codes: The list to store all fully decoded strings.
Base Case
java
Copy code
if (input.length() == 0){
    codes.add(currentCodes);
    return;
}
If input is empty, it means we’ve decoded the entire string. So we add currentCodes to codes and return.
Recursive Steps
Single Digit Mapping

java
Copy code
int firstDigit = input.charAt(0) - '0';
if (firstDigit >= 1 && firstDigit <= 9){
    char firstChar = (char) ('a' + firstDigit - 1);
    generateCodes(input.substring(1), currentCodes + firstChar, codes);
}
We take the first character of input, convert it to an integer (firstDigit), and check if it’s between 1 and 9.
If so, it maps to a character firstChar using (char) ('a' + firstDigit - 1).
We then call generateCodes recursively with:
The remaining string (input.substring(1)).
currentCodes updated with firstChar.
Handling Leading Zeros

java
Copy code
if (firstDigit == 0){
    generateCodes(input.substring(1), currentCodes, codes);
}
If firstDigit is 0, we skip it by calling generateCodes on input.substring(1) without adding anything to currentCodes.
This part assumes that "0" in the input should be ignored (although the problem specifies the input does not contain 0, this can handle any unexpected cases).
Two Digit Mapping

java
Copy code
if (input.length() >= 2){
    int firstTwoDigit = Integer.parseInt(input.substring(0, 2));
    if (firstTwoDigit >= 10 && firstTwoDigit <= 26){
        char secondChar = (char) ('a' + firstTwoDigit - 1);
        generateCodes(input.substring(2), currentCodes + secondChar, codes);
    }
}
If there are at least two characters left in input, we take the first two characters, parse them as an integer (firstTwoDigit).
We check if firstTwoDigit is between 10 and 26.
If yes, it maps to a character secondChar.
We then call generateCodes recursively with:
The remaining string after the first two characters (input.substring(2)).
currentCodes updated with secondChar.
Example Walkthrough
Let’s use "1123" as an example:

Initial Call: generateCodes("1123", "", codes)

We start with an empty currentCodes and codes.
First Recursive Step:

Single-digit mapping of "1" to a → generateCodes("123", "a", codes)
Two-digit mapping of "11" to k → generateCodes("23", "k", codes)
Exploring Branches

For "a123":
Single-digit mapping of "1" to a → generateCodes("23", "aa", codes)
Two-digit mapping of "12" to l → generateCodes("3", "al", codes)
For "k23":
Single-digit mapping of "2" to b → generateCodes("3", "kb", codes)
Two-digit mapping of "23" to w → generateCodes("", "kw", codes)
Reaching Base Cases

As generateCodes progresses, it eventually reaches input.length() == 0 in each path, at which point currentCodes (like "aabc", "kbc", etc.) is added to codes.*/
public class ReturnAllCodesString {
    public static void main(String[] args) {
        String input = "1123";
        String ans[] = getCode(input);
        for (int i = 0; i < ans.length; i++) {
            System.out.println(ans[i]);
        }
    }

    public static String[] getCode(String input) {
       ArrayList<String> codes = new ArrayList<>();
       generateCodes(input, "", codes);
       return codes.toArray(new String[codes.size()]);
    }

    // Helper function to generate codes recursively
    private static void generateCodes(String input, String currentCodes, ArrayList<String> codes) {
        // Base Case: If input is empty, add the current code to the list
        if (input.length() == 0){
            codes.add(currentCodes);
            return;
        }
        // Take the first digit and map it to a character
        int firstDigit = input.charAt(0) - '0';
        if (firstDigit >= 1 && firstDigit <= 9){
            char firstChar = (char) ('a' + firstDigit - 1);
            generateCodes(input.substring(1), currentCodes + firstChar, codes);
        }
        if (firstDigit == 0){
            generateCodes(input.substring(1), currentCodes, codes);
        }

        // If possible, take the first two digits and map them to a character
        if (input.length() >= 2){
            int firstTwoDigit = Integer.parseInt(input.substring(0, 2));
            if (firstTwoDigit >= 10 && firstTwoDigit <= 26){
                char secondChar = (char) ('a' + firstTwoDigit - 1);
                generateCodes(input.substring(2), currentCodes + secondChar, codes);
            }
        }
    }



    /*public static String[] getCode(String input) {

        if (input.length() == 0) {
            String ans[] = {""};
            return ans;
        }
        String smallAns[] = getCode(input.substring(1));

        int an = input.charAt(0) - '0';
        char firstChar = (char) ('a' + an - 1);

        for (int i = 0; i < smallAns.length; i++) {
            smallAns[i] = firstChar + smallAns[i];
        }

        String smallans1[] = new String[0];
        if (input.length() >= 2) {
            int ch1 = input.charAt(0) - '0';
            int ch2 = input.charAt(1) - '0';
            int an3 = (ch1 * 10) + ch2;

            if (an3 >= 10 && an3 <= 26) {
                char firsttwochar = (char) ('a' + an3 - 1);
                smallans1 = getCode(input.substring(2));
                for (int i = 0; i < smallans1.length; i++) {
                    smallans1[i] = firsttwochar + smallans1[i];
                }
            }
        }
        String output[] = new String[smallAns.length + smallans1.length];
        int k = 0;
        for (int i = 0; i < smallAns.length; i++) {
            output[k] = smallAns[i];
            k++;
        }
        for (int i = 0; i < smallans1.length; i++) {
            output[k] = smallans1[i];
            k++;
        }
        return output;
    }*/
}
