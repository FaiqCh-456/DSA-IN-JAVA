//Let k be a given integer value. Search two nodes in singly linked list whose sum is equal to k without using any extra space.
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

public class SearchSumNodes {

    // Find two nodes whose sum equals k in a singly linked list
    public static int[] findNodesWithSum(ListNode2 head, int k) {
        if (head == null || head.next == null) {
            return null; // Not enough nodes in the list
        }

        ListNode2 ptr1 = head;
        ListNode2 ptr2 = head;

        // Move ptr2 to the end of the list
        while (ptr2.next != null) {
            ptr2 = ptr2.next;
        }

        while (ptr2 != null && ptr1 != ptr2) {
            ListNode2 ptr3 = ptr1;
            while (ptr3 != ptr2) {
                if (ptr1.val + ptr3.val == k) {
                    return new int[]{ptr1.val, ptr3.val};
                }
                ptr3 = ptr3.next;
            }
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return null; // No such pair found
    }

    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6
        ListNode2 head = new ListNode2(1);
        head.next = new ListNode2(2);
        head.next.next = new ListNode2(3);
        head.next.next.next = new ListNode2(4);
        head.next.next.next.next = new ListNode2(5);
        head.next.next.next.next.next = new ListNode2(6);

        int k = 10;
        int[] result = findNodesWithSum(head, k);

        if (result != null) {
            System.out.println("Nodes with sum " + k + ": " + result[0] + " and " + result[1]);
        } else {
            System.out.println("No such pair found.");
        }
    }
}
