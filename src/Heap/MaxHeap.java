package Heap;

public class MaxHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MaxHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity];
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private void swap(int index1, int index2) {
        int temp = heap[index1];
        heap[index1] = heap[index2];
        heap[index2] = temp;
    }

    public void insert(int value) {
        if (size == capacity) {
            System.out.println("Heap is full. Cannot insert more elements.");
            return;
        }

        size++;
        int index = size - 1;
        heap[index] = value;

        // Heapify Up
        while (index != 0 && heap[parent(index)] < heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    public int extractMax() {
        if (size <= 0) {
            System.out.println("Heap is empty. Cannot extract maximum.");
            return -1;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        int max = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Heapify Down
        int index = 0;
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            int largest = index;

            if (left < size && heap[left] > heap[largest]) {
                largest = left;
            }

            if (right < size && heap[right] > heap[largest]) {
                largest = right;
            }

            if (largest != index) {
                swap(index, largest);
                index = largest;
            } else {
                break;
            }
        }

        return max;
    }
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap(10);

        maxHeap.insert(10);
        maxHeap.insert(20);
        maxHeap.insert(15);
        maxHeap.insert(30);

        System.out.println("Max Heap:");
        System.out.println(maxHeap.extractMax()); // Output: 30
        System.out.println(maxHeap.extractMax()); // Output: 20
    }
}
