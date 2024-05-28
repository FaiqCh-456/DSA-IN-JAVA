package Stack;

import java.util.Stack;

public class BinaryToDecimal {

    public static int binaryToDecimal(String binary) {
        Stack<Integer> stack = new Stack<>();

        // Push each binary digit onto the stack
        for (int i = 0; i < binary.length(); i++) {
            char digit = binary.charAt(i);
            if (digit != '0' && digit != '1') {
                throw new IllegalArgumentException("Invalid binary string");
            }
            stack.push(Character.getNumericValue(digit));
        }

        // Calculate the decimal value by popping bits from the stack
        int decimal = 0;
        int power = 0;
        while (!stack.isEmpty()) {
            decimal += stack.pop() * Math.pow(2, power);
            power++;
        }

        return decimal;
    }

    public static void main(String[] args) {
        String binary = "101010"; // Example binary number
        int decimal = binaryToDecimal(binary);
        System.out.println("Binary " + binary + " is equivalent to Decimal " + decimal);
    }
}
