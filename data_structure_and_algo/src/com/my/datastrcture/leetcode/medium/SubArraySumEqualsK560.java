package com.my.datastrcture.leetcode.medium;

import java.util.HashMap;

public class SubArraySumEqualsK560 {
    public static void main(String[] args) {
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums, k));
    }

    public static int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> mpp = new HashMap<>();
        mpp.put(0, 1);
        int preSum = 0;
        int cnt = 0;

        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remove = preSum - k;
            cnt += mpp.getOrDefault(remove, 0);
            mpp.put(preSum, mpp.getOrDefault(preSum, 0) + 1);
        }

        return cnt;
    }

    private static final int NULL = Integer.MIN_VALUE, MIXER = 0x9E3779BA;

    public static int subarraySum1(final int[] nums, final int k) {
        final int mask = mask(nums.length);
        final int[] hashtable = new int[mask + 1];
        int res = 0, sum = 0, zeros = 1;
        for (final int n : nums) {
            sum += n;
            final int diff = sum - k;

            if (diff != 0) {
                int i = diff * MIXER & mask;
                while (true) {
                    final int key = hashtable[i];
                    if (key == 0) break;
                    if (key == diff) {
                        res += hashtable[i + 1];
                        break;
                    }
                    i = i + 2 & mask;
                }
            } else {
                res += zeros;
            }

            if (sum != 0) {
                int i = sum * MIXER & mask;
                while (true) {
                    final int key = hashtable[i];
                    if (key == 0) {
                        hashtable[i] = sum;
                        hashtable[i + 1] = 1;
                        break;
                    }
                    if (key == sum) {
                        hashtable[i + 1]++;
                        break;
                    }
                    i = i + 2 & mask;
                }
            } else {
                zeros++;
            }
        }
        return res;
    }

    private static int mask(int n) {
        n |= n >> 1;
        n |= n >> 2;
        n |= n >> 4;
        n |= n >> 8;
        return (n << 1) | 31;
    }


    /*public static int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSum = new HashMap<>();
        int ans=0,currPrefix=0;
        prefixSum.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            currPrefix+=nums[i];
            ans+=prefixSum.getOrDefault(currPrefix-k,0);
            prefixSum.put(currPrefix,prefixSum.getOrDefault(currPrefix,0)+1);
        }
        return ans;
    }

*/   /* public static int subarraySum(int[] nums, int k) {
        return subsetsSumKHelper(nums, k, 0).length;
    }

    private static int[][] subsetsSumKHelper(int input[], int k, int startIndex) {

        if (startIndex == input.length) {
            int arr[][];
            if (k == 0) {
                arr = new int[1][0];
            } else {
                arr = new int[0][0];
            }
            return arr;
        }

        int smallOutput1[][] = subsetsSumKHelper(input, k, startIndex + 1);
        int smallOutput2[][] = subsetsSumKHelper(input, k - input[startIndex], startIndex + 1);

        int output[][] = new int[smallOutput1.length + smallOutput2.length][];
        int index = 0;
        for (int i = 0; i < smallOutput1.length; i++) {
            output[index++] = smallOutput1[i];
        }

        for (int i = 0; i < smallOutput2.length; i++) {
            output[index] = new int[smallOutput2[i].length + 1];
            output[index][0] = input[startIndex];
            for (int j = 0; j < smallOutput2[i].length; j++) {
                output[index][j+1] = smallOutput2[i][j];
            }
            index++;
        }
        return output;
    }
*/
}
