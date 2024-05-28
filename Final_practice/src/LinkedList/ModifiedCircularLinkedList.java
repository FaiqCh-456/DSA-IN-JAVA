package LinkedList;
//Implement Circular Linked list( Insertion from head, deletion from end, Traversal) provided with head only, no extra pointer
//class ListNode {
//    int val;
//    ListNode next;
//
//    ListNode(int val) {
//        this.val = val;
//        this.next = null;
//    }
//}

public class ModifiedCircularLinkedList {

    private ListNode head;

    // Constructor to initialize an empty circular linked list
    public ModifiedCircularLinkedList() {
        this.head = null;
    }

    // Insert a new node at the beginning of the circular linked list (insertion from head)
    public void insertFromHead(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            newNode.next = newNode; // Make it circular
            head = newNode;
        } else {
            newNode.next = head.next;
            head.next = newNode;
            int temp = head.val;
            head.val = newNode.val;
            newNode.val = temp;
        }
    }

    // Delete the last node from the circular linked list
    public void deleteFromEnd() {
        if (head == null || head.next == head) {
            head = null; // Empty list or single node list
        } else {
            ListNode current = head;
            while (current.next.next != head) {
                current = current.next;
            }
            current.next = head; // Make the second last node point to the head
        }
    }

    // Traverse and print the values of the circular linked list
    public void traverse() {
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
        ModifiedCircularLinkedList cll = new ModifiedCircularLinkedList();

        // Insert nodes at the beginning
        cll.insertFromHead(1);
        cll.insertFromHead(2);
        cll.insertFromHead(3);
        cll.insertFromHead(4);
        cll.insertFromHead(5);

        System.out.print("Original Circular Linked List: ");
        cll.traverse();

        // Delete node from the end
        cll.deleteFromEnd();

        System.out.print("Circular Linked List after deletion from end: ");
        cll.traverse();
    }
}
