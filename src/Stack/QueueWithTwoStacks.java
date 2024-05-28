package Stack;

import java.util.Stack;

public class QueueWithTwoStacks<T> {
    private Stack<T> stack1; // Stack for enqueue operations
    private Stack<T> stack2; // Auxiliary stack for dequeue operations

    public QueueWithTwoStacks() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    // Enqueue operation: Add an element to the queue
    public void enqueue(T element) {
        stack1.push(element);
    }

    // Dequeue operation: Remove and return the front element of the queue
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    // Peek operation: Get the front element of the queue without removing it
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        if (stack2.isEmpty()) {
            // Transfer elements from stack1 to stack2
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.peek();
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return stack1.size() + stack2.size();
    }

    public static void main(String[] args) {
        QueueWithTwoStacks<Integer> queue = new QueueWithTwoStacks<Integer>();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        System.out.println("Size of queue: " + queue.size());
        System.out.println("Front element of queue: " + queue.peek());
        System.out.println("Dequeued element: " + queue.dequeue());
        System.out.println("Size of queue after dequeue: " + queue.size());
    }
}

