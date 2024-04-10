package LinkedList;

public class SinglyLinkedList {
    int val;
    SinglyLinkedList next;

    SinglyLinkedList(int val){
        this.val = val;
    }

    SinglyLinkedList(int val, SinglyLinkedList next){
        this.val = val;
        this.next = next;
    }
}
