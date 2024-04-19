package com.my.datastrcture.codingninja.binarytree;

/*
 * Binary Tree Node class
 *
 * class BinaryTreeNode<T> {
 * 		T data;
 * 		BinaryTreeNode<T> left;
 * 		BinaryTreeNode<T> right;
 * 		public BinaryTreeNode(T data)
 * 		{
 * 			this.data = data;
 * 		}
 * }
 */

/*
 * Main Method being used internally
 *	public static void main(String[] args) throws IOException {
 *		BinarySearchTree bst = new BinarySearchTree();
 *		int choice, input;
 *		int q = Integer.parseInt(br.readLine());
 *		while (q-- > 0) {
 *			st = new StringTokenizer(br.readLine());
 *			choice = Integer.parseInt(st.nextToken());
 *			switch (choice) {
 *			case 1:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.insert(input);
 *				break;
 *				case 2:
 *				input = Integer.parseInt(st.nextToken());
 *				bst.remove(input);
 *				break;
 *			case 3:
 *				input = Integer.parseInt(st.nextToken());
 *				System.out.println(bst.search(input));
 *				break;
 *			default:
 *				bst.printTree();
 *				break;
 *			}
 *		}
 *	}
 */

public class BinarySearchTree {
   /* private BinaryTreeNode<Integer> root;

    public void insert(int data) {
        root = insertHelper(root, data);
    }

    private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x) {
        if (node == null) {
            BinaryTreeNode<Integer> newRoot = new BinaryTreeNode<>(x);
            return newRoot;
        }
        if (x >= node.data) {
            node.right = insertHelper(node.right, x);
        } else {
            node.left = insertHelper(node.left, x);
        }
        return node;
    }

    public void remove(int data) {
        deleteDataHelper(root, data);
    }

    private BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> root, int x) {
        if (root == null) {
            return new BSTDeleteReturn(null, false);
        }

        if (root.data < x) {
            BSTDeleteReturn outputRight = deleteDataHelper(root.right, x);
            root.right = outputRight.root;
            outputRight.root = root;
            return outputRight;
        }
        if (root.data > x) {
            BSTDeleteReturn outputLeft = deleteDataHelper(root.left, x);
            root.left = outputLeft.root;
            outputLeft.root = root;
            return outputLeft;
        }

        //0 children
        if (root.left == null && root.right == null)
            return new BSTDeleteReturn(null, true);

        //only left child
        if (root.left != null && root.right == null)
            return new BSTDeleteReturn(root.left, true);

        //only right child
        if (root.left == null && root.right != null)
            return new BSTDeleteReturn(root.right, true);

        //both children present
        int rightMin = minimum(root.right);
        root.data = rightMin;
        BSTDeleteReturn outputRight = deleteDataHelper(root.right, rightMin);
        root.right = outputRight.root;
        return new BSTDeleteReturn(root.right, true);


    }

    private static int minimum(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        int leftMin = minimum(root.left);
        int rightMin = minimum(root.right);
        return Math.min(root.data, Math.min(leftMin, rightMin));
    }

    public void printTree() {
        printTree(root);
    }

    private void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String toBePrinted = root.data + ":";
        if (root.left != null) {
            toBePrinted += "L:" + root.left.data + ",";
        }

        if (root.right != null) {
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

    public boolean search(int data) {
        return isPresentHelper(root, data);
    }

    private boolean isPresentHelper(BinaryTreeNode<Integer> node, int x) {
        if (node == null) {
            return false;
        }

        if (node.data == x) {
            return true;
        }

        if (x < node.data) {
            return isPresentHelper(node.left, x);
        } else {
            return isPresentHelper(node.right, x);
        }
    }*/

    private BinaryTreeNode<Integer> root;

    //insert data
    //private helper for insert data
    private BinaryTreeNode<Integer> insertHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            BinaryTreeNode<Integer> newNode = new BinaryTreeNode<Integer>(data);
            return newNode;
        }
        if (data <= root.data) {
            //insert on left subtree
            root.left = insertHelper(data, root.left);
        } else {
            //insert on right subtree
            root.right = insertHelper(data, root.right);
        }
        return root;
    }

    public void insert(int data) {
        //Implement the insert() function
        root = insertHelper(data, root);

    }

    //remove function'
    //remove helper function
    private BinaryTreeNode<Integer> removeHelper(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return null;
        }
        if (data < root.data) {
            root.left = removeHelper(data, root.left);
            return root;
        } else if (data > root.data) {
            root.right = removeHelper(data, root.right);
            return root;
        } else { //data = root.data
            if (root.left == null && root.right == null) {
                return null;
            } else if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                //if both left and right are not null, pick minimum element from right subtree and make that as the root
                BinaryTreeNode<Integer> minNode = root.right;
                while (minNode.left != null) {
                    minNode = minNode.left;
                }
                root.data = minNode.data;
                root.right = removeHelper(minNode.data, root.right);
                return root;

            }

        }


    }

    //tree remove function
    public void remove(int data) {
        //Implement the remove() function
        root = removeHelper(data, root);
    }

    //tree print function
    private void printTree(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return;
        }
        String toBePrinted = root.data + ":";
        if (root.left != null) {
            toBePrinted += "L:" + root.left.data + ",";
        }

        if (root.right != null) {
            toBePrinted += "R:" + root.right.data;
        }
        System.out.println(toBePrinted);
        printTree(root.left);
        printTree(root.right);
    }

    public void printTree() {
        printTree(root);
    }

    //search
    //helper function
    private boolean helperSearch(int data, BinaryTreeNode<Integer> root) {
        if (root == null) {
            return false;
        }
        if (root.data == data) {
            return true;
        } else if (data > root.data) {
            //call right
            return helperSearch(data, root.right);
        } else {
            //call left
            return helperSearch(data, root.left);
        }
    }

    public boolean search(int data) {
        //Implement the search() function
        return helperSearch(data, root);
    }


}