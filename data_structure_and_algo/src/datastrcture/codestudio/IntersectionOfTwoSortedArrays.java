package datastrcture.codestudio;

/*Intersection Of Two Sorted Arrays
* Problem Statement


Sample Input 1 :
2
6 4
1 2 2 2 3 4
2 2 3 3
3 2
1 2 3
3 4
Sample Output 1 :
2 2 3
3
Explanation for Sample Input 1 :
For the first test case, the common elements are 2 2 3 in both the arrays, so we print it.

For the second test case, only 3 is common so we print 3.
Sample Input 2 :
2
3 3
1 4 5
3 4 5
1 1
3
6
Sample Output 2 :
4 5
-1

* */

import java.util.ArrayList;

public class IntersectionOfTwoSortedArrays {
    public static void main(String[] args) {
        ArrayList<Integer> arr1 = new ArrayList<>();
        arr1.add(1);
        arr1.add(2);
        arr1.add(2);
        arr1.add(2);
        arr1.add(3);
        arr1.add(4);
        ArrayList<Integer> arr2 = new ArrayList<>();
        arr2.add(2);
        arr2.add(2);
        arr2.add(3);
        arr2.add(3);

        ArrayList<Integer> ans = findArrayIntersection(arr1, arr1.size(), arr2, arr2.size());
        ans.forEach(System.out::println);
    }

    public static ArrayList<Integer> findArrayIntersection(ArrayList<Integer> arr1, int n, ArrayList<Integer> arr2, int m)
    {
       // ArrayList<Integer> ans = new ArrayList<>();

        /*for (int i = 0; i < n; i++){
            int element = arr1.get(i);
            for (int j = 0; j < m; j++){
                if (element < arr2.get(j))
                    break;
                if (element == arr2.get(j)){
                    ans.add(arr2.get(j));
                    arr2.set(j, -1);
                    break;
                }
            }
        }*/

        ArrayList<Integer> ans = new ArrayList<>();

        int i = 0;
        int j = 0;

        while (i < n && j < m){

            if (arr1.get(i) == arr2.get(j)){
                ans.add(arr1.get(i));
                i++;
                j++;
            } else if (arr1.get(i) < arr2.get(j)) {
                i++;
            } else {
                j++;
            }
        }

        return ans;
    }
}
