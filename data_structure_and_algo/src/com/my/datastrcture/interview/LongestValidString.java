package com.my.datastrcture.interview;
/*There are two-letter strings, "AA", "AB" and "BB", which appear AA, AB and BB times respectively. The task is to join some of these strings to create the longest possible string which does not contain "AAA" or "BBB". For example, having AA = 5, AB = 0 and BB = 2, it is possible to join five strings by taking both of the "BB" strings and three of the "AA" strings. Then they can be joined into "AA-BB-AA-BB-AA" "AABBAABBAA".  class Solution { public String solution(int AA, int AB, int BB);
that, given three integers AA, AB and BB, returns the longest string that can be created according to the rules described above. If there is more than one possible answer, the function may return any of them.
Examples: 1. Given AA = 5, AB = 0 and BB = 2, the function should return "AABBAABBAA", as explained above. 2. Given AA = 1, AB = 2 and BB = 1, possible results are "BBABABAA", "ABAABBAB", "ABABAABB" or "AABBABAB". 3. Given AA = 0, AB = 2 and BB = 0, the function should return "ABAB".
4. Given AA = 0, AB = 0 and BB = 10, the function should return "BB".
Assume that:
• AA, AB and BB are integers within the range [0..13 • the resulting string will not be empty.
In your solution, focus on correctness.*/
public class LongestValidString {
    public static void main(String[] args) {

        // Test cases
        System.out.println(solution(5, 0, 2)); // Expected: "AABBAABBAA"
        System.out.println(solution(1, 2, 1)); // Expected: "BBABABAA" or other valid outputs
        System.out.println(solution(0, 2, 0)); // Expected: "ABAB"
        System.out.println(solution(0, 0, 10)); // Expected: "BB"
        System.out.println(solution(3, 3, 3)); // Expected: Various valid outputs like "AABBABABAB"

        // Edge Cases
        System.out.println(solution(13, 13, 13)); // Large input case
        System.out.println(solution(1, 1, 1)); // Smallest valid case
    }

    public static String solution(int AA, int AB, int BB) {
        StringBuilder result = new StringBuilder();

        while (AA > 0 || BB > 0 || AB > 0) {
            if (AA > 0 && (result.length() < 2 || !(result.substring(result.length() - 2).equals("AA")))) {
                result.append("AA");
                AA--;
            } else if (BB > 0 && (result.length() < 2 || !(result.substring(result.length() - 2).equals("BB")))) {
                result.append("BB");
                BB--;
            } else if (AB > 0) {
                result.append("AB");
                AB--;
            } else {
                break;
            }
        }

        return result.toString();
    }

}
