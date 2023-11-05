import java.util.Arrays;

public class HeapSort {

    static int[] sort(int[] a) {
        buildHeap(a); // Build heap

        for (int i = a.length - 1; i > 0; i--) {
            // Swap the maximum element (at the root) with the last element
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;

            // Percolate down the new root element to restore the heap property
            percolateDown(a, 0, i);
        }
        return a;
    }

    static void buildHeap(int[] a) { // Build heap
        for (int i = a.length-1; i >= 0; i--) { // Percolate down all elements
            percolateDown(a, i, a.length);
        }
    }

    static void percolateDown(int[] a, int index, int heapSize) { // Percolate down/bubble down once
        int parentIndex = index;
        int leftChildIndex = 2 * index + 1;
        int rightChildIndex = 2 * index + 2;

        int maxIndex = parentIndex;
        if (leftChildIndex < heapSize && a[leftChildIndex] > a[maxIndex]) {
            maxIndex = leftChildIndex;
        }
        if (rightChildIndex < heapSize && a[rightChildIndex] > a[maxIndex]) {
            maxIndex = rightChildIndex;
        }

        if (maxIndex != parentIndex) {
            int temp = a[parentIndex];
            a[parentIndex] = a[maxIndex];
            a[maxIndex] = temp;
            percolateDown(a, maxIndex, heapSize);
        }

    }
}
