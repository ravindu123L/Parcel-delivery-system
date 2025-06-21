// MaxHeap.java
// Custom implementation to store parcels by highest priority

import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Parcel> heap = new ArrayList<>();

    // Insert new parcel and reorder heap
    public void insert(Parcel p) {
        heap.add(p);
        bubbleUp(heap.size() - 1);
    }

    // Remove the parcel with highest priority
    public Parcel extractMax() {
        if (heap.isEmpty())
            return null;
        Parcel max = heap.get(0); // Top of the heap
        Parcel last = heap.remove(heap.size() - 1); // Take the last element
        if (!heap.isEmpty()) {
            heap.set(0, last); // Replace root
            bubbleDown(0); // Restore heap order
        }
        return max;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    // Move inserted parcel to correct position (upwards)
    private void bubbleUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (heap.get(index).compareTo(heap.get(parent)) > 0) {
                Parcel temp = heap.get(index);
                heap.set(index, heap.get(parent));
                heap.set(parent, temp);
                index = parent;
            } else
                break;
        }
    }

    // Reorder from the top after removing max
    private void bubbleDown(int index) {
        int size = heap.size();
        while (index < size) {
            int left = 2 * index + 1;
            int right = 2 * index + 2;
            int largest = index;

            if (left < size && heap.get(left).compareTo(heap.get(largest)) > 0)
                largest = left;

            if (right < size && heap.get(right).compareTo(heap.get(largest)) > 0)
                largest = right;

            if (largest != index) {
                Parcel temp = heap.get(index);
                heap.set(index, heap.get(largest));
                heap.set(largest, temp);
                index = largest;
            } else
                break;
        }
    }
}
