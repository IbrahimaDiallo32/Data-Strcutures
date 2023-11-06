import java.util.*;

public class RadixSort {
    //this method takes in two parameters and returns the value of whatever place is requested
    //if the second parameter is 1, it will return the ones places if its 2 then the tens place and so on
    public static int extractDigit(int x, int place) {
        int temp = 0;
        if (place == 1) {
            temp = (x % 10);
            return temp;
        }
        for (int i = 1; i < place; i++) {
            temp = x / 10;
            x = temp;
        }
        temp %= 10;
        return temp;

    }
    //this method takes in an array of numbers and will capture the largest number in that array through linear search
    // then it will return the amount of digits in that number which is useful information for radix sort.

    public static int countDigits(int[] x) {
        int currentMax = x[0];
        int placeMax = 0;
        for (int i = 1; i < x.length; i++) {
            if (x[i] > currentMax) {
                currentMax = x[i];
                placeMax = i;
            }
        }
        int counter = 0;
        while (currentMax != 0) {
            currentMax /= 10;
            counter++;
        }
        return counter;

    }

    public static void RadixSort(int[] x) {
        //this creates 10 seperate queues
        Queue<Integer> Q0 = new Queue<Integer>();
        Queue<Integer> Q1 = new Queue<Integer>();
        Queue<Integer> Q2 = new Queue<Integer>();
        Queue<Integer> Q3 = new Queue<Integer>();
        Queue<Integer> Q4 = new Queue<Integer>();
        Queue<Integer> Q5 = new Queue<Integer>();
        Queue<Integer> Q6 = new Queue<Integer>();
        Queue<Integer> Q7 = new Queue<Integer>();
        Queue<Integer> Q8 = new Queue<Integer>();
        Queue<Integer> Q9 = new Queue<Integer>();
        //calles the countDigits method to figure out the amount of digits in the largest element
        int longest = countDigits(x);
        //these loops extracts digits depending on which one its looking for and enqueues them to their proper queue.
        //the outer loop will dictate which position to extract from
        for (int j = 1; j <= longest; j++) {
            for (int i = 0; i < x.length; i++) {
                int temp = extractDigit(x[i], j);
                switch (temp) {
                    case 0:
                        Q0.enqueue(x[i]);
                        break;
                    case 1:
                        Q1.enqueue(x[i]);
                        break;
                    case 2:
                        Q2.enqueue(x[i]);
                        break;
                    case 3:
                        Q3.enqueue(x[i]);
                        break;
                    case 4:
                        Q4.enqueue(x[i]);
                        break;
                    case 5:
                        Q5.enqueue(x[i]);
                        break;
                    case 6:
                        Q6.enqueue(x[i]);
                        break;
                    case 7:
                        Q7.enqueue(x[i]);
                        break;
                    case 8:
                        Q8.enqueue(x[i]);
                        break;
                    case 9:
                        Q9.enqueue(x[i]);
                        break;
                }
            }
            //this for loop puts them back into the array in order then dequeues them before the next iteration
            //if there is one.
            for (int i = 0; i < x.length; i++) {
                if (!Q0.isEmpty()) {
                    x[i] = Q0.front();
                    Q0.dequeue();
                } else if (!Q1.isEmpty()) {
                    x[i] = Q1.front();
                    Q1.dequeue();
                } else if (!Q2.isEmpty()) {
                    x[i] = Q2.front();
                    Q2.dequeue();
                } else if (!Q3.isEmpty()) {
                    x[i] = Q3.front();
                    Q3.dequeue();
                } else if (!Q4.isEmpty()) {
                    x[i] = Q4.front();
                    Q4.dequeue();
                } else if (!Q5.isEmpty()) {
                    x[i] = Q5.front();
                    Q5.dequeue();
                } else if (!Q6.isEmpty()) {
                    x[i] = Q6.front();
                    Q6.dequeue();
                } else if (!Q7.isEmpty()) {
                    x[i] = Q7.front();
                    Q7.dequeue();
                } else if (!Q8.isEmpty()) {
                    x[i] = Q8.front();
                    Q8.dequeue();
                } else if (!Q9.isEmpty()) {
                    x[i] = Q9.front();
                    Q9.dequeue();
                }
            }
        }
    }

    public static void main(String[] args) {
        int choice = 0;
        int arraySize = 0;
        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);
        int[] inputs =null;
        String arrBeforeSort ="";
        do {
            System.out.println("\n--------MAIN MENU--------\n" + "1 – Read array size\n" + "2 – Read array values\n" + "3 – Run Radix Sort algorithm\n" + "4 – Print outputs\n" + "5 - Exit program\n" + "\nEnter option number:");
            //try catch for all places that may contain user input
            try {
                choice = Integer.parseInt(myScan2.nextLine());

            switch (choice) {
                //this case captures how long the user wants the array size to be
                case 1:
                    System.out.println("What is your desired array size: ");
                    arraySize = myScan.nextInt();
                    inputs = new int[arraySize];
                    break;
                    //this case allows the user to input values for the array and also saves the values into a
                //string for comparison after the radix sort is completed.
                case 2:
                    try {
                        for (int i = 0; i < arraySize; i++) {
                            System.out.println("Input value for " + (i + 1));
                            inputs[i] = myScan.nextInt();
                        }
                        arrBeforeSort = "";
                        for (int i = 0; i < arraySize; i++) {
                            if (i == arraySize - 1) {
                                arrBeforeSort += inputs[i];
                                continue;
                            }
                            arrBeforeSort += inputs[i] + ", ";
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                    //this runs the radixsort and does not print anything out
                case 3:
                    try {
                        RadixSort(inputs);
                    } catch (Exception e) {
                        System.out.println("The array is empty.");
                    }
                    break;
                    //this case shows the user the before and after values of the radix sort
                case 4:
                    try {
                        System.out.println("Array Inputs before sorting: " + arrBeforeSort);
                        System.out.print("Array Inputs after sorting:  ");
                        for (int i = 0; i < inputs.length; i++) {
                            if (i == inputs.length - 1) {
                                System.out.print(inputs[i]);
                                continue;
                            }
                            System.out.print(inputs[i] + ", ");
                        }
                        System.out.println();
                    }
                    catch(Exception e) {
                System.out.println("The array is empty.");
            }
                    break;
            }
            }
            catch(Exception e){
                System.out.println("Not a valid integer.");
            }
        } while (choice != 5);
    }
}
