// Name: <Ibrahima Diallo>
// Class: CS 3305/Section-04
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment: 8
// IDE Name: <IntelliJ>
import java.util.*;
public class HashFunctions {
    public static int extractDigit(int x, int place) {// takes in place, if place is 1 it will be the ones place
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
        return temp; //this will return the requested place for the number inputted

    }
    public static void printHash(Integer [][] hash){//takes in a hashFunction and outputs its keys and probes
        System.out.println("\nIndex   Key    probes\n" +
                "------------------------");
        for(int i=0; i<hash.length; i++){
            for(int j=0; j<1; j++){ //hash[0].length is the # of columns.
                if(i<10){
                    if(hash[i][1] == null){
                        System.out.println("0" + i + "     " + hash[i][0] + "       " + 0);
                        continue;
                    }
                    System.out.println("0" + i + "     " + hash[i][0] + "       " + hash[i][1]);
                }else {
                    if(hash[i][1] == null){//if I did not have this check it would print null for probes when it hasn't hashed
                        System.out.println(i + "     " + hash[i][0] + "       " + 0);//rather than printing 0
                        continue;
                    }
                    System.out.println(i + "     " + hash[i][0] + "       " + hash[i][1]);
                }
            }
        }
        System.out.println("------------------------");
        int numberProbes = 0;
        for(int i =0; i< hash.length; i++){
            if(hash[i][1] == null){ //loop to get total number of probes in hash table
                continue;
            }//loop to get total number of probes in hash table
            numberProbes += hash[i][1];
        }
        System.out.println("\nSum of probe values = " + numberProbes + " probes.");
    }
    //this method implements linear probing
    public static Integer[][] HF1(int [] keys){
        Integer [][] hashTable = new Integer[50][2]; //first column stores keys, second stores # of probes.
        for (int key : keys) {
            int probes = 0;
            int index = (key % 50); //function for finding index in the hash table
            while (hashTable[index][0] != null) {
                if (index == 49) { // when the end of the array is reached, index is set to -1.
                    index = -1;
                }
                probes++;
                index++; //increments index, when index = -1, it will = 0 when the while condition is checked.
            }
            hashTable[index][0] = key;
            hashTable[index][1] = probes;
        }
        return hashTable;
    }
    //this method implements a quadratic collision resolution
    public static Integer[][] HF2(int [] keys){
        Integer [][] hashTable = new Integer[50][2]; //first column stores keys, second stores # of probes
        for(int i=0; i<keys.length; i++) {
            int probes = 0;
            int index = (keys[i] % 50); //function for finding index in the hash table
            int newIndex = index;
            int powerCounter = 1; //for the quadratic collision method; the powers must be tracked
            while (hashTable[newIndex][0] != null) {
                double probing =  Math.pow(powerCounter, 2);
                newIndex = (int) (index+probing) % keys.length;
                probes++; //increment probes while looking for open index.
                powerCounter++;
            }
            hashTable[newIndex][0] = keys[i];
            hashTable[newIndex][1] = probes;
        }
        return hashTable;
    }
    public static Integer[][] HF3(int [] keys){ //implements double hashing
        Integer [][] hashTable = new Integer[50][2];
        for(int i=0; i<keys.length; i++){
            int probes = 0;
            int index = (keys[i] % 50); //function for finding index in the hash table
            int hashTries = 0;
            int h2Key = 30 - (keys[i] % 25); //this is the second hashfunction
            int oldIndex = index; //keeping the original index from the original
            //Increment is (key % 50) + j * H2 (key)
            while (hashTable[index][0] != null && hashTries < 50){
                probes++;
                int increment = (probes*h2Key);
                index = (oldIndex + increment) % 50;
                hashTries++;
            }
            if(hashTries == 50){
                System.out.println("Unable to hash key " + keys[i] + " to the table.");
                continue; //will continue to loop when it tries to hash 50 times
            }
            hashTable[index][0] = keys[i];
            hashTable[index][1] = probes;
        }
        return hashTable;
    }
    public static Integer[][] HF4(int [] keys){ //custom hashing function with double hashing as collision method
        Integer [][] hashTable = new Integer[50][2];
        for(int i=0; i<keys.length; i++){
            int probes = 0;
            int lastDigit = extractDigit(keys[i], 1); //extract first digit
            int secondDigit = extractDigit(keys[i], 2); //this will be added to the lastDigit
            int thirdDigit = extractDigit(keys[i], 3); //this is multiplied to second and last
            int fourthDigit = extractDigit(keys[i], 4); //this is the first digit from left added to the result
            int index = ((lastDigit+secondDigit)*thirdDigit+fourthDigit) % 50; //custom hash function adding and multiplying digits
            int hashTries = 0;
            int h2Key = 30 - (keys[i] % 25); //second hashing method
            int oldIndex = index; //keeping track of original index from custom hash function
            while (hashTable[index][0] != null && hashTries < 50){
                probes++;
                int increment = (probes*h2Key); //collision method is double hashing
                index = (oldIndex + increment) % 50;
                hashTries++; //keeping track of times it has tried to hash
            }
            if(hashTries == 50){
                System.out.println("Unable to hash key " + keys[i] + " to the table.");
                continue;
            }
            hashTable[index][0] = keys[i];
            hashTable[index][1] = probes;
        }
        return hashTable;
    }

    public static void main(String[] args) {
        int[] keys = {1234, 8234, 7867, 1009, 5438, 4312, 3420, 9487, 5418, 5299,
                5078, 8239, 1208, 5098, 5195, 5329, 4543, 3344, 7698, 5412,
                5567, 5672, 7934, 1254, 6091, 8732, 3095, 1975, 3843, 5589,
                5439, 8907, 4097, 3096, 4310, 5298, 9156, 3895, 6673, 7871,
                5787, 9289, 4553, 7822, 8755, 3398, 6774, 8289, 7665, 5523};

        int choice;
        Scanner myScan = new Scanner(System.in);
        do {
            System.out.println("\n-----MAIN MENU--------------------------------------\n" +
                    "1. Run HF1 (Division method with Linear Probing)\n" +
                    "2. Run HF2 (Division method with Quadratic Probing)\n" +
                    "3. Run HF3 (Division method with Double Hashing)\n" +
                    "4. Run HF4 (Student Designed HF)\n" +
                    "5. Exit program\n\n" +
                    "Enter option number: ");
            try{
                choice = Integer.parseInt(myScan.nextLine()); //exception for user input
            }
            catch(Exception e){
                System.out.println("Please enter valid integer");
                choice =-1;
            }
            //this case will call HF1 and print is contents
            switch(choice){
                case 1:
                    System.out.println("Hash table resulted from HF1: ");
                    Integer [][] HF1 = HF1(keys);
                    printHash(HF1);
                    break;
                    //this case will call HF2 and print is contents
                case 2:
                    System.out.println("Hash table resulted from HF2: ");
                    Integer [][] HF2 = HF2(keys);
                    printHash(HF2);
                    break;
                //this case will call HF3 and print is contents
                case 3:
                    System.out.println("Hash table resulted from HF3: \n");
                    Integer [][] HF3 = HF3(keys);
                    printHash(HF3);
                    break;
                //this case will call HF4 (custom hash function) and print is contents
                case 4:
                    System.out.println("Hash table resulted from HF3: \n");
                    Integer [][] HF4 = HF4(keys);
                    printHash(HF4);
                    break;
            }
        }while (choice != 5);
    }
}