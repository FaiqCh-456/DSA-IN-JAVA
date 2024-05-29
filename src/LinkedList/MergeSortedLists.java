package LinkedList;

class ListNode {
    int val;
    ListNode2 next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class MergeSortedLists {

    public static ListNode2 mergeTwoLists(ListNode2 l1, ListNode2 l2) {
        // Create a dummy node to act as the start of the merged list
        ListNode2 dummy = new ListNode2(0);
        ListNode2 current = dummy;

        // Traverse both lists
        while (l1 != null && l2 != null) {
            // Compare the current nodes of both lists
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        // If there are remaining nodes in either list, add them to the merged list
        if (l1 != null) {
            current.next = l1;
        } else if (l2 != null) {
            current.next = l2;
        }

        // Return the merged list, starting from the node after the dummy node
        return dummy.next;
    }

    // Utility method to print the linked list
    public static void printList(ListNode2 head) {
        ListNode2 current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating first sorted linked list: 1 -> 3 -> 5
        ListNode2 l1 = new ListNode2(1);
        l1.next = new ListNode2(3);
        l1.next.next = new ListNode2(5);

        // Creating second sorted linked list: 2 -> 4 -> 6
        ListNode2 l2 = new ListNode2(2);
        l2.next = new ListNode2(4);
        l2.next.next = new ListNode2(6);

        System.out.print("List 1: ");
        printList(l1);

        System.out.print("List 2: ");
        printList(l2);

        // Merging the two sorted linked lists
        ListNode2 mergedList = mergeTwoLists(l1, l2);

        System.out.print("Merged List: ");
        printList(mergedList);
    }
}

