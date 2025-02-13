package com.my.datastrcture.prectice.leetcode.medium;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin973 {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.sqDist, a.sqDist));
        // Calculate squared distances for each point and add to maxHeap
        for (int[] point : points) {
            int x = point[0];
            int y = point[1];
            long sqDist = (long) x * x + (long) y * y;
            maxHeap.offer(new Pair(x, y, sqDist));

            // If heap size exceeds k, remove the farthest point
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        // Extract k closest points from maxHeap
        int[][] res = new int[k][2];
        int index = 0;
        while (!maxHeap.isEmpty()) {
            Pair pair = maxHeap.poll();
            res[index][0] = pair.x;
            res[index][1] = pair.y;
            index++;
        }

        return res;
    }

    public static void main(String[] args) {
        KClosestPointsToOrigin973 solution = new KClosestPointsToOrigin973();
        int[][] points = {{1, 3}, {-2, 2}, {5, 8}, {0, 1}};
        int k = 2;
        int[][] result = solution.kClosest(points, k);
        for (int[] point : result) {
            System.out.println(Arrays.toString(point));
        }
    }
    public int[][] kClosestBest(int[][] points, int k) {
        int left = 0, right = points.length - 1, pivot = points.length;
        while (pivot != k) {
            pivot = partition(points, left, right);
            if (pivot < k) {
                left = pivot;
                continue;
            }
            right = pivot;
        }
        return Arrays.copyOfRange(points, 0, k);
    }

    private int partition(int[][] points, int left, int right) {
        int pivot = left + (right - left) / 2;
        long pivotVal = getDist(points[pivot]);
        int[] temp;
        while (left < right) {
            if (getDist(points[left]) < pivotVal) {
                left++;
                continue;
            }
            temp = points[left];
            points[left] = points[right];
            points[right--] = temp;
        }
        if (getDist(points[left]) < pivotVal) {
            left++;
        }
        return left;
    }

    private long getDist(int[] point) {
        return point[0] * point[0] + point[1] * point[1];
    }
    class Pair {
        int x;
        int y;
        long sqDist;

        Pair(int x, int y, long sqDist) {
            this.x = x;
            this.y = y;
            this.sqDist = sqDist;
        }
    }
}
