package com.my.datastrcture.codingninja.linkedlist.Single;

public class SingleLinkedListUsingRecursionMain {
    public static void main(String[] args) {
        SingleLinkedListUsingRecursion listUsingRecursion = new SingleLinkedListUsingRecursion();
        SinglyNode<Integer> head = listUsingRecursion.insertNode();
        //Node<Integer> head2 = listUsingRecursion.insertNode();

        printLikedList(head);
        //printLikedList(head2);
        //3 4 5 2 6 1 9 7 -1
        //head = listUsingRecursion.insertR(head,8, 8);
        //head = listUsingRecursion.deleteNodeRec(head,6);
        //head = listUsingRecursion.reverseRec(head);
        //head = listUsingRecursion.reverseRBeast(head);
        //head = listUsingRecursion.reverseRecBetter(head);
        //Node<Integer> mid = listUsingRecursion.midPoint(head);

        //head = listUsingRecursion.mergeTwoSorteds(head, head2);
        //head = listUsingRecursion.mergeSort(head);

        //printLikedList(head);
        //System.out.println(mid.data);
        //System.out.println(listUsingRecursion.findNodeRec(head, 100));

        //head = listUsingRecursion.evenAfterOdd(head);
        //head = listUsingRecursion.skipMdeleteN(head, 2, 2);
        head = listUsingRecursion.swapNodes(head, 2, 5);
        //head = listUsingRecursion.kReverse(head, 4);

        printLikedList(head);
    }

    private static void printLikedList(SinglyNode<Integer> head) {
        SinglyNode<Integer> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
}
