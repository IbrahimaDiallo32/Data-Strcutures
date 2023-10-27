import java.util.*;
// Name: <Ibrahima Diallo>
// Class: CS 3305/Section-04
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment: 6
// IDE Name: <IntelliJ>

public class RemoveDuplicates {
    public static void main(String [] args) {
        //I sometimes have issues using just one scanner so i use one for menu choice and another for string input just disregard
        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);
        int choice;
        BST<String> tree = new BST<String>();
        //this string is to store the original to compare with the removed duplicates string
        String orginalText = "";

        do {
            System.out.println("\n-----------------MAIN MENU---------------\n" +
                    "1. Read input string\n" +
                    "2. Remove duplicates and display outputs\n" +
                    "3. Exit program\n" +
                    "\nEnter option number:");
            try{
                choice = Integer.parseInt(myScan2.nextLine());
            }
            catch(Exception e){
                System.out.println("Please enter a valid number");
                choice = -1;
            }
            switch(choice){
                //this case allows the user to input a string and delimetes by spaces if necessary. Also, it initializes the
                //string back to empty if its called again, so it forgets previous user input. also resets the tree.
                case 1:
                    tree = new BST<String>();
                    String input = "";
                    orginalText = "";
                    while(input.length() <= 1){
                        System.out.println("Please enter a string");
                        input = myScan.nextLine();
                    }
                    if(input.contains(" ")){
                        String [] stringArr = input.split(" ");
                        //for loop to add all strings separated by spaces into one String
                        for (String temp : stringArr) {
                            tree.insert(temp);
                            orginalText += temp + " ";
                        }
                    } else {
                        tree.insert(input);
                        orginalText += input + " ";
                    }
                    break;
                    //this case will print out the old text and then remove all duplicates and place them in order then
                //print the contents of the tree.
                case 2:
                    System.out.println("Original Text: \n" + orginalText + "\n");
                    System.out.println("Processed Text: ");
                    tree.inorder();
                    System.out.println();
                    break;
                    //this case allows the user to exit the program
                case 3:
                    System.out.println("Goodbye!");
                    break;
            }
        }while(choice != 3);
    }
}
