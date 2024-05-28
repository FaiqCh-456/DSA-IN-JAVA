package Queue;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingTwoQueues {

    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public StackUsingTwoQueues() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    // Push operation
    public void push(int x) {
        // Always push to q1
        q1.add(x);
    }

    // Pop operation
    public int pop() {
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Get the last element from q1
        int poppedElement = q1.remove();

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return poppedElement;
    }

    // Top operation
    public int top() {
        // Move all elements except the last one from q1 to q2
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }

        // Get the last element from q1
        int topElement = q1.peek();

        // Also add it to q2 since we are not removing it
        q2.add(q1.remove());

        // Swap the names of q1 and q2
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return topElement;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        StackUsingTwoQueues stack = new StackUsingTwoQueues();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.top()); // Output: 30
        System.out.println(stack.pop()); // Output: 30
        System.out.println(stack.top()); // Output: 20
        System.out.println(stack.pop()); // Output: 20
        System.out.println(stack.pop()); // Output: 10
        System.out.println(stack.isEmpty()); // Output: true
    }
}
