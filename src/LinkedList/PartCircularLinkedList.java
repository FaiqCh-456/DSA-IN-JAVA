package LinkedList;

class CircularLinkedList {
    Node1 head;

    class Node1 {
        int data;
        Node1 next;

        Node1(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to split a circular linked list into two halves
    public void splitCircularList() {
        if (head == null || head.next == head) {
            // If the list is empty or has only one node, no splitting is required
            System.out.println("Cannot split circular list with less than 2 nodes.");
            return;
        }

        // Find the midpoint of the circular linked list using Floyd's Tortoise and Hare algorithm
        Node1 slow = head;
        Node1 fast = head;

        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // If the number of nodes is even, move the fast pointer one more step
        if (fast.next.next == head) {
            fast = fast.next;
        }

        // Split the list by breaking the link between the midpoint and the previous node
        Node1 head1 = head;
        Node1 head2 = slow.next;

        slow.next = head1; // Make the first half circular
        fast.next = head2; // Make the second half circular

        // Print the first half of the circular linked list
        System.out.println("First half of the circular linked list:");
        printCircularList(head1);

        // Print the second half of the circular linked list
        System.out.println("\nSecond half of the circular linked list:");
        printCircularList(head2);
    }

    // Utility function to print the circular linked list starting from a given node
    public void printCircularList(Node1 start) {
        Node1 current = start;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != start);
    }

    public static void main(String[] args) {
        CircularLinkedList list = new CircularLinkedList();

        // Create a sample circular linked list: 1 -> 2 -> 3 -> 4 -> 5 -> 1 (circular)
        list.head = list.new Node1(1);
        list.head.next = list.new Node1(2);
        list.head.next.next = list.new Node1(3);
        list.head.next.next.next = list.new Node1(4);
        list.head.next.next.next.next = list.new Node1(5);
        list.head.next.next.next.next.next = list.head;

        System.out.println("Original circular linked list:");
        list.printCircularList(list.head);

        System.out.println("\n\nSplitting the circular linked list into two halves:");
        list.splitCircularList();
    }
}

