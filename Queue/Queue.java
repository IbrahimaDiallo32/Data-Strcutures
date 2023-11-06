// Name: <Ibrahima Diallo>
// Class: CS 3305/Section-04
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment: 5
// IDE Name: <IntelliJ>

public class Queue <T> {
    Node<T> head;
    Node<T> tail;
    //sets values of head and tail to null
public Queue(){
    head = null;
    tail = null;
}
//this adds data fot whatever type to the front of the queue then augments to the queue after first node
public void enqueue(T data) {
    if(size() == 0){
        Node <T> temp = new Node(data);
        head = tail = temp;
    }else {
        tail.next = new Node(data);
        tail = tail.next;
    }
}
//this void method deletes the first queue that was enqueued. First in first out.
public void dequeue(){
    if(size() == 0){
        System.out.print("Queue is empty.");
    }else if (size() ==1 ){
          head = tail = null;
    }else{
       head = head.next;
    }
}
//this returns the amount of elements in the queue as an integer
public int size(){
    int queueSize= 0;
    Node<T> temp = head;
    while(temp != null){
        temp = temp.next;
        queueSize++;
    }
    return queueSize;
}
//this will return the data in the first element of the queue aka the head.
public T front(){
    if(size() == 0){
        System.out.print("The queue is empty.");
    }
    return head.data;
}
//this boolean method returns true or false depending on if the queue is empty or not
public boolean isEmpty(){
    return size() == 0;
}
//this will print out the current values of the queue and special case if the queue is empty.
    public void queueContent(){
        if(size() == 0){
            System.out.print("Queue is empty.");
            return;
        }
        Node <T>temp = head;

        while(temp != null) {
            System.out.print(temp.data + "     ");
            temp = temp.next;
        }
    }

//nested class because this is Linked List implementation not array.
    private static class Node <T>{

        private T data;  //data field
        private Node<T> next; //link field

        public Node(T data) //constructor method
        {
            this.data = data;
            next = null;
        }
    }
}
