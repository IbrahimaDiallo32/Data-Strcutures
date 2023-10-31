// Name: <Ibrahima Diallo>
// Class: CS 3305/Section-04
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment: 2
// IDE Name: <IntelliJ>
import java.util.*;
public class Vowels {
    static char [] vowels = {'a', 'e', 'i', 'o', 'u'};
    //this method takes in a string and checks if the first index of the string is a vowel then adds one to a recursive call that has one less index if it does.
    //the last return will only happen if the first index is not a vowel and will not add one.
    public static int countVowels(String userInput){
        if(userInput.length() == 0){
            return 0;
        }
        if(userInput.charAt(0) == 'a' || userInput.charAt(0) == 'e' ||userInput.charAt(0) == 'i' || userInput.charAt(0) == 'o' || userInput.charAt(0) == 'u'){
            return 1+countVowels(userInput.substring(1));
        }
        return countVowels(userInput.substring(1));
    }
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);
        int choice=0;
        String userInput = "";
        do{
            System.out.println("---------MAIN MENU---------\n1. Read input string\n" + "2. Compute number of vowels\n" + "3. Exit program\n" + "Enter option number:");
            choice = myScan.nextInt();
            switch(choice){
                case 1:
                    try {
                        System.out.println("Enter input string: ");
                        userInput = myScan2.nextLine();
                    }
                    catch(Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.println("You entered string: " + userInput);
                    int vowels = countVowels(userInput);
                    System.out.println("Number of vowels:   " + vowels);
                    break;
                case 3:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }while(choice !=3);
    }
}