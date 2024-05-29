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

public class RemoveNthNodeFromEnd {

    public static ListNode2 removeNthFromEnd(ListNode2 head, int n) {
        if (head == null || n <= 0) {
            return head;
        }

        // Create a dummy node to handle edge cases
        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;

        ListNode2 fast = dummy;
        ListNode2 slow = dummy;

        // Move the fast pointer n positions ahead
        for (int i = 0; i <= n; i++) {
            if (fast == null) {
                return head; // List length less than n
            }
            fast = fast.next;
        }

        // Move both pointers simultaneously until fast reaches the end
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        // Remove the nth node from the end by adjusting pointers
        slow.next = slow.next.next;

        return dummy.next;
    }

    // Print the linked list
    public static void printList(ListNode2 head) {
        ListNode2 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        System.out.print("Original Linked List: ");
        printList(head);

        int n = 2;
        head = removeNthFromEnd(head, n);

        System.out.print("Updated Linked List: ");
        printList(head);
    }
}
