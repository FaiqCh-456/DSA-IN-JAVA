package LinkedList;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class InsertingInCLL {
    // Function to insert a new node into a sorted circular linked list
    static Node insert(Node head, int newData) {
        // Create a new node
        Node newNode = new Node(newData);

        // If the list is empty, make the new node as the only node
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }

        // If the new node should be inserted at the beginning of the list
        if (newData <= head.data) {
            Node last = head;
            // Find the last node of the list
            while (last.next != head) {
                last = last.next;
            }
            // Connect the last node to the new node
            last.next = newNode;
            // Make the new node point to the head of the list
            newNode.next = head;
            // Update the head to point to the new node
            return newNode;
        }

        // If the new node should be inserted somewhere in the middle or at the end
        Node current = head;
        // Find the node after which the new node should be inserted
        while (current.next != head && current.next.data < newData) {
            current = current.next;
        }
        // Insert the new node after 'current'
        newNode.next = current.next;
        current.next = newNode;
        return head;
    }

    // Function to print the circular linked list
    static void printList(Node head) {
        if (head == null)
            return;
        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);
    }

    public static void main(String[] args) {
        Node head = null;
        head = insert(head, 5);
        head = insert(head, 10);
        head = insert(head, 7);
        head = insert(head, 3);
        System.out.println("Circular Linked List after insertion: ");
        printList(head);
    }
}

