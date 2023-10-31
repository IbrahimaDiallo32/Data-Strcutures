// Name: <Ibrahima Diallo>
// Generic code for class PQ_heap for Assignment 7
public class PQ_heap <E extends Comparable<E>>
{
    private Heap<E> heapObject = new Heap<>();
    // Constructor method
    PQ_heap() {

    }

    // Return true if priority queue is empty; otherwise return false
    public boolean is_empty() {
        return heapObject.getSize() == 0;
    }

    // Return true if priority queue is full; otherwise return false
    public boolean is_full() {
        return heapObject.getSize() >= heapObject.CAPACITY;
    }

    // Return (don't remove) the front element from the priority queue
    // Precondition: priority queue is not empty.
    public E front() {
        if(heapObject.getSize() == 0){
            System.out.println("Sorry, the Queue is empty.");
        }
        return heapObject.front();
    }

    // return number of elements in the queue
    public int size() {
        return heapObject.getSize();
    }

    // Remove the largest value from this priority queue and return it.
    // Precondition: priority queue is not empty.
    public E dequeue() {
        return heapObject.remove();
    }

    // Inserts the 'value' into the priority queue.
    // Precondition: priority queue is not full
    public void enqueue(E value) {
        heapObject.add(value);
    }
    //this method will print the priority queue in order
    public void printQueue(){
        heapObject.printQueue();
    }
}
