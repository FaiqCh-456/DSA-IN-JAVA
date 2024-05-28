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

public class PairwiseSwap {

    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No need to swap if the list is empty or has only one node
        }

        // Create a dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Traverse the list and swap pairs of nodes
        while (prev.next != null && prev.next.next != null) {
            ListNode firstNode = prev.next;
            ListNode secondNode = prev.next.next;

            // Swap nodes
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // Move to the next pair of nodes
            prev = firstNode;
        }

        return dummy.next;
    }

    // Print the linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        System.out.print("Original Linked List: ");
        printList(head);

        // Swap nodes pairwise
        head = swapPairs(head);

        System.out.print("Pairwise Swapped Linked List: ");
        printList(head);
    }
}
