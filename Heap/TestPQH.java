// Name: <Ibrahima Diallo>
import java.util.*;
class TestPQH {
    public static void main(String[] args) {
        boolean hasRunOption0 = false;
        int choice = 0;
        boolean isIntegerTree = false; //allows for checking of tree type for every case
        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);
        String dataType;
        PQ_heap<Integer> intHeap = null;
        PQ_heap<String> stringHeap = null;

        do {
            System.out.println("\n----------------MAIN MENU---------------\n" +
                    "0. Enter Queue Type (integer or string)\n" +
                    "1. Enqueue Element\n" +
                    "2. Dequeue Element\n" +
                    "3. Check is_Full\n" +
                    "4. Check is_Empty\n" +
                    "5. Print PQueue Size\n" +
                    "6. Display Front Element\n" +
                    "7. Print PQueue Elements\n" +
                    "8. Exit program\n" +
                    "\nEnter option number:");
            //this forces the user to go through option 0 first.
            if (!hasRunOption0) {
                choice = 0;
            } else {
                try {
                    choice = Integer.parseInt(myScan2.nextLine());
                } catch (Exception e) {
                    choice = -1;
                }
            }
            //this switch runs through all the cases of the menu and allows the user to input
            switch (choice) {
                case 0:
                    hasRunOption0 = false;
                    //this loops while they have not entered a valid option
                    while (!hasRunOption0) {
                        System.out.println("Please enter tree data type (integer or string)");
                        dataType = myScan.nextLine();
                        dataType.toLowerCase();
                        if (dataType.equals("integer") || dataType.equals("int")) {
                            isIntegerTree = true;
                            hasRunOption0 = true;
                            intHeap = new PQ_heap<Integer>();
                            break;
                        } else if(dataType.equals("string")){
                            isIntegerTree = false;
                            hasRunOption0 = true;
                            stringHeap = new PQ_heap<String>();
                        }
                    }
                    break;
                    //This case will test the enqueue() method and handle exceptions
                case 1:
                    System.out.println("Testing method enqueue()");
                    System.out.print("Please enter the value you would like to insert: ");
                    if (isIntegerTree) {
                        try {
                            int insertValue = Integer.parseInt(myScan.nextLine());
                            intHeap.enqueue(insertValue);
                            System.out.println(insertValue + " was inserted into the tree.");
                        } catch (Exception e) {
                            System.out.println("Invalid Integer, try again.");
                        }
                        //for every case, the else is for when it is a string tree and not an integer tree.
                    } else {
                        String insertValues = myScan.nextLine();
                        stringHeap.enqueue(insertValues);
                        System.out.println(insertValues + " was inserted into the tree.");
                    }
                    break;
                    //tests method dequeue() and handles exceptions
                case 2:
                    System.out.println("Testing method dequeue()");
                    if (isIntegerTree) {
                        if (intHeap.size() == 0) {
                            System.out.println("Sorry the tree is empty.");
                            break;
                        } else {
                            intHeap.dequeue();
                            System.out.println(intHeap.front() + " was dequeued from the tree.");
                        }
                    } else {
                        if (stringHeap.size() == 0) {
                            System.out.println("Sorry the tree is empty.");
                            break;
                        } else {
                            stringHeap.dequeue();
                            System.out.println(stringHeap.front() + " was dequeued from the tree.");
                        }
                    }
                    break;
                    //this case will let the user know if the queue is empty or not
                case 3:
                    System.out.println("Testing method is_full()");
                    if(isIntegerTree) {
                        if (intHeap.is_full()) {
                            System.out.println("The tree is full");
                        } else {
                            System.out.println("The tree is not full");
                        }
                    } else {
                        if (stringHeap.is_full()) {
                            System.out.println("The tree is full");
                        } else {
                            System.out.println("The tree is not full");
                        }
                    }
                    break;
                    //this will test if the method is empty or not
                case 4:
                    System.out.println("Testing method is_Empty()");
                    if(isIntegerTree) {
                        if (intHeap.is_empty()) {
                            System.out.println("The tree is empty");
                        } else {
                            System.out.println("The tree is not empty");
                        }
                    } else {
                        if (stringHeap.is_empty()) {
                            System.out.println("The tree is empty");
                        } else {
                            System.out.println("The tree is not empty");
                        }
                    }
                    break;
                    //this case will return the size of the heap
                case 5:
                    System.out.println("Testing method size()");
                    System.out.println("The current tree size is: ");
                    if(isIntegerTree){
                        System.out.println(intHeap.size());
                    } else {
                        System.out.println(stringHeap.size());
                    }
                    break;
                    //this method will return the front element of the ArrayList of tree
                case 6:
                    System.out.println("Testing method front()");
                    System.out.print("The current front element is: ");
                    if(isIntegerTree){
                        if(intHeap.is_empty()){
                            System.out.println("The tree is empty.");
                            break;
                        }
                        System.out.println(intHeap.front());
                    } else {
                        if(stringHeap.is_empty()){
                            System.out.println("The tree is empty.");
                            break;
                        }
                        System.out.println(stringHeap.front());
                    }
                    break;
                    //this will print out the contents of the queue in order
                case 7:
                    System.out.println("Testing method printQueue()");
                    if(isIntegerTree){
                        intHeap.printQueue();
                    } else {
                        stringHeap.printQueue();
                    }
                    break;
                    //this will print out if they input an invalid integer.
                default:
                    System.out.println("Please enter a valid integer");
                    break;
            }
        }
            while (choice != 8) ;
    }
}
