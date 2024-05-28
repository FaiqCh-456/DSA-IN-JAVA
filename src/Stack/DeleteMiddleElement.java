package Stack;

import java.util.Stack;

public class DeleteMiddleElement {

    public static Stack<Integer> deleteMiddleElement(Stack<Integer> stack) {
        int size = stack.size();
        int middle = size / 2;

        Stack<Integer> tempStack = new Stack<>();

        // Push elements from the original stack to the temporary stack until reaching the middle element
        for (int i = 0; i < middle; i++) {
            tempStack.push(stack.pop());
        }

        // Skip the middle element by not pushing it onto the temporary stack

        // Push the remaining elements (after the middle element) onto the temporary stack
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        // Push elements from the temporary stack back to the original stack
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }

        return stack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println("Original stack: " + stack);
        deleteMiddleElement(stack);
        System.out.println("Stack after deleting middle element: " + stack);
    }
}
