package datastrcture.codestudio;

import java.util.ArrayList;

/*Problem statement

Sample Input 1:
4 3
8 9 4 5


Sample output 1:
-1


Explanation of Sample Output 1:
For the test case, 3 is not present in the array. Hence the output will be -1.


Sample Input 2:
4 3
2 3 5 8


Sample output 2:
1


Expected Time Complexity:
Try to do this in O(log(n)).


Constraints:
1 <= n <= 10^5
0 <= k <= 10^9
0 <= arr[i] <= 10^9

Time Limit: 1 second*/
public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        //int arr[] = {11 3 4 5 6 7 8 9};
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(11);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(7);
        arr.add(8);
        arr.add(9);

        int n = arr.size();
        int k = 7;

        System.out.println("Index of "+k+" is : "+search(arr, n, k));
    }

    /*public static int getPivot(ArrayList<Integer> arr){
        int start = 0;
        int end = arr.size()-1;
        int mid = start + (end -start)/2;

        while (start < end){

            if (arr.get(mid) > arr.get(0)){
                start = mid + 1;

            } else {
                end = mid;
            }

            mid = start + (end -start)/2;
        }

        return start;
    }

    public static int binarySearch(ArrayList<Integer> arr, int s, int e , int key) {
        int start = s;
        int end = e;

        int mid = start +(end-start)/2;

        while (start <= end){
            //Comparing middile index value with key
            if (arr.get(mid) == key){
                return mid;
            }

            //If key value is greater than middle index value than go to right side in array
            if (key > arr.get(mid)){
                start = mid+1;
            }else { //If key value is less than middle index value than go to array lift side in array
                end = mid - 1;
            }
            //now start or end value has been changed than again we need to calculate middle value
            mid = start +(end-start)/2;
        }

        return -1;

    }*/

    public static int search(ArrayList<Integer> arr, int n, int k) {
        /*int pivot = getPivot(arr);

        if (k >= arr.get(pivot) && k <= arr.get(n-1)){
            //BS on second line
            return binarySearch(arr, pivot, n-1, k);
        } else {
            //BS on first line
            return binarySearch(arr, 0, pivot - 1, k);
        }*/

        int start = 0;
        int end = n - 1;
        int mid = start + (end - start) / 2;

        while (start <= end) {

            if (arr.get(mid) == k)
                return mid;

            else if (arr.get(mid) > arr.get(n - 1)) {

                if (k >= arr.get(start) && k < arr.get(mid))
                    end = mid - 1;
                else
                    start = mid + 1;

            } else {
                if (k > arr.get(mid) && k <= arr.get(end))
                    start = mid + 1;
                else
                    end = mid - 1;
            }

            mid = start + (end - start) / 2;
        }
        return -1;

    }
}
