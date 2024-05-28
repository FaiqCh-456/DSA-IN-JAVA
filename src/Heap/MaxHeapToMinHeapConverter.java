package Heap;

public class MaxHeapToMinHeapConverter {
    public void convert(int[] arr) {
        // Start from the last non-leaf node and move up to the root
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private void heapify(int[] arr, int index) {
        int smallest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Compare with left child
        if (leftChild < arr.length && arr[leftChild] < arr[smallest]) {
            smallest = leftChild;
        }

        // Compare with right child
        if (rightChild < arr.length && arr[rightChild] < arr[smallest]) {
            smallest = rightChild;
        }

        // If the smallest value is not the current parent, swap and continue heapifying
        if (smallest != index) {
            int temp = arr[index];
            arr[index] = arr[smallest];
            arr[smallest] = temp;
            heapify(arr, smallest);
        }
    }
    public static void main(String[] args) {
        int[] maxHeap = {9, 8, 7, 6, 5, 4, 3, 2, 1};

        MaxHeapToMinHeapConverter converter = new MaxHeapToMinHeapConverter();
        converter.convert(maxHeap);

        System.out.println("Min Heap after conversion:");
        for (int num : maxHeap) {
            System.out.print(num + " ");
        }
    }
}

