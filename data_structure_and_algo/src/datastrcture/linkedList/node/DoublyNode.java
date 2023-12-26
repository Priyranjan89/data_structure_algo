package datastrcture.linkedList.node;

public class DoublyNode {
    public int value;
    public DoublyNode next;
    public DoublyNode pre;

    public DoublyNode(){}

    public DoublyNode(int value, DoublyNode next, DoublyNode pre) {
        this.value = value;
        this.next = next;
        this.pre = pre;
    }

    public int getValue() {
        return value;
    }

    public DoublyNode getNext() {
        return next;
    }

    public DoublyNode getPre() {
        return pre;
    }
}
