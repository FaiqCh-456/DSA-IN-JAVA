package Lab_final;

class Node {
    String data;
    int pos;
    Node next;

    public Node(String data, int pos) {
        this.data = data;
        this.pos = pos;
        this.next = null;
    }
}

class CircularSinglyLinkedList {
    Node head;

    public CircularSinglyLinkedList() {
        this.head = null;
    }

    public void append(String data, int pos) {
        Node newNode = new Node(data, pos);
        if (head == null) {
            head = newNode;
            head.next = head;
        } else {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    public int getLength() {
        if (head == null) return 0;
        int length = 0;
        Node temp = head;
        do {
            length++;
            temp = temp.next;
        } while (temp != head);
        return length;
    }

    public String[][] removeEverySecond() {
        if (head == null) {
            return new String[0][];
        }

        int length = getLength();
        String[][] removed = new String[length - 1][2];
        Node current = head;
        int index = 0;

        while (length > 1) {
            Node nextNode = current.next;
            removed[index][0] = nextNode.data;
            removed[index][1] = String.valueOf(nextNode.pos);
            current.next = nextNode.next;
            current = nextNode.next;
            length--;
            index++;
        }

        head = current;
        return removed;
    }


    public String[] getFinalElement() {
        if (head != null) {
            return new String[]{head.data, String.valueOf(head.pos)};
        }
        return new String[]{};
    }
}

public class CircularLinkedList {
    public static void main(String[] args) {
        String[] elements = {"1", "2", "3", "4", "5", "6"};
        CircularSinglyLinkedList cll = new CircularSinglyLinkedList();

        for (int i = 0; i < elements.length; i++) {
            cll.append(elements[i], i + 1);
        }

        String[][] removedElements = cll.removeEverySecond();
        String[] finalElement = cll.getFinalElement();

        System.out.println("Input: 1,2,3,4,5,6");

        System.out.println("\nSequence of removed elements (data, original position):");
        for (String[] elem : removedElements) {
            System.out.println("(" + elem[0] + ", " + elem[1] + ")");
        }

        System.out.println("\nFinal remaining element (data, original position):");
        System.out.println("(" + finalElement[0] + ", " + finalElement[1] + ")");
    }
}
