package com.my.datastrcture.prectice.leetcode.easy;

import com.my.datastrcture.kk.trees.BST;
import com.my.datastrcture.prectice.leetcode.TreeNode;

import static com.my.datastrcture.prectice.leetcode.TreeCreation.printTreeLevelWise;

public class ConvertSortedArrayToBST108 {
    public static void main(String[] args) {
        ConvertSortedArrayToBST108 bt = new ConvertSortedArrayToBST108();

        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};

        TreeNode result = bt.sortedArrayToBST(arr);
        printTreeLevelWise(result);

    }

    TreeNode root = null;
    public TreeNode sortedArrayToBST(int[] nums) {
        populatedSorted(nums, 0, nums.length);
        return root;
    }

    private void populatedSorted(int[] nums, int start, int end) {
        if (start >= end) {
            return;
        }

        int mid = (start + end) / 2;

        this.insert(nums[mid]);
        populatedSorted(nums, start, mid);
        populatedSorted(nums, mid + 1, end);
    }
    private void insert(int value) {
        root = insert(value, root);
    }

    private TreeNode insert(int val, TreeNode node) {
        if (node == null) {
            node = new TreeNode(val);
            return node;
        }

        if (val < node.val) {
            node.left = insert(val, node.left);
        }

        if (val > node.val) {
            node.right = insert(val, node.right);
        }

        return node;
    }
}
