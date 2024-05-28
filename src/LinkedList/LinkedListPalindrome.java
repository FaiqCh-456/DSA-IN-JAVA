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

public class LinkedListPalindrome {

    // Add a node to the end of the linked list
    public static ListNode add(ListNode head, int val) {
        ListNode newNode = new ListNode(val);
        if (head == null) {
            return newNode;
        } else {
            ListNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        return head;
    }

    // Reverse a linked list
    public static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }

    // Check if the linked list is a palindrome
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        // Find the middle of the linked list
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the linked list
        ListNode secondHalf = reverse(slow);

        // Compare the first half and the reversed second half
        ListNode firstHalf = head;
        ListNode temp = secondHalf; // to restore the list later
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        // Restore the original list (optional)
        reverse(temp);

        return true;
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
        ListNode head = null;
        head = add(head, 1);
        head = add(head, 2);
        head = add(head, 3);
        head = add(head, 2);
        head = add(head, 1);

        System.out.print("Linked List: ");
        printList(head);

        boolean isPalindrome = isPalindrome(head);
        System.out.println("Is Palindrome: " + isPalindrome);

        System.out.print("Restored Linked List: ");
        printList(head);
    }
}
