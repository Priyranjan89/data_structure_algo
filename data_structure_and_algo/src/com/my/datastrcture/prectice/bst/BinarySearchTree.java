package com.my.datastrcture.prectice.bst;

import com.my.datastrcture.codingninja.Test2.LinkedListNode;
import com.my.datastrcture.prectice.binarytree.BinaryTreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
    public boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null) {
            return false;
        }

        if (root.data == k) {
            return true;

        } else if (k < root.data) {
            return searchInBST(root.left, k);
        } else {
            return searchInBST(root.right, k);
        }
    }

    public void elementsInRangeK1K2(BinaryTreeNode<Integer> root, int k1, int k2) {
        if (root == null) {
            return;
        }

        if (root.data >= k1 && root.data <= k2) {
            elementsInRangeK1K2(root.left, k1, k2);
            System.out.print(root.data + " ");
            elementsInRangeK1K2(root.right, k1, k2);
        } else if (root.data < k1) {
            elementsInRangeK1K2(root.right, k1, k2);
        } else if (root.data > k2) {
            elementsInRangeK1K2(root.left, k1, k2);
        }
    }

    public BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        return sortedArrayToBSTHelper(arr, 0, n - 1);
    }

    private BinaryTreeNode<Integer> sortedArrayToBSTHelper(int[] arr, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        int rootData = arr[mid];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        root.left = sortedArrayToBSTHelper(arr, start, mid - 1);
        root.right = sortedArrayToBSTHelper(arr, mid + 1, end);

        return root;
    }

    public boolean isBST(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return true;
        }
        int leftMax = maximum(root.left);
        int rightMin = minimum(root.right);

        if (leftMax >= root.data) {
            return false;
        }
        if (rightMin < root.data) {
            return false;
        }
        boolean isLeft = isBST(root.left);
        boolean isRight = isBST(root.right);

        return isLeft && isRight;
    }

    private int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);

        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    private int maximum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = maximum(root.left);
        int rightMax = maximum(root.right);

        return Math.max(root.data, Math.max(leftMax, rightMax));
    }

    public boolean isBSTBetter(BinaryTreeNode<Integer> root) {
        BSTResponse bstResponse = isBSTBetterHelper(root);
        return bstResponse.isBST;
    }

    private BSTResponse isBSTBetterHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new BSTResponse(true, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        BSTResponse leftResponse = isBSTBetterHelper(root.left);
        BSTResponse rightResponse = isBSTBetterHelper(root.right);

        int min = Math.min(root.data, Math.min(leftResponse.min, rightResponse.min));
        int max = Math.max(root.data, Math.max(leftResponse.max, rightResponse.max));

        boolean isBST = true;
        if (leftResponse.max >= root.data || rightResponse.min < root.data) {
            isBST = false;
        }
        if (!leftResponse.isBST || !rightResponse.isBST) {
            isBST = false;
        }
        return new BSTResponse(isBST, min, max);
    }

    public LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        LinkedListNode<Integer> head = new LinkedListNode<>(root.data);
        helper(root, head);
        return head.next;
    }

    private LinkedListNode<Integer> helper(BinaryTreeNode<Integer> root, LinkedListNode<Integer> currLLNode) {
        if (root == null) {
            return currLLNode;
        }
        if (root.left != null) {
            currLLNode = helper(root.left, currLLNode);
        }
        currLLNode = add(root, currLLNode);
        if (root.right != null) {
            currLLNode = helper(root.right, currLLNode);
        }
        return currLLNode;
    }

    private LinkedListNode<Integer> add(BinaryTreeNode<Integer> root, LinkedListNode<Integer> currLLNode) {
        LinkedListNode<Integer> newNode = new LinkedListNode<>(root.data);
        currLLNode.next = newNode;
        currLLNode = newNode;
        return currLLNode;
    }

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        replace(root, 0);
    }

    public static int replace(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) {
            return sum;
        }
        sum = replace(root.right, sum);
        sum = sum + root.data;
        root.data = sum;
        sum = replace(root.left, sum);

        return sum;
    }

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data) {
        if (root == null) {
            return null;
        }
        if (root.data == data) {
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = getPath(root.left, data);
        if (leftOutput != null) {
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = getPath(root.right, data);
        if (rightOutput != null) {
            rightOutput.add(root.data);
            return rightOutput;
        }

        return null;
    }

    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }

        ArrayList<LinkedListNode<Integer>> arr = new ArrayList<>();
        LinkedListNode<Integer> head = null, tail = null;
        Queue<BinaryTreeNode<Integer>> nodeToPrint = new LinkedList<>();
        nodeToPrint.add(root);
        nodeToPrint.add(null);

        while (!nodeToPrint.isEmpty()){
            BinaryTreeNode<Integer> front = nodeToPrint.poll();
            if (front == null){
                if (nodeToPrint.isEmpty()){
                    break;
                } else {
                    nodeToPrint.add(null);
                    tail = null;
                    head = null;
                }
            } else {
                LinkedListNode<Integer> newNode = new LinkedListNode<>(front.data);
                if (head == null){
                    head = newNode;
                    tail = newNode;
                    arr.add(head);
                } else {
                    tail.next = newNode;
                    tail = newNode;
                }
                if (front.left != null){
                    nodeToPrint.add(front.left);
                }
                if (front.right != null){
                    nodeToPrint.add(front.right);
                }
            }
        }

        return arr;
    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {
        LargestBSTResponse largestBSTResponse = largestBSTHelper(root);
        return largestBSTResponse.height;
    }

    public static LargestBSTResponse largestBSTHelper(BinaryTreeNode<Integer> root) {

        if (root == null){
            return new LargestBSTResponse(Integer.MAX_VALUE, Integer.MIN_VALUE, true, 0);
        }

        LargestBSTResponse leftResponse = largestBSTHelper(root.left);
        LargestBSTResponse rightResponse = largestBSTHelper(root.right);

        int min = Math.min(root.data, Math.min(leftResponse.min, rightResponse.min));
        int max = Math.max(root.data, Math.max(leftResponse.max, rightResponse.max));

        boolean isBST = true;
        if (leftResponse.max > root.data || rightResponse.min < root.data || !leftResponse.isBST || !rightResponse.isBST){
            isBST = false;
        }

        int height = 0;
        if (isBST){
            height = Math.max(leftResponse.height, rightResponse.height) + 1;
        } else {
            height = Math.max(leftResponse.height, rightResponse.height);
        }

        return new LargestBSTResponse(min, max, isBST, height);
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if (root == null){
            return;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        subArray(root, ans);
        int arr[] = ans.stream().mapToInt(Integer::valueOf).toArray();
        int i = 0;
        int j = ans.size() -1;

        while (i < j){
            if (ans.get(i) + ans.get(j) == s){
                System.out.println(ans.get(i)+" "+ans.get(j));
                i++;
                j--;
            } else if (ans.get(i) + ans.get(j) > s) {
                j--;
            } else {
                i++;
            }
        }

    }

    private static void subArray(BinaryTreeNode<Integer> root, ArrayList<Integer> ans ){
        if (root == null){
            return;
        }
        subArray(root.left, ans);
        ans.add(root.data);
        subArray(root.right, ans);

    }
}
