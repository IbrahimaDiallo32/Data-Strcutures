// Name: <Ibrahima Diallo>
// Textbook - Listing 23.9, Page 878

public class TestHeapSort {
    /** A test method */
    public static void main(String[] args) {

        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};

        System.out.print("Original List:\t");  //print original list
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");

        HeapSort.heapSort(list);  //sort the list

        System.out.print("\n\nSorted List:\t");  //print sorted list
        for (int i = 0; i < list.length; i++)
            System.out.print(list[i] + " ");

        System.out.println("\n");
        //Creating character array which is wrapper class because Java does not accept primitive data types
        //into generics
        Character [] list2 = {'w','f','A','X','T','Q','k','s','8','L','3','b','A','w','s','H','j','K','L'};

        System.out.print("Original List:\t");  //print original list
        for (int i = 0; i < list2.length; i++)
            System.out.print(list2[i] + " ");

        HeapSort.heapSort(list2 );  //this method sorts the list

        System.out.print("\n\nSorted List:\t");  //this method prints the sorted list
        for (int i = 0; i < list2.length; i++)
            System.out.print(list2[i] + " ");

        System.out.println("\n");
        //Creates an array of string that will be passed through heap sort
        String [] list3 = {"Class", "Study", "Data", "Computing", "hard", "Structures,", "to pass."};

        System.out.print("Original List:\t");  //print original list
        for (int i = 0; i < list3.length; i++)
            System.out.print(list3[i] + " ");

        HeapSort.heapSort(list3);  //this method sorts the list

        System.out.print("\n\nSorted List:\t");  //this method prints the sorted list
        for (int i = 0; i < list3.length; i++)
            System.out.print(list3[i] + " ");

    }
}
