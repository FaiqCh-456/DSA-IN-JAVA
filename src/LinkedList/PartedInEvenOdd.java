package LinkedList;

class PartedInEvenOdd {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to split the linked list into two lists containing elements at even and odd positions
    public void splitEvenOdd() {
        if (head == null || head.next == null) {
            // If the list is empty or has only one node, no splitting is required
            System.out.println("Cannot split linked list with less than 2 nodes.");
            return;
        }

        Node evenHead = null;
        Node oddHead = null;
        Node current = head;
        Node evenTail = null;
        Node oddTail = null;
        int position = 1;

        while (current != null) {
            if (position % 2 == 0) {
                // Even position
                if (evenHead == null) {
                    evenHead = current;
                    evenTail = current;
                } else {
                    evenTail.next = current;
                    evenTail = evenTail.next;
                }
            } else {
                // Odd position
                if (oddHead == null) {
                    oddHead = current;
                    oddTail = current;
                } else {
                    oddTail.next = current;
                    oddTail = oddTail.next;
                }
            }

            current = current.next;
            position++;
        }

        // Set the last nodes of even and odd lists to null to terminate them
        if (evenTail != null) {
            evenTail.next = null;
        }
        if (oddTail != null) {
            oddTail.next = null;
        }

        // Print the even-positioned elements list
        System.out.println("Even-positioned elements list:");
        printList(evenHead);

        // Print the odd-positioned elements list
        System.out.println("\nOdd-positioned elements list:");
        printList(oddHead);
    }

    // Utility function to print the linked list
    public void printList(Node start) {
        Node temp = start;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        PartedInEvenOdd list = new PartedInEvenOdd();

        // Create a sample linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7
        list.head = list.new Node(1);
        list.head.next = list.new Node(2);
        list.head.next.next = list.new Node(3);
        list.head.next.next.next = list.new Node(4);
        list.head.next.next.next.next = list.new Node(5);
        list.head.next.next.next.next.next = list.new Node(6);
        list.head.next.next.next.next.next.next = list.new Node(7);

        System.out.println("Original linked list:");
        list.printList(list.head); // Output: 1 2 3 4 5 6 7

        System.out.println("\nSplitting the linked list into even and odd-positioned elements:");
        list.splitEvenOdd();
    }
}
