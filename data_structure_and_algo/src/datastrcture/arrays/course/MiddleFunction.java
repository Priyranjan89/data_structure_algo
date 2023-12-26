package datastrcture.arrays.course;

import java.util.Arrays;

public class MiddleFunction {

    static int[] middle(int[] arr) {
        return Arrays.copyOfRange(arr, 1, arr.length-1);
    }

    public static void main(String[] args) {
        int arr[] = {2,3,4,5,6,7};
        int res[] = middle(arr);

        System.out.print("[");
        for (int i = 0; i<res.length; i++){
            System.out.print(res[i]+" ");
        }
        System.out.print("]");
    }
}
