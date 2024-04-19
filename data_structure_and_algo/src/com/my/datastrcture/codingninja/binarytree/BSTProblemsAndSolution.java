package com.my.datastrcture.codingninja.binarytree;

import com.my.datastrcture.codingninja.Test2.LinkedListNode;

import java.util.*;

import static com.my.datastrcture.codingninja.binarytree.BinaryTreeUse.printLevelWise;
import static com.my.datastrcture.codingninja.binarytree.BinaryTreeUse.takeInputLevelWise;

public class BSTProblemsAndSolution {
    public static void main(String[] args) {
        /*BinaryTreeNode<Integer> root = takeInputLevelWise();
        //insertDuplicateNode(root);
        printLevelWise(root);
        //8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        elementsInRangeK1K2(root, 6, 10);*/
        /*int arr[] = {1,2,3,4,5,6,7};
        BinaryTreeNode<Integer> root = SortedArrayToBST(arr, arr.length);
        printLevelWise(root);*/
        //11 -1 12 -1 13 -1 14 -1 15 -1 -1
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        printLevelWise(root);

       /* LinkedListNode ans = constructLinkedList(root);
        while (ans != null){
            System.out.print(ans.data+" ");
            ans = ans.next;
        }*/

        //8 5 10 2 6 -1 -1 -1 -1 -1  7 -1 -1
        /*ArrayList<Integer> output = getPath(root, 2);
        if (output != null){
            output.forEach(System.out::println);
        }*/
        //8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1
        printNodesSumToS(root, 12);

    }

    public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
        if (root == null){
            return false;
        }
        /*if (root.data == k){
            return true;
        }else if(root.data > k){
            return searchInBST(root.left, k);
        }else {
            return searchInBST(root.right, k);
        }*/


