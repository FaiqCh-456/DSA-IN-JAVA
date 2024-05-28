package Queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueReverser {

    // Method to reverse the queue
    public static Queue<Integer> reverseQueue(Queue<Integer> queue) {
        Stack<Integer> stack = new Stack<>();

        // Step 1: Dequeue all elements from the queue and push them onto the stack
        while (!queue.isEmpty()) {
            stack.push(queue.remove());
        }

        // Step 2: Pop all elements from the stack and enqueue them into the queue
        while (!stack.isEmpty()) {
            queue.add(stack.pop());
        }

        return queue;
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();

        // Adding elements to the queue
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        System.out.println("Original Queue: " + queue);

        // Reversing the queue
        Queue<Integer> reversedQueue = reverseQueue(queue);

        System.out.println("Reversed Queue: " + reversedQueue);
    }
}
