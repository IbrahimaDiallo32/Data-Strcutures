// Name: <Ibrahima Diallo>
import java.util.*;
public class TestDailyTemps {
    public static void main(String[] args) {
        //System.out.println("Testing method setTemp:" + );
        Scanner myScan = new Scanner(System.in);
        DailyTemps myDailyTemps = new DailyTemps();
        System.out.println("Which day would you like to re-set the temperature for?");
        int newDay = myScan.nextInt();
        System.out.println("What would you like to change the temperature to?");
        int newTemp = myScan.nextInt();
        myDailyTemps.setTemp(newDay, newTemp);
        System.out.println("You've changed " + myDailyTemps.days[newDay] +" to "+ newTemp + " degrees.");
        System.out.println("Number of freezing days is " + myDailyTemps.freezing() + " days.");
        int warmest = myDailyTemps.warmest();
        String warmestDay = myDailyTemps.days[warmest];
        System.out.println("The warmest day of the week is " + warmestDay + ".");
        myDailyTemps.printTemps();

        System.out.println("");
        System.out.println("Testing method setTemp:");
        System.out.print("Which day would you like to re-set the temperature for?");
        int testDay = myScan.nextInt();
        System.out.print("What would you like to change the temperature to?");
        int testTemp = myScan.nextInt();
        myDailyTemps.setTemp(testDay, testTemp);
        System.out.println("You've changed " + myDailyTemps.days[testDay] +" to "+ testTemp + " degrees.");

        System.out.print("Testing method warmest: ");
        warmest = myDailyTemps.warmest();
        warmestDay = myDailyTemps.days[warmest];
        System.out.println(warmestDay + ".");
        System.out.println("Testing method freezing: " + myDailyTemps.freezing() + " days.");



    }
}
