package com.my.datastrcture.codingninja.binarytree;

import java.util.*;

public class BinaryTreeUse {

    public static BinaryTreeNode<Integer> takeTreeInput(BinaryTreeNode<Integer> root){
        if (root == null){
            System.out.println("Enter the root data: ");
        }

        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if (rootData == -1){
            return null;
        }

        root = new BinaryTreeNode<>(rootData);

        System.out.println("Enter the Left Child of "+rootData);
        root.left = takeTreeInput(root);

        System.out.println("Enter the Right Child of "+rootData);
        root.right = takeTreeInput(root);

        return root;
    }

    public static BinaryTreeNode<Integer> takeTreeInput(){
        System.out.println("Enter the root data: ");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        System.out.print(rootData+" Left Child : ");
        root.left = takeTreeInput();

        System.out.print(rootData+" Right Child : ");
        root.right = takeTreeInput();

        return root;
    }

    public static void printTree(BinaryTreeNode<Integer> root ){
        if (root == null){
            return;
        }

        System.out.println(root.data);
        printTree(root.left);
        printTree(root.right);
    }

    public static void printTreeDetailed(BinaryTreeNode<Integer> root ){
        if (root == null){
            return;
        }

        System.out.print(root.data + " :");
        if (root.left != null){
            System.out.print(" L"+root.left.data);
        }

        if (root.right != null){
            System.out.print(" R"+root.right.data);
        }
        System.out.println();
        printTreeDetailed(root.left);
        printTreeDetailed(root.right);
    }

    public static int getSum(BinaryTreeNode<Integer> root) {
        //return getSum(root, 0);
        if (root == null){
            return 0;
        }

        int leftSum = getSum(root.left);
        int rightSum = getSum(root.right);

        return leftSum + rightSum + root.data;
    }

    private static int getSum(BinaryTreeNode<Integer> root, int sum) {
        if (root == null){
            return sum;
        }
        sum = sum + root.data;

        sum = getSum(root.left, sum);
        sum = getSum(root.right, sum);

        return sum;
    }

    public static int numbersOfNodeInTree(BinaryTreeNode<Integer> root ){
        if (root == null){
            return 0;
        }

        int leftCount =  numbersOfNodeInTree(root.left);
        int rightCount = numbersOfNodeInTree(root.right);

        return 1+leftCount+rightCount;
    }

    public static BinaryTreeNode<Integer> takeInputLevelWise(){
        System.out.println("Enter the root node value ");
        Scanner sc = new Scanner(System.in);
        int rootData = sc.nextInt();

        if (rootData == -1){
            return null;
        }

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
        Queue<BinaryTreeNode<Integer>> pendingChildren = new LinkedList<>();
        pendingChildren.add(root);

        while (!pendingChildren.isEmpty()){
            BinaryTreeNode<Integer> front = pendingChildren.poll();
            System.out.println("Enter the left Child of "+front.data);
            int left = sc.nextInt();;
            if (left != -1){
                BinaryTreeNode<Integer> leftChild = new BinaryTreeNode<>(left);
                front.left = leftChild;
                pendingChildren.add(leftChild);
            }

            System.out.println("Enter the right Child of "+front.data);
            int right = sc.nextInt();;

            if (right != -1){
                BinaryTreeNode<Integer> rightChild = new BinaryTreeNode<>(right);
                front.right = rightChild;
                pendingChildren.add(rightChild);
            }
        }

        return root;
    }

    public static void printLevelWise(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        Queue<BinaryTreeNode<Integer>> pendingNodesToPrint = new LinkedList<>();
        pendingNodesToPrint.add(root);

        while (!pendingNodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodesToPrint.poll();
            System.out.print(front.data + ":");
            if (front.left != null) {
                pendingNodesToPrint.add(front.left);
                System.out.print("L:" + front.left.data);

            } else {
                System.out.print("L:-1");
            }

            if (front.right != null) {
                pendingNodesToPrint.add(front.right);
                System.out.print(",R:" + front.right.data);
            } else {
                System.out.print(",R:-1");
            }
            System.out.println();
        }
    }

