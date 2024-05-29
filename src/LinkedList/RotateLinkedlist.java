package LinkedList;

class RotateLinkedList {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to rotate a linked list to the right by k places
    public void rotateRight(int k) {
        if (head == null || k == 0) {
            // If the list is empty or no rotation needed, return
            return;
        }

        // Find the length of the linked list
        int length = 1;
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Calculate the effective rotation count
        int effectiveK = k % length;
        if (effectiveK == 0) {
            // If effectiveK is 0, no rotation needed
            return;
        }

        // Find the new tail (length - effectiveK)th node
        Node newTail = head;
        for (int i = 1; i < length - effectiveK; i++) {
            newTail = newTail.next;
        }

        // Update pointers to rotate the list
        tail.next = head; // Make the original tail node circular
        head = newTail.next; // Set the new head to the (length - effectiveK + 1)th node
        newTail.next = null; // Make the new tail point to null

        // Print the rotated linked list
        System.out.println("Linked list after rotating right by " + k + " places:");
        printList();
    }

    // Utility function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RotateLinkedList list = new RotateLinkedList();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5
        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(3);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(5);

        System.out.println("Original linked list:");
        list.printList(); // Output: 1 2 3 4 5

        int k = 2;
        list.rotateRight(k); // Rotate the linked list to the right by 2 places
        // Output: 4 5 1 2 3
    }
}
