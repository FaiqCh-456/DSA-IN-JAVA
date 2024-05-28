package Queue;

public class Deque<T> {

    // Node class for doubly linked list
    private class Node {
        T data;
        Node next;
        Node prev;

        Node(T data) {
            this.data = data;
        }
    }

    private Node front;
    private Node rear;
    private int size;

    public Deque() {
        front = null;
        rear = null;
        size = 0;
    }

    // Add an element to the front
    public void addFront(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.next = front;
            front.prev = newNode;
            front = newNode;
        }
        size++;
    }

    // Add an element to the rear
    public void addRear(T data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            front = rear = newNode;
        } else {
            newNode.prev = rear;
            rear.next = newNode;
            rear = newNode;
        }
        size++;
    }

    // Remove an element from the front
    public T removeFront() {
        if (isEmpty()) {
            System.out.println("Queue.Deque is empty");
            return null;
        }
        T data = front.data;
        front = front.next;
        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }
        size--;
        return data;
    }

    // Remove an element from the rear
    public T removeRear() {
        if (isEmpty()) {
            System.out.println("Queue.Deque is empty");
            return null;
        }
        T data = rear.data;
        rear = rear.prev;
        if (rear != null) {
            rear.next = null;
        } else {
            front = null;
        }
        size--;
        return data;
    }

    // Check if the deque is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Get the size of the deque
    public int size() {
        return size;
    }

    public static void main(String[] args) {
        Deque<Integer> deque = new Deque<>();

        deque.addFront(10);
        deque.addRear(20);
        deque.addFront(5);
        deque.addRear(25);

        System.out.println("Removed from front: " + deque.removeFront()); // Output: 5
        System.out.println("Removed from rear: " + deque.removeRear());   // Output: 25
        System.out.println("Removed from front: " + deque.removeFront()); // Output: 10
        System.out.println("Removed from rear: " + deque.removeRear());   // Output: 20
        System.out.println("Is deque empty: " + deque.isEmpty());         // Output: true
    }
}
