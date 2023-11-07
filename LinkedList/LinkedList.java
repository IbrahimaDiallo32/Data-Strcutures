public class LinkedList
{
    public Node head, tail;

    //constructor method to create a list of object with head, tail, and size.
    public LinkedList()
    {
        head = null;
        tail = null;
    }

    //method add node to end of list
    public void addLastNode(int data)
    {
        if (tail == null)
            head = tail = new Node(data); //empty list
        else
        {
            tail.next = new Node(data); //link new node as last node
            tail = tail.next; //make tail pointer points to last node
        }
    }

    //This will create a new node, point that node to the current head then re-assign that node as the head
    public void addFirstNode(int data)
    {
        if(countNodes() == 0){
            head = tail = new Node(data);
        }else {
            Node temp = new Node(data);
            temp.next = head;
            head = temp;
        }
    }

    //Create a new Node, iterates though the list until we are at the index before the requested new Index the user
    //want to insert at. Then assign the new temp to the rest of the list
    public void addAtIndex(int index, int data)
    {
        Node temp = new Node(data);
        Node currentHead = head;
        if(currentHead == null){
            head = tail = temp;
            return;
        }
        if(index == 0){
            temp.next = head;
            head = temp;
            return;
        }
        for(int i=0; i<index-1; i++){
            currentHead = currentHead.next;
        }
        temp.next = currentHead.next;
        currentHead.next = temp;
    }

    //This is reassigning the head to the next node and there will be no way for the memory to access the previous head
    // because there is no link pointing to it.
    public void removeFirstNode()
    {
        if(countNodes() == 0){
            System.out.println("List is Empty");
            return;
        }
        head = head.next;
    }

    //Traversing through the Linked List then assigning a null value to the last node.
    public void removeLastNode()
    {
        int currentNodes = countNodes();
        if(countNodes() == 0){
            System.out.println("List is Empty");
        } else if(countNodes() == 1){
            head = tail = null;
    }else {
            Node temp = head;
            for (int i=0; i<currentNodes-2; i++){
                temp = temp.next;
            }
            tail = temp;
            temp.next = null;

        }

    }

    //method #5: Checks for valid index and special case if the index is 1. Assigns previous to head then loops through to
    //index before requested index and links the two nodes in-between leaving the node to be collected by garbage
    //collection
    public void removeAtIndex(int index)
    {
        if(index<0 || index <=countNodes()){
            System.out.println("Invalid Index");
            return;
        }
        if(countNodes() == 0){
            System.out.println("List is Empty");
        } else if(index == 0) {
            removeFirstNode();
        } else if(index == countNodes()-1){
            removeLastNode();
        }else{
            Node previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
        }
    }

    //While the current node is not null, the listSize will increment by 1 then return that number once the currentNode
    //is null
    public int countNodes()
    {
        int listSize= 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            listSize++;
        }
        return listSize;

    }

    //method #7: will recursively call itself until the node is null and as it pops off the activation stack it will
    //print out its data causing it to be in reverse;
    public void printInReverse(Node L)
    {
        if(L == null){
            return;
        }
        printInReverse(L.next);
        System.out.print(L.data + "    ");
    }

    //method to print out the list
    public void printList()
    {
        Node temp;
        temp = head;
        if(temp == null){
            System.out.println("List is empty.");
        }
        while (temp != null)
        {
            System.out.print(temp.data + "   ");
            temp = temp.next;
        }
    }

    //class to create nodes as objects
    private class Node
    {
        private int data;  //data field
        private Node next; //link field

        public Node(int item) //constructor method
        {
            data = item;
            next = null;
        }
    }
}

