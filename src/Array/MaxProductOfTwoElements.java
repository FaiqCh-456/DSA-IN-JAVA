package Array;

public class MaxProductOfTwoElements {

    public static int maxProduct(int[] nums) {
        int max1 = Integer.MIN_VALUE; // Maximum element
        int max2 = Integer.MIN_VALUE; // Second maximum element

        for (int num : nums) {
            if (num > max1) {
                max2 = max1;
                max1 = num;
            } else if (num > max2) {
                max2 = num;
            }
        }

        return max1 * max2;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};

        int maxProduct = maxProduct(nums);
        System.out.println("Maximum product of two elements: " + maxProduct);
    }
}
//Given an array of integers, find the maximum product of two elements in the array.