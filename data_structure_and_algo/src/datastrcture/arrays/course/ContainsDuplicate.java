package datastrcture.arrays.course;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {

   /* public static boolean containsDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }*/

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> sets = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (sets.add(nums[i]) == false){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 1};

        System.out.println(containsDuplicate(arr));
    }
}
