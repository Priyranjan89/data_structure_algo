package com.my.datastrcture.codingninja.genericTree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenericTreeTest {
    public static TreeNode<Integer> takeInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the root data ");
        int rootData = sc.nextInt();

        if (rootData == -1){
            return null;
        }
        TreeNode<Integer> root = new TreeNode<>(rootData);
        Queue<TreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()) {
            TreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter no. of children "+ front.data);
            int numChild= sc.nextInt();
            for(int i=0;i<numChild;i++){
                System.out.println("Enter the  "+ i +" th child data "+ front.data);
                int childData= sc.nextInt();
                TreeNode<Integer> childNode= new TreeNode<>(childData);
                front.children.add(childNode);
                pendingChildren.add(childNode);
            }
        }
        return root;
    }

    public static void printLevelWise(TreeNode<Integer> root){
        if (root == null)
            return;

        Queue<TreeNode<Integer>> pendingNodesToPrint = new LinkedList<>();
        pendingNodesToPrint.add(root);
        pendingNodesToPrint.add(null);
        while (!pendingNodesToPrint.isEmpty()) {
            TreeNode<Integer> front = pendingNodesToPrint.poll();
            if (front == null) {
                if (pendingNodesToPrint.isEmpty())
                    break;
                else {
                    System.out.println();
                    pendingNodesToPrint.add(null);
                }

            } else {
                System.out.print(front.data + " ");
                for (int i = 0; i < front.children.size(); i++){
                    pendingNodesToPrint.add(front.children.get(i));
                }
            }
        }
    }
    public static void replaceWithDepthValue(TreeNode<Integer> root){
        int depth=0;
        replaceWithDepthHelper(root,depth);
    }

    private static void replaceWithDepthHelper(TreeNode<Integer>root,int depth){
        root.data=depth;

        for(int i=0;i<root.children.size();i++){
            replaceWithDepthHelper(root.children.get(i),depth+1);
        }
    }

    public static void printTree(TreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data+" ");
        for (int i = 0; i < root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printTree(child);
        }
    }

    private static ArrayList<Integer> storeNodeToArrayList(TreeNode<Integer> root,ArrayList<Integer> a){
        a.add(root.data);
        for(int i=0;i<root.children.size();i++){
            storeNodeToArrayList(root.children.get(i),a);
        }
        return a;
    }

    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2) {
        ArrayList<Integer> a1 = new ArrayList<>();
        a1 = storeNodeToArrayList(root1, a1);
        ArrayList<Integer> a2 = new ArrayList<>();
        a2 = storeNodeToArrayList(root2, a2);

        if (a1.size() != a2.size()) {
            return false;
        } else {
            for (int i = 0; i < a1.size(); i++) {
                if (a1.get(i) != a2.get(i)) {
                    return false;
                }
            }
            return true;
        }
    }

    public static void printTreeBetter(TreeNode<Integer> root){
        if (root == null){
            return;
        }
        System.out.print(root.data + " : ");
        for (int i = 0; i < root.children.size(); i++){
            System.out.print(root.children.get(i).data + " ");
        }
        System.out.println();
        for (int i = 0; i < root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            printTreeBetter(child);
        }
    }

    public static int numberOfNodesTree(TreeNode<Integer> root){

        if (root == null){
            return 0;
        }
        int count = 1;
        for (int i = 0; i < root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            int childCount = numberOfNodesTree(child);
            count += childCount;
        }
        return count;
    }

    public static int numNodeGreater(TreeNode<Integer> root,int x){
        if (root == null){
            return 0;
        }
        int count = 0;
        if (root.data > x){
            count++;
        }

        for (int i = 0; i < root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            int childCount = numNodeGreater(child, x);
            count += childCount;
        }
        return count;
    }

    private static boolean isPresent=false;
    public static boolean checkIfContainsX(TreeNode<Integer> root, int x){
        if(root == null){
            return isPresent;
        }
        if(root.data == x){
            isPresent=true;
            return isPresent;
        }

        for(int i=0;i<root.children.size();i++){
            isPresent=checkIfContainsX(root.children.get(i),x);
        }
        return isPresent;
    }

    public static int getHeight(TreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        int ans = 0;

        for (int i = 0; i < root.children.size(); i++){
            int childHeight = getHeight(root.children.get(i));
            ans = Math.max(ans, childHeight);
        }
        return ans + 1;
    }

    public static int sumOfAllNode(TreeNode<Integer> root){
        if (root == null){
            return 0;
        }
        int sum = root.data;

        for (int i = 0; i < root.children.size(); i++){
            TreeNode<Integer> child = root.children.get(i);
            int childSum = sumOfAllNode(child);
            sum += childSum;
        }
        return sum;
    }

    public static void printPostOrder(TreeNode<Integer> root){
        if(root==null)
            return;

        for(int i=0;i<root.children.size();i++)
        {
            printPostOrder(root.children.get(i));
        }
        System.out.print(root.data+" ");
    }

    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
        Pair result = maxPairSum(root);
        return result.node;
    }

    private static ArrayList<Pair> a1=new ArrayList<>();
    private static int maxSum=Integer.MIN_VALUE;
    private static Pair maxPair;


    private static Pair maxPairSum(TreeNode<Integer>root){
        int allsum=root.data;

        for(int i=0;i<root.children.size();i++){
            allsum+=root.children.get(i).data;
        }

        Pair result=new Pair(root,allsum);
        a1.add(result);

        for(int i=0;i<root.children.size();i++){
            maxPairSum(root.children.get(i));
        }

        for(int i=0;i<a1.size();i++){
            if(a1.get(i).sum>maxSum){
                maxSum=a1.get(i).sum;
                maxPair=a1.get(i);
            }
        }
        return maxPair;
    }

    private static TreeNode<Integer>nextLarger=new TreeNode<>(Integer.MAX_VALUE);

    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
        if(root.data > n && root.data < nextLarger.data){
            nextLarger=root;
        }
        for(int i=0;i<root.children.size();i++){
            findNextLargerNode(root.children.get(i),n);
        }
        return nextLarger;
    }

    private static TreeNode<Integer> largest = new TreeNode<>(Integer.MIN_VALUE);
    private static TreeNode<Integer> secondLargest = new TreeNode<>(Integer.MIN_VALUE);
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
        if (root == null){
            return null;
        }
        if (root.data > largest.data){
            if (largest.data != Integer.MIN_VALUE){
                secondLargest = largest;
            }
            largest = root;
        } else if (root.data > secondLargest.data && root.data < largest.data){
            secondLargest = root;
        }
        for(int i=0;i<root.children.size();i++){
            findSecondLargest(root.children.get(i));
        }

        return secondLargest;
    }

    public static int countLeafNodes(TreeNode<Integer> root){
        int count = 0;
        if (root == null){
            return count;
        }
        if (root.children.size() == 0){
            count++;
        }
        for(int i=0;i<root.children.size();i++){
            int smallCount = countLeafNodes(root.children.get(i));
            count += smallCount;
        }
        return count;
    }


    public static void main(String[] args) {
        /*TreeNode<Integer> root = new TreeNode<>(4);
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

        //printTree(root);
        /*printTreeBetter(root);
        System.out.println("Number of Nodes in Tree: " +numberOfNodesTree(root));
        System.out.println("Sum of all Nodes: " +sumOfAllNode(root));*/
    }
}
