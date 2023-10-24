import java.util.Scanner;
// Name: <Ibrahima Diallo>
// Class: CS 3305/Section-04
// Term: Spring 2023
// Instructor: Dr. Haddad
// Assignment: 1
// IDE Name: <Intellij>
class TestRectangle {
    public static void main(String[] args) {
        Scanner myScan = new Scanner(System.in);
        Rectangle myRectangle = new Rectangle();
        System.out.print("Please enter a valid width: ");
        int width = myScan.nextInt();
        System.out.print("Please enter a valid height: " +"");
        int height = myScan.nextInt();
        Rectangle yourRectangle = new Rectangle(width, height);

        System.out.println("");
        System.out.println("myRectanlgle: \n ------------ ");
        System.out.println("Width: " + myRectangle.getWidth() + "\nHeight: " + myRectangle.getHeight() + "\nArea: "+ myRectangle.getArea() + "\nPerimeter: " + myRectangle.getPerimeter() +"\n");
        myRectangle.printRectangle("myRectangle");
        System.out.println("\nyourRectanlgle: \n ------------ ");
        System.out.println("Width: " + yourRectangle.getWidth() + "\nHeight: " + yourRectangle.getHeight() + "\nArea: "+ yourRectangle.getArea() + "\nPerimeter: " + yourRectangle.getPerimeter() +"\n");
        yourRectangle.printRectangle("yourRectangle");


        System.out.print("\nTesting method getWidth() on object yourRectangle: " + yourRectangle.getWidth() + "\nTesting method getHeight() on object yourRectangle: " + yourRectangle.getHeight() + "\nTesting method getArea() on object yourRectangle: " + yourRectangle.getArea() + "\nTesting method getPerimeter() on object yourRectangle: " + yourRectangle.getPerimeter() + "\nTesting method printRectangle() on object yourRectangle: ");
        yourRectangle.printRectangle("yourRectangle");


        myScan.close();
    }
}