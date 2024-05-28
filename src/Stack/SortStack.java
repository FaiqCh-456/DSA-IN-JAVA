package Stack;

import java.util.Stack;

public class SortStack {

    public static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.isEmpty()) {
            int temp = stack.pop();

            while (!tempStack.isEmpty() && tempStack.peek() < temp) {
                stack.push(tempStack.pop());
            }

            tempStack.push(temp);
        }

        return tempStack;
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(5);
        stack.push(2);
        stack.push(8);
        stack.push(3);
        stack.push(1);

        System.out.println("Original stack: " + stack);

        Stack<Integer> sortedStack = sortStack(stack);

        System.out.println("Sorted stack: " + sortedStack);
    }
}
