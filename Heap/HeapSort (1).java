// Name: <Ibrahima Diallo>
// Class: CS 3305/04
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment: 7
// IDE Name: <IntelliJ>
// Class Heap.java
// Textbook - Listing 23.9, Page 878

public class HeapSort {
    /** Heap sort method */
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        // Create a Heap of integers
        Heap<E> heap = new Heap<E>();

        // Add elements to the heap
        for (int i = 0; i < list.length; i++)
            heap.add(list[i]);

        // Remove elements from the heap
        for (int i = list.length - 1; i >= 0; i--)
            list[i] = heap.remove();
    }
}
