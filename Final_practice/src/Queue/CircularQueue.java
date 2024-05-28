package Queue;

public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    public CircularQueue(int capacity) {
        this.capacity = capacity;
        queue = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Enqueue operation
    public boolean enqueue(int element) {
        if (isFull()) {
            System.out.println("Queue is full");
            return false;
        }
        rear = (rear + 1) % capacity;
        queue[rear] = element;
        size++;
        return true;
    }

    // Dequeue operation
    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int element = queue[front];
        front = (front + 1) % capacity;
        size--;
        return element;
    }

    // Peek front element
    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        return queue[front];
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == capacity;
    }

    // Get the current size of the queue
    public int getSize() {
        return size;
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(5);

        circularQueue.enqueue(10);
        circularQueue.enqueue(20);
        circularQueue.enqueue(30);
        circularQueue.enqueue(40);
        circularQueue.enqueue(50);

        System.out.println("Front element is: " + circularQueue.peek());

        System.out.println("Dequeued element: " + circularQueue.dequeue());
        System.out.println("Dequeued element: " + circularQueue.dequeue());

        circularQueue.enqueue(60);
        circularQueue.enqueue(70);

        System.out.println("Front element is: " + circularQueue.peek());

        while (!circularQueue.isEmpty()) {
            System.out.println("Dequeued element: " + circularQueue.dequeue());
        }

        System.out.println("Queue is empty: " + circularQueue.isEmpty());
    }
}