    public static void printLevelWiseInLine(BinaryTreeNode<Integer> root) {

        if (root == null)
            return;

        Queue<BinaryTreeNode<Integer>> pendingNodesToPrint = new LinkedList<>();
        pendingNodesToPrint.add(root);
        pendingNodesToPrint.add(null);
        while (!pendingNodesToPrint.isEmpty()) {
            BinaryTreeNode<Integer> front = pendingNodesToPrint.poll();
            if (front == null) {
                if (pendingNodesToPrint.isEmpty())
                    break;
                else {
                    System.out.println();
                    pendingNodesToPrint.add(null);
                }

            } else {
                System.out.print(front.data + " ");
                if (front.left != null)
                    pendingNodesToPrint.add(front.left);
                if (front.right != null)
                    pendingNodesToPrint.add(front.right);
            }
        }
    }

    public static void preOrder(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public static void postOrder(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }

    public static int largest(BinaryTreeNode<Integer> root){
        if (root == null){
            return -1;
        }

        int leftLarge = largest(root.left);
        int rightLarge = largest(root.right);

        return Math.max(root.data, Math.max(leftLarge, rightLarge));
    }

    public static int countNodesGreaterThanX(BinaryTreeNode<Integer> root, int x) {
        if (root == null){
            return 0;
        }
        int count = 0;

        if (root.data > x){
            count++;
        }

        int leftCount = countNodesGreaterThanX(root.left, x);
        int rightCount = countNodesGreaterThanX(root.right, x);

        return count+leftCount+rightCount;
    }

    public static int height(BinaryTreeNode<Integer> root) {
        if (root == null){
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int numbersOfLeaf(BinaryTreeNode<Integer> root){
        if (root == null){
            return 0;
        }

        if (root.left == null && root.right == null){
            return 1;
        }

        return numbersOfLeaf(root.left) + numbersOfLeaf(root.right);
    }

    public static void printAtDepthK(BinaryTreeNode<Integer> root, int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.println(root.data);
            return;
        }

        printAtDepthK(root.left, k-1);
        printAtDepthK(root.right, k-1);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root) {
        changeToDepthTree(root,0);
    }

    public static void changeToDepthTree(BinaryTreeNode<Integer> root, int depth)
    {
        if (root==null)
        {
            return;
        }
        root.data=depth;
        changeToDepthTree(root.left,depth+1);
        changeToDepthTree(root.right,depth+1);
    }

    public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
        if (root == null){
            return false;
        }

        if (root.data == x){
            return true;
        } else {
            return isNodePresent(root.left, x) || isNodePresent(root.right, x);
        }
    }

    public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }

