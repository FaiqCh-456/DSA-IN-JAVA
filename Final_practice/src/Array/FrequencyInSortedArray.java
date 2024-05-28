package Array;

public class FrequencyInSortedArray {

    public static int countOccurrences(int[] arr, int target) {
        int count = 0;

        for (int num : arr) {
            if (num == target) {
                count++;
            } else if (num > target) {
                break; // Since the array is sorted, no need to continue if we've passed the target
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5};
        int target = 4;
        int frequency = countOccurrences(arr, target);
        System.out.println("Frequency of " + target + " in the array: " + frequency);
    }
}
