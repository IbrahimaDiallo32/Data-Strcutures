import java.util.*;
public class TestQueue {
    public static void main(String[] args) {
        //creates a queue of type integer
        Queue<Integer> myQueue = new Queue<Integer>();
        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("\n--------MAIN MENU--------\n" + "1 – Enqueue element\n" + "2 – Dequeue element\n" + "3 – Front element\n" + "4 – Size of queue\n" + "5 – Is Empty queue?\n" + "6 - Print queue content\n" + "7 - Exit program\n" + "\nEnter option number:");
            //try catch for all places the user might "mess up"
            try {
                choice = Integer.parseInt(myScan2.nextLine());
                switch (choice) {
                    //this method tests the enqueue method and prints before and afters
                    case 1:
                        System.out.println("Testing method enqueue()");
                        System.out.println("Which integer would you like to add to queue: ");
                        int enqueue = myScan.nextInt();
                        System.out.print("Queue content before enqueue is:   ");
                        myQueue.queueContent();
                        myQueue.enqueue(enqueue);
                        System.out.println();
                        System.out.print("Queue content after enqueue is:    ");
                        myQueue.queueContent();
                        System.out.println();
                        break;
                    //this method tests the dequeue method and prints before and after contents
                    case 2:
                        System.out.println("Testing method dequeue()");
                        System.out.print("Queue content before dequeue:    ");
                        myQueue.queueContent();
                        System.out.println();
                        if(myQueue.size() == 0 ){
                            break;
                        }
                        System.out.print("Queue content after dequeue:     ");
                        myQueue.dequeue();
                        myQueue.queueContent();
                        System.out.println();
                        break;
                    //this method tests the front method and shows before and after queue contents
                    case 3:
                        System.out.println("Testing method front()");
                        System.out.print("The Queue contents before front() are: ");
                        myQueue.queueContent();
                        if (myQueue.size() == 0) {
                            System.out.println();
                            break;
                        }
                        System.out.print("\nThe front element is:                  ");
                        int front = myQueue.front();
                        System.out.println(front);
                        System.out.print("The Queue contents after front() are:  ");
                        myQueue.queueContent();
                        System.out.println();
                        break;
                    //this method tests the size of the queue and shows the integer value
                    case 4:
                        System.out.println("Testing method size()");
                        System.out.println("The size of the queue is " + myQueue.size());
                        break;
                    //this case shows if the queue is empty or not
                    case 5:
                        System.out.println("Testing method isEmpty()");
                        System.out.print("The queue is ");
                        if (myQueue.isEmpty()) {
                            System.out.print("empty");
                        } else {
                            System.out.print("not empty.");
                        }
                        System.out.println();
                        break;
                    //this case prints out the current values of the queue
                    case 6:
                        System.out.println("Testing method queueContent()");
                        System.out.print("The queue content is:    ");
                        myQueue.queueContent();
                        System.out.println();
                        break;
                    //this allows the user to exit the program
                    case 7:
                        break;
                    //default case if integer is not valid
                    default:
                        System.out.println("Please enter valid integer");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Not a valid integer.");
            }
        } while (choice != 7);
    }
}
