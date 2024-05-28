package Stack;

import java.util.Stack;

public class ParenthesisBalancing {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    return false; // Unmatched closing parenthesis
                }
                char top = stack.pop();
                if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                    return false; // Mismatched closing parenthesis
                }
            }
        }

        return stack.isEmpty(); // Return true if stack is empty, false otherwise
    }

    public static void main(String[] args) {
        String s1 = "{[()]}"; // Balanced parentheses
        String s2 = "{[(])}"; // Unbalanced parentheses

        System.out.println("Is '" + s1 + "' balanced? " + isBalanced(s1));
        System.out.println("Is '" + s2 + "' balanced? " + isBalanced(s2));
    }
}
