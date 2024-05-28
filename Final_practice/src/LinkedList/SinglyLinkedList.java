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
public class SinglyLinkedList {

    private ListNode head;

    // Add a node to the end of the linked list
    public void add(int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            head = newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Find the middle node of the linked list
    public ListNode findMiddle() {
        if (head == null) {
            return null;
        }

        ListNode slowPointer = head;
        ListNode fastPointer = head;

        // Move fastPointer twice as fast as slowPointer
        while (fastPointer != null && fastPointer.next != null) {
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }

        // When fastPointer reaches the end, slowPointer will be at the middle
        return slowPointer;
    }

    // Print the linked list
    public void printList() {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList list = new SinglyLinkedList();

        // Adding elements to the linked list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.print("Linked List: ");
        list.printList();

        // Finding the middle of the linked list
        ListNode middleNode = list.findMiddle();
        if (middleNode != null) {
            System.out.println("Middle Node: " + middleNode.val);
        } else {
            System.out.println("The list is empty.");
        }
    }
}
