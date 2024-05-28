package LinkedList;

//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int val) {
//        this.val = val;
//        this.next = null;
//    }
//}

public class CircularLinkedList {
    private ListNode head;
    private ListNode tail;

    public CircularLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add node to the end of the circular linked list
    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
            tail = newNode;
            newNode.next = head;
        } else {
            tail.next = newNode;
            tail = newNode;
            tail.next = head;
        }
    }

    // Reverse the circular linked list
    public void reverse() {
        if (head == null || head.next == head) {
            return; // Empty list or single node list, no need to reverse
        }

        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        ListNode start = head;

        do {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        } while (current != start);

        head.next = prev;
        head = prev;
    }

    // Print the circular linked list
    public void printList() {
        if (head == null) {
            return;
        }
        ListNode current = head;
        do {
            System.out.print(current.val + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularLinkedList cll = new CircularLinkedList();
        cll.add(1);
        cll.add(2);
        cll.add(3);
        cll.add(4);
        cll.add(5);

        System.out.println("Original Circular Linked List:");
        cll.printList();

        cll.reverse();

        System.out.println("Reversed Circular Linked List:");
        cll.printList();
    }
}
