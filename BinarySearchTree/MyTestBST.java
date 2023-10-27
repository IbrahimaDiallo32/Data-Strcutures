import java.util.*;
public class MyTestBST {

    static int rootNode;
    public static void main(String[] args) {

        // Create a BST of strings
        BST<String> tree = new BST<String>();

        // Create a BST of integers
        BST<Integer> intTree = new BST<Integer>();
        //Scanners for the switch menu and elements the user wants
        Scanner myScan = new Scanner(System.in);
        Scanner myScan2 = new Scanner(System.in);
        int insertValue = 0;
        int choice =0;
        String dataType;
        //booleans for an integer tree and if they have completed option 0
        boolean isIntegerTree = false;
        boolean hasRunOption0 = false;

        do{
            System.out.println("\n----------------MAIN MENU---------------\n" +
                    "0. Enter Tree Data Type (integer or string)\n" +
                    "1. Insert Data Element\n" + "2. Delete Data Element\n" +
                    "3. Search for Data Element\n" + "4. Print Tree Size\n" +
                    "5. Path from Root to Data Element\n" + "6. Check if Empty Tree\n" +
                    "7. Print Preorder Traversal\n" + "8. Print Inorder Traversal\n" +
                    "9. Print Postorder Traversal\n" + "10. Exit program\n" +
                    "\nEnter option number:");
            if(!hasRunOption0){
                choice = 0;
            }else {
                //if their input is not a valid string it will catch that exception
                try {
                    choice = Integer.parseInt(myScan2.nextLine());
                } catch (Exception e) {
                    System.out.println("Please enter a valid integer!");
                    choice = -1;
                }
            }
            switch(choice){
                //this case will originally be forced upon the user the first time the program is ran
                //if they choose this while there are elements in the tree, it will be erased and a new tree will be created
                case 0:
                    hasRunOption0 = false;
                    while(!hasRunOption0){
                        System.out.println("Please enter tree data type (integer or string)");
                        dataType = myScan.nextLine();
                        dataType.toLowerCase();
                        if(dataType.equals("integer") || dataType.equals("int")){
                            isIntegerTree = true;
                            hasRunOption0 = true;
                            intTree = new BST<Integer>();
                            break;
                        }
                        if(dataType.equals("string")){
                            isIntegerTree = false;
                            hasRunOption0 = true;
                            tree = new BST<String>();
                        }
                    }
                    break;
                    //this case will allow the user to input values into the tree depending on if they asked for a
                //string tree or an int tree.
                case 1:
                    System.out.print("Please enter the value you would like to insert: ");
                    if(isIntegerTree){
                        try {
                            insertValue = myScan.nextInt();
                            System.out.println("Testing method Insert Data Element (Option 1)");
                            System.out.print("BST before inserting " + insertValue + " (Inorder):               ");
                            if(intTree.size == 0){
                                System.out.print("The tree is empty");
                            } else {
                                intTree.inorder();
                            }
                            intTree.insert(insertValue);
                            System.out.println();
                            System.out.print("BST after inserting " + insertValue + " (Inorder):                ");
                            intTree.inorder(intTree.root);
                        }
                        catch(Exception e){
                            System.out.print("Invalid Integer.");
                        }
                        //for every case, the else is for when it is a string tree and not an integer tree.
                    } else {
                        String insertValues = "";
                            insertValues = myScan.nextLine();
                        System.out.println("Testing method Insert Data Element (Option 1)");
                        System.out.print("BST before inserting " + insertValues + " (Inorder): ");
                        if(tree.size == 0){
                            System.out.println("The tree is empty");
                        } else {
                            tree.inorder();
                            System.out.println();
                        }
                        tree.insert(insertValues);
                        System.out.print("BST after inserting " + insertValues + " (Inorder):  ");
                        tree.inorder();
                    }
                    System.out.println();
                    break;

                    //this case will delete elements and has special cases if the tree is empty also catches exceptions
                case 2:
                    int deleteValue =0;
                    boolean isInList = false;
                    if(isIntegerTree){
                        if(intTree.isEmpty()){
                            System.out.println("Sorry the tree is empty");
                            break;
                        }
                        System.out.println("Which element would you like to delete?");
                        try {
                            deleteValue = myScan2.nextInt();
                        }
                        catch(Exception e){
                            System.out.println("Sorry invalid Integer.");
                            break;
                        }
                        System.out.println("Testing method Delete Data Element (Option 2)");
                        System.out.print("BST before deleting " + deleteValue + " (Inorder): ");
                        if(intTree.isEmpty()){
                            System.out.println("The tree is empty.");
                            break;
                        } else {
                            intTree.inorder(intTree.root);
                        }
                        intTree.delete(deleteValue);
                        System.out.print("\nBST after deleting " + deleteValue + " (Inorder):  ");
                        intTree.inorder(intTree.root);
                        System.out.println();
                    } else {
                        //catches when the tree is empty.
                        if(tree.isEmpty()){
                            System.out.println("Sorry the tree is empty");
                            break;
                        }
                        System.out.println("Which element would you like to delete?");
                        String deleteValues = myScan.nextLine();
                        System.out.println("Testing method Delete Data Element (Option 2)");
                        System.out.print("BST before deleting " + deleteValues + " (Inorder): ");
                        if(tree.isEmpty()){
                            System.out.print("The tree is empty.");
                            break;
                        } else {
                            tree.inorder(tree.root);
                        }
                        tree.delete(deleteValues);
                        System.out.print("\nBST after deleting " + deleteValues + " (Inorder):  ");
                        tree.inorder(tree.root);
                        System.out.println();
                    }
                    break;
                    //this case checks for an element in the tree and prints true or false depending on if it
                //is found or not
                case 3:
                    int searchValues = 0;
                    System.out.println("Testing method Search for Data Element (Option 3)");
                    System.out.println("Which element would you like to search for?");
                    if(isIntegerTree){
                        try {
                            searchValues = myScan.nextInt();
                        }
                        catch(Exception e ){
                            System.out.println("Invalid integer.");
                            break;
                        }
                        System.out.print("Search for " + searchValues + "? ");
                        boolean isFound = intTree.search(searchValues);
                        System.out.print(isFound);
                    } else {
                        String searchValue = myScan.nextLine();
                        System.out.print("Search for " + searchValue + "? ");
                        boolean isFound = tree.search(searchValue);
                        System.out.print(isFound);
                    }
                    System.out.println();
                    break;
                    //this case will print the current size of the tree as an integer
                case 4:
                    System.out.print("Testing method Tree size (Option 4)\n" + "Tree size: ");
                    if(isIntegerTree){
                        System.out.println(intTree.size);
                    } else {
                        System.out.println(tree.size);
                    }
                    break;
                    //this case will give you a path to the element requested and will print not found if that element is not in the tree
                case 5:
                    int data = 0;
                    System.out.println("Testing method Path from Root to Data Element (Option 5)");
                    System.out.println("Which data element would you like to access?");
                    if(isIntegerTree){
                        try {
                            data = Integer.parseInt(myScan2.nextLine());
                            if(!intTree.search(data)){
                                System.out.println(data + " is not in the tree.");
                                break;
                            }
                            //gives a path for an integer BST
                            System.out.print("Path from root to " + data + ": ");
                            java.util.ArrayList<BST.TreeNode<Integer>> path = intTree.path(data);
                            for (int i = 0; path != null && i < path.size(); i++)
                                System.out.print(path.get(i).element + " ");
                        }
                        catch(Exception e){
                            System.out.print("Invalid integer.");
                        }
                    } else {
                        String datas = myScan.nextLine();
                        if(!tree.search(datas)){
                            System.out.println(datas + " is not in the tree.");
                            break;
                        }
                        System.out.print("Path from root to " + datas + ": ");
                        //gives a path for a string BST
                        java.util.ArrayList<BST.TreeNode<String>> path = tree.path(datas);
                        for (int i = 0; path != null && i < path.size(); i++)
                            System.out.print(path.get(i).element + " ");
                    }
                    System.out.println();
                    break;
                    //this will tell the user if the tree is empty or not
                case 6:
                    System.out.print("Testing method Check if Empty Tree (Option 6)\n" + "Is empty tree? ");
                    if(isIntegerTree) {
                        System.out.print(intTree.isEmpty());
                    } else {
                        System.out.print(tree.isEmpty());
                    }
                    System.out.println();
                    break;
                    //this case will print the contents of the tree in pre-order
                case 7:
                    System.out.print("Testing method Preorder Traversal (Option 7)\n" + "Preorder: ");
                    if(isIntegerTree){
                        if(intTree.isEmpty()){
                            System.out.println("The tree is empty");
                            break;
                        }
                        intTree.preorder();
                    } else {
                        if(tree.isEmpty()){
                            System.out.println("The tree is empty");
                            break;
                        }
                        tree.preorder();
                    }
                    System.out.println();
                    break;
                    //this case will print out the contents of the tree in order
                case 8:
                    System.out.print("Testing method Inorder Traversal (Option 8)\n" + "Inorder:");
                    if(isIntegerTree){
                        if(intTree.isEmpty()){
                            System.out.println("The tree is empty");
                            break;
                        }
                        intTree.inorder();
                    } else {
                        if(tree.isEmpty()){
                            System.out.println("The tree is empty");
                            break;
                        }
                        tree.inorder();
                    }
                    System.out.println();
                    break;
                    //this case will print the method in post traversal
                case 9:
                    System.out.print("Testing method Postorder Traversal (Option 9)\n" + "Postorder: ");
                    if(isIntegerTree){
                        //checks if the tree is empty
                        if(intTree.isEmpty()){
                            System.out.println("The tree is empty");
                            break;
                        }
                        intTree.postorder();
                    } else {
                        if(tree.isEmpty()){
                            System.out.println("The tree is empty");
                            break;
                        }
                        tree.postorder();
                    }
                    System.out.println();
                    break;
            }
        }while(choice != 10);
    }
}
