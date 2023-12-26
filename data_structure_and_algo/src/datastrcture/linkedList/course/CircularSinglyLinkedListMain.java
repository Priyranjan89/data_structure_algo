package datastrcture.linkedList.course;

public class CircularSinglyLinkedListMain {
    public static void main(String[] args) {

        CircularSinglyLinkedList list = new CircularSinglyLinkedList();
        list.createCircularSinglyLinkedList(10);

        list.insertLinkedList(20,0);
        list.insertLinkedList(30,2);
        list.insertLinkedList(40,4);
        list.insertLinkedList(60,1);
        list.insertLinkedList(70,2);

        list.traverseSinglyLinkedList();
        list.searchLinkedList(10);
        list.deletionOfSingleNode(2);
        list.traverseSinglyLinkedList();
        list.deletionCircularSinglyLinkedList();
        list.traverseSinglyLinkedList();
    }
}
