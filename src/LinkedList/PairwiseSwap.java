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

    public static ListNode2 swapPairs(ListNode2 head) {
        if (head == null || head.next == null) {
            return head; // No need to swap if the list is empty or has only one node
        }

        // Create a dummy node to handle edge cases
        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;
        ListNode2 prev = dummy;

        // Traverse the list and swap pairs of nodes
        while (prev.next != null && prev.next.next != null) {
            ListNode2 firstNode = prev.next;
            ListNode2 secondNode = prev.next.next;

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
    public static void printList(ListNode2 head) {
        ListNode2 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);
        head.next.next.next.next.next = new ListNode2(6);

        System.out.print("Original Linked List: ");
        printList(head);

        // Swap nodes pairwise
        head = swapPairs(head);

        System.out.print("Pairwise Swapped Linked List: ");
        printList(head);
    }
}
