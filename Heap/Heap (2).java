// Name: <Ibrahima Diallo>
// Textbook - Listing 23.9, Page 878

public class Heap<E extends Comparable<E>> {
    private java.util.ArrayList<E> list = new java.util.ArrayList<E>();
    public final int CAPACITY = 100;

    /**
     * Create a default heap
     */
    public Heap() {
    }

    /**
     * Create a heap from an array of objects
     */
    public Heap(E[] objects) {
        for (int i = 0; i < objects.length; i++)
            add(objects[i]);
    }

    /**
     * Add a new object into the heap
     */
    public void add(E newObject) {
        list.add(newObject); // Append to the heap
        int currentIndex = list.size() - 1; // The index of the last node

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) / 2;
            // Swap if the current object is greater than its parent
            if (list.get(currentIndex).compareTo(
                    list.get(parentIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, temp);
            } else
                break; // the tree is a heap now

            currentIndex = parentIndex;
        }
    }

    /**
     * Remove the root from the heap
     */
    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() - 1));
        list.remove(list.size() - 1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;

            // Find the maximum between two children
            if (leftChildIndex >= list.size()) break; // The tree is a heap
            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(maxIndex).compareTo(
                        list.get(rightChildIndex)) < 0) {
                    maxIndex = rightChildIndex;
                }
            }

            // Swap if the current node is less than the maximum
            if (list.get(currentIndex).compareTo(
                    list.get(maxIndex)) < 0) {
                E temp = list.get(maxIndex);
                list.set(maxIndex, list.get(currentIndex));
                list.set(currentIndex, temp);
                currentIndex = maxIndex;
            } else
                break; // The tree is a heap
        }

        return removedObject;
    }

    /**
     * Get the number of nodes in the tree
     */
    public int getSize() {
        return list.size();
    }

    //this returns the first element of the ArrayList which will always be the greatest element
    //of this type of Priority Queue
    public E front() {
        return list.get(0);
    }

    //this will print out the queue where parents will have their kids on the same line
    //and leaf nodes will be printed on their seperate lines
    public void printQueue() {
        if(getSize() == 0) {
            System.out.println("The Heap is empty.");
            return;
        }
        //run for as long as the arrayList is
        for(int i =0; i< getSize(); i++){
            System.out.print("Index " + i + ": " + list.get(i) + " ");
            //this will check if the child node exists of the current 'i' index using this formula
            if((i*2) + 1 < getSize()){
                System.out.print(list.get((i*2) + 1) + " ");
            }
            //does the same thing of checking if the right child exits of a current node
            if((i*2) + 2 < getSize()){
                System.out.print(list.get((i*2) + 2) + " ");
            }
            System.out.println();
        }
    }
}
