package com.my.datastrcture.prectice.generictree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTreeTest {

    public static TreeNode<Integer> takeInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the root data ");
        int rootData = sc.nextInt();

        if (rootData == -1) {
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(rootData);
        Queue<TreeNode<Integer>> pendingChild = new LinkedList<>();
        pendingChild.add(root);

        while (!pendingChild.isEmpty()) {
            TreeNode<Integer> front = pendingChild.poll();
            System.out.println("Please enter no of children " + front.data);
            int noOfChild = sc.nextInt();

            for (int i = 0; i < noOfChild; i++) {
                System.out.println("Please enter " + i + "th child data " + front.data);
                int childData = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childData);
                front.children.add(childNode);
                pendingChild.add(childNode);
            }
        }

        return root;
    }

    public static void printTree(TreeNode<Integer> root) {
        //Special case not base case
        if (root == null) {
            return;
        }
        System.out.print(root.data + ": ");
        for (int i = 0; i < root.children.size(); i++) {
            System.out.print(root.children.get(i).data + " ");
        }

        System.out.println();
        for (int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }

    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode<Integer>> pendingChild = new LinkedList<>();
        pendingChild.add(root);
        pendingChild.add(null);

        while (!pendingChild.isEmpty()) {
            TreeNode<Integer> front = pendingChild.poll();
            if (front == null) {
                if (!pendingChild.isEmpty()) {
                    System.out.println();
                    pendingChild.add(null);
                }
            } else {
                System.out.print(front.data + " ");
                for (int i = 0; i < front.children.size(); i++) {
                    pendingChild.add(front.children.get(i));
                }
            }
        }
    }

    public static int numberOfNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int count = 1;

        for (int i = 0; i < root.children.size(); i++) {
            int childCount = numberOfNode(root.children.get(i));
            count += childCount;
        }
        return count;
    }

    public static int sumOfAllNode(TreeNode<Integer> root) {
        if (root == null) {
            return 0;
        }
        int sum = root.data;

        for (int i = 0; i < root.children.size(); i++) {
            int childSum = sumOfAllNode(root.children.get(i));
            sum += childSum;
        }
        return sum;
    }

    public static int numNodeGreater(TreeNode<Integer> root, int x) {

        if (root == null) {
            return 0;
        }
        int count = 0;
        if (root.data > x){
            count = count+1;
        }

        for (int i = 0; i < root.children.size(); i++) {
            int childCount = numNodeGreater(root.children.get(i), x);
            count += childCount;
        }
        return count;

    }

    public static int getHeight(TreeNode<Integer> root){
        if (root == null) {
            return 0;
        }
        int ans = 0;

        for (int i = 0; i < root.children.size(); i++) {
            int childHeight = getHeight(root.children.get(i));
            ans = Math.max(ans, childHeight);
        }
        return ans + 1;
    }

    public static void printPostOrder(TreeNode<Integer> root){
        if (root == null) {
            return;
        }
        for (int i = 0; i < root.children.size(); i++) {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data+" ");
    }

    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if (root == null) {
            return false;
        }
        if (root.data == x){
            return true;
        }
        for (int i = 0; i < root.children.size(); i++) {
            if (checkIfContainsX(root.children.get(i), x)){
                return true;
            }
        }
        return false;
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
       // MaxNodePair<Integer> result = maxSumNodeHelper(root);
        return maxSumNodeHelper(root).node;
    }

    private static MaxNodePair<Integer> maxSumNodeHelper(TreeNode<Integer> root){

        if (root == null){
            return new MaxNodePair<>(null, Integer.MIN_VALUE);
        }

        int sum = root.data;
        for (TreeNode<Integer> child : root.children) {
            sum += child.data;
        }
        MaxNodePair<Integer> ans = new MaxNodePair<>(root, sum);

        for (TreeNode<Integer> child : root.children) {
            MaxNodePair<Integer> childAns = maxSumNodeHelper(child);
            if (childAns.sum > ans.sum){
                ans = childAns;
            }
        }
        return ans;
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
        if (root1 == null && root2 == null){
            return true;
        }
        if (root1 == null || root2 == null){
            return false;
        }
        if (!root1.data.equals(root2.data)){
            return false;
        }
        if (root1.children.size() != root2.children.size()){
            return false;
        }

        for (int i = 0; i < root1.children.size(); i++) {
            if (!checkIdentical(root1.children.get(i), root2.children.get(i))){
                return false;
            }
        }
        return true;
    }

    //private static TreeNode<Integer> nextLager = new TreeNode<>(Integer.MAX_VALUE);
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        if (root == null){
            return null;
        }
        TreeNode<Integer> nextLagerNode = null;
        if (root.data > n){
            nextLagerNode = root;
        }

        for (TreeNode<Integer> child : root.children){
            TreeNode<Integer> nextLagerInChild = findNextLargerNode(child, n);
            if (nextLagerInChild != null){
                if (nextLagerNode == null || nextLagerNode.data > nextLagerInChild.data){
                    nextLagerNode = nextLagerInChild;
                }
            }
        }

        return nextLagerNode;
    }

   public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
       // Edge case: If the tree is empty, return null
       if (root == null) {
           return null;
       }

       // Call the recursive function to find the largest and second largest nodes
       return findSecondLargestHelper(root, null, null).secondLargest;
   }

    private static SecondLargestResponse findSecondLargestHelper(TreeNode<Integer> root, TreeNode<Integer> largest, TreeNode<Integer> secondLargest) {
        // Base case: If root is null, return the current result
        if (root == null) {
            return new SecondLargestResponse(largest, secondLargest);
        }

        // Check if the current node is larger than the largest node
        if (largest == null || root.data > largest.data) {
            secondLargest = largest;
            largest = root;
        }
        // Check if the current node is larger than secondLargest but smaller than largest
        else if ((secondLargest == null || root.data > secondLargest.data) && root.data < largest.data) {
            secondLargest = root;
        }

        // Traverse the children of the current node
        for (TreeNode<Integer> child : root.children) {
            SecondLargestResponse result = findSecondLargestHelper(child, largest, secondLargest);
            largest = result.largest;
            secondLargest = result.secondLargest;
        }

        // Return the updated largest and secondLargest nodes
        return new SecondLargestResponse(largest, secondLargest);
    }
    public static int countLeafNodes(TreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        if (root.children.size() == 0){
            return 1;
        }
        int count = 0;

        for (TreeNode<Integer> child :  root.children){
            count += countLeafNodes(child);
        }
        return count;
    }

    public static void replaceWithDepthValue(TreeNode<Integer> root){
        if (root == null){
            return;
        }
        replaceWithDepthValueHelper(root, 0);
    }

    private static void replaceWithDepthValueHelper(TreeNode<Integer> root, int depth){
        root.data = depth;
        for (TreeNode<Integer> child : root.children){
            replaceWithDepthValueHelper(child, depth+1);
        }
    }

    public static void main(String[] args) {
        /*TreeNode<Integer> root = new TreeNode<> (4);
        TreeNode<Integer> node1 = new TreeNode<>(2);
        TreeNode<Integer> node2 = new TreeNode<>(3);
        TreeNode<Integer> node3 = new TreeNode<>(1);
        TreeNode<Integer> node4 = new TreeNode<>(5);
        TreeNode<Integer> node5 = new TreeNode<>(6);
        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);

        node2.children.add(node4);
        node2.children.add(node5);*/
        TreeNode<Integer> root = takeInput();
        printLevelWise(root);
       /* System.out.println(numberOfNode(root));
        System.out.println(sumOfAllNode(root));*/
    }
}
