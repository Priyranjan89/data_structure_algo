package datastrcture.binary.search;

public class FindPivotInAnArray {
    public static void main(String[] args) {
        int arr[] = {7, 9, 11, 13, 2, 4, 6};

        System.out.println("Pivot value in given array :"+getPivot(arr));
    }

    public static int getPivot(int arr[]){
        int start = 0;
        int end = arr.length-1;
        int mid = start + (end -start)/2;

        while (start < end){

            if (arr[mid] > arr[0]){
                start = mid + 1;

            } else {
                end = mid;
            }

            mid = start + (end -start)/2;
        }

        return start;
    }
}