        if (root.data == k){
            return true;
        }
        if(root.data > k){
            return searchInBST(root.left, k);
        }
        return searchInBST(root.right, k);
    }

    public static void elementsInRangeK1K2(BinaryTreeNode<Integer> root,int k1,int k2){
        List<Integer> list = new ArrayList<>();

        elementsInRangeK1K2Helper( root, k1, k2, list);
        Collections.sort(list);
        for (int num : list){
            System.out.print(num+" ");
        }
    }

    private static List<Integer> elementsInRangeK1K2Helper(BinaryTreeNode<Integer> root, int k1, int k2, List<Integer> list){
        if (root == null){
            return list;
        }

        if (root.data > k2){
            elementsInRangeK1K2Helper(root.left, k1, k2, list);
        } else if (root.data < k1){
            elementsInRangeK1K2Helper(root.right, k1, k2, list);
        } else {
            list.add(root.data);
            elementsInRangeK1K2Helper(root.left, k1, k2, list);
            elementsInRangeK1K2Helper(root.right, k1, k2, list);
        }
        return list;
    }

    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
        return sortedArrayToBSTHelper(arr, 0, n-1);
    }

    private static BinaryTreeNode<Integer> sortedArrayToBSTHelper(int[] arr, int startIndex, int endIndex){
        if (startIndex > endIndex){
            return null;
        }
        int mid = (startIndex + endIndex) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);

        root.left = sortedArrayToBSTHelper(arr, startIndex, mid - 1);
        root.right = sortedArrayToBSTHelper(arr, mid + 1, endIndex);

        return root;
    }

    public static boolean isBST(BinaryTreeNode<Integer> root) {
       /* if(root==null){
            return true;
        }
        int leftMax= largest(root.left);
        if(leftMax>=root.data){
            return false;
        }
        int rightMin= minimum(root.right);
        if(rightMin<root.data){
            return false;
        }
        boolean isLeftBST= isBST(root.left);
        boolean isRightBST= isBST(root.right);
        return isLeftBST && isRightBST;*/
        IsBSTReturn ans = isBST2(root);
        return ans.isBST;
    }

    public static int largest(BinaryTreeNode<Integer> root){
        if(root==null){
            return Integer.MIN_VALUE;
        }
        int largestLeft= largest(root.left);
        int largestRight= largest(root.right);
        return Math.max(root.data, Math.max(largestLeft, largestRight));
    }

    public static int minimum(BinaryTreeNode<Integer> root){
        if (root == null){
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public static IsBSTReturn isBST2(BinaryTreeNode<Integer> root){
        if(root==null){
            IsBSTReturn ans = new IsBSTReturn(Integer.MAX_VALUE, Integer.MIN_VALUE, true);
            return ans;
        }
        IsBSTReturn leftAns= isBST2(root.left);
        IsBSTReturn rightAns= isBST2(root.right);

        int min= Math.min(root.data, Math.min(leftAns.min, rightAns.min));
        int max= Math.max(root.data, Math.max(leftAns.max, rightAns.max));
        boolean isBST= true;
        if(leftAns.max>=root.data){
            isBST= false;
        }
        if(rightAns.min<root.data){
            isBST= false;
        }
        if(!leftAns.isBST){
            isBST= false;
        }
        if(!rightAns.isBST){
            isBST= false;
        }
        IsBSTReturn ans = new IsBSTReturn(min,max,isBST);
        return ans;
    }

    static  LinkedListNode<Integer> tail;

    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        if (root == null){
            return null;
        }
        LinkedListNode<Integer> head = new LinkedListNode<>(root.data);
        tail = head;
        head = helper(root, head);
        return head.next;
    }
    private static LinkedListNode<Integer> helper(BinaryTreeNode<Integer> currRoot, LinkedListNode<Integer> currLLNode) {
        if (currRoot == null){
            return currLLNode;
        }
        if (currRoot.left != null){
            currLLNode = helper(currRoot.left, currLLNode);
        }
        currLLNode = addNode(currRoot, currLLNode);
        if (currRoot.right != null){
            currLLNode = helper(currRoot.right, currLLNode);
        }
        return currLLNode;
    }

    private static LinkedListNode<Integer> addNode(BinaryTreeNode<Integer> currRoot, LinkedListNode<Integer> currLLNode){
        LinkedListNode<Integer> newNode = new LinkedListNode<>(currRoot.data);
        tail.next = newNode;
        tail = newNode;
        return currLLNode;
    }

    public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
        if(root==null) {
            return -1;
        }
        if(a < root.data && b < root.data ) {
            return getLCA(root.left, a, b);
        }
        if(a>root.data && b > root.data) {
            return getLCA(root.right, a, b);
        }
        if(root.data == a || root.data == b) {
            return root.data;
        }
        int leftLca = getLCA(root.left, a, b);
        int rightLca = getLCA(root.right, a, b);
        if(leftLca==-1 && rightLca==-1) {
            return -1;
        }
        else if(leftLca==-1) {
            return rightLca;
        }
        else if(rightLca==-1) {
            return leftLca;
        }
        else {
            return root.data;
        }
    }

    public static void replaceWithLargerNodesSum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        replace(root, 0);
    }

    public static int replace(BinaryTreeNode<Integer> root, int sum) {
        if (root == null) {
            return 0;
        }

        int right = replace(root.right, sum);
        int rootdata = root.data;
        root.data = root.data + right + sum;
        int left = replace(root.left, root.data);

        return rootdata + right + left;

    }

    public static ArrayList<Integer> getPath(BinaryTreeNode<Integer> root, int data){
        if (root == null){
            return null;
        }
        if (root.data == data){
            ArrayList<Integer> output = new ArrayList<>();
            output.add(root.data);
            return output;
        }

        ArrayList<Integer> leftOutput = getPath(root.left, data);
        if (leftOutput != null){
            leftOutput.add(root.data);
            return leftOutput;
        }

        ArrayList<Integer> rightOutput = getPath(root.right, data);
        if (rightOutput != null){
            rightOutput.add(root.data);
            return rightOutput;
        }
        return  null;
    }


    public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root) {
        if (root == null)
            return null;

        ArrayList<LinkedListNode<Integer>> arr = new ArrayList<>();
        Queue<BinaryTreeNode<Integer>> nodesToPrint = new LinkedList<>();
        nodesToPrint.add(root);
        nodesToPrint.add(null);
        LinkedListNode<Integer> head = null, tail = null;

        while (!nodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = nodesToPrint.poll();
            if (front == null) {
                if (nodesToPrint.isEmpty())
                    break;
                else {
                    nodesToPrint.add(null);
                    tail.next = null;
                    tail = tail.next;
                    head = null;

                }

            } else {
                if (head == null) {
                    head = new LinkedListNode<>(front.data);
                    tail = head;
                    arr.add(head);
                } else {
                    tail.next = new LinkedListNode<>(front.data);
                    tail = tail.next;
                }
                if (front.left != null)
                    nodesToPrint.add(front.left);
                if (front.right != null)
                    nodesToPrint.add(front.right);
            }
        }
        return arr;
    }

    public static int largestBSTSubtree(BinaryTreeNode<Integer> root) {

        LargestBstPair ans = largestBSTHelper(root);
        return ans.height;
    }


    public static LargestBstPair largestBSTHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            LargestBstPair output = new LargestBstPair();
            output.max = Integer.MIN_VALUE;
            output.min = Integer.MAX_VALUE;
            output.isBST = true;
            output.height = 0;
            return output;
        }

        LargestBstPair left = largestBSTHelper(root.left);
        LargestBstPair right = largestBSTHelper(root.right);

        LargestBstPair output = new LargestBstPair();

        output.min = Math.min(root.data, Math.min(left.min, right.min));
        output.max = Math.max(root.data, Math.max(left.max, right.max));

        if(left.max < root.data && right.min > root.data && left.isBST && right.isBST){
            output.isBST = true;
        } else {
            output.isBST = false;
        }

        if (output.isBST) {
            output.height = Math.max(left.height, right.height) + 1;
        } else {
            output.height = Math.max(left.height, right.height);
        }

        return output;
    }

    public static void printNodesSumToS(BinaryTreeNode<Integer> root, int s) {
        if (root == null)
            return;
        int[] arr = arrayInsertion(root);
        Arrays.sort(arr);
        int i = 0;
        int j = arr.length - 1;
        while (i < j) {
            if (arr[i] + arr[j] == s) {
                System.out.println(arr[i] + " " + arr[j]);
                i++;
                j--;
            } else if (arr[i] + arr[j] < s)
                i++;
            else
                j--;

        }
    }

    private static int[] arrayInsertion(BinaryTreeNode<Integer> root) {

        if (root == null) {
            int[] arr = new int[0];
            return arr;
        }
        int firstData = root.data;

        int[] jrr = arrayInsertion(root.left);
        int[] krr = arrayInsertion(root.right);
        int[] finalArray = new int[1 + jrr.length + krr.length];
        int k = 0;
        finalArray[k] = firstData;
        k++;
        for (int i = 0; i < jrr.length; i++) {
            finalArray[k] = jrr[i];
            k++;
        }

        for (int i = 0; i < krr.length; i++) {
            finalArray[k] = krr[i];
            k++;
        }
        return finalArray;
    }
}
