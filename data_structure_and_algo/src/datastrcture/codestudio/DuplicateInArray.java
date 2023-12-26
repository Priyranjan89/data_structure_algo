package datastrcture.codestudio;
/*
*
* Problem Statement


Sample Input 1:
2
5
4 2 1 3 1
7
6 3 1 5 4 3 2
Sample Output 1:
1
3
Explanation of sample input 1:
For the first test case,
The duplicate integer value present in the array is 1. Hence, the answer is 1 in this case.

For the second test case,
The duplicate integer value present in the array is 3. Hence, the answer is 3 in this case.
Sample Input 2:
2
6
5 1 2 3 4 2
9
8 7 2 5 4 7 1 3 6
Sample Output 2:
2
7
*/

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DuplicateInArray {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(3);
        arr.add(1);
        arr.add(5);
        arr.add(4);
        arr.add(3);
        arr.add(2);

        int duplicateValue = findDuplicate(arr);

        System.out.println("Duplicate value in Array: "+duplicateValue);
    }

    public static int findDuplicate(ArrayList<Integer> arr) {

        int ans = 0;

        Set<Integer> set = new HashSet<>();
        for(int i : arr){
            if (set.add(i) == false){
                ans = i;
            }
        }

       /* //XOR ing all array elements
        for(int i = 0; i<arr.size(); i++ ) {
            ans = ans^arr.get(i);
        }

        //XOR [1, n-1]
        for(int i = 1; i<arr.size();i++ ) {
            ans = ans^i;
        }*/

        return ans;
    }
}
