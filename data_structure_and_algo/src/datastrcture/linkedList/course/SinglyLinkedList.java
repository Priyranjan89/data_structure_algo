package datastrcture.linkedList.course;

import com.my.datastrcture.linkedList.node.SingleNode;

public class SinglyLinkedList {

    public SingleNode head;
    public SingleNode tail;
    public int size;

    public SingleNode createSinglyLinkedList(int nodeValue) {
        head = new SingleNode();
        SingleNode node = new SingleNode();
        node.next = null;
        node.setValue(nodeValue);
        head = node;
        tail = node;
        size = 1;
        return head;
    }

    public void insertLinkedList(int nodeValue, int location) {

        SingleNode node = new SingleNode();
        node.setValue(nodeValue);

        if (head == null) {
            createSinglyLinkedList(nodeValue);
            return;
        } else if (location == 0) {
            node.next = head;
            head = node;
        } else if (location >= size) {
            node.next = null;
            tail.next = node;
            tail = node;
        } else {
            SingleNode tempNode = head;
            int index = 0;
            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
            }

            SingleNode newNode = tempNode.next;
            tempNode.next = node;
            node.next = newNode;

        }
        size++;
    }

    public void traverseSinglyLinkedList() {
        if (head == null) {
            System.out.println("Singly LinkedList doesn't exist!!!");
        } else {
            SingleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    public boolean searchLinkedList(int nodeValue) {
        if (head != null) {
            SingleNode tempNode = head;
            for (int i = 0; i < size; i++) {
                if (tempNode.value == nodeValue) {
                    System.out.println("Found the node at location " + i);
                    return true;
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("Node not found");
        return false;
    }

    public void deletionOfNode(int location) {
        if (head == null) {
            System.out.println("Singly LinkedList doesn't exist!!!");
            return;
        } else if (location == 0) {
            head = head.next;
            size--;
            if (size == 0) {
                tail = null;
            }
        } else if (location >= size) {
            SingleNode tempNode = head;
            for (int i = 0; i < size - 1; i++) {
                tempNode = tempNode.next;
            }
            if (tempNode == head){
                head = tail = null;
                size--;
                return;
            }
            tempNode.next = null;
            tail = tempNode;
            size--;
        } else {
            SingleNode tempNode = head;
            for (int i = 0; i < location-1; i++) {
                tempNode = tempNode.next;
            }
            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    public void deletionSinglyLinkedList() {
        head = null;
        tail = null;
        System.out.println("Successfully deleted SinglyLinkedList...");
    }
}
