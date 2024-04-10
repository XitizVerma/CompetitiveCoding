package LinkedList;

public class LinkedListManipulation {

    public static void main(String[] args){
        SinglyLinkedList node = new SinglyLinkedList(1);
        node.next = new SinglyLinkedList(2);
        node.next.next = new SinglyLinkedList(3);
        node.next.next.next = new SinglyLinkedList(4);
        node.next.next.next.next = new SinglyLinkedList(5);
        node.next.next.next.next.next = new SinglyLinkedList(6);


        SinglyLinkedList middleNode = middleOfLinkedList(node);
        System.out.println(middleNode.val);
    }

    private static SinglyLinkedList middleOfLinkedList(SinglyLinkedList head){
        SinglyLinkedList slowPtr = head;
        while(head!=null && head.next!=null){
            head = head.next.next;
            slowPtr = slowPtr.next;
        }
        return slowPtr;
    }


}
