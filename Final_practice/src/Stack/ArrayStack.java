package Stack;

public class ArrayStack {
    private int[] stack; // Array to store elements of the stack
    private int capacity; // Capacity of the stack (size of the array)

    // Constructor to initialize an empty stack with a specified capacity
    public ArrayStack(int capacity) {
        this.stack = new int[capacity];
        this.capacity = capacity;
    }

    // Push operation: Add an element to the top of the stack
    public void push(int element) {
        if (isFull()) {
            throw new IllegalStateException("Stack is full");
        }
        stack[nextIndex()] = element; // Store the element at the next available index
    }

    // Pop operation: Remove and return the element at the top of the stack
    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        int element = stack[currentIndex()]; // Get the element at the current top index
        stack[currentIndex()] = 0; // Clear the element from the stack
        return element;
    }

    // Peek operation: Get the element at the top of the stack without removing it
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        return stack[currentIndex()]; // Return the element at the current top index
    }

    // Check if the stack is empty
    public boolean isEmpty() {
        return currentIndex() < 0;
    }

    // Check if the stack is full
    public boolean isFull() {
        return nextIndex() >= capacity;
    }

    // Get the index of the current top element of the stack
    private int currentIndex() {
        return nextIndex() - 1;
    }

    // Get the index of the next available position in the array (next top index)
    private int nextIndex() {
        for (int i = 0; i < capacity; i++) {
            if (stack[i] == 0) {
                return i;
            }
        }
        return capacity; // Stack is full
    }

    public static void main(String[] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("Top element of stack: " + stack.peek());
        System.out.println("Popped element: " + stack.pop());
        System.out.println("Top element of stack after pop: " + stack.peek());
    }
}