        if (root.right == null && root.left != null ){
            System.out.println(root.left.data);
        } else if (root.left == null && root.right != null){
            System.out.print(root.right.data+" ");
        }
        printNodesWithoutSibling(root.left);
        printNodesWithoutSibling(root.right);
    }

    public static BinaryTreeNode<Integer> removeLeaf(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }

        if (root.left == null && root.right == null){
            return null;
        }

        root.left = removeLeaf(root.left);
        root.right = removeLeaf(root.right);

        return root;
    }

    public static void mirrorBinaryTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return;
        }
        BinaryTreeNode<Integer> temp = null;
        if (root.right != null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        mirrorBinaryTree(root.left);
        mirrorBinaryTree(root.right);
    }

    public static BinaryTreeNode<Integer> mirrorTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return null;
        }
        BinaryTreeNode<Integer> temp = null;
        if (root.right != null){
            temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
        root.left = mirrorTree(root.left);
        root.right = mirrorTree(root.right);

        return root;
    }

    public static boolean isBalanced(BinaryTreeNode<Integer> root){
        if (root == null){
            return true;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1){
            return false;
        }

        boolean isLeftBalance = isBalanced(root.left);
        boolean isRightBalance = isBalanced(root.right);

        return isLeftBalance && isRightBalance;
    }

    public static BalanceTreeReturn isBalancedBatter(BinaryTreeNode<Integer> root){
        if (root == null){
            boolean isBal = true;
            int height = 0;
            BalanceTreeReturn ans = new BalanceTreeReturn();
            ans.height = height;
            ans.isBalanced = isBal;
            return ans;
        }

        BalanceTreeReturn leftOutput = isBalancedBatter(root.left);
        BalanceTreeReturn rightOutput = isBalancedBatter(root.right);
        boolean isBal = true;
        int height = 1 + Math.max(leftOutput.height, rightOutput.height);

        if (Math.abs(leftOutput.height - rightOutput.height) > 1){
            isBal = false;
        }

        if (!leftOutput.isBalanced || !rightOutput.isBalanced ){
            isBal = false;
        }
        BalanceTreeReturn ans = new BalanceTreeReturn();
        ans.height = height;
        ans.isBalanced = isBal;
        return ans;
    }

    public static int diameterOfBinaryTree(BinaryTreeNode<Integer> root){
        if (root == null){
            return 0;
        }

        int leftDiameter = diameterOfBinaryTree(root.left);
        int rightDiameter = diameterOfBinaryTree(root.right);
        int heightOfRoot = 1 + height(root.left) + height(root.right);

        return Math.max(heightOfRoot, Math.max(leftDiameter, rightDiameter));
    }

    public static BinaryTreeNode<Integer> buildTreeUsingPre(int[] preorder, int[] inorder) {
        int preStart =0;
        int preEnd = preorder.length-1;
        int inStart = 0;
        int inEnd = inorder.length-1;

        return buildTreeUsingPre(preorder, preStart, preEnd,
                inorder, inStart, inEnd);

    }

    public static BinaryTreeNode<Integer> buildTreeUsingPre(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd){
        if(preStart > preEnd || inStart > inEnd )
            return null;

        int rootValue = preorder[preStart];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootValue);

        int k=0;
        for(int i=0; i< inorder.length; i++){
            if(inorder[i]==rootValue){
                k = i;
                break;
            }
        }

        // Becuase k is not the length, it it need to -(inStart+1) to get the length
        root.left = buildTreeUsingPre(preorder, preStart+1, preStart+1-inStart+k-1,
                inorder, inStart, k-1 );
        // postStart+k-inStart = postStart+k-(inStart+1) +1
        root.right = buildTreeUsingPre(preorder, preStart+1-inStart+k, preEnd,
                inorder, k+1, inEnd);

        return root;
    }

    public static BinaryTreeNode<Integer> buildTreeExample(int[] postOrder, int[] inOrder) {
        if(postOrder.length == 0 || postOrder.length != inOrder.length)
            return null;
        return buildTreeExample(postOrder, 0, postOrder.length - 1, inOrder, 0, inOrder.length - 1);
    }

    public static BinaryTreeNode<Integer> buildTreeExample(int[] post, int start1, int end1, int[] in, int start2, int end2){
        if(start1 > end1 || start2 > end2)
            return null;
        int val = post[end1];
        int offset = start2;
        BinaryTreeNode<Integer> cur = new BinaryTreeNode<Integer>(val);
        // search for the inOrder index
        for(; offset < end2; offset++){
            if(in[offset] == val)
                break;
        }
        cur.left = buildTreeExample(post, start1, start1 + offset - start2 - 1, in, start2, offset - 1);
        cur.right = buildTreeExample(post, start1 + offset - start2, end1 - 1, in, offset + 1, end2);
        return cur;
    }

    public static BinaryTreeNode<Integer> buildTreeUsingPreIn(int preOrder[], int inOrder[]){
        return buildTreeUsingPreInHelper(preOrder, inOrder, 0, preOrder.length-1, 0, inOrder.length-1);
    }

    public static BinaryTreeNode<Integer> buildTreeUsingPreInHelper(int preOrder[], int inOrder[], int siPre,
                                                                    int eiPre, int siIn, int eiIn){
        if (siPre > eiPre){
            return null;
        }
        int rootData = preOrder[siPre];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for (int i = siIn; i <= eiIn; i++){
            if (inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }

        int siPreLeft = siPre + 1;
        int siInLeft = siIn;
        int eiInLeft  = rootIndex - 1;
        int siInRight = rootIndex + 1;
        int eiPreRight = eiPre;
        int eiInRight = eiIn;

        int leftSubTreeLength = eiInLeft - siInLeft + 1;

        int eiPreLeft = siPreLeft + leftSubTreeLength - 1;
        int siPreRight = eiPreLeft + 1;

        root.left =  buildTreeUsingPreInHelper(preOrder, inOrder, siPreLeft, eiPreLeft, siInLeft, eiInLeft);
        root.right = buildTreeUsingPreInHelper(preOrder, inOrder, siPreRight, eiPreRight, siInRight, eiInRight);

        return root;
    }
    public static BinaryTreeNode<Integer> buildTree(int[] postOrder, int[] inOrder) {
        return buildTreePostInHelper(postOrder, inOrder, 0,
                postOrder.length-1, 0, inOrder.length-1);
    }
    public static BinaryTreeNode<Integer> buildTreePostInHelper(int[] postOrder, int[] inOrder, int siPost,
                                                                int eiPost, int siIn, int eiIn) {
        if (siPost > eiPost){
            return null;
        }
        int rootData = postOrder[eiPost];
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);

        int rootIndex = -1;
        for (int i = siIn; i <= eiIn; i++){
            if (inOrder[i] == rootData){
                rootIndex = i;
                break;
            }
        }
        int siPostLeft = siPost;
        int siInLeft = siIn;
        int eiInLeft  = rootIndex - 1;
        int siInRight = rootIndex + 1;
        int eiPostRight = eiPost -1;
        int eiInRight = eiIn;

        int leftSubTreeLength = eiInLeft - siInLeft + 1;

        int eiPostLeft = siPostLeft + leftSubTreeLength - 1;
        int siPostRight = eiPostLeft + 1;

        root.left = buildTreePostInHelper(postOrder, inOrder, siPostLeft, eiPostLeft, siInLeft, eiInLeft);
        root.right = buildTreePostInHelper(postOrder, inOrder, siPostRight, eiPostRight, siInRight, eiInRight);

        return root;
    }

    public static void insertDuplicateNode(BinaryTreeNode<Integer> root) {
        if (root == null){
            return;
        }
        int rootData = root.data;
        BinaryTreeNode<Integer> duplicateNode = new BinaryTreeNode<>(rootData);
        duplicateNode.left = root.left;
        root.left = duplicateNode;

        insertDuplicateNode(duplicateNode.left);
        insertDuplicateNode(root.right);
    }

    public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
        if (root == null){
            int min  = Integer.MAX_VALUE;
            int max  = Integer.MIN_VALUE;
            Pair<Integer,Integer> ans = new Pair<>(min,max);
            return ans;
        }

        Pair<Integer,Integer> leftAns = getMinAndMax(root.left);
        Pair<Integer,Integer> rightAns = getMinAndMax(root.right);

        int max = Math.max(root.data, Math.max(leftAns.maximum, rightAns.maximum));
        int min = Math.min(root.data, Math.min(leftAns.minimum, rightAns.minimum));
        Pair<Integer,Integer> ans = new Pair<>(min,max);

        return ans;
    }

    public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
            rootToLeafPathsSumHelper(root, k , "");
        }
        public static void rootToLeafPathsSumHelper(BinaryTreeNode<Integer> root, int k, String str) {
            if (root == null){
                return;
            }
            if (root.left == null && root.right == null && root.data == k){
                System.out.println(str+root.data);
                return;
            }
            str = str + root.data + " ";

            rootToLeafPathsSumHelper(root.left, k - root.data, str);
            rootToLeafPathsSumHelper(root.right, k - root.data, str);
    }

    public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
        printKDistanceNode(root, node, k);
    }

    private static void printKDistanceFromRoot(BinaryTreeNode<Integer> node, int k) {
        if (node == null || k < 0)
            return;

        if (k == 0) {
            System.out.println(node.data);
            return;
        }
        printKDistanceFromRoot(node.left, k - 1);
        printKDistanceFromRoot(node.right, k - 1);
    }

    private static int printKDistanceNode(BinaryTreeNode<Integer> root, int node, int k) {
        if (root == null)
            return -1;

        if (root.data == node) {
            printKDistanceFromRoot(root, k);
            return 0;
        }
        int leftDistance = printKDistanceNode(root.left, node, k);
        if (leftDistance != -1) {
            if (leftDistance + 1 == k)
                System.out.println(root.data);
            else
                printKDistanceFromRoot(root.right, k - leftDistance - 2);
            return 1 + leftDistance;
        }

        int rightDistance = printKDistanceNode(root.right, node, k);
        if (rightDistance != -1) {
            if (rightDistance + 1 == k)
                System.out.println(root.data);
            else
                printKDistanceFromRoot(root.left, k - rightDistance - 2);
            return 1 + rightDistance;
        }
        return -1;
    }


        public static void main(String[] args) {
      /*  BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        BinaryTreeNode<Integer> rootLeft = new BinaryTreeNode<>(2);
        BinaryTreeNode<Integer> rootRight = new BinaryTreeNode<>(3);
        root.left = rootLeft;
        root.right = rootRight;

        BinaryTreeNode<Integer> twoLeft = new BinaryTreeNode<>(4);
        BinaryTreeNode<Integer> twoRight = new BinaryTreeNode<>(5);
        BinaryTreeNode<Integer> threeLeft = new BinaryTreeNode<>(6);
        rootLeft.left = twoLeft;
        rootLeft.right = twoRight;
        rootRight.left = threeLeft;*/

       // BinaryTreeNode<Integer> root = takeTreeInput(null);
        //BinaryTreeNode<Integer> root = takeInputLevelWise();

        //printTree(root);
        //printLevelWise(root);
        //printTreeDetailed(root);
       /* System.out.println(getSum(root));
        System.out.println(largest(root));*/
        /*System.out.println(countNodesGreaterThanX(root, 4));
        System.out.println(height(root));
        System.out.println(numbersOfLeaf(root));
        System.out.println("Print at depth K");
        printAtDepthK(root, 2);*/
        /*System.out.println("Replace Node With Depth");
        changeToDepthTree(root);*/
        //printNodesWithoutSibling(root);

        //System.out.println("Numbers of Node in Tree : "+numbersOfNodeInTree(root));
        //1 4 5 6 -1 -1 7 20 30 80 90 -1 -1 -1 -1 -1 -1 -1 -1

      /*  root = removeLeaf(root);
        System.out.println("After remove leaf");*/
       /* System.out.println("\nMirror Tree");
        mirrorBinaryTree(root);
        printLevelWise(root);*/
        /*System.out.println("Is tree balanced : "+isBalancedBatter(root).isBalanced);
        System.out.println("Diameter Of Binary Tree : "+DiameterOfBinaryTree.diameterOfBinaryTree(root));*/

       /* int inOrder[] = {4, 2, 5, 1, 6, 3, 7 };
        int preOrder[] = {1, 2, 4, 5, 3, 6, 7};
        int postOrder[] = {4, 5, 2, 6, 7, 3, 1};

        BinaryTreeNode<Integer> rootPreIn = buildTreeUsingPreIn(preOrder, inOrder);
        printLevelWise(rootPreIn);

        System.out.println("Post With In order");
        BinaryTreeNode<Integer> rootPostIn = buildTree(postOrder, inOrder);
        printLevelWise(rootPostIn);*/

        //8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
        BinaryTreeNode<Integer> root = takeInputLevelWise();
        //insertDuplicateNode(root);
        printLevelWise(root);
        Pair<Integer,Integer> ans = getMinAndMax(root);
        System.out.println();
        System.out.println("Max Value in Tree : "+ans.maximum);
        System.out.println("Min Value in Tree : "+ans.minimum);


    }
}
