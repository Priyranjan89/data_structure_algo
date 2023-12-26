package datastrcture.binary.search;

public class BinarySearchTest {
    public static void main(String[] args) {
        int even[] = {2,4,6,8,12,18};
        int odd[] = {3, 8, 11, 14, 16};

        int evenIndex = binarySearch(even, 6, 6);

        System.out.println(" Index of 6 is " + evenIndex);

        int oddIndex = binarySearch(odd, 5, 14);

        System.out.println(" Index of 14 is " + oddIndex);


    }

    public static int binarySearch(int arr[], int size, int key) {

        int start = 0;
        int end = size-1;
        int mid = start +(end-start)/2;

        while (start <= end){
            //Comparing middile index value with key
            if (arr[mid] == key){
                return mid;
            }

            //If key value is greater than middle index value than go to right side in array
            if (key > arr[mid]){
                start = mid+1;
            }else { //If key value is less than middle index value than go to array lift side in array
                end = mid -1;
            }
            //now start or end value has been changed than again we need to calculate middle value
            mid = start +(end-start)/2;
        }

        return -1;

    }
}
