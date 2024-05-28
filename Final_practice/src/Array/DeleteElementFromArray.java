package Array;

import java.util.Arrays;

public class DeleteElementFromArray {

    public static void deleteElement(int[] arr, int index) {
        int lastIndex = arr.length - 1;

        // Swap the element to be deleted with the last element
        int temp = arr[index];
        arr[index] = arr[lastIndex];
        arr[lastIndex] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};

        System.out.println("Original array: " + Arrays.toString(arr));

        int indexToDelete = 2; // Index of the element to delete
        deleteElement(arr, indexToDelete);

        // Resize the array to remove the last element
        arr = Arrays.copyOf(arr, arr.length - 1);

        System.out.println("Array after deleting element at index " + indexToDelete + ": " + Arrays.toString(arr));
    }
}
//Delete an element which is neither the start nor end of an array, (in between)  but in O(1) time complexity