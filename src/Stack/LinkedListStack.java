package Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

public class LinkedListStack {
    private ListNode top; // Top of the stack

    // Constructor to initialize an empty stack
    public LinkedListStack() {
        this.top = null;
    }

    // Push operation: Add an element to the top of the stack
    public void push(int val) {
        ListNode newNode = new ListNode(val);
        newNode.next = top; // New node points to the current top
        top = newNode; // Update top to point to the new node
    }

    // Pop operation: Remove and return the element at the top of the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int val = top.val; // Get the value of the top node
        top = top.next; // Move top to the next node
        return val;
    }

    // Peek operation: Get the element at the top of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return top.val;
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return top == null;
    }

    public static void main(String[] args) {
        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element of stack: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element of stack after pop: " + stack.peek());
    }
}
