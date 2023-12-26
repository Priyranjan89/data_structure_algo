package datastrcture.codestudio;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairSum {
    public static void main(String[] args) {
        int nums[] = {1, 2, 3, 4, 5};
        int target = 5;

        List<int[]> result = pairSum(nums, target);

        for (int i = 0; i < result.size(); i++) {
            System.out.print("[ ");
            for (int j = 0; j < result.get(i).length; j++){
                System.out.print(result.get(i)[j] + " ");
            }
            System.out.print("]");
            System.out.println();
        }

    }

    public static List<int[]> pairSum(int[] arr, int s) {
        List<int[]> result = new ArrayList<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j =i+1; j<arr.length;j++ ){
                int tamp[] = new int[2];
                if((arr[i]+arr[j]) == s){
                    tamp[0] = arr[i];
                    tamp[1] = arr[j];
                    result.add(tamp);
                }
            }
        }
        return result;
    }
}
