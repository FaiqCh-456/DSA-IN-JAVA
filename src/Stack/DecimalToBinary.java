package Stack;

import java.util.Stack;

public class DecimalToBinary {

    public static String decimalToBinary(int decimal) {
        if (decimal == 0) {
            return "0"; // Special case for decimal 0
        }

        Stack<Integer> stack = new Stack<>();

        // Convert decimal to binary by repeatedly dividing by 2
        while (decimal > 0) {
            int remainder = decimal % 2;
            stack.push(remainder);
            decimal /= 2;
        }

        // Construct the binary string by popping bits from the stack
        StringBuilder binary = new StringBuilder();
        while (!stack.isEmpty()) {
            binary.append(stack.pop());
        }

        return binary.toString();
    }

    public static void main(String[] args) {
        int decimal = 42; // Example decimal number
        String binary = decimalToBinary(decimal);
        System.out.println("Decimal " + decimal + " is equivalent to Binary " + binary);
    }
}
