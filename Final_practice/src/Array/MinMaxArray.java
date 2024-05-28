package Array;

public class MinMaxArray {

    public static void findMinMax(int[] arr) {
        if (arr == null || arr.length == 0) {
            System.out.println("Array is empty");
            return;
        }

        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            } else if (arr[i] > max) {
                max = arr[i];
            }
        }

        System.out.println("Minimum element: " + min);
        System.out.println("Maximum element: " + max);
    }

    public static void main(String[] args) {
        int[] arr = {3, 7, 2, 8, 1, 5, 9, 4, 6};
        findMinMax(arr);
    }
}
