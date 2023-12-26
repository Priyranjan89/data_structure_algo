package datastrcture.linkedList.course;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();
        list.createSinglyLinkedList(10);

        list.insertLinkedList(20,0);
        list.insertLinkedList(30,2);
        list.insertLinkedList(40,4);
        list.insertLinkedList(60,1);
        list.insertLinkedList(70,2);

        list.traverseSinglyLinkedList();
        list.searchLinkedList(10);

        list.deletionOfNode(2);
        list.traverseSinglyLinkedList();
        list.deletionSinglyLinkedList();
        list.traverseSinglyLinkedList();
    }
}
