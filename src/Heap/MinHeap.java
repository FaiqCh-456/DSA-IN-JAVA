package Heap;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
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
        while (index != 0 && heap[parent(index)] > heap[index]) {
            swap(parent(index), index);
            index = parent(index);
        }
    }

    public int extractMin() {
        if (size <= 0) {
            System.out.println("Heap is empty. Cannot extract minimum.");
            return -1;
        }

        if (size == 1) {
            size--;
            return heap[0];
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        // Heapify Down
        int index = 0;
        while (true) {
            int left = leftChild(index);
            int right = rightChild(index);
            int smallest = index;

            if (left < size && heap[left] < heap[smallest]) {
                smallest = left;
            }

            if (right < size && heap[right] < heap[smallest]) {
                smallest = right;
            }

            if (smallest != index) {
                swap(index, smallest);
                index = smallest;
            } else {
                break;
            }
        }

        return min;
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);

        minHeap.insert(10);
        minHeap.insert(20);
        minHeap.insert(15);
        minHeap.insert(30);

        System.out.println("Min Heap:");
        System.out.println(minHeap.extractMin()); // Output: 10
        System.out.println(minHeap.extractMin()); // Output: 15
    }
}

