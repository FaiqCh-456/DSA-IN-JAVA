package LinkedList;

class LinkedList2 {
    Node head;

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // Function to get the intersection node of two linked lists
    public Node getIntersectionNode(Node headA, Node headB) {
        if (headA == null || headB == null) return null;

        // Get the lengths of both linked lists
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);

        // Calculate the difference in lengths
        int diff = Math.abs(lengthA - lengthB);

        // Advance the pointer of the longer list by the difference in lengths
        Node currentA = headA;
        Node currentB = headB;

        if (lengthA > lengthB) {
            for (int i = 0; i < diff; i++) {
                currentA = currentA.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                currentB = currentB.next;
            }
        }

        // Traverse both lists simultaneously until the pointers meet
        while (currentA != null && currentB != null) {
            if (currentA == currentB) {
                return currentA; // Intersection node found
            }
            currentA = currentA.next;
            currentB = currentB.next;
        }

        return null; // No intersection
    }

    // Utility function to get the length of a linked list
    private int getLength(Node head) {
        int length = 0;
        Node current = head;
        while (current != null) {
            length++;
            current = current.next;
        }
        return length;
    }

    // Utility function to print the linked list
    public void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList2 list1 = new LinkedList2();
        LinkedList2 list2 = new LinkedList2();

        // Create first linked list: 1 -> 2 -> 3 -> 4 -> 5
        list1.head = list1.new Node(1);
        list1.head.next = list1.new Node(2);
        list1.head.next.next = list1.new Node(3);
        list1.head.next.next.next = list1.new Node(4);
        list1.head.next.next.next.next = list1.new Node(5);

        // Create second linked list: 10 -> 4 -> 5 (intersects at node with value 4)
        list2.head = list2.new Node(10);
        list2.head.next = list1.head.next.next.next; // Points to the node with value 4 in the first list

        Node intersectionNode = list1.getIntersectionNode(list1.head, list2.head);

        if (intersectionNode != null) {
            System.out.println("The intersection node value is: " + intersectionNode.data);
        } else {
            System.out.println("There is no intersection.");
        }
    }
}

