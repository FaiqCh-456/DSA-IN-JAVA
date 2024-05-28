package Stack;

import java.util.Stack;

public class PalindromeChecker {

    public static boolean isPalindrome(String s) {
        Stack<Character> stack = new Stack<>();

        // Push each character onto the stack
        for (char c : s.toCharArray()) {
            stack.push(c);
        }

        // Pop characters from the stack and compare with the original string
        for (char c : s.toCharArray()) {
            if (c != stack.pop()) {
                return false; // Mismatch found, not a palindrome
            }
        }

        return true; // All characters match, it's a palindrome
    }

    public static void main(String[] args) {
        String s1 = "radar"; // Palindrome
        String s2 = "hello"; // Not a palindrome

        System.out.println("Is '" + s1 + "' a palindrome? " + isPalindrome(s1));
        System.out.println("Is '" + s2 + "' a palindrome? " + isPalindrome(s2));
    }
}
