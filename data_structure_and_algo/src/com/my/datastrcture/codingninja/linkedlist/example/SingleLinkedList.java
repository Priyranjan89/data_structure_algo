package com.my.datastrcture.codingninja.linkedlist.example;

public class SingleLinkedList<T> {

    public Node<T> head;
    public Node<T> tail;

    public Node<T> createSingleNode(T val){
        Node<T> node = new Node<>(val);
        head = node;
        tail = node;
        return head;
    }

    public Node<T> insertAtHead(Node<T> head, T val){
        if (head == null){
            head = createSingleNode(val);
            return head;
        }
        Node<T> node = new Node<>(val);
        node.next = head;
        head = node;

        return head;
    }
    public Node<T> insertAtTail(Node<T> head, T val){
        if (head == null){
            head = createSingleNode(val);
            return head;
        }
        Node<T> node = new Node<>(val);
        tail.next = node;
        tail = node;

        return head;
    }


    public void printLinkedList(Node<T> head){
        Node<T> temp = head;
        while (temp != null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node<T> insert(Node<T> head, int pos, T data){
        if (head == null || pos < 0){
            return head;
        }

        Node<T> node = new Node<>(data);
        Node<T> temp = head;
        int index = 0;

        if (pos == 0){
            node.next = head;
            head = node;
        } else {
            while (temp != null && index < pos-1){
                index++;
                temp = temp.next;
            }
            if (temp != null){
                node.next = temp.next;
                temp.next = node;
            }
            if (temp.next == null){
                tail = node;
            }
        }
        return head;
    }

    public Node<Integer> deleteNode( Node<Integer> head, int pos) {
        if (head == null || pos < 0){
            return head;
        }
        Node<Integer> temp = head;
        int index = 0;

        if (pos == 0){
            head = head.next;
        } else {
            while (temp != null && index < pos-1){
                index++;
                temp = temp.next;
            }

            if (temp != null && temp.next != null){
                temp.next = temp.next.next;
            }

        }
        return head;
    }
}
