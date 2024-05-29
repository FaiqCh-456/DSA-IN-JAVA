package LinkedList;

class ListNode2 {
    int val;
    ListNode2 next;

    ListNode2(int x) {
        val = x;
    }
}

public class ReverseInGroups {

    // Function to reverse nodes of a linked list in groups of size k
    public static ListNode2 reverseKGroup(ListNode2 head, int k) {
        if (head == null || k == 1)
            return head;

        ListNode2 dummy = new ListNode2(0);
        dummy.next = head;
        ListNode2 prev = dummy, curr = head;

        int count = 0;
        while (curr != null) {
            count++;
            if (count % k == 0) {
                prev = reverse(prev, curr.next);
                curr = prev.next;
            } else {
                curr = curr.next;
            }
        }
        return dummy.next;
    }

    // Function to reverse a group of nodes between prev and next
    private static ListNode2 reverse(ListNode2 prev, ListNode2 next) {
        ListNode2 last = prev.next;
        ListNode2 curr = last.next;
        while (curr != next) {
            last.next = curr.next;
            curr.next = prev.next;
            prev.next = curr;
            curr = last.next;
        }
        return last;
    }

    // Function to print the linked list
    public static void printList(ListNode2 head) {
        ListNode2 temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);

        int k = 2;

        System.out.println("Original Linked List: ");
        printList(head);

        head = reverseKGroup(head, k);

        System.out.println("\nLinked List after reversing in groups of " + k + ": ");
        printList(head);
    }
}
