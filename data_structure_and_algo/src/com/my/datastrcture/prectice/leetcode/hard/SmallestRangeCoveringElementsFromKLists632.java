package com.my.datastrcture.prectice.leetcode.hard;

import java.util.*;

class Info {
    int data;
    int rIndex;
    int cIndex;

    Info(int data, int rIndex, int cIndex) {
        this.data = data;
        this.rIndex = rIndex;
        this.cIndex = cIndex;
    }
}

class Compare implements Comparator<Info> {
    @Override
    public int compare(Info a, Info b) {
        return Integer.compare(a.data, b.data);
    }
}

public class SmallestRangeCoveringElementsFromKLists632 {

    public int[] smallestRange(List<List<Integer>> nums) {
        PriorityQueue<Info> pq = new PriorityQueue<>(new Compare());

        int maxi = Integer.MIN_VALUE;
        int mini = Integer.MAX_VALUE;

        int totalRows = nums.size();

        for (int row = 0; row < totalRows; row++) {
            int element = nums.get(row).get(0);
            pq.add(new Info(element, row, 0));
            maxi = Math.max(maxi, element);
            mini = Math.min(mini, element);
        }

        int ansStart = mini;
        int ansEnd = maxi;

        while (!pq.isEmpty()) {
            Info front = pq.poll();

            mini = front.data;

            if ((maxi - mini) < (ansEnd - ansStart)) {
                ansStart = mini;
                ansEnd = maxi;
            }

            int frontRIndex = front.rIndex;
            int frontCIndex = front.cIndex;
            int currTotalColumns = nums.get(frontRIndex).size();

            if (frontCIndex + 1 < currTotalColumns) {
                int element = nums.get(frontRIndex).get(frontCIndex + 1);
                pq.add(new Info(element, frontRIndex, frontCIndex + 1));
                maxi = Math.max(maxi, element);
            } else {
                break;
            }
        }

        int ans[] = new int[2];
        ans[0] = ansStart;
        ans[1] = ansEnd;

        return ans;
    }

    public static void main(String[] args) {
        SmallestRangeCoveringElementsFromKLists632 solution = new SmallestRangeCoveringElementsFromKLists632();
        List<List<Integer>> nums = new ArrayList<>();
        nums.add(Arrays.asList(4, 10, 15, 24, 26));
        nums.add(Arrays.asList(0, 9, 12, 20));
        nums.add(Arrays.asList(5, 18, 22, 30));

        int[] result = solution.smallestRange(nums);
        System.out.println("Smallest Range: " + result[0]+" "+result[1]);
    }
}
