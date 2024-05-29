package LinkedList;

class LinkedList1 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to remove duplicate elements from a sorted linked list
    public void removeDuplicates() {
        if (head == null) return; // If the list is empty, there's nothing to do

        Node current = head;

        // Traverse the list
        while (current != null && current.next != null) {
            if (current.data == current.next.data) {
                // If the current node and the next node have the same data,
                // skip the next node by pointing the current node's next to the next of next node
                current.next = current.next.next;
            } else {
                // Otherwise, move to the next node
                current = current.next;
            }
        }
    }

    // Utility function to print the linked list
    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList1 list = new LinkedList1();
        list.head = list.new Node(1);
        list.head.next = list.new Node(1);
        list.head.next.next = list.new Node(2);
        list.head.next.next.next = list.new Node(3);
        list.head.next.next.next.next = list.new Node(3);

        System.out.println("Original list:");
        list.printList();  // Output: 1 1 2 3 3

        list.removeDuplicates();

        System.out.println("\nList after removing duplicates:");
        list.printList();  // Output: 1 2 3
    }
}
