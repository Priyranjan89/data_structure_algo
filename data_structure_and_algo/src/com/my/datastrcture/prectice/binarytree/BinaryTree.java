package com.my.datastrcture.prectice.binarytree;

import com.my.datastrcture.codingninja.binarytree.Pair;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static java.lang.Math.max;

public class BinaryTree {

    public BinaryTreeNode<Integer> createTree(){

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);

        root.left = rootLeft;
        root.right = rootRight;

        BinaryTreeNode<Integer> twoLeft = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(4);
        rootLeft.right = twoRight;
        rootRight.left = twoLeft;

        return root;
    }

    public BinaryTreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data: ");
        int data = sc.nextInt();

        if (data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        System.out.print(data + " Left Child : ");
        root.left = takeInput();

        System.out.print(data + " Right Child : ");
        root.right = takeInput();

        return root;
    }

    public BinaryTreeNode<Integer> takeInputBetter(boolean isRoot, int parentData, boolean isLeft ){
        if (isRoot){
            System.out.println("Enter the root data: ");
        } else {
            if (isLeft){
                System.out.println(" Enter the left child of "+parentData);
            } else {
                System.out.println(" Enter the right child of "+parentData);
            }
        }
        Scanner sc = new Scanner(System.in);
        int data = sc.nextInt();

        if (data == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(data);
        root.left = takeInputBetter(false, data, true);
        root.right = takeInputBetter(false, data, false);

        return root;
    }

    public BinaryTreeNode<Integer> takeInputLevelWise(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data: ");

        int rootData = sc.nextInt();
        if (rootData == -1){
            return null;
        }
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<>();
        pendingChild.add(root);

        while (!pendingChild.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChild.poll();

            System.out.println("Enter the left child of "+front.data);
            int left = sc.nextInt();
            if (left != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChild.add(leftChild);
            }

            System.out.println("Enter the right child of "+front.data);
            int right = sc.nextInt();
            if (right != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChild.add(rightChild);
            }
        }

        return root;
    }

    public int numberOfNode(BinaryTreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        int left = numberOfNode(root.left);
        int right = numberOfNode(root.right);

        return (1+left+right);
    }

    public int getSum(BinaryTreeNode<Integer> root) {
        if (root == null){
            return 0;
        }
        int left = getSum(root.left);
        int right = getSum(root.right);

        return (root.data + left + right);
    }

    public void printTreeLevelWise(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }

        Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<>();
        pendingChild.add(root);

        while (!pendingChild.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChild.poll();

            System.out.print(front.data+" : ");

            if (front.left != null){
                System.out.print("L"+front.left.data+", ");
                pendingChild.add(front.left);
            }
            if (front.right != null){
                System.out.print("R"+front.right.data);
                pendingChild.add(front.right);
            }
            System.out.println();
        }
    }

    public void printTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public void printTreeBetter(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" : ");

        if (root.left != null){
            System.out.print("L"+root.left.data+", ");
        }
        if (root.right != null){
            System.out.print("R"+root.right.data);
        }
        System.out.println();
        printTreeBetter(root.left);
        printTreeBetter(root.right);
    }

    public void preOrder(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void postOrder(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public void inOrder(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }

    public int largestNode(BinaryTreeNode<Integer> root) {
        if (root == null){
            return -1;
        }

        int left = largestNode(root.left);
        int right = largestNode(root.right);

        return max(root.data, max(left, right));
    }

    public int height(BinaryTreeNode<Integer> root) {
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public int noOfLeafNode(BinaryTreeNode<Integer> root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        return noOfLeafNode(root.left) + noOfLeafNode(root.right);
    }

    public void printNodeAtDepthK(BinaryTreeNode<Integer> root, int k){
        if (root == null){
            return;
        }
        if (k == 0){
            System.out.println(root.data);
            return;
        }
        printNodeAtDepthK(root.left, k-1);
        printNodeAtDepthK(root.right, k-1);
    }

    public void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTree(root,0);
    }

    public void changeToDepthTree(BinaryTreeNode<Integer> root, int depth) {
        if (root == null){
            return;
        }
        root.data = depth;
        changeToDepthTree(root.left, depth + 1);
        changeToDepthTree(root.right, depth + 1);
    }

    public boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null){
            return false;
        }
        if (root.data == x){
            return true;
        }
        return isNodePresent(root.left, x) || isNodePresent(root.right, x);
    }

    public void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        if (root.right == null && root.left != null){
            System.out.print(root.left.data);
        } else if (root.left == null && root.right != null){
            System.out.print(root.right.data+" ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    public BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }

        if (root.left == null && root.right == null){
            return null;
        }
        root.left = removeLeaves(root.left);
        root.right = removeLeaves(root.right);

        return root;
    }

    public void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        BinaryTreeNode<Integer> temp = root.left;
        root.left = root.right;
        root.right = temp;

        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }

    public boolean isTreeBalanced(BinaryTreeNode<Integer> root){
        if (root == null){
            return true;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.left);

        if (Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }
        boolean isLeft = isTreeBalanced(root.left);
        boolean isRight = isTreeBalanced(root.right);

        return isLeft && isRight;
    }

    public BalancedTreeResponse isTreeBalancedBatter(BinaryTreeNode<Integer> root){
        if (root == null){
            boolean isBalance = true;
            int height = 0;
            return new BalancedTreeResponse(isBalance, height);
        }

        BalancedTreeResponse leftResponse = isTreeBalancedBatter(root.left);
        BalancedTreeResponse rightResponse = isTreeBalancedBatter(root.right);

        boolean isBalance = true;
        //boolean isBalance = leftResponse.isBalance && rightResponse.isBalance;
        int height = 1 + Math.max(leftResponse.height, rightResponse.height);
        if (Math.abs(leftResponse.height - rightResponse.height) > 1){
            isBalance = false;
        }

        if (!leftResponse.isBalance || !rightResponse.isBalance){
            isBalance = false;
        }

        BalancedTreeResponse response = new BalancedTreeResponse(isBalance, height);

        return response;
    }

    public int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        TreeDiameterResponse response = diameterHelper(root);
        return response.diameter;
    }

    public TreeDiameterResponse diameterHelper(BinaryTreeNode<Integer> root){
        if (root == null){
            return new TreeDiameterResponse(0, 0);
        }

        TreeDiameterResponse leftResponse = diameterHelper(root.left);
        TreeDiameterResponse rightResponse = diameterHelper(root.right);

        int longestDistance = leftResponse.height + rightResponse.height + 1;
        int diameter = Math.max(leftResponse.diameter, Math.max(rightResponse.diameter, longestDistance));
        int height = Math.max(leftResponse.height, rightResponse.height) + 1;

        return new TreeDiameterResponse(height, diameter);
    }

    public BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
        int preStart = 0;
        int preEnd = preOrder.length-1;
        int inStart = 0;
        int inEnd = inOrder.length-1;
        return buildTreeHelper(preOrder, preStart, preEnd, inOrder, inStart, inEnd);
    }

    private BinaryTreeNode<Integer> buildTreeHelper(int[] preOrder, int preStart, int preEnd,
                                                   int[] inOrder, int inStart, int inEnd) {

        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootVal = preOrder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootVal);

        int k = -1;
        for (int i = inStart; i < inOrder.length; i++){
            if (inOrder[i] == rootVal){
                k = i;
                break;
            }
        }

        root.left = buildTreeHelper(preOrder, preStart+1, preStart + (k - inStart), inOrder, inStart,k-1);
        root.right = buildTreeHelper(preOrder, preStart+(k - inStart)+1, preEnd, inOrder, k+1,inEnd);

        return root;
    }

    public void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        BinaryTreeNode<Integer> newLeft = new BinaryTreeNode<>(root.data);
        newLeft.left = root.left;
        root.left = newLeft;
        insertDuplicateNode(root.left.left);
        insertDuplicateNode(root.right);
    }

    public Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        if (root == null){
            int minimum = Integer.MAX_VALUE;
            int maximum = Integer.MIN_VALUE;

            return new Pair<>(minimum, maximum);
        }
        Pair<Integer, Integer> leftPair = getMinAndMax(root.left);
        Pair<Integer, Integer> righttPair = getMinAndMax(root.right);

        int minimum = Math.min(root.data, Math.min(leftPair.minimum, righttPair.minimum));
        int maximum = Math.max(root.data, Math.max(leftPair.maximum, righttPair.maximum));

        return new Pair<>(minimum, maximum);
    }
    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }

        Queue<BinaryTreeNode<Integer>> pendingChild = new LinkedList<>();
        pendingChild.add(root);
        pendingChild.add(null);

        while (!pendingChild.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChild.poll();
            if (front == null){
                System.out.println();

                if (!pendingChild.isEmpty()){
                    pendingChild.add(null);
                }
            } else {
                System.out.print(front.data+" ");
                if (front.left != null){
                    pendingChild.add(front.left);
                }
                if (front.right != null){
                    pendingChild.add(front.right);
                }
            }
        }
    }

    public void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
        rootToLeafPathsSumToKHelper(root, k, "");
    }

    private void rootToLeafPathsSumToKHelper(BinaryTreeNode<Integer> root, int k, String str) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null && root.data == k){
            System.out.println(str+root.data);
            return;
        }
        str = str + root.data+" ";

        rootToLeafPathsSumToKHelper(root.left, k - root.data, str);
        rootToLeafPathsSumToKHelper(root.right, k - root.data, str);
    }
}
