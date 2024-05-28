package Heap;

public class MinHeapToMaxHeapConverter {
    public void convert(int[] arr) {
        // Start from the last non-leaf node and move up to the root
        for (int i = (arr.length / 2) - 1; i >= 0; i--) {
            heapify(arr, i);
        }
    }

    private void heapify(int[] arr, int index) {
        int largest = index;
        int leftChild = 2 * index + 1;
        int rightChild = 2 * index + 2;

        // Compare with left child
        if (leftChild < arr.length && arr[leftChild] > arr[largest]) {
            largest = leftChild;
        }

        // Compare with right child
        if (rightChild < arr.length && arr[rightChild] > arr[largest]) {
            largest = rightChild;
        }

        // If the largest value is not the current parent, swap and continue heapifying
        if (largest != index) {
            int temp = arr[index];
            arr[index] = arr[largest];
            arr[largest] = temp;
            heapify(arr, largest);
        }
    }
    public static void main(String[] args) {
        int[] minHeap = {1, 2, 3, 4, 5, 6, 7, 8, 9};

        MinHeapToMaxHeapConverter converter = new MinHeapToMaxHeapConverter();
        converter.convert(minHeap);

        System.out.println("Max Heap after conversion:");
        for (int num : minHeap) {
            System.out.print(num + " ");
        }
    }
}

